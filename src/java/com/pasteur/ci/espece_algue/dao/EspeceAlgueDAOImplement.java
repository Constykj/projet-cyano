/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.espece_algue.dao;

import com.pasteur.ci.bean.EspeceAlgue;
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
public class EspeceAlgueDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idespece_algue,idgenre_algue,design_espece_algue,visible from espece_algue where idespece_algue = ? ";
    private static final String SQL_SELECT_ALL = "select idespece_algue,idgenre_algue,design_espece_algue,visible from espece_algue";
    private static final String SQL_CREATE = "insert into espece_algue (idgenre_algue,design_espece_algue,visible) values (?,?,?)";
    private static final String SQL_UPDATE = "update espece_algue set idgenre_algue = ?, design_espece_algue = ?,visible = ? where idespece_algue= ?";
    private static final String SQL_DELETE = "delete from espece_algue where idespece_algue = ? ";

    public EspeceAlgueDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        EspeceAlgue espece_algue = (EspeceAlgue) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, espece_algue.getIdespece_algue());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                espece_algue.setDesign_espece_algue(resultSet.getString("design_espece_algue"));
                espece_algue.setIdgenre_algue(resultSet.getInt("idgenre_algue"));
                espece_algue.setVisible(resultSet.getBoolean("visible"));
                espece_algue.setIdespece_algue(resultSet.getInt("idespece_algue"));
            }
             DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return espece_algue;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> espece_algues = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EspeceAlgue espece_algue = new EspeceAlgue();
                espece_algue.setDesign_espece_algue(resultSet.getString("design_espece_algue"));
                espece_algue.setIdgenre_algue(resultSet.getInt("idgenre_algue"));
                espece_algue.setIdespece_algue(resultSet.getInt("idespece_algue"));
                espece_algue.setVisible(resultSet.getBoolean("visible"));

                espece_algues.add(espece_algue);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return espece_algues;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        EspeceAlgue espece_algue = (EspeceAlgue) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    espece_algue.getIdgenre_algue(),
                    espece_algue.getDesign_espece_algue(),
                    espece_algue.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                espece_algue.setIdespece_algue(valeurAutoGeneree.getInt(1));
                // quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return espece_algue;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        EspeceAlgue espece_algue = (EspeceAlgue) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    espece_algue.getIdgenre_algue(),
                    espece_algue.getDesign_espece_algue(),
                    espece_algue.isVisible(),
                    espece_algue.getIdespece_algue());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
DAOUtilitaire.fermetureSilencieuse( preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return espece_algue;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        EspeceAlgue espece_algue = (EspeceAlgue) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false,
                    espece_algue.getIdespece_algue());
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
