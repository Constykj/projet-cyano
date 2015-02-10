/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.ligne_habitat.dao;

import com.pasteur.ci.bean.LigneHabitat;
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
public class LigneHabitatDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idligne_habitat,idmateriaux_construction,idhabitat from ligne_habitat where idligne_habitat = ? ";
    private static final String SQL_SELECT_ALL = "select idligne_habitat,idmateriaux_construction,idhabitat from ligne_habitat";
    private static final String SQL_CREATE = "insert into ligne_habitat (idhabitat,idmateriaux_construction ) values (?,?)";
    private static final String SQL_UPDATE = "update ligne_habitat set idmateriaux_construction= ?,idhabitat = ? where idligne_habitat = ?";
    private static final String SQL_DELETE = "delete from ligne_habitat where idligne_habitat = ? ";
    private static final String SQL_SELECT_S_S = "select idligne_habitat from ligne_habitat where idhabitat = ? and idmateriaux_construction = ? ";
    private static final String SQL_SELECT_S = "select idligne_habitat,idmateriaux_construction,idhabitat from ligne_habitat where idhabitat = ? ";

    public LigneHabitatDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public ArrayList<Object> findS(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList ligne_habitats = new ArrayList();
        LigneHabitat ligneHabitat = (LigneHabitat) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_S, false,
                    ligneHabitat.getIdhabitat());

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneHabitat ligne_habitat = new LigneHabitat();
                ligne_habitat.setIdligne_habitat(resultSet.getInt("idligne_habitat"));
                ligne_habitat.setIdhabitat(resultSet.getInt("idhabitat"));
                ligne_habitat.setIdmateriaux_construction(resultSet.getInt("idmateriaux_construction"));

                ligne_habitats.add(ligne_habitat);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_habitats;
    }

    public Object findSS(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        LigneHabitat ligneHabitat = (LigneHabitat) obj;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_S_S, false,
                    ligneHabitat.getIdhabitat(),
                    ligneHabitat.getIdmateriaux_construction());

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                ligneHabitat.setIdligne_habitat(resultSet.getInt("idligne_habitat"));

            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligneHabitat;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        LigneHabitat ligne_habitat = (LigneHabitat) obj;
        //Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, ligne_habitat.getIdligne_habitat());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                ligne_habitat.setIdligne_habitat(resultSet.getInt("idligne_habitat"));
                ligne_habitat.setIdhabitat(resultSet.getInt("habitat"));
                ligne_habitat.setIdmateriaux_construction(resultSet.getInt("idmateriaux_construction"));
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_habitat;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> ligne_habitats = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneHabitat ligne_habitat = new LigneHabitat();
                ligne_habitat.setIdligne_habitat(resultSet.getInt("idligne_habitat"));
                ligne_habitat.setIdhabitat(resultSet.getInt("idhabitat"));
                ligne_habitat.setIdmateriaux_construction(resultSet.getInt("idmateriaux_construction"));

                ligne_habitats.add(ligne_habitat);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_habitats;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        LigneHabitat ligne_habitat = (LigneHabitat) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    ligne_habitat.getIdhabitat(), ligne_habitat.getIdmateriaux_construction());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                ligne_habitat.setIdligne_habitat(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_habitat;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneHabitat ligne_habitat = (LigneHabitat) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false, ligne_habitat.getIdmateriaux_construction(),
                    ligne_habitat.getIdhabitat(),
                    ligne_habitat.getIdligne_habitat());

            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_habitat;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneHabitat ligne_habitat = (LigneHabitat) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, ligne_habitat.getIdligne_habitat());
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
