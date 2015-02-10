/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.quartier.dao;

import com.pasteur.ci.bean.Quartier;
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
 * @author HP USER
 */
public class QuartierDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idquartier,designation,visible from quartier where idquartier = ? ";
    private static final String SQL_SELECT_ALL = "select idquartier,designation,visible from quartier";
    private static final String SQL_CREATE = "insert into quartier (designation,visible) values (?,?)";
    private static final String SQL_UPDATE = "update quartier set designation = ?, visible = ? where idquartier = ?";
    private static final String SQL_DELETE = "delete from quartier where idquartier = ? ";

    public QuartierDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false,quartier.getIdquartier());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                quartier.setIdquartier(resultSet.getInt("idquartier"));
                quartier.setDesignation(resultSet.getString("designation"));
            }
              DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return quartier;
    }
    

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> quartiers = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Quartier quartier = new Quartier();
                quartier.setIdquartier(resultSet.getInt("idquartier"));
                quartier.setDesignation(resultSet.getString("designation"));
                quartier.setVisible(resultSet.getBoolean("visible"));
                quartiers.add(quartier);
            }
              DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return quartiers;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true, quartier.getDesignation(), quartier.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation de la quartier");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation du quartier, aucun ID retorne");
            }
  DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return quartier;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false, quartier.getDesignation(), quartier.isVisible(), quartier.getIdquartier());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour du quartier");
            }
  DAOUtilitaire.fermetureSilencieuse( preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return quartier;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Quartier quartier  = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, quartier.getIdquartier());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echect a la suppression du quartier");
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
