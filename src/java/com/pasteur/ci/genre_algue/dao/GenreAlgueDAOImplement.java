/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.genre_algue.dao;

import com.pasteur.ci.bean.GenreAlgue;
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
public class GenreAlgueDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idgenre_algue,idfamille,design_genre_algue,visible from genre_algue where idgenre_algue = ? ";
    private static final String SQL_SELECT_S = "select idgenre_algue,design_genre_algue,visible, idfamille from genre_algue where design_genre_algue = ? ";
    private static final String SQL_SELECT_ALL = "select idgenre_algue,idfamille,design_genre_algue,visible from genre_algue";
    private static final String SQL_SELECT_ALL_S = "select idgenre_algue,idfamille,design_genre_algue,visible from genre_algue  where idfamille = ?";
    private static final String SQL_CREATE = "insert into genre_algue (idfamille,design_genre_algue,visible) values (?,?,?)";
    private static final String SQL_UPDATE = "update genre_algue set idfamille = ?, design_genre_algue = ?, visible = ? where idgenre_algue = ?";
    private static final String SQL_DELETE = "delete from genre_algue where idgenre_algue = ? ";

    public GenreAlgueDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        GenreAlgue genre_algue = (GenreAlgue) obj;
        //Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false,
                    genre_algue.getIdgenre_algue());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                genre_algue.setIdfamille(resultSet.getInt("idfamille"));
                genre_algue.setDesign_genre_algue(resultSet.getString("design_genre_algue"));
                genre_algue.setIdgenre_algue(resultSet.getInt("idgenre_algue"));
                genre_algue.setVisible(resultSet.getBoolean("visible"));
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return genre_algue;
    }

     public Object findS(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        GenreAlgue genre_algue = (GenreAlgue) obj;
        //Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_S, false,
                    genre_algue.getDesign_genre_algue());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                genre_algue.setIdfamille(resultSet.getInt("idfamille"));
                genre_algue.setDesign_genre_algue(resultSet.getString("design_genre_algue"));
                genre_algue.setIdgenre_algue(resultSet.getInt("idgenre_algue"));
                genre_algue.setVisible(resultSet.getBoolean("visible"));
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return genre_algue;
    }

    
    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> genre_algues = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                GenreAlgue genre_algue = new GenreAlgue();
                genre_algue.setIdfamille(resultSet.getInt("idfamille"));
                genre_algue.setDesign_genre_algue(resultSet.getString("design_genre_algue"));
                genre_algue.setIdgenre_algue(resultSet.getInt("idgenre_algue"));
                genre_algue.setVisible(resultSet.getBoolean("visible"));

                genre_algues.add(genre_algue);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return genre_algues;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        GenreAlgue genre_algue = (GenreAlgue) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    genre_algue.getIdfamille(),
                    genre_algue.getDesign_genre_algue(),
                    genre_algue.isVisible());

            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                genre_algue.setIdgenre_algue(valeurAutoGeneree.getInt(1));
                // quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return genre_algue;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        GenreAlgue genre_algue = (GenreAlgue) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    genre_algue.getIdfamille(),
                    genre_algue.getDesign_genre_algue(),
                    genre_algue.isVisible(),
                    genre_algue.getIdgenre_algue());

            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return genre_algue;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        GenreAlgue genre_algue = (GenreAlgue) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false,
                    genre_algue.getIdgenre_algue());
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
    public ArrayList<Object> find(int i) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> genre_algues = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL_S, false,i);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                GenreAlgue genre_algue = new GenreAlgue();
                genre_algue.setIdfamille(resultSet.getInt("idfamille"));
                genre_algue.setDesign_genre_algue(resultSet.getString("design_genre_algue"));
                genre_algue.setIdgenre_algue(resultSet.getInt("idgenre_algue"));
                genre_algue.setVisible(resultSet.getBoolean("visible"));

                genre_algues.add(genre_algue);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return genre_algues;
    }
}
