/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.ligne_gene_toxicite;

import com.pasteur.ci.bean.LigneGeneCyano;
import com.pasteur.ci.bean.LigneTypeGeneToxicite;
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
 * @author HP USER
 */
public class LigneGeneToxiciteDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idligne_type_toxicite,idtyp_gene_toxicite,idcyano, concentration from ligne_type_gene_toxicite where idligne_type_toxicite = ? ";
    private static final String SQL_SELECT_ALL = "select idligne_type_toxicite,idtyp_gene_toxicite,idcyano, concentration from ligne_type_gene_toxicite";
    private static final String SQL_CREATE = "insert into ligne_type_gene_toxicite (idtyp_gene_toxicite,idcyano, concentration) values (?,?,?)";
    private static final String SQL_UPDATE = "update ligne_type_gene_toxicite set idtyp_gene_toxicite= ?,idcyano = ?, , concentration = ? where idligne_type_toxicite = ?";
    private static final String SQL_DELETE = "delete from ligne_type_gene_toxicite where idligne_type_toxicite = ? ";

    public LigneGeneToxiciteDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        LigneTypeGeneToxicite ligne_type_gene_toxicite = (LigneTypeGeneToxicite) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, ligne_type_gene_toxicite.getIdlignetype_toxicite());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                ligne_type_gene_toxicite.setIdcyano(resultSet.getInt("idgene_cyano"));
                ligne_type_gene_toxicite.setIdtyp_gene_toxicite(resultSet.getInt("idligne_type_gene_toxicite"));
                ligne_type_gene_toxicite.setConcentration_gene_toxicite(resultSet.getDouble("concentration"));
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_type_gene_toxicite;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> ligne_type_gene_toxicites = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneTypeGeneToxicite ligne_type_gene_toxicite = new LigneTypeGeneToxicite();
                ligne_type_gene_toxicite.setIdtyp_gene_toxicite(resultSet.getInt("idtyp_gene_toxicite"));
                ligne_type_gene_toxicite.setIdlignetype_toxicite(resultSet.getInt("idligne_type_gene_toxicite"));
                ligne_type_gene_toxicite.setIdcyano(resultSet.getInt("idcyano"));
                ligne_type_gene_toxicite.setConcentration_gene_toxicite(resultSet.getDouble("concentration"));

                ligne_type_gene_toxicites.add(ligne_type_gene_toxicite);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_type_gene_toxicites;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        LigneTypeGeneToxicite ligne_type_gene_toxicite = (LigneTypeGeneToxicite) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true, ligne_type_gene_toxicite.getIdcyano(),
                    ligne_type_gene_toxicite.getIdtyp_gene_toxicite(), ligne_type_gene_toxicite.getConcentration_gene_toxicite());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                ligne_type_gene_toxicite.setIdlignetype_toxicite(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_type_gene_toxicite;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneTypeGeneToxicite ligne_type_gene_toxicite = (LigneTypeGeneToxicite) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false, ligne_type_gene_toxicite.getIdcyano(),
                    ligne_type_gene_toxicite.getIdtyp_gene_toxicite(), ligne_type_gene_toxicite.getConcentration_gene_toxicite(), ligne_type_gene_toxicite.getIdlignetype_toxicite());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_type_gene_toxicite;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneTypeGeneToxicite ligne_type_gene_toxicite = (LigneTypeGeneToxicite) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, ligne_type_gene_toxicite.getIdlignetype_toxicite());
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
