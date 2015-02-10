/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.ligne_genre_cyano.dao;

import com.pasteur.ci.bean.LigneGenreCyano;
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
public class LigneGenreCyanoDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select * from ligne_genre_cyano where idcyano = ? ";
    private static final String SQL_SELECT_ALL = "select idligne_genre_cyano,idcyano,idgenre_cyano,idespece_cyano, denombrement from ligne_genre_cyano";
    private static final String SQL_CREATE = "insert into ligne_genre_cyano (idcyano,idgenre_cyano,idespece_cyano, denombrement) values (?,?,?,?)";
    private static final String SQL_UPDATE = "update ligne_genre_cyano set idcyano=?,idgenre_cyano=?,idespece_cyano=?, denombrement=? where idligne_genre_cyano = ?";
    private static final String SQL_DELETE = "delete from ligne_genre_cyano where idligne_genre_cyano = ? ";

    public LigneGenreCyanoDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public ArrayList<Object> find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        LigneGenreCyano ligne_genre_cyano_ = (LigneGenreCyano) obj;
        ArrayList<Object> ligne_genre_cyanos = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, ligne_genre_cyano_.getIdcyano());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneGenreCyano ligne_genre_cyano = new LigneGenreCyano();
                ligne_genre_cyano.setIdligne_genre_cyano(resultSet.getInt("idligne_genre_cyano"));
                ligne_genre_cyano.setIdcyano(resultSet.getInt("idcyano"));
                ligne_genre_cyano.setIdgenre_cyano(resultSet.getInt("idgenre_cyano"));
                ligne_genre_cyano.setIdespece_cyano(resultSet.getInt("idespece_cyano"));
                ligne_genre_cyano.setDenombrement_esp_cyano(resultSet.getInt("denombrement"));

                ligne_genre_cyanos.add(ligne_genre_cyano);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_genre_cyanos;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> ligne_genre_cyanos = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneGenreCyano ligne_genre_cyano = new LigneGenreCyano();
                ligne_genre_cyano.setIdligne_genre_cyano(resultSet.getInt("idligne_genre_cyano"));
                ligne_genre_cyano.setIdcyano(resultSet.getInt("idcyano"));
                ligne_genre_cyano.setIdgenre_cyano(resultSet.getInt("idgenre_cyano"));
                ligne_genre_cyano.setIdespece_cyano(resultSet.getInt("idespece_cyano"));
                ligne_genre_cyano.setDenombrement_esp_cyano(resultSet.getInt("denombrement"));

                ligne_genre_cyanos.add(ligne_genre_cyano);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_genre_cyanos;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        LigneGenreCyano ligne_genre_cyano = (LigneGenreCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true, ligne_genre_cyano.getIdcyano(),
                    ligne_genre_cyano.getIdgenre_cyano(), ligne_genre_cyano.getIdespece_cyano(), ligne_genre_cyano.getDenombrement_esp_cyano());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                ligne_genre_cyano.setIdligne_genre_cyano(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_genre_cyano;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneGenreCyano ligne_genre_cyano = (LigneGenreCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    ligne_genre_cyano.getIdcyano(),
                    ligne_genre_cyano.getIdgenre_cyano(),
                    ligne_genre_cyano.getIdespece_cyano(),
                    ligne_genre_cyano.getDenombrement_esp_cyano(),
                    ligne_genre_cyano.getIdligne_genre_cyano());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_genre_cyano;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneGenreCyano ligne_genre_cyano = (LigneGenreCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, ligne_genre_cyano.getIdligne_genre_cyano());
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
