/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.parasite.dao;

import com.pasteur.ci.bean.Parasite;
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
public class ParasiteDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idparasite,cryptosporidium,giardia,helminthe,visible from parasite where idparasite = ? ";
    private static final String SQL_SELECT_ALL = "select idparasite,cryptosporidium,giardia,helminthe,visible from parasite";
    private static final String SQL_CREATE = "insert into parasite(cryptosporidium,giardia,helminthe,visible) values (?,?,?,?)";
    private static final String SQL_UPDATE = "update parasite  set  cryptosporidium=?,giardia=?,helminthe=? where idparasite=?";
    private static final String SQL_DELETE = "delete from parasite where idparasite= ? ";

    public ParasiteDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Parasite parasite =(Parasite) obj;
        //Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false,parasite.getIdparasite());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                parasite.setCryptosporidium(resultSet.getInt("cryptosporidium"));
                parasite.setGiardia(resultSet.getInt("giardia"));
                parasite.setHelminthe(resultSet.getInt("helminthe"));
                parasite.setIdparasite(resultSet.getInt("idparasite"));
                parasite.setVisible(resultSet.getBoolean("visible"));
                
            }
              DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return parasite;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> parasites = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
                Parasite parasite = new Parasite();
                parasite.setCryptosporidium(resultSet.getInt("cryptosporidium"));
                parasite.setGiardia(resultSet.getInt("giardia"));
                parasite.setHelminthe(resultSet.getInt("helminthe"));
                parasite.setIdparasite(resultSet.getInt("idparasite"));
                parasite.setVisible(resultSet.getBoolean("visible"));
                parasites.add(parasite);
            }
              DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return parasites;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        Parasite parasite =(Parasite) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true, 
                    parasite.getCryptosporidium(),
                    parasite.getGiardia(),
                    parasite.getHelminthe(),
                    parasite.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                parasite.setIdparasite(valeurAutoGeneree.getInt(1));
                
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
  DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return parasite;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
       Parasite parasite =(Parasite) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    parasite.getCryptosporidium(),
                    parasite.getGiardia(),
                    parasite.getHelminthe(),                     
                    parasite.getIdparasite());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
  DAOUtilitaire.fermetureSilencieuse( preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return parasite;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Parasite parasite =(Parasite) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, parasite.getIdparasite());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echect a la suppression ");
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

