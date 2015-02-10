/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.point_prelevement.dao;

import com.pasteur.ci.bean.PointPrelevement;
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

public class PointPrelevementDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idpoint_prelevement,designation,profondeur,idstat,visible from point_prelevement where idpoint_prelevement = ? ";
    private static final String SQL_SELECT_ALL = "select idpoint_prelevement,designation,profondeur,idstat,visible from point_prelevement";
    private static final String SQL_CREATE = "insert into point_prelevement (designation,profondeur,idstat,visible) values (?,?,?,?)";
    private static final String SQL_UPDATE = "update point_prelevement set designation = ?, profondeur = ? , idstat= ? ,visible = ? where idpoint_prelevement = ?";
    private static final String SQL_DELETE = "delete point_prelevement habitat where idpoint_prelevement = ? ";

    public PointPrelevementDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        PointPrelevement point_prelevement = (PointPrelevement) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false,
                    point_prelevement.getIdpoint_prelevement());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                point_prelevement.setIdpoint_prelevement(resultSet.getInt("idpoint_prelevement"));
                point_prelevement.setDesignation(resultSet.getString("designation"));
                point_prelevement.setProfondeur(resultSet.getDouble("profondeur"));
                point_prelevement.setIdstat(resultSet.getInt("idstat"));
                point_prelevement.setVisible(resultSet.getBoolean("visible"));
                //quartier.setIdquartier(resultSet.getInt("idquartier"));
                //quartier.setDesignation(resultSet.getString("designation"));

            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return point_prelevement;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> point_prelevements = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PointPrelevement point_prelevement = new PointPrelevement();
                point_prelevement.setIdpoint_prelevement(resultSet.getInt("idpoint_prelevement"));
                point_prelevement.setDesignation(resultSet.getString("designation"));
                point_prelevement.setProfondeur(resultSet.getDouble("profondeur"));
                point_prelevement.setIdstat(resultSet.getInt("idstat"));
                point_prelevement.setVisible(resultSet.getBoolean("visible"));
                point_prelevements.add(point_prelevement);

            }
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return point_prelevements;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        PointPrelevement point_prelevement = (PointPrelevement) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    point_prelevement.getDesignation(),
                    point_prelevement.getProfondeur(),
                    point_prelevement.getIdstat(),
                    point_prelevement.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation du point de prélèvement ");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                point_prelevement.setIdpoint_prelevement(valeurAutoGeneree.getInt(1));
                //quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation  du point de prélèvement, aucun ID retorne");
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return point_prelevement;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        PointPrelevement point_prelevement = (PointPrelevement) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    point_prelevement.getDesignation(),
                    point_prelevement.getProfondeur(),
                    point_prelevement.getIdstat(),
                    point_prelevement.isVisible(),
                    point_prelevement.getIdpoint_prelevement());

            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour du point de prélèvement");
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return point_prelevement;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        PointPrelevement point_prelevement = (PointPrelevement) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false,
                    point_prelevement.getIdpoint_prelevement());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echect a la suppression de l'habitat");
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public Object find(int i) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
