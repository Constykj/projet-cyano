/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.stat_prelevement.dao;

import com.pasteur.ci.bean.StatPrelevement;
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
public class StatPrelevementDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idstat,idstat_prelevement,idhabitat,gps_lat,gps_long,idplan_eau,visible from stat_prelevement where idstat = ? ";
    private static final String SQL_SELECT_ALL = "select idstat,idstat_prelevement,idhabitat,gps_lat,gps_long,idplan_eau,visible from stat_prelevement";
    private static final String SQL_CREATE = "insert into stat_prelevement (idstat_prelevement,idhabitat,gps_lat,gps_long,idplan_eau,visible) values (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "update stat_prelevement set idstat_prelevement=?,idhabitat = ?,gps_lat = ? ,gps_long = ?,idplan_eau = ? , visible = ? where idstat = ?";
    private static final String SQL_DELETE = "delete from stat_prelevement where idstat = ? ";

    public StatPrelevementDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        StatPrelevement stat_prelevement = (StatPrelevement) obj;
        //Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false,
                    stat_prelevement.getIdstat());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                stat_prelevement.setIdstat(resultSet.getInt("idstat"));
                stat_prelevement.setIdStat_prelevement(resultSet.getString("idStat_prelevement"));
                stat_prelevement.setIdhabitat(resultSet.getInt("idhabitat"));
                stat_prelevement.setGps_lat(resultSet.getDouble("gps_lat"));
                stat_prelevement.setGps_long(resultSet.getDouble("gps_long"));
                stat_prelevement.setIdplan_eau(resultSet.getInt("idplan_eau"));
                stat_prelevement.setVisible(resultSet.getBoolean("visible"));
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return stat_prelevement;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> statp = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                StatPrelevement stat_prelevement = new StatPrelevement();
                stat_prelevement.setIdstat(resultSet.getInt("idstat"));
                stat_prelevement.setIdStat_prelevement(resultSet.getString("idStat_prelevement"));
                stat_prelevement.setIdhabitat(resultSet.getInt("idhabitat"));
                stat_prelevement.setGps_lat(resultSet.getDouble("gps_lat"));
                stat_prelevement.setGps_long(resultSet.getDouble("gps_long"));
                stat_prelevement.setIdplan_eau(resultSet.getInt("idplan_eau"));
                stat_prelevement.setVisible(resultSet.getBoolean("visible"));
                statp.add(stat_prelevement);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return statp;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        StatPrelevement stat_prelevement = (StatPrelevement) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    stat_prelevement.getIdstat_prelevement(),
                    stat_prelevement.getIdhabitat(),
                    stat_prelevement.getGps_lat(),
                    stat_prelevement.getGps_long(),
                    stat_prelevement.getIdplan_eau(),
                    stat_prelevement.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                stat_prelevement.setIdstat(valeurAutoGeneree.getInt(1));

            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return stat_prelevement;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        StatPrelevement stat_prelevement = (StatPrelevement) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    stat_prelevement.getIdstat_prelevement(),
                    stat_prelevement.getIdhabitat(),
                    stat_prelevement.getGps_lat(),
                    stat_prelevement.getGps_long(),
                    stat_prelevement.getIdplan_eau(),
                    stat_prelevement.isVisible(),
                    stat_prelevement.getIdstat());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return stat_prelevement;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        StatPrelevement stat_prelevement = (StatPrelevement) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, stat_prelevement.getIdstat());
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
