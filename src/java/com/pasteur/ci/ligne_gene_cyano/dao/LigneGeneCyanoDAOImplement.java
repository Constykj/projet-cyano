/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.ligne_gene_cyano.dao;

/**
 *
 * @author HP USER
 */
import com.pasteur.ci.bean.LigneGeneCyano;
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
public class LigneGeneCyanoDAOImplement implements BaseDAO {

    private final DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idligne_gene_cyano,idgene_cyano,idcyano, concentration from ligne_gene_cyano where idcyano = ? order by idligne_gene_cyano";
    private static final String SQL_SELECT_ALL = "select idligne_gene_cyano,idgene_cyano,idcyano, concentration from ligne_gene_cyano";
    private static final String SQL_CREATE = "insert into ligne_gene_cyano (idcyano, idgene_cyano,concentration) values (?,?,?)";
    private static final String SQL_UPDATE = "update ligne_gene_cyano set idcyano = ?, idgene_cyano= ?, concentration = ? where idligne_gene_cyano = ?";
    private static final String SQL_DELETE = "delete from ligne_gene_cyano where idligne_gene_cyano = ? ";

    public LigneGeneCyanoDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public ArrayList<Object> find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        LigneGeneCyano ligne_gene_cyano = (LigneGeneCyano) obj;
        ArrayList<Object> ligne_gene_cyanos = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, ligne_gene_cyano.getIdcyano());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneGeneCyano ligne_gene_cyano_ = new LigneGeneCyano();
                ligne_gene_cyano_.setIdgene_cyano(resultSet.getInt("idgene_cyano"));
                ligne_gene_cyano_.setIdligne_gene_cyano(resultSet.getInt("idligne_gene_cyano"));
                ligne_gene_cyano_.setIdcyano(resultSet.getInt("idcyano"));
                ligne_gene_cyano_.setConcentration_gene_cyano(resultSet.getInt("concentration"));

                ligne_gene_cyanos.add(ligne_gene_cyano_);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_gene_cyanos;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> ligne_gene_cyanos = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneGeneCyano ligne_gene_cyano = new LigneGeneCyano();
                ligne_gene_cyano.setIdgene_cyano(resultSet.getInt("idgene_cyano"));
                ligne_gene_cyano.setIdligne_gene_cyano(resultSet.getInt("idligne_gene_cyano"));
                ligne_gene_cyano.setIdcyano(resultSet.getInt("idcyano"));
                ligne_gene_cyano.setConcentration_gene_cyano(resultSet.getInt("concentration"));

                ligne_gene_cyanos.add(ligne_gene_cyano);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_gene_cyanos;
    }

    /**
     *
     * @param object
     * @return
     * @throws DAOException
     */
//    @Override
//    public ArrayList<Object> find(Object object) throws DAOException {
//
//        Connection connection;
//        PreparedStatement preparedStatement;
//        ResultSet resultSet;
//        ArrayList<Object> ligne_gene_cyanos = new ArrayList<Object>();
//
//        try {
//            connection = daoFactory.getConnection();
//            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                LigneGeneCyano ligne_gene_cyano = new LigneGeneCyano();
//                ligne_gene_cyano.setIdgene_cyano(resultSet.getInt("idgene_cyano"));
//                ligne_gene_cyano.setIdligne_gene_cyano(resultSet.getInt("idligne_gene_cyano"));
//                ligne_gene_cyano.setIdcyano(resultSet.getInt("idcyano"));
//                ligne_gene_cyano.setConcentration(resultSet.getInt("concentration"));
//
//                ligne_gene_cyanos.add(ligne_gene_cyano);
//            }
//            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
//        } catch (Exception e) {
//            throw new DAOException(e);
//        }
//        return ligne_gene_cyanos;
//    }
    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        LigneGeneCyano ligne_gene_cyano = (LigneGeneCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    ligne_gene_cyano.getIdcyano(),
                    ligne_gene_cyano.getIdgene_cyano(),
                    ligne_gene_cyano.getConcentration_gene_cyano());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                ligne_gene_cyano.setIdligne_gene_cyano(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_gene_cyano;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneGeneCyano ligne_gene_cyano = (LigneGeneCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    ligne_gene_cyano.getIdcyano(),
                    ligne_gene_cyano.getIdgene_cyano(),
                    ligne_gene_cyano.getConcentration_gene_cyano(),
                    ligne_gene_cyano.getIdligne_gene_cyano());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligne_gene_cyano;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneGeneCyano ligne_gene_cyano = (LigneGeneCyano) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, ligne_gene_cyano.getIdligne_gene_cyano());
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

        return null;
    }
}
