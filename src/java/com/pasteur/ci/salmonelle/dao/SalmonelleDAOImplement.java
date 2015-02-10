/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.salmonelle.dao;

import com.pasteur.ci.bean.PointPrelevement;
import com.pasteur.ci.bean.Salmonelle;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.dao.BaseDAO;
import com.pasteur.ci.dao.DAOUtilitaire;
import static com.pasteur.ci.dao.DAOUtilitaire.initialisationRequetePreparee;
import com.pasteur.ci.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Abouchou
 */
public class SalmonelleDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idsalmonelle,design_salmonelle,idserotype_sal,visible from salmonelle where idsalmonelle = ? ";
    private static final String SQL_SELECT_ALL = "select idsalmonelle,design_salmonelle,idserotype_sal,visible from salmonelle";
    private static final String SQL_CREATE = "insert into salmonelle (design_salmonelle,idserotype_sal,visible) values (?,?,?)";
    private static final String SQL_UPDATE = "update salmonelle set design_salmonelle = ? , idserotype_sal= ? ,visible = ? where idsalmonelle = ?" ;
    private static final String SQL_DELETE = "delete from salmonelle where idsalmonelle = ? ";

    public SalmonelleDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Salmonelle salmonelle = (Salmonelle) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false,
                    salmonelle.getIdsalmonelle());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                salmonelle.setIdsalmonelle(resultSet.getInt("idsalmonelle"));
                salmonelle.setDesign_salmonelle(resultSet.getString("design_salmonelle"));
                salmonelle.setIdserotype_sal(resultSet.getInt("idserotype_sal"));
                salmonelle.setVisible(resultSet.getBoolean("visible"));
                
            }
             DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return salmonelle;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> salmonelles = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Salmonelle salmonelle = new Salmonelle();
                salmonelle.setIdsalmonelle(resultSet.getInt("idsalmonelle"));
                salmonelle.setDesign_salmonelle(resultSet.getString("design_salmonelle"));
                salmonelle.setIdserotype_sal(resultSet.getInt("idserotype_sal"));
                salmonelle.setVisible(resultSet.getBoolean("visible"));
                salmonelles.add(salmonelle);
                //quartiers.add(quartier);
            }
             DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return salmonelles;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        Salmonelle salmonelle= (Salmonelle) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    salmonelle.getDesign_salmonelle(),
                    salmonelle.getIdserotype_sal(),
                    salmonelle.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation du point de prélèvement ");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                salmonelle.setIdsalmonelle(valeurAutoGeneree.getInt(1));
                //quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation  du point de prélèvement, aucun ID retorne");
            }
 DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return salmonelle;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Salmonelle Salmonelle = (Salmonelle) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    
                    Salmonelle.getDesign_salmonelle(),
                    Salmonelle.getIdserotype_sal(),
                    Salmonelle.isVisible(),
                    Salmonelle.getIdsalmonelle());
                    
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour du point de prélèvement");
            }
 DAOUtilitaire.fermetureSilencieuse( preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return Salmonelle;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Salmonelle salmonelle = (Salmonelle) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false,
                    salmonelle.getIdsalmonelle());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echect a la suppression de l'habitat");
            }
 DAOUtilitaire.fermetureSilencieuse( preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public Object find(int i) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
