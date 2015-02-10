/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.ligne_espece_algue.dao;

import com.pasteur.ci.bean.LigneEspeceAlgue;
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
public class LigneEspeceAlgueDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idligne_espece_algue,idgenre_algue,idespece_algue from ligne_espece_algue where idligne_espece_algue = ? ";
    private static final String SQL_SELECT_ALL = "select  idligne_espece_algue,idgenre_algue,idespece_algue from ligne_espece_algue";
    private static final String SQL_CREATE = "insert into ligne_espece_algue (idgenre_algue,idespece_algue) values (?,?)";
    private static final String SQL_UPDATE = "update ligne_espce_algue set idespece_algue = ?,idgenre_algue = ? where idligne_espece_algue = ?";
    private static final String SQL_DELETE = "delete from ligne_espece_algue where idligne_espece_algue = ? ";

    public LigneEspeceAlgueDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        LigneEspeceAlgue ligne_espece_algue = (LigneEspeceAlgue) obj;
        //Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, ligne_espece_algue.getIdligne_espece_algue());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ligne_espece_algue.setIdligne_espece_algue(resultSet.getInt("idligne_espece_algue"));
                ligne_espece_algue.setIdgenre_algue(resultSet.getInt("idgenre_algue"));
                ligne_espece_algue.setIdespece_algue(resultSet.getInt("idespece_algue"));
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_espece_algue;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> ligne_espece_algues = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneEspeceAlgue ligne_espece_algue = new LigneEspeceAlgue();
                ligne_espece_algue.setIdligne_espece_algue(resultSet.getInt("idligne_espece_algue"));
                ligne_espece_algue.setIdgenre_algue(resultSet.getInt("idgenre_algue"));
                ligne_espece_algue.setIdespece_algue(resultSet.getInt("idespece_algue"));
                ligne_espece_algues.add(ligne_espece_algue);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_espece_algues;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        LigneEspeceAlgue ligne_espece_algue = (LigneEspeceAlgue) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true, ligne_espece_algue.getIdespece_algue(), ligne_espece_algue.getIdgenre_algue());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                ligne_espece_algue.setIdligne_espece_algue(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_espece_algue;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneEspeceAlgue ligne_espece_algue = (LigneEspeceAlgue) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false, ligne_espece_algue.getIdespece_algue(), ligne_espece_algue.getIdespece_algue(), ligne_espece_algue.getIdligne_espece_algue());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_espece_algue;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneEspeceAlgue ligne_espece_algue = (LigneEspeceAlgue) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, ligne_espece_algue.getIdligne_espece_algue());
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
