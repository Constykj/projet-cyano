/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.ligne_espece_cyano.dao;

import com.pasteur.ci.bean.LigneEspeceCyano;
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
public class LigneEspeceCyanoDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idligne_espece_cyano,idgenre_cyano,idespece_cyano from ligne_espece_cyano where idligne_espece_cyano = ? ";
    private static final String SQL_SELECT_ALL = "select idligne_espece_cyano,idgenre_cyano,idespece_cyano from ligne_espece_cyano";
    private static final String SQL_CREATE = "insert into ligne_espece_cyano (idgenre_cyano,idespece_cyano) values (?,?)";
    private static final String SQL_UPDATE = "update ligne_espce_cyano set idespece_cyano= ?,idgenre_cyano = ? where idligne_espece_cyano = ?";
    private static final String SQL_DELETE = "delete from ligne_espece_cyano where idligne_espece_cyano = ? ";

    public LigneEspeceCyanoDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        LigneEspeceCyano ligne_espece_cyano = (LigneEspeceCyano) obj;
        //Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, ligne_espece_cyano.getIdligne_espece_cyano());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ligne_espece_cyano.setIdligne_espece_cyano(resultSet.getInt("idligne_espece_cyano"));
                ligne_espece_cyano.setIdgenre_cyano(resultSet.getInt("idgenre_cyano"));
                ligne_espece_cyano.setIdespece_cyano(resultSet.getInt("idespece_cyano"));
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_espece_cyano;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> ligne_espece_cyanos = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneEspeceCyano ligne_espece_cyano = new LigneEspeceCyano();
                ligne_espece_cyano.setIdligne_espece_cyano(resultSet.getInt("idligne_espece_cyano"));
                ligne_espece_cyano.setIdgenre_cyano(resultSet.getInt("idgenre_cyano"));
                ligne_espece_cyano.setIdespece_cyano(resultSet.getInt("idespece_cyano"));
                // quartier.setIdquartier(resultSet.getInt("idquartier"));
                //quartier.setDesignation(resultSet.getString("designation"));
                ligne_espece_cyanos.add(ligne_espece_cyano);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_espece_cyanos;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        LigneEspeceCyano ligne_espece_cyano = (LigneEspeceCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true, ligne_espece_cyano.getIdespece_cyano(), ligne_espece_cyano.getIdgenre_cyano());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                ligne_espece_cyano.setIdligne_espece_cyano(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_espece_cyano;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneEspeceCyano ligne_espece_cyano = (LigneEspeceCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false, ligne_espece_cyano.getIdespece_cyano(), ligne_espece_cyano.getIdgenre_cyano(), ligne_espece_cyano.getIdligne_espece_cyano());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
DAOUtilitaire.fermetureSilencieuse( preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_espece_cyano;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneEspeceCyano ligne_espece_cyano = (LigneEspeceCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, ligne_espece_cyano.getIdligne_espece_cyano());
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
