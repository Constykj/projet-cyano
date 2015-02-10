/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.espece_vb.dao;

import com.pasteur.ci.bean.EspeceVb;
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
public class EspeceVbDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idespece_vb,design_espece,visible from espece_vb where idespece_vb = ? ";
    private static final String SQL_SELECT_ALL = "select idespece_vb,design_espece,visible from espece_vb";
    private static final String SQL_CREATE = "insert into espece_vb (design_espece,visible) values (?,?)";
    private static final String SQL_UPDATE = "update espece_vb set design_espece = ?,visible = ? where idespece_vb = ?";
    private static final String SQL_DELETE = "delete from espece_vb where idespece_vb = ? ";

    public EspeceVbDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        EspeceVb espece_vb = (EspeceVb) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false,
                    espece_vb.getIdespece_vb());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                espece_vb.setDesign_espece(resultSet.getString("design_espece"));
                espece_vb.setIdespece_vb(resultSet.getInt("idespece_vb"));
                espece_vb.setVisible(resultSet.getBoolean("visible"));
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return espece_vb;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> espece_vbs = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EspeceVb espece_vb = new EspeceVb();
                espece_vb.setDesign_espece(resultSet.getString("design_espece"));
                espece_vb.setIdespece_vb(resultSet.getInt("idespece_vb"));
                espece_vb.setVisible(resultSet.getBoolean("visible"));

                espece_vbs.add(espece_vb);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return espece_vbs;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        EspeceVb espece_vb = (EspeceVb) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    espece_vb.getDesign_espece(),
                    espece_vb.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                espece_vb.setIdespece_vb(valeurAutoGeneree.getInt(1));
                // quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return espece_vb;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        EspeceVb espece_vb = (EspeceVb) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    espece_vb.getDesign_espece(),
                    espece_vb.isVisible(),
                    espece_vb.getIdespece_vb());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return espece_vb;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        EspeceVb espece_vb = (EspeceVb) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false,
                    espece_vb.getIdespece_vb());
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
