/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.ligne_famille.dao;

import com.pasteur.ci.bean.AutreAlgue;
import com.pasteur.ci.bean.Famille;
import com.pasteur.ci.bean.LigneFamille;
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
public class LigneFamilleDAOimplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select * from ligne_famille where idautre_algue = ? ";
    private static final String SQL_SELECT_ALL = "select idligne_famille,idautre_algue,idfamille from ligne_famille";
    private static final String SQL_CREATE = "insert into ligne_famille (idfamille,idautre_algue) values (?,?)";
    private static final String SQL_UPDATE = "update ligne_famille set idautre_algue = ?,idfamille = ? where idligne_famille = ?";
    private static final String SQL_DELETE = "delete from ligne_famille where idligne_famille = ? ";

    public LigneFamilleDAOimplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public ArrayList<Object> find(Object obj) throws DAOException {

        LigneFamille ligne_famille_ = (LigneFamille) obj;
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> ligne_familles = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, ligne_famille_.getIdautre_algue());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneFamille ligne_famille = new LigneFamille();
                ligne_famille.setIdautre_algue(resultSet.getInt("idautre_algue"));
                ligne_famille.setIdfamille(resultSet.getInt("idfamille"));
                ligne_famille.setIdligne_famille(resultSet.getInt("idligne_famille"));
                ligne_familles.add(ligne_famille);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_familles;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> ligne_familles = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneFamille ligne_famille = new LigneFamille();
                ligne_famille.setIdautre_algue(resultSet.getInt("idautre_algue"));
                ligne_famille.setIdfamille(resultSet.getInt("idfamille"));
                ligne_famille.setIdligne_famille(resultSet.getInt("idligne_famille"));
                // quartier.setIdquartier(resultSet.getInt("idquartier"));
                //quartier.setDesignation(resultSet.getString("designation"));
                ligne_familles.add(ligne_famille);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_familles;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        LigneFamille ligne_famille = (LigneFamille) obj;
//        AutreAlgue autre_algue = (AutreAlgue) obj;
//        Famille famille =(Famille)obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    ligne_famille.getIdfamille(),
                    ligne_famille.getIdautre_algue());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                ligne_famille.setIdligne_famille(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_famille;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneFamille ligne_famille = (LigneFamille) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    ligne_famille.getIdautre_algue(),
                    ligne_famille.getIdfamille(), 
                    ligne_famille.getIdligne_famille());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_famille;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneFamille ligne_famille = (LigneFamille) obj;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, ligne_famille.getIdligne_famille());
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
