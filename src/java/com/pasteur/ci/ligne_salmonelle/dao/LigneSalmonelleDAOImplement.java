/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.ligne_salmonelle.dao;

import com.pasteur.ci.bean.LigneSalmonelle;
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
public class LigneSalmonelleDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idligne_salmonelle,idautre_bacterie,idsalmonelle from contient_sal where idligne_salmonelle = ? ";
    private static final String SQL_SELECT_ALL = "select idligne_salmonelle,idautre_bacterie,idsalmonelle from ligne_salmonelle";
    private static final String SQL_CREATE = "insert into contient_sal (idautre_bacterie,idsalmonelle) values (?,?)";
    private static final String SQL_UPDATE = "update ligne_salmonelle set idautre_bacterie = ?,idsalmonelle = ? where idligne_salmonelle = ?";
    private static final String SQL_DELETE = "delete from ligne_salmonelle where idligne_salmonelle = ? ";

    public LigneSalmonelleDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        LigneSalmonelle ligne_salmonelle = (LigneSalmonelle) obj;
        //Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, ligne_salmonelle.getIdligne_salmonelle());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ligne_salmonelle.setIdautre_bacterie(resultSet.getInt("idautre_bacterie"));
                ligne_salmonelle.setIdligne_salmonelle(resultSet.getInt("idligne_salmonelle"));
                ligne_salmonelle.setIdsalmonelle(resultSet.getInt("idligne_salmonelle"));
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_salmonelle;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> ligne_salmonelles = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneSalmonelle ligne_salmonelle = new LigneSalmonelle();
                ligne_salmonelle.setIdautre_bacterie(resultSet.getInt("idautre_bacterie"));
                ligne_salmonelle.setIdligne_salmonelle(resultSet.getInt("idligne_salmonelle"));
                ligne_salmonelle.setIdsalmonelle(resultSet.getInt("idsalmonelle"));
                ligne_salmonelles.add(ligne_salmonelle);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_salmonelles;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        LigneSalmonelle ligne_salmonelle = (LigneSalmonelle) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true, ligne_salmonelle.getIdautre_bacterie(), ligne_salmonelle.getIdsalmonelle());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                ligne_salmonelle.setIdligne_salmonelle(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_salmonelle;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneSalmonelle ligne_salmonelle = new LigneSalmonelle();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false, ligne_salmonelle.getIdautre_bacterie(), ligne_salmonelle.getIdsalmonelle(), ligne_salmonelle.getIdligne_salmonelle());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_salmonelle;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneSalmonelle ligne_salmonelle = (LigneSalmonelle) obj;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, ligne_salmonelle.getIdligne_salmonelle());
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
