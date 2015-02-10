/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.type_gene_toxicite.dao;



import com.pasteur.ci.bean.TypeGeneToxicite;
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
public class TypeGeneToxiciteDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select idtyp_gene_toxicite,design_typ_gene_toxicite,visible from type_gene_toxicite where idtyp_gene_toxicite = ? ";
    private static final String SQL_SELECT_ALL = "select idtyp_gene_toxicite,design_typ_gene_toxicite,visible from type_gene_toxicite";
    private static final String SQL_CREATE = "insert into type_gene_toxicite (design_typ_gene_toxicite,visible) values (?,?)";
    private static final String SQL_UPDATE = "update type_gene_toxicite set design_typ_gene_toxicite=?,visible=? where idtyp_gene_toxicite= ?";
    private static final String SQL_DELETE = "delete from type_gene_toxicite where idtyp_gene_toxicite= ? ";

    public TypeGeneToxiciteDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        TypeGeneToxicite type_gene_toxicite = (TypeGeneToxicite) obj;
        //Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, type_gene_toxicite.getIdtyp_gene_toxicite());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                type_gene_toxicite.setDesign_typ_gene_toxicite(resultSet.getString("design_typ_gene_toxicite"));
              
                type_gene_toxicite.setIdtyp_gene_toxicite(resultSet.getInt("idtyp_gene_toxicite"));
                type_gene_toxicite.setVisible(resultSet.getBoolean("visible"));
            }
             DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return type_gene_toxicite;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> type_gene_toxicites = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                TypeGeneToxicite type_gene_toxicite = new TypeGeneToxicite();
                 type_gene_toxicite.setDesign_typ_gene_toxicite(resultSet.getString("design_typ_gene_toxicite"));
                
                type_gene_toxicite.setIdtyp_gene_toxicite(resultSet.getInt("idtyp_gene_toxicite"));
                type_gene_toxicite.setVisible(resultSet.getBoolean("visible"));

                type_gene_toxicites.add(type_gene_toxicite);
            }
             DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return type_gene_toxicites;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        TypeGeneToxicite type_gene_toxicite = (TypeGeneToxicite) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    type_gene_toxicite.getDesign_typ_gene_toxicite(),
         
                    type_gene_toxicite.isVisible());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                type_gene_toxicite.setIdtyp_gene_toxicite(valeurAutoGeneree.getInt(1));
                // quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
 DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return type_gene_toxicite;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        TypeGeneToxicite type_gene_toxicite = (TypeGeneToxicite) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false, 
                    type_gene_toxicite.getDesign_typ_gene_toxicite(),
              
                    type_gene_toxicite.isVisible(),
                    type_gene_toxicite.getIdtyp_gene_toxicite());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
 DAOUtilitaire.fermetureSilencieuse( preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return type_gene_toxicite;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        TypeGeneToxicite type_gene_toxicite = (TypeGeneToxicite) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false,
                    type_gene_toxicite.getIdtyp_gene_toxicite());
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
