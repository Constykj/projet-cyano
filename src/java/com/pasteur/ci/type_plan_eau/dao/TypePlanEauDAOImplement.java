/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.type_plan_eau.dao;
import com.pasteur.ci.bean.TypePlanEau;
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
 * @author HP USER
 */
public class TypePlanEauDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idtype_plan_eau,designation,visible from type_plan_eau where idtype_plan_eau = ? ";
    private static final String SQL_SELECT_ALL = "select idtype_plan_eau,designation,visible from type_plan_eau";
    private static final String SQL_CREATE = "insert into type_plan_eau (designation,visible) values (?,?)";
    private static final String SQL_UPDATE = "update type_plan_eau set designation = ?, visible = ? where idtype_plan_eau = ?";
    private static final String SQL_DELETE = "delete from type_plan_eau where idtype_plan_eau = ? ";

    public TypePlanEauDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        TypePlanEau type_plan_eau = (TypePlanEau) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, type_plan_eau.getIdtype_plan_eau());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                type_plan_eau.setIdtype_plan_eau(resultSet.getInt("idtype_plan_eau"));
                type_plan_eau.setDesignation(resultSet.getString("designation"));
            }
            
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return type_plan_eau;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> type_plan_eaux = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                TypePlanEau type_plan_eau = new TypePlanEau();
                type_plan_eau.setIdtype_plan_eau(resultSet.getInt("idtype_plan_eau"));
                type_plan_eau.setDesignation(resultSet.getString("designation"));
                type_plan_eau.setVisible(resultSet.getBoolean("visible"));
                type_plan_eaux.add(type_plan_eau);
            }
             DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return type_plan_eaux;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        TypePlanEau type_plan_eau = (TypePlanEau) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true, type_plan_eau.getDesignation(), type_plan_eau.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation du type de plan d'eau");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                type_plan_eau.setIdtype_plan_eau(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation du type de plan d'eau, aucun ID retorne");
            }
 DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return type_plan_eau;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        TypePlanEau type_plan_eau = (TypePlanEau) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false, type_plan_eau.getDesignation(), type_plan_eau.isVisible(), type_plan_eau.getIdtype_plan_eau());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour du type de plan d'eau");
            }
 DAOUtilitaire.fermetureSilencieuse( preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return type_plan_eau;
    }
    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        TypePlanEau type_plan_eau = (TypePlanEau) obj;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, type_plan_eau.getIdtype_plan_eau());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echect a la suppression du type de plan d'eau");
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
