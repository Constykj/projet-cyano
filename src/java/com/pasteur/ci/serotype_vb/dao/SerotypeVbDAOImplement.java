/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.serotype_vb.dao;

import com.pasteur.ci.bean.SerotypeVb;
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
public class SerotypeVbDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idserotype_vb,design_serotype,visible from serotype_vb where idserotype_vb = ? ";
    private static final String SQL_SELECT_ALL = "select idserotype_vb,design_serotype,visible from serotype_vb";
    private static final String SQL_CREATE = "insert into serotype_vb (design_serotype,visible) values (?,?)";
    private static final String SQL_UPDATE = "update serotype_vb set design_serotype = ?,visible = ? where idserotype_vb = ?";
    private static final String SQL_DELETE = "delete from serotype_vb where idserotype_vb = ? ";

    public SerotypeVbDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        SerotypeVb serotype_vb = (SerotypeVb) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false,
                    serotype_vb.getIdserotype_vb());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                serotype_vb.setDesign_serotype(resultSet.getString("design_serotype"));
                serotype_vb.setIdserotype_vb(resultSet.getInt("idserotype_vb"));
                serotype_vb.setVisible(resultSet.getBoolean("visible"));
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return serotype_vb;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> serotype_vbs = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                SerotypeVb serotype_vb = new SerotypeVb();
                serotype_vb.setDesign_serotype(resultSet.getString("design_serotype"));
                serotype_vb.setIdserotype_vb(resultSet.getInt("idserotype_vb"));
                serotype_vb.setVisible(resultSet.getBoolean("visible"));

                serotype_vbs.add(serotype_vb);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return serotype_vbs;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        SerotypeVb serotype_vb = (SerotypeVb) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    serotype_vb.getDesign_serotype(),
                    serotype_vb.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                serotype_vb.setIdserotype_vb(valeurAutoGeneree.getInt(1));
                // quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return serotype_vb;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        SerotypeVb serotype_vb = (SerotypeVb) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    serotype_vb.getDesign_serotype(),
                    serotype_vb.isVisible(),
                    serotype_vb.getIdserotype_vb());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return serotype_vb;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        SerotypeVb serotype_vb = (SerotypeVb) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false,
                    serotype_vb.getIdserotype_vb());
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
