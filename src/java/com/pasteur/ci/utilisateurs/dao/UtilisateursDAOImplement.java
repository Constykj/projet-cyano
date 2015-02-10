/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.utilisateurs.dao;

import com.pasteur.ci.bean.Utilisateurs;
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
public class UtilisateursDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select iduser,nom,prenoms,date_inscription,mot_de_passe,identifiant,valide,droit from utilisateurs where iduser = ? ";
    private static final String SQL_SELECT_ALL = "select iduser,nom,prenoms,date_inscription,mot_de_passe,identifiant,valide,droit from utilisateurs";
    private static final String SQL_CREATE = "insert into utilisateurs (nom,prenoms,identifiant,mot_de_passe,valide,droit) values (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "update utilisateurs set nom=?,prenoms=?,identifiant=?,mot_de_passe=?,valide=?,droit=? where iduser = ?";
    private static final String SQL_DELETE = "delete from utilisateurs where iduser = ? ";
    private static final String SQL_SELECT_USER = "select iduser,nom,prenoms,valide,droit,mot_de_passe from utilisateurs where identifiant = ?   ";

    public UtilisateursDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Utilisateurs utilisateurs = (Utilisateurs) obj;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, utilisateurs.getIduser());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                utilisateurs.setDate_inscription(resultSet.getString("date_inscription"));
                utilisateurs.setIduser(resultSet.getInt("iduser"));
                utilisateurs.setMot_de_passe(resultSet.getString("mot_de_passe"));
                utilisateurs.setNom(resultSet.getString("nom"));
                utilisateurs.setPrenoms(resultSet.getString("prenoms"));
                utilisateurs.setIdentifiant(resultSet.getString("identifiant"));
                utilisateurs.setValide(resultSet.getBoolean("valide"));
                utilisateurs.setDroit(resultSet.getString("droit"));
            }
             DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return utilisateurs;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> utilisateur = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Utilisateurs utilisateurs = new Utilisateurs();
                utilisateurs.setDate_inscription(resultSet.getString("date_inscription"));
                utilisateurs.setIduser(resultSet.getInt("iduser"));
                utilisateurs.setMot_de_passe(resultSet.getString("mot_de_passe"));
                utilisateurs.setNom(resultSet.getString("nom"));
                utilisateurs.setPrenoms(resultSet.getString("prenoms"));
                utilisateurs.setIdentifiant(resultSet.getString("identifiant"));
                utilisateurs.setValide(resultSet.getBoolean("valide"));
                utilisateurs.setDroit(resultSet.getString("droit"));
                utilisateur.add(utilisateurs);
            }
             DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return utilisateur;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        Utilisateurs utilisateurs = (Utilisateurs) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    utilisateurs.getNom(), utilisateurs.getPrenoms(), utilisateurs.getIdentifiant(),
                    utilisateurs.getMot_de_passe(), utilisateurs.getValide(),utilisateurs.getDroit());

            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }
            valeurAutoGeneree = preparedStatement.getGeneratedKeys();
            if (valeurAutoGeneree.next()) {
                utilisateurs.setIduser(valeurAutoGeneree.getInt(1));
                // quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
 DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return utilisateurs;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Utilisateurs utilisateurs = (Utilisateurs) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection,
                    SQL_UPDATE, false, utilisateurs.getNom(), utilisateurs.getPrenoms(),
                    utilisateurs.getIdentifiant(), utilisateurs.getMot_de_passe(), utilisateurs.getValide(),
                    utilisateurs.getDroit(),utilisateurs.getIduser());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return utilisateurs;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        Utilisateurs utilisateurs = (Utilisateurs) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, utilisateurs.getIduser());
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

    public Object findUser(Object object) throws DAOException {

        Utilisateurs utilisateurAuthen = null;
        Connection connection;
        PreparedStatement preparedStatement;
        Utilisateurs utilisateurs = (Utilisateurs) object;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_USER, false, utilisateurs.getIdentifiant());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                utilisateurs.setNom(rs.getString("nom"));
                utilisateurs.setPrenoms(rs.getString("prenoms"));
                utilisateurs.setValide(rs.getBoolean("valide"));
                utilisateurs.setDroit(rs.getString("droit"));
                utilisateurs.setMot_de_passe(rs.getString("mot_de_passe"));
                
                if (utilisateurs.getValide()) {
                    utilisateurAuthen = utilisateurs;
                }
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return utilisateurAuthen;
    }
}
