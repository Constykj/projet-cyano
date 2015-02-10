/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.espece_cyano.dao;

import com.pasteur.ci.bean.EspeceCyano;
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
public class EspeceCyanoDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idespece_cyano,idgenre_cyano,design_espece_cyano,visible from espece_cyano where idespece_cyano = ? ";
    private static final String SQL_SELECT_ALL = "select idespece_cyano,idgenre_cyano,design_espece_cyano,visible from espece_cyano";
    private static final String SQL_CREATE = "insert into espece_cyano (idgenre_cyano,design_espece_cyano,visible) values (?,?,?)";
    private static final String SQL_UPDATE = "update espece_cyano set idgenre_cyano = ?,design_espece_cyano = ?,visible = ? where idespece_cyano= ?";
    private static final String SQL_DELETE = "delete from espece_cyano where idespece_cyano = ? ";

    public EspeceCyanoDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        EspeceCyano espece_cyano = (EspeceCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, espece_cyano.getIdespece_cyano());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                espece_cyano.setIdespece_cyano(resultSet.getInt("idespece_cyano"));
                espece_cyano.setIdgenre_cyano(resultSet.getInt("idgenre_cyano"));
                espece_cyano.setDesign_espece_cyano(resultSet.getString("design_espece_cyano"));
                espece_cyano.setVisible(resultSet.getBoolean("visible"));
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return espece_cyano;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> espece_cyanos = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EspeceCyano espece_cyano = new EspeceCyano();
                espece_cyano.setIdespece_cyano(resultSet.getInt("idespece_cyano"));
                espece_cyano.setIdgenre_cyano(resultSet.getInt("idgenre_cyano"));
                espece_cyano.setDesign_espece_cyano(resultSet.getString("design_espece_cyano"));
                
                espece_cyano.setVisible(resultSet.getBoolean("visible"));

                espece_cyanos.add(espece_cyano);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return espece_cyanos;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        EspeceCyano espece_cyano = (EspeceCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    espece_cyano.getIdgenre_cyano(),
                    espece_cyano.getDesign_espece_cyano(),
                    espece_cyano.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                espece_cyano.setIdespece_cyano(valeurAutoGeneree.getInt(1));
                // quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return espece_cyano;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        EspeceCyano espece_cyano = (EspeceCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    espece_cyano.getIdgenre_cyano(),
                    espece_cyano.getDesign_espece_cyano(),
                    espece_cyano.isVisible(),
                    espece_cyano.getIdespece_cyano());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return espece_cyano;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        EspeceCyano espece_cyano = (EspeceCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, 
                    espece_cyano.getIdespece_cyano());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echect a la suppression ");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public Object find(int i) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
