/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.ligne_type_gene_toxicite.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.pasteur.ci.bean.LigneTypeGeneCyano;
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
 * @author abouchou
 */
public class LigneTypeGeneToxiciteDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select * from ligne_type_gene_toxicite where idcyano = ? order by idligne_type_toxicite";
    private static final String SQL_SELECT_ALL = "select idligne_gene_toxicite,idtyp_gene_toxicite,idcyano,concentration  from ligne_gene_cyano";
    private static final String SQL_CREATE = "insert into ligne_type_gene_toxicite (idtyp_gene_toxicite,idcyano,concentration) values (?,?,?)";
    private static final String SQL_UPDATE = "update ligne_type_gene_toxicite set idtyp_gene_toxicite=?,idcyano=?,concentration=? where idligne_type_toxicite = ?";
    private static final String SQL_DELETE = "delete from ligne_gene_toxicite where idligne_gene_toxicite = ? ";

    public LigneTypeGeneToxiciteDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public ArrayList<Object> find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        LigneTypeGeneToxicite ligneTypeGeneToxicite = (LigneTypeGeneToxicite) obj;
        ArrayList<Object> ligne_toxines = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, ligneTypeGeneToxicite.getIdcyano());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneTypeGeneToxicite ligne_gene_cyano = new LigneTypeGeneToxicite();
                ligne_gene_cyano.setIdlignetype_toxicite(resultSet.getInt("idligne_type_toxicite"));
                ligne_gene_cyano.setIdtyp_gene_toxicite(resultSet.getInt("idtyp_gene_toxicite"));
                ligne_gene_cyano.setIdcyano(resultSet.getInt("idcyano"));
                ligne_gene_cyano.setConcentration_gene_toxicite(resultSet.getInt("concentration"));
                ligne_toxines.add(ligne_gene_cyano);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_toxines;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> ligne_toxines = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LigneTypeGeneToxicite ligne_gene_cyano = new LigneTypeGeneToxicite();
                ligne_gene_cyano.setIdlignetype_toxicite(resultSet.getInt("idligne_type_toxicite"));
                ligne_gene_cyano.setIdtyp_gene_toxicite(resultSet.getInt("idtyp_gene_toxicite"));
                ligne_gene_cyano.setIdcyano(resultSet.getInt("idcyano"));
                ligne_gene_cyano.setConcentration_gene_toxicite(resultSet.getInt("concentration"));
                ligne_toxines.add(ligne_gene_cyano);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ligne_toxines;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        LigneTypeGeneToxicite ligneTypeGeneCyano = (LigneTypeGeneToxicite) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    ligneTypeGeneCyano.getIdtyp_gene_toxicite(),
                    ligneTypeGeneCyano.getIdcyano(),
                    ligneTypeGeneCyano.getConcentration_gene_toxicite());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                ligneTypeGeneCyano.setIdlignetype_toxicite(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligneTypeGeneCyano;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneTypeGeneToxicite ligneTypeGeneCyano = (LigneTypeGeneToxicite) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    ligneTypeGeneCyano.getIdtyp_gene_toxicite(),
                    ligneTypeGeneCyano.getIdcyano(),
                    ligneTypeGeneCyano.getConcentration_gene_toxicite(),
                    ligneTypeGeneCyano.getIdlignetype_toxicite());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return ligneTypeGeneCyano;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        LigneTypeGeneToxicite ligneTypeGeneCyano = (LigneTypeGeneToxicite) obj;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false,
                    ligneTypeGeneCyano.getIdlignetype_toxicite());
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
