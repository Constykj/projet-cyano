/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.cyanobacterie.dao;

import com.pasteur.ci.bean.Cyanobacterie;
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
public class CyanobacterieDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idcyano  , type_gene_cyano, conc_gene_cyano, gene_toxicite,gene_cyano,conc_gene_toxicite,type_gene_toxicite, conc_microcystine, type_microcystine, conc_anatoxine, conc_saxitoxine, conc_cylindrospermopsine,visible from cyanobacterie where idcyano = ? ";
    private static final String SQL_SELECT_ALL = "select idcyano, type_gene_cyano, conc_gene_cyano, gene_toxicite,gene_cyano,conc_gene_toxicite,type_gene_toxicite, conc_microcystine, type_microcystine, conc_anatoxine, conc_saxitoxine, conc_cylindrospermopsine,visible from cyanobacterie";
    private static final String SQL_CREATE = "insert into cyanobacterie (idcyano) values (?)";
    private static final String SQL_UPDATE = "update cyanobacterie set   type_gene_cyano = ?, conc_gene_cyano = ?, gene_toxicite = ?,gene_cyano = ?,conc_gene_toxicite = ?,type_gene_toxicite = ?, conc_microcystine = ?, type_microcystine = ?, conc_anatoxine = ?, conc_saxitoxine = ?, conc_cylindrospermopsine = ?,visible = ? where idcyano = ?";
    private static final String SQL_DELETE = "delete from cyanobacterie where idcyano = ? ";

    public CyanobacterieDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Cyanobacterie cyanobacterie = (Cyanobacterie) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, cyanobacterie.getIdcyano());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cyanobacterie.setIdcyano(resultSet.getInt("idcyano"));
                

            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return cyanobacterie;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> cyano = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Cyanobacterie cyanobacterie = new Cyanobacterie();
                cyanobacterie.setIdcyano(resultSet.getInt("idcyano"));
                 

                cyano.add(cyanobacterie);
                //quartiers.add(quartier);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return cyano;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        Cyanobacterie cyanobacterie = (Cyanobacterie) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true, (Object) null);
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                cyanobacterie.setIdcyano(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation , aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return cyanobacterie;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Cyanobacterie cyanobacterie = (Cyanobacterie) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
             
                    cyanobacterie.getIdcyano());

            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return cyanobacterie;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Cyanobacterie cyanobacterie = (Cyanobacterie) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, cyanobacterie.getIdcyano());
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
