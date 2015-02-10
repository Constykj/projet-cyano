/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.ligne_pratique.dao;

import com.pasteur.ci.bean.LignePratique;
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
public class LignePratiqueDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idligne_pratique,idpratique,idplan_eau from ligne_pratique where idligne_pratique = ? ";
    private static final String SQL_SELECT_ALL = "select idligne_pratique,idpratique,idplan_eau from ligne_pratique";
    private static final String SQL_CREATE = "insert into ligne_pratique (idpratique,idplan_eau) values (?,?)";
    private static final String SQL_UPDATE = "update ligne_pratique set idpratique = ?,idplan_eau = ? where idligne_pratique = ?";
    private static final String SQL_DELETE = "delete from ligne_pratique where idligne_pratique = ? ";
    private static final String SQL_SELECT_S_S = "select idligne_pratique from ligne_pratique where idplan_eau = ? and idpratique = ? ";
    private static final String SQL_SELECT_S = "select idligne_pratique,idpratique,idplan_eau from ligne_pratique where idplan_eau = ? ";

    public LignePratiqueDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public ArrayList<Object> findS(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList ligne_pratiques = new ArrayList();
        LignePratique lignePratique = (LignePratique) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_S, false,
                    lignePratique.getIdplan_eau());

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LignePratique ligne_pratique = new LignePratique();
                ligne_pratique.setIdligne_pratique(resultSet.getInt("idligne_pratique"));
                ligne_pratique.setIdplan_eau(resultSet.getInt("idplan_eau"));
                ligne_pratique.setIdpratique(resultSet.getInt("idpratique"));

                ligne_pratiques.add(ligne_pratique);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_pratiques;
    }

    public Object findSS(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        LignePratique lignePratique = (LignePratique) obj;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_S_S, false,
                    lignePratique.getIdplan_eau(),
                    lignePratique.getIdpratique());

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                lignePratique.setIdligne_pratique(resultSet.getInt("idligne_pratique"));

            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return lignePratique;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        LignePratique ligne_pratique = (LignePratique) obj;
        //Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false,
                    ligne_pratique.getIdligne_pratique());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                ligne_pratique.setIdligne_pratique(resultSet.getInt("idligne_pratique"));
                ligne_pratique.setIdplan_eau(resultSet.getInt("idplan_eau"));
                ligne_pratique.setIdpratique(resultSet.getInt("pratique"));

            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_pratique;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> ligne_pratiques = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LignePratique ligne_pratique = new LignePratique();
                ligne_pratique.setIdligne_pratique(resultSet.getInt("idligne_pratique"));
                ligne_pratique.setIdplan_eau(resultSet.getInt("idplan_eau"));
                ligne_pratique.setIdpratique(resultSet.getInt("pratique"));

                ligne_pratiques.add(ligne_pratique);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_pratiques;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        LignePratique ligne_pratique = (LignePratique) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true, ligne_pratique.getIdpratique(), ligne_pratique.getIdplan_eau());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                ligne_pratique.setIdligne_pratique(valeurAutoGeneree.getInt(1));
                // quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_pratique;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LignePratique ligne_pratique = (LignePratique) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false, ligne_pratique.getIdplan_eau(), ligne_pratique.getIdpratique(), ligne_pratique.getIdligne_pratique());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_pratique;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LignePratique ligne_pratique = (LignePratique) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, ligne_pratique.getIdligne_pratique());
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
