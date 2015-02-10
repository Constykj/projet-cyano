/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.type_gene_cyano.dao;


import com.pasteur.ci.bean.TypeGeneCyano;
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
public class TypeGeneCyanoDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idtyp_gene_cyano,design_typ_gene_cyano,visible from type_gene_cyano where idtyp_gene_cyano = ? ";
    private static final String SQL_SELECT_ALL = "select idtyp_gene_cyano,design_typ_gene_cyano,visible from type_gene_cyano";
    private static final String SQL_CREATE = "insert into type_gene_cyano (design_typ_gene_cyano,visible) values (?,?)";
    private static final String SQL_UPDATE = "update type_gene_cyano set design_typ_gene_cyano = ?,visible = ? where idtyp_gene_cyano= ?";
    private static final String SQL_DELETE = "delete from type_gene_cyano where idtyp_gene_cyano = ? ";

    public TypeGeneCyanoDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        TypeGeneCyano type_gene_cyano = (TypeGeneCyano) obj;
        //Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, type_gene_cyano.getIdtyp_gene_cyano());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                type_gene_cyano.setDesign_typ_gene_cyano(resultSet.getString("design_typ_gene_cyano"));
               
                type_gene_cyano.setIdtyp_gene_cyano(resultSet.getInt("idtyp_gene_cyano"));
                type_gene_cyano.setVisible(resultSet.getBoolean("visible"));
            }
             DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return type_gene_cyano;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> type_gene_cyanos = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                TypeGeneCyano type_gene_cyano = new TypeGeneCyano();
                type_gene_cyano.setDesign_typ_gene_cyano(resultSet.getString("design_typ_gene_cyano"));
              
                type_gene_cyano.setIdtyp_gene_cyano(resultSet.getInt("idtyp_gene_cyano"));
                type_gene_cyano.setVisible(resultSet.getBoolean("visible"));

                type_gene_cyanos.add(type_gene_cyano);
            }
             DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return type_gene_cyanos;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        TypeGeneCyano type_gene_cyano = (TypeGeneCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    type_gene_cyano.getDesign_typ_gene_cyano(),
                   
                    type_gene_cyano.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                type_gene_cyano.setIdtyp_gene_cyano(valeurAutoGeneree.getInt(1));
                // quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
 DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return type_gene_cyano;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        TypeGeneCyano type_gene_cyano = (TypeGeneCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false, 
                    type_gene_cyano.getDesign_typ_gene_cyano(),
                    
                    type_gene_cyano.isVisible(),
                    type_gene_cyano.getIdtyp_gene_cyano());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
 DAOUtilitaire.fermetureSilencieuse( preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return type_gene_cyano;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        TypeGeneCyano type_gene_cyano = (TypeGeneCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false,
                    type_gene_cyano.getIdtyp_gene_cyano());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echect a la suppression ");
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
