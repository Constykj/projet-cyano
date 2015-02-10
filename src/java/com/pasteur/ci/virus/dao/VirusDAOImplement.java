/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.virus.dao;

import com.pasteur.ci.bean.Virus;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.dao.BaseDAO;
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
public class VirusDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idvirus,enterovirus,visible from virus where idvirus = ? ";
    private static final String SQL_SELECT_ALL = "select idvirus,enterovirus,visible from virus";
    private static final String SQL_CREATE = "insert into virus (enterovirus,visible) values (?,?)";
    private static final String SQL_UPDATE = "update virus set enterovirus = ? where idvirus = ?";
    private static final String SQL_DELETE = "delete from virus where idvirus = ? ";

    public VirusDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
       Virus virus  = (Virus) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, virus.getIdvirus());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                virus.setEnterovirus(resultSet.getInt("enterovirus"));
                virus.setIdvirus(resultSet.getInt("idvirus"));
                virus.setVisible(resultSet.getBoolean("visible"));
                
            }
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return virus;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> viral = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Virus  virus  = new Virus();
                virus.setEnterovirus(resultSet.getInt("enterovirus"));
                virus.setIdvirus(resultSet.getInt("idvirus"));
                virus.setVisible(resultSet.getBoolean("visible"));
                viral.add(virus);
            }
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return viral;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        Virus virus  = (Virus) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true, virus.getEnterovirus(),virus.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation ");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                virus.setIdvirus(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return virus;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Virus virus  = (Virus) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false, 
                    virus.getEnterovirus(),                     
                    virus.getIdvirus());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return virus;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Virus virus  = (Virus) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, virus.getIdvirus());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echect a la suppression");
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
