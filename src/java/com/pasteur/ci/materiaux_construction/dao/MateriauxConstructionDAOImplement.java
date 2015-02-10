/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.materiaux_construction.dao;

import com.pasteur.ci.bean.MateriauxConstruction;
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
public class MateriauxConstructionDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idmateriaux_construction,lib_materiaux_construction,visible from materiaux_construction where idmateriaux_construction = ? ";
    private static final String SQL_SELECT_ALL = "select idmateriaux_construction,lib_materiaux_construction,visible from materiaux_construction";
    private static final String SQL_CREATE = "insert into materiaux_construction (lib_materiaux_construction,visible) values (?,?)";
    private static final String SQL_UPDATE = "update materiaux_construction set lib_materiaux_construction = ?,visible = ? where idmateriaux_construction = ?";
    private static final String SQL_DELETE = "delete from materiaux_construction where idmateriaux_construction = ? ";

    public MateriauxConstructionDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        MateriauxConstruction materiaux_construction = (MateriauxConstruction) obj;
        //Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false,
                    materiaux_construction.getIdmateriaux_construction());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                materiaux_construction.setIdmateriaux_construction(resultSet.getInt("idmateriaux_construction"));
                materiaux_construction.setLib_materiaux_construction(resultSet.getString("lib_materiaux_construction"));
                //materiaux_construction.setVisible(resultSet.getBoolean("visible"));

            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return materiaux_construction;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> materiaux_constructions = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MateriauxConstruction materiaux_construction = new MateriauxConstruction();
                materiaux_construction.setIdmateriaux_construction(resultSet.getInt("idmateriaux_construction"));//ajout
                materiaux_construction.setLib_materiaux_construction(resultSet.getString("lib_materiaux_construction"));
                materiaux_construction.setVisible(resultSet.getBoolean("visible"));
                materiaux_constructions.add(materiaux_construction);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return materiaux_constructions;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        MateriauxConstruction materiaux_construction = (MateriauxConstruction) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    materiaux_construction.getLib_materiaux_construction(),
                    materiaux_construction.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                materiaux_construction.setIdmateriaux_construction(valeurAutoGeneree.getInt(1));

            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return materiaux_construction;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        MateriauxConstruction materiaux_construction = (MateriauxConstruction) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    materiaux_construction.getLib_materiaux_construction(),
                    materiaux_construction.isVisible(),
                    materiaux_construction.getIdmateriaux_construction());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
  DAOUtilitaire.fermetureSilencieuse( preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return materiaux_construction;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        MateriauxConstruction materiaux_construction = (MateriauxConstruction) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, materiaux_construction.getIdmateriaux_construction());
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
