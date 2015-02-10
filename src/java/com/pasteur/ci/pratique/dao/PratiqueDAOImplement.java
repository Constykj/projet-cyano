/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.pratique.dao;

import com.pasteur.ci.bean.Pratique;
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
public class PratiqueDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idpratique,pratique,visible from pratique where idpratique = ? ";
    private static final String SQL_SELECT_ALL = "select idpratique,pratique,visible from pratique";
    private static final String SQL_CREATE = "insert into pratique (pratique,visible) values (?,?)";
    private static final String SQL_UPDATE = "update pratique set pratique= ?,visible = ? where idpratique = ?";
    private static final String SQL_DELETE = "delete from pratique where idpratique= ? ";

    public PratiqueDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Pratique pratique = (Pratique) obj;
        //Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false
                    , pratique.getIdpratique());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                pratique.setIdpratique(resultSet.getInt("idpratique"));
                pratique.setPratique(resultSet.getString("pratique"));
                pratique.setVisible(resultSet.getBoolean("visible"));
            }
              DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return pratique;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> pratiquer = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Pratique pratique = new Pratique();
                pratique.setIdpratique(resultSet.getInt("idpratique"));
                pratique.setPratique(resultSet.getString("pratique"));
                pratique.setVisible(resultSet.getBoolean("visible"));
                pratiquer.add(pratique);
            }
              DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return pratiquer;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        Pratique pratique = (Pratique) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true, pratique.getPratique(),pratique.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                pratique.setIdpratique(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
  DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return pratique;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Pratique pratique = (Pratique) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,pratique.getPratique(),pratique.isVisible(),pratique.getIdpratique());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
  DAOUtilitaire.fermetureSilencieuse( preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return pratique;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Pratique pratique = (Pratique) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, pratique.getIdpratique());
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
