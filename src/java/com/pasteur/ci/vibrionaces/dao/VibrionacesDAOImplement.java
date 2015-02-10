/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.vibrionaces.dao;
import com.pasteur.ci.bean.Vibrionaces;
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
public class VibrionacesDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idvibrio,idespece_vb,idserotype_vb,visible from vibrionaces where idvibrio = ? ";
    private static final String SQL_SELECT_ALL = "select idvibrio,idespece_vb,idserotype_vb,visible from vibrionaces";
    private static final String SQL_CREATE = "insert into vibrionaces (idespece_vb,idserotype_vb,visible) values (?,?,?)";
    private static final String SQL_UPDATE = "update vibrionaces set idespece_vb=?,idserotype_vb=?,visible = ? where idvibrio = ?";
    private static final String SQL_DELETE = "delete from vibrionaces where idvibrio = ? ";

    public VibrionacesDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Vibrionaces vibrionaces =(Vibrionaces) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false,vibrionaces.getIdvibrio());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                vibrionaces.setIdespece_vb(resultSet.getInt("idespece_vb"));
                vibrionaces.setIdvibrio(resultSet.getInt("idvibrio"));
                vibrionaces.setIdserotype_vb(resultSet.getInt("idserotype_vb"));
                vibrionaces.setVisible(resultSet.getBoolean("visible"));
                }
             DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return vibrionaces;
    }
    

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> vibrionace = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
               Vibrionaces vibrionaces = new Vibrionaces();
               vibrionaces.setIdespece_vb(resultSet.getInt("idespece_vb"));
                vibrionaces.setIdvibrio(resultSet.getInt("idvibrio"));
                vibrionaces.setIdserotype_vb(resultSet.getInt("idserotype_vb"));
                vibrionaces.setVisible(resultSet.getBoolean("visible"));  
                vibrionace.add(vibrionaces);
            }
             DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return vibrionace;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        Vibrionaces vibrionaces = (Vibrionaces) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    vibrionaces.getIdespece_vb(),
                    vibrionaces.getIdserotype_vb(),
                    vibrionaces.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation ");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                vibrionaces.setIdvibrio(valeurAutoGeneree.getInt(1));
                //quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
 DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return vibrionaces;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Vibrionaces vibrionaces = (Vibrionaces) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    vibrionaces.getIdespece_vb(), 
                    vibrionaces.getIdserotype_vb(),
                    vibrionaces.isVisible(),
                    vibrionaces.getIdvibrio());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
 DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return vibrionaces;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Vibrionaces vibrionaces = (Vibrionaces) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false,
                    vibrionaces.getIdvibrio());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echect a la suppression");
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

