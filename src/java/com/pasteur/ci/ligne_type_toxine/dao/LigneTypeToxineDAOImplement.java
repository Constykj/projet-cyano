/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.ligne_type_toxine.dao;

/**
 *
 * @author HP USER
 */

import com.pasteur.ci.bean.LigneToxine;
import com.pasteur.ci.bean.LigneTypeToxine;
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
public class LigneTypeToxineDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select * from ligne_type_toxine where idcyano = ? order by  idligne_type_toxine";
    private static final String SQL_SELECT_ALL = "select idligne_type_toxine,idcyano, idtype_toxine,concentration from ligne_type_toxine";
    private static final String SQL_CREATE = "insert into ligne_type_toxine (idcyano, idtype_toxine,concentration ) values (?,?,?)";
    private static final String SQL_UPDATE = "update ligne_type_toxine set idcyano = ?,idtype_toxine = ?,concentration =? where idligne_type_toxine = ?";
    private static final String SQL_DELETE = "delete from ligne_type_toxine where idligne_type_toxine = ? ";

    public LigneTypeToxineDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public ArrayList<Object> find(Object obj) throws DAOException {

        
        LigneTypeToxine ligne_type_toxine_ = (LigneTypeToxine) obj;
       
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> ligne_type_toxines = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false,ligne_type_toxine_.getIdcyano());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneTypeToxine ligne_type_toxine = new LigneTypeToxine();
                ligne_type_toxine.setIdcyano(resultSet.getInt("idcyano"));
                ligne_type_toxine.setIdligne_type_toxine(resultSet.getInt("idligne_type_toxine"));
                ligne_type_toxine.setIdtype_toxine(resultSet.getInt("idtype_toxine"));
                ligne_type_toxine.setConcentration_type_toxicite(resultSet.getInt("concentration"));
                ligne_type_toxines.add(ligne_type_toxine);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_type_toxines;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> ligne_type_toxines = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneTypeToxine ligne_type_toxine = new LigneTypeToxine();
                ligne_type_toxine.setIdcyano(resultSet.getInt("idcyano"));
                ligne_type_toxine.setIdligne_type_toxine(resultSet.getInt("idligne_type_toxine"));
                ligne_type_toxine.setIdtype_toxine(resultSet.getInt("idtype_toxine"));
                ligne_type_toxine.setConcentration_type_toxicite(resultSet.getInt("concentration"));
                ligne_type_toxines.add(ligne_type_toxine);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_type_toxines;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        LigneTypeToxine ligne_type_toxine = (LigneTypeToxine) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true, ligne_type_toxine.getIdcyano(), 
                    ligne_type_toxine.getIdtype_toxine(),ligne_type_toxine.getConcentration_type_toxicite());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                ligne_type_toxine.setIdligne_type_toxine(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_type_toxine;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneTypeToxine ligne_Toxine = (LigneTypeToxine) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false, 
                    ligne_Toxine.getIdcyano(),
                    ligne_Toxine.getIdtype_toxine(),
                    ligne_Toxine.getConcentration_type_toxicite(),
                    ligne_Toxine.getIdligne_type_toxine());
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
        LigneTypeToxine ligne_type_toxine = (LigneTypeToxine) obj;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, ligne_type_toxine.getIdligne_type_toxine());
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
