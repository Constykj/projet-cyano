/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.ligne_vibrionaces.dao;

import com.pasteur.ci.bean.LigneVibrionaces;
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
public class LigneVibrionacesDAOImplement  implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idligne_vibrionaces,idautre_bacterie,idvibrio from ligne_vibrionaces where idligne_vibrionaces = ? ";
    private static final String SQL_SELECT_ALL = "select idligne_vibrionaces,idautre_bacterie,idvibrio from ligne_vibrionaces";
    private static final String SQL_CREATE = "insert into ligne_vibrionaces (idautre_bacterie,idvibrio) values (?,?)";
    private static final String SQL_UPDATE = "update ligne_vibrionaces set idautre_bacterie = ?,idvibrio = ? where idligne_vibrionaces = ?";
    private static final String SQL_DELETE = "delete from ligne_vibrionaces where idligne_vibrionaces= ? ";

    public LigneVibrionacesDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        LigneVibrionaces ligne_vibrionaces = (LigneVibrionaces) obj;
        
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, ligne_vibrionaces.getIdligne_vibrionaces());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ligne_vibrionaces.setIdautre_bacterie(resultSet.getInt("autre_bacterie"));
               ligne_vibrionaces.setIdligne_vibrionaces(resultSet.getInt("idigne_vibrionaces"));
               ligne_vibrionaces.setIdvibrio(resultSet.getInt("idvibrio"));
            }
              DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_vibrionaces;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> igne_vibrionace = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneVibrionaces igne_vibrionaces = new LigneVibrionaces();
                igne_vibrionaces.setIdautre_bacterie(resultSet.getInt("autre_bacterie"));
                igne_vibrionaces.setIdligne_vibrionaces(resultSet.getInt("idigne_vibrionaces"));
               igne_vibrionaces.setIdvibrio(resultSet.getInt("idvibrio"));
               igne_vibrionace.add(igne_vibrionaces) ;
            }
              DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return igne_vibrionace;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
         LigneVibrionaces ligne_vibrionaces = (LigneVibrionaces) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true, ligne_vibrionaces.getIdautre_bacterie(),ligne_vibrionaces.getIdvibrio());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                ligne_vibrionaces.setIdligne_vibrionaces(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
  DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_vibrionaces;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
         LigneVibrionaces ligne_vibrionaces = (LigneVibrionaces) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,ligne_vibrionaces.getIdautre_bacterie(),ligne_vibrionaces.getIdvibrio(),ligne_vibrionaces.getIdligne_vibrionaces());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
  DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_vibrionaces;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneVibrionaces ligne_vibrionaces = (LigneVibrionaces) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false,ligne_vibrionaces.getIdligne_vibrionaces());
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
