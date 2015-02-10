/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.echantillon.dao;

import com.pasteur.ci.bean.Echantillon;
import com.pasteur.ci.bean.RapportEchantillon;
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
public class EchantillonDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idechantillon,num_echantillon,idprojet,date_prelevement,idpoint_prelevement,idparasite,idvirus,idp_phy_chim,idcyano,idautre_bacterie,idautre_algue from echantillon where num_echantillon = ? ";
    private static final String SQL_SELECT_S = "select * from echantillon where num_echantillon = ? ";
    private static final String SQL_SELECT_ALL = "select * from echantillon";
    private static final String SQL_CREATE = "insert into echantillon (num_echantillon,idprojet,date_prelevement,idpoint_prelevement,idparasite,idvirus,idp_phy_chim,idcyano,idautre_bacterie,idautre_algue,visible) values (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "update echantillon set date_prelevement = ?, idprojet = ? where num_echantillon = ?";
    private static final String SQL_DELETE = "delete from echantillon where idechantillon = ? ";
    private static final String SQL_SELECT_M = "SELECT e.num_echantillon as 'num', p.designation as 'design', s.idstat_prelevement as 'station', pe.designation as 'planeau' from echantillon e, stat_prelevement s, point_prelevement p, plan_eau pe where e.idpoint_prelevement = p.idpoint_prelevement and p.idstat = s.idstat and s.idplan_eau = pe.idplan_eau";

    public EchantillonDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public Object findS(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        Echantillon echantillon = new Echantillon();
        Echantillon echantillon1 = (Echantillon) obj;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_S, false, echantillon1.getNum_echantillon());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                echantillon.setNum_echantillon(resultSet.getString("num_echantillon"));

            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return echantillon;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Echantillon echantillon1 = (Echantillon) obj;
        Echantillon echantillon = new Echantillon();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, echantillon1.getNum_echantillon());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                echantillon.setIdechantillon(resultSet.getInt("idechantillon"));
                echantillon.setDate_prelevement(resultSet.getString("date_prelevement"));
                echantillon.setIdpoint_prelevement(resultSet.getInt("idpoint_prelevement"));
                echantillon.setNum_echantillon(resultSet.getString("num_echantillon"));
                echantillon.setIdp_phy_chim(resultSet.getInt("idp_phy_chim"));
                echantillon.setIdparasite(resultSet.getInt("idparasite"));
                echantillon.setIdvirus(resultSet.getInt("idvirus"));
                echantillon.setIdprojet(resultSet.getInt("idprojet"));
                echantillon.setIdcyano(resultSet.getInt("idcyano"));
                echantillon.setIdautre_bacterie(resultSet.getInt("idautre_bacterie"));
                echantillon.setIdautre_algue(resultSet.getInt("idautre_algue"));
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return echantillon;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> echantillons = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Echantillon echantillon = new Echantillon();
                echantillon.setIdechantillon(resultSet.getInt("idechantillon"));
                echantillon.setDate_prelevement(resultSet.getString("date_prelevement"));
                echantillon.setIdpoint_prelevement(resultSet.getInt("idpoint_prelevement"));
                echantillon.setNum_echantillon(resultSet.getString("num_echantillon"));
                echantillon.setVisible(resultSet.getBoolean("visible"));
                echantillon.setIdp_phy_chim(resultSet.getInt("idp_phy_chim"));
                echantillon.setIdparasite(resultSet.getInt("idparasite"));
                echantillon.setIdvirus(resultSet.getInt("idvirus"));
                echantillon.setIdprojet(resultSet.getInt("idprojet"));
                echantillon.setIdautre_algue(resultSet.getInt("idautre_algue"));
                echantillon.setIdautre_bacterie(resultSet.getInt("idautre_bacterie"));
                echantillons.add(echantillon);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return echantillons;
    }

    public ArrayList<Object> findSS() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> rappEchantillons = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_M, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RapportEchantillon rapportEchantillon = new RapportEchantillon();
                rapportEchantillon.setIdEchantillon(resultSet.getString("num"));
                rapportEchantillon.setPointPrelev(resultSet.getString("design"));
                rapportEchantillon.setStationPrelev(resultSet.getString("station"));
                rapportEchantillon.setPlanEau(resultSet.getString("planeau"));
                rappEchantillons.add(rapportEchantillon);
            }
             
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return rappEchantillons;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        Echantillon echantillon = (Echantillon) obj;
        System.out.println("idautre_bacetrie ====== " + echantillon.getIdautre_bacterie());
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    echantillon.getNum_echantillon(),
                    echantillon.getIdprojet(),
                    echantillon.getDate_prelevement(),
                    echantillon.getIdpoint_prelevement(),
                    echantillon.getIdparasite(),
                    echantillon.getIdvirus(),
                    echantillon.getIdp_phy_chim(),
                    echantillon.getIdcyano(),
                    echantillon.getIdautre_bacterie(),
                    echantillon.getIdautre_algue(),
                    echantillon.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation de l'échantillon");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                echantillon.setIdechantillon(valeurAutoGeneree.getInt(1));

            } else {
                throw new DAOException("Echec a la creation de l'échantillon, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return echantillon;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Echantillon echantillon = (Echantillon) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    echantillon.getDate_prelevement(),
                    echantillon.getIdprojet(),
                    echantillon.getIdechantillon());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour de l'échantillon");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return echantillon;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Echantillon echantillon = (Echantillon) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, echantillon.getIdechantillon());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echect a la suppression de l'échantillon");
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
