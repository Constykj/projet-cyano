/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.ligne_toxine.dao;

import com.pasteur.ci.bean.LigneToxine;
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
public class LigneToxineDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idligne_toxine,idespece_cyano,idtoxine,concentration from ligne_toxine where idligne_toxine = ? ";
    private static final String SQL_SELECT_ALL = "select idligne_toxine,idespece_cyano,idtoxine,concentration  from ligne_toxine";
    private static final String SQL_CREATE = "insert into ligne_toxine (idespece_cyano,idtoxine,concentration ) values (?,?,?)";
    private static final String SQL_UPDATE = "update ligne_toxine set idespece_cyano = ?,idtoxine = ?,concentration =? where idligne_toxine = ?";
    private static final String SQL_DELETE = "delete from ligne_toxine where idligne_toxine = ? ";

    public LigneToxineDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        LigneToxine ligne_toxine = (LigneToxine) obj;
        //Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, ligne_toxine.getIdligne_toxine());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ligne_toxine.setIdespece_cyano(resultSet.getInt("idespece_cyano"));
                ligne_toxine.setIdligne_toxine(resultSet.getInt("idligne_toxine"));
                ligne_toxine.setIdtoxine(resultSet.getInt("idtoxine"));
                ligne_toxine.setIdtoxine(resultSet.getInt("concentration"));
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_toxine;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> ligne_toxines = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneToxine ligne_toxine = new LigneToxine();
                ligne_toxine.setIdespece_cyano(resultSet.getInt("idespece_cyano"));
                ligne_toxine.setIdligne_toxine(resultSet.getInt("idligne_toxine"));
                ligne_toxine.setIdtoxine(resultSet.getInt("idtoxine"));
                ligne_toxine.setIdtoxine(resultSet.getInt("concentration"));
                ligne_toxines.add(ligne_toxine);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_toxines;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        LigneToxine ligne_toxine = (LigneToxine) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true, ligne_toxine.getIdespece_cyano(), ligne_toxine.getIdtoxine(),ligne_toxine.getConcentration());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                ligne_toxine.setIdligne_toxine(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_toxine;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneToxine ligne_Toxine = (LigneToxine) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false, ligne_Toxine.getIdespece_cyano(), ligne_Toxine.getIdligne_toxine(), 
                    ligne_Toxine.getIdtoxine(),ligne_Toxine.getConcentration());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_Toxine;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneToxine ligne_toxine = (LigneToxine) obj;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, ligne_toxine.getIdligne_toxine());
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
