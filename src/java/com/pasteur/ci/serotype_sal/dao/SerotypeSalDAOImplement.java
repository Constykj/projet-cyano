/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.serotype_sal.dao;

import com.pasteur.ci.bean.SerotypeSal;
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
public class SerotypeSalDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idserotype_sal,design_serotype,visible from serotype_sal where idserotype_sal = ? ";
    private static final String SQL_SELECT_ALL = "select idserotype_sal,design_serotype,visible from serotype_sal";
    private static final String SQL_CREATE = "insert into serotype_sal (design_serotype,visible) values (?,?)";
    private static final String SQL_UPDATE = "update serotype_sal set design_serotype = ?,visible = ? where idserotype_sal = ?";
    private static final String SQL_DELETE = "delete from serotype_sal where idserotype_sal = ? ";

    public SerotypeSalDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        SerotypeSal serotype_sal = (SerotypeSal) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false,
                    serotype_sal.getDesign_serotype());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                serotype_sal.setDesign_serotype(resultSet.getString("design_serotype"));
                serotype_sal.setIdserotype_sal(resultSet.getInt("idserotype_sal"));
                serotype_sal.setVisible(resultSet.getBoolean("visible"));
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return serotype_sal;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> serotype_sals = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                SerotypeSal serotype_sal = new SerotypeSal();
                serotype_sal.setDesign_serotype(resultSet.getString("design_serotype"));
                serotype_sal.setIdserotype_sal(resultSet.getInt("idserotype_sal"));
                serotype_sal.setVisible(resultSet.getBoolean("visible"));

                serotype_sals.add(serotype_sal);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return serotype_sals;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        SerotypeSal serotype_sal = (SerotypeSal) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    serotype_sal.getDesign_serotype(),
                    serotype_sal.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                serotype_sal.setIdserotype_sal(valeurAutoGeneree.getInt(1));
                // quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return serotype_sal;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        SerotypeSal serotype_sal = (SerotypeSal) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    serotype_sal.getDesign_serotype(),
                    serotype_sal.isVisible(),
                    serotype_sal.getIdserotype_sal());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return serotype_sal;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        SerotypeSal serotype_sal = (SerotypeSal) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false,
                    serotype_sal.getIdserotype_sal());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echect a la suppression ");
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public Object find(int i) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
