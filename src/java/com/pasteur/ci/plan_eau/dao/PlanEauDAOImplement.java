
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.plan_eau.dao;

import com.pasteur.ci.bean.PlanEau;
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
public class PlanEauDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idplan_eau,designation,superficie,matiere_fecale,idtype_plan_eau,commentaire,idquartier,idcommune,idregion,visible from plan_eau where idplan_eau = ? ";
    private static final String SQL_SELECT_ALL = "select idplan_eau,designation,superficie,matiere_fecale,idtype_plan_eau,commentaire,idquartier,idcommune,idregion,visible from plan_eau";
    private static final String SQL_CREATE = "insert into plan_eau (designation,superficie,idregion,matiere_fecale,idquartier,idcommune,idtype_plan_eau,commentaire,visible) values (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "update plan_eau set designation= ? ,superficie= ?,idregion= ?,matiere_fecale= ?,idquartier= ?,idcommune= ?,idtype_plan_eau= ?,commentaire= ?,visible= ? where idplan_eau = ?";
    private static final String SQL_DELETE = "delete from plan_eau where idplan_eau = ? ";

    public PlanEauDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        PlanEau plan_eau = (PlanEau) obj;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false,
                    plan_eau.getIdplan_eau());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                plan_eau.setCommentaire(resultSet.getString("commentaire"));
                plan_eau.setDesignation(resultSet.getString("designation"));
                plan_eau.setIdcommune(resultSet.getInt("idcommune"));
                plan_eau.setIdplan_eau(resultSet.getInt("idplan_eau"));
                plan_eau.setIdquartier(resultSet.getInt("idquartier"));
                plan_eau.setIdregion(resultSet.getInt("idregion"));
                plan_eau.setIdtype_plan_eau(resultSet.getInt("idtype_plan_eau"));
                plan_eau.setMatiere_fecale(resultSet.getBoolean("matiere_fecale"));
                plan_eau.setSuperficie(resultSet.getDouble("superficie"));
                plan_eau.setVisible(resultSet.getBoolean("visible"));
            }
            
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
            
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return plan_eau;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> plan_eaux = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PlanEau plan_eau = new PlanEau();
                plan_eau.setCommentaire(resultSet.getString("commentaire"));
                plan_eau.setDesignation(resultSet.getString("designation"));
                plan_eau.setIdcommune(resultSet.getInt("idcommune"));
                plan_eau.setIdplan_eau(resultSet.getInt("idplan_eau"));
                plan_eau.setIdquartier(resultSet.getInt("idquartier"));
                plan_eau.setIdregion(resultSet.getInt("idregion"));
                plan_eau.setIdtype_plan_eau(resultSet.getInt("idtype_plan_eau"));
                plan_eau.setMatiere_fecale(resultSet.getBoolean("matiere_fecale"));
                plan_eau.setSuperficie(resultSet.getDouble("superficie"));
                plan_eau.setVisible(resultSet.getBoolean("visible"));
                plan_eaux.add(plan_eau);
            }
              DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return plan_eaux;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        PlanEau plan_eau = (PlanEau) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    plan_eau.getDesignation(), 
                    plan_eau.getSuperficie(),
                    plan_eau.getIdregion(), 
                    plan_eau.getMatiere_fecale(), 
                    plan_eau.getIdquartier(), 
                    plan_eau.getIdcommune(),
                    plan_eau.getIdtype_plan_eau(),
                    plan_eau.getCommentaire(), 
                    plan_eau.isVisible());

            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation de la commune");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                plan_eau.setIdplan_eau(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation de la commune, aucun ID retorne");
            }
  DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return plan_eau;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        PlanEau plan_eau = (PlanEau) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    
                    plan_eau.getDesignation(),
                    plan_eau.getSuperficie(), 
                    plan_eau.getIdregion(),
                    plan_eau.getMatiere_fecale(),
                    plan_eau.getIdquartier(),
                    plan_eau.getIdcommune(),
                    plan_eau.getIdtype_plan_eau(),
                    plan_eau.getCommentaire(),
                    plan_eau.isVisible(),
                    plan_eau.getIdplan_eau());
            
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour du plan d'eau");
            }
  DAOUtilitaire.fermetureSilencieuse( preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return plan_eau;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        PlanEau plan_eau = (PlanEau) obj;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, plan_eau.getIdplan_eau());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echect a la suppression du plan d'eau");
            }
  DAOUtilitaire.fermetureSilencieuse( preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public Object find(int i) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
