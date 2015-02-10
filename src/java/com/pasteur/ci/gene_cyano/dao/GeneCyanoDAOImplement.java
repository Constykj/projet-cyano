/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.gene_cyano.dao;

import com.pasteur.ci.bean.GeneCyano;
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
public class GeneCyanoDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idgene_cyano,design_gene_cyano,visib from gene_cyano where idgene_cyano = ? ";
    private static final String SQL_SELECT_ALL = "select idgene_cyano, design_gene_cyano, visib from gene_cyano";
    private static final String SQL_CREATE = "insert into gene_cyano (design_gene_cyano,visib) values (?,?)";
    private static final String SQL_UPDATE = "update gene_cyano set design_gene_cyano = ?,visib = ? where idgene_cyano= ?";
    private static final String SQL_DELETE = "delete from gene_cyano where idgene_cyano = ? ";

    public GeneCyanoDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        GeneCyano gene_cyano = (GeneCyano) obj;
        //Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, gene_cyano.getIdgene_cyano());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                gene_cyano.setDesign_gene_cyano(resultSet.getString("design_gene_cyano"));
                gene_cyano.setIdgene_cyano(resultSet.getInt("idgene_cyano"));
                gene_cyano.setVisib(resultSet.getBoolean("visib"));
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return gene_cyano;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> gene_cyanos = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                GeneCyano gene_cyano = new GeneCyano();
                gene_cyano.setDesign_gene_cyano(resultSet.getString("design_gene_cyano"));
                gene_cyano.setIdgene_cyano(resultSet.getInt("idgene_cyano"));
                gene_cyano.setVisib(resultSet.getBoolean("visib"));

                gene_cyanos.add(gene_cyano);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return gene_cyanos;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        GeneCyano gene_cyano = (GeneCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    gene_cyano.getDesign_gene_cyano(),
                    gene_cyano.getVisib());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                gene_cyano.setIdgene_cyano(valeurAutoGeneree.getInt(1));
                // quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return gene_cyano;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        GeneCyano gene_cyano = (GeneCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    gene_cyano.getDesign_gene_cyano(),
                    gene_cyano.getVisib(),
                    gene_cyano.getIdgene_cyano());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return gene_cyano;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        GeneCyano gene_cyano = (GeneCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false,
                    gene_cyano.getIdgene_cyano());
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
