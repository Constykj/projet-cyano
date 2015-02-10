/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.ligne_genre_algue.dao;

import com.pasteur.ci.bean.LigneGenreAlgue;
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
public class LigneGenreAlgueDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select * from ligne_genre_algue where idligne_famille = ? ";
    private static final String SQL_SELECT_ALL = "select idligne_genre_algue,idgenre_algue,idligne_famille from ligne_genre_algue";
    private static final String SQL_CREATE = "insert into ligne_genre_algue (idgenre_algue,idligne_famille) values (?,?)";
    private static final String SQL_UPDATE = "update ligne_genre_algue set idgenre_algue = ?,idligne_famille = ? where idligne_genre_cyano = ?";
    private static final String SQL_DELETE = "delete from ligne_genre_algue where idligne_famille = ? ";

    public LigneGenreAlgueDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public ArrayList<Object>  find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        LigneGenreAlgue ligne_genre_algue_ = (LigneGenreAlgue) obj;
        ArrayList<Object> ligne_genre_algues = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false,ligne_genre_algue_.getIdligne_famille());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneGenreAlgue ligne_genre_algue = new LigneGenreAlgue();
                ligne_genre_algue.setIdgenre_algue(resultSet.getInt("idgenre_algue"));
                ligne_genre_algue.setIdligne_genre_algue(resultSet.getInt("idligne_genre_algue"));
                ligne_genre_algue.setIdligne_famille(resultSet.getInt("idligne_famille"));                 
                ligne_genre_algues.add(ligne_genre_algue);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_genre_algues;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> ligne_genre_algues = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneGenreAlgue ligne_genre_algue = new LigneGenreAlgue();
                ligne_genre_algue.setIdgenre_algue(resultSet.getInt("idgenre_algue"));
                ligne_genre_algue.setIdligne_genre_algue(resultSet.getInt("idligne_genre_algue"));
                ligne_genre_algue.setIdligne_famille(resultSet.getInt("idligne_famille"));
                // quartier.setIdquartier(resultSet.getInt("idquartier"));
                //quartier.setDesignation(resultSet.getString("designation"));
                ligne_genre_algues.add(ligne_genre_algue);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_genre_algues;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        LigneGenreAlgue ligne_genre_algue = (LigneGenreAlgue) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    ligne_genre_algue.getIdgenre_algue(),
                    ligne_genre_algue.getIdligne_famille());

            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                ligne_genre_algue.setIdligne_genre_algue(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_genre_algue;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneGenreAlgue ligne_genre_algue = (LigneGenreAlgue) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false, ligne_genre_algue.getIdligne_famille(), ligne_genre_algue.getIdligne_genre_algue(), ligne_genre_algue.getIdligne_genre_algue());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_genre_algue;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneGenreAlgue ligne_genre_algue = (LigneGenreAlgue) obj;
        System.out.println("idligne_famille: "+ligne_genre_algue.getIdligne_famille());
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false,
                    ligne_genre_algue.getIdligne_famille());
        
            int statut = preparedStatement.executeUpdate();
//             
//            if (statut == 0) {
//                throw new DAOException("Echec a la suppression ");
//            }
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
