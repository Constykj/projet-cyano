/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.projet.dao;

import com.pasteur.ci.bean.Projet;
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
public class ProjetDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idprojet,design_projet,source_financement,caract_projet,collabor_projet,debut_projet,fin_projet,visible from projet where idprojet = ? ";
    private static final String SQL_SELECT_ALL = "select idprojet,design_projet,collabor_projet,caract_projet,source_financement,debut_projet,fin_projet,visible from projet";
    private static final String SQL_CREATE = "insert into projet ( design_projet,caract_projet,source_financement,collabor_projet,debut_projet,fin_projet,visible) values (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "update projet set design_projet= ?,source_financement= ?,caract_projet= ?,collabor_projet= ?,debut_projet= ?, fin_projet= ?, visible = ? where idprojet = ?";
    private static final String SQL_DELETE = "delete from projet where idprojet = ? ";

    public ProjetDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Projet projet = (Projet) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, projet.getIdprojet());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                projet.setCaract_projet(resultSet.getString("caract_projet"));
                projet.setCollabor_projet(resultSet.getString("collabor_projet"));
                projet.setDebut_projet(resultSet.getString("debut_projet"));
                projet.setDesign_projet(resultSet.getString("design_projet"));
                projet.setIdprojet(resultSet.getInt("idprojet"));
                projet.setFin_projet(resultSet.getString("fin_projet"));
                projet.setVisible(resultSet.getBoolean("visible"));
                projet.setSource_financement(resultSet.getString("source_financement"));
            }
              DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return projet;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> projets = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Projet projet = new Projet();
                projet.setCaract_projet(resultSet.getString("caract_projet"));
                projet.setCollabor_projet(resultSet.getString("collabor_projet"));
                projet.setDebut_projet(resultSet.getString("debut_projet"));
                projet.setDesign_projet(resultSet.getString("design_projet"));
                projet.setIdprojet(resultSet.getInt("idprojet"));
                projet.setFin_projet(resultSet.getString("fin_projet"));
                projet.setVisible(resultSet.getBoolean("visible"));
                projet.setSource_financement(resultSet.getString("source_financement"));

                projets.add(projet);
            }
              DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return projets;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        Projet projet = (Projet) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    projet.getDesign_projet(),
                    projet.getCaract_projet(),
                    projet.getSource_financement(),
                    projet.getCollabor_projet(),
                    projet.getDebut_projet(),
                    projet.getFin_projet(),
                    projet.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                projet.setIdprojet(valeurAutoGeneree.getInt(1));
                // quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
  DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return projet;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Projet projet = (Projet) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    projet.getDesign_projet(),
                    projet.getCaract_projet(),
                    projet.getSource_financement(),
                    projet.getCollabor_projet(),
                    projet.getDebut_projet(),
                    projet.getFin_projet(),
                    projet.isVisible(),
                    projet.getIdprojet());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
  DAOUtilitaire.fermetureSilencieuse( preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return projet;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Projet projet = (Projet) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, projet.getIdprojet());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echect a la suppression ");
            }
  DAOUtilitaire.fermetureSilencieuse(   preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public Object find(int i) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
