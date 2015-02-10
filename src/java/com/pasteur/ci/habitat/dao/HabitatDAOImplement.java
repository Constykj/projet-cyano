/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.habitat.dao;

import com.pasteur.ci.bean.Habitat;
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
public class HabitatDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idhabitat,design_habitat,dist_bord_lagune,effectif,idplan_eau,visible from habitat where idhabitat = ? ";
    private static final String SQL_SELECT_ALL = "select idhabitat,design_habitat,dist_bord_lagune,effectif,idplan_eau,visible from habitat";
    private static final String SQL_CREATE = "insert into habitat (design_habitat,dist_bord_lagune,effectif,idplan_eau,visible) values (?,?,?,?,?)";
    private static final String SQL_UPDATE = "update habitat set design_habitat=?,dist_bord_lagune = ?,effectif = ?,idplan_eau = ?,visible = ? where idhabitat = ?";

    private static final String SQL_DELETE = "delete from habitat where idhabitat = ? ";

    //nouvelle variable
    private static final String SQL_SELECT_S = "select idligne_habitat,idmateriaux_construction,idhabitat from ligne_habitat where idhabitat = ? ";

    public HabitatDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

//    
//    public ArrayList<Object> findS(Object obj) throws DAOException {
//
//        Connection connection;
//        PreparedStatement preparedStatement;
//        ResultSet resultSet;
//        ArrayList<Object> ligne_habitats = new ArrayList<>();
//        LigneHabitat ligneHabitat = (LigneHabitat) obj;
//
//        try {
//            connection = daoFactory.getConnection();
//            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_S, false, ligneHabitat.getIdhabitat());
//            
//            
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                LigneHabitat ligne_habitat = new LigneHabitat();
//                ligne_habitat.setIdligne_habitat(resultSet.getInt("idligne_habitat"));
//                ligne_habitat.setIdhabitat(resultSet.getInt("idhabitat"));
//                ligne_habitat.setIdmateriaux_construction(resultSet.getInt("idmateriaux_construction"));
//                
//                ligne_habitats.add(ligne_habitat);
//            }
//        } catch (Exception e) {
//            throw new DAOException(e);
//        }
//        return ligne_habitats;
//    }
//
    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Habitat habitat = (Habitat) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false,
                    habitat.getIdhabitat());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                habitat.setIdhabitat(resultSet.getInt("idhabitat"));
                habitat.setDesign_habitat(resultSet.getString("design_habitat"));
                habitat.setDist_bord_lagune(resultSet.getDouble("dist_bord_lagune"));
                habitat.setEffectif(resultSet.getInt("effectif"));
                habitat.setIdplan_eau(resultSet.getInt("idplan_eau"));
                habitat.setVisible(resultSet.getBoolean("visible"));

                //quartier.setIdquartier(resultSet.getInt("idquartier"));
                //quartier.setDesignation(resultSet.getString("designation"));
            }
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return habitat;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> habitats = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Habitat habitat = new Habitat();
                habitat.setIdhabitat(resultSet.getInt("idhabitat"));
                habitat.setDesign_habitat(resultSet.getString("design_habitat"));
                habitat.setDist_bord_lagune(resultSet.getDouble("dist_bord_lagune"));
                habitat.setEffectif(resultSet.getInt("effectif"));
                habitat.setIdplan_eau(resultSet.getInt("idplan_eau"));
                habitat.setVisible(resultSet.getBoolean("visible"));
                habitats.add(habitat);
                //quartiers.add(quartier);
            }
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return habitats;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        Habitat habitat = (Habitat) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    habitat.getDesign_habitat(),
                    habitat.getDist_bord_lagune(),
                    habitat.getEffectif(),
                    habitat.getIdplan_eau(),
                    habitat.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation de l'habitat");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                habitat.setIdhabitat(valeurAutoGeneree.getInt(1));
                //quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation de l'habitat, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return habitat;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Habitat habitat = (Habitat) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    habitat.getDesign_habitat(),
                    habitat.getDist_bord_lagune(),
                    habitat.getEffectif(),
                    habitat.getIdplan_eau(),
                    habitat.isVisible(),
                    habitat.getIdhabitat());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour de l'habitat");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return habitat;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Habitat habitat = (Habitat) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, habitat.getIdhabitat());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echect a la suppression de l'habitat");
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
