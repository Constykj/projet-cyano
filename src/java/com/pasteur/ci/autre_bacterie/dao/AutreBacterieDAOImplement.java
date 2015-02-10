/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.autre_bacterie.dao;

import com.pasteur.ci.bean.AutreBacterie;
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
public class AutreBacterieDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select * from autre_bacterie where idautre_bacterie = ? ";
    private static final String SQL_SELECT_ALL = "select idautre_bacterie,coliforme_tx,streptocoques_fecaux,anaerobie_sulfo_red,e_coli,caliform_thermo,autre_sal,salmonelle,vibrio,serotype_salm,serotype_vibrio,visible from autre_bacterie";
    private static final String SQL_CREATE = "insert into autre_bacterie (coliforme_tx,streptocoques_fecaux,anaerobie_sulfo_red,e_coli,coliforme_thermo,autre_salm,salmonelle,vibrio,serotype_salm,serotype_vibrio,visible) values (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "update autre_bacterie set coliforme_tx = ?,streptocoques_fecaux = ?,anaerobie_sulfo_red = ?,e_coli = ?,coliforme_thermo= ?,autre_salm= ?,salmonelle= ?,vibrio= ?,serotype_salm= ?,serotype_vibrio= ? where idautre_bacterie = ?";
    private static final String SQL_DELETE = "delete from autre_bacterie where idautre_bacterie = ? ";

    public AutreBacterieDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        AutreBacterie autre_bacterie = (AutreBacterie) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, autre_bacterie.getIdautre_bacterie());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                autre_bacterie.setIdautre_bacterie(resultSet.getInt("idautre_bacterie"));
                autre_bacterie.setColiforme_tx(resultSet.getInt("coliforme_tx"));
                autre_bacterie.setAnaerobie_sulfo_red(resultSet.getInt("anaerobie_sulfo_red"));
                autre_bacterie.setStreptocoques_fecaux(resultSet.getInt("streptocoques_fecaux"));
                autre_bacterie.setE_coli(resultSet.getInt("e_coli"));
                autre_bacterie.setColiforme_thermo(resultSet.getInt("coliforme_thermo"));
                autre_bacterie.setAutre_salm(resultSet.getInt("autre_salm"));
                autre_bacterie.setSerotype_salm(resultSet.getInt("serotype_salm"));
                autre_bacterie.setSerotype_vibrio(resultSet.getInt("serotype_vibrio"));
                autre_bacterie.setSalmonelle(resultSet.getInt("salmonelle"));
                autre_bacterie.setVibrio(resultSet.getInt("vibrio"));

            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return autre_bacterie;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> bacteries = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                AutreBacterie autre_bacterie = new AutreBacterie();
                autre_bacterie.setIdautre_bacterie(resultSet.getInt("idautre_bacterie"));
                autre_bacterie.setColiforme_tx(resultSet.getInt("coliforme_tx"));
                autre_bacterie.setStreptocoques_fecaux(resultSet.getInt("streptocoques_fecaux"));
                autre_bacterie.setAnaerobie_sulfo_red(resultSet.getInt("anaerobie_sulfo_red"));
                autre_bacterie.setE_coli(resultSet.getInt("e_coli"));
                autre_bacterie.setVisible(resultSet.getBoolean("visible"));
                bacteries.add(autre_bacterie);

                //quartiers.add(quartier);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return bacteries;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        AutreBacterie autre_bacterie = (AutreBacterie) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    autre_bacterie.getColiforme_tx(),
                    autre_bacterie.getStreptocoques_fecaux(),
                    autre_bacterie.getAnaerobie_sulfo_red(),
                    autre_bacterie.getE_coli(),
                    autre_bacterie.getColiforme_thermo(),
                    autre_bacterie.getAutre_salm(),
                    autre_bacterie.getSalmonelle(),
                    autre_bacterie.getVibrio(),
                    autre_bacterie.getSerotype_salm(),
                    autre_bacterie.getSerotype_vibrio(),
                    autre_bacterie.isVisible());
            int statut = preparedStatement.executeUpdate();
         
            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                autre_bacterie.setIdautre_bacterie(valeurAutoGeneree.getInt(1));
                //quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation , aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return autre_bacterie;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        AutreBacterie autre_bacterie = (AutreBacterie) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    autre_bacterie.getColiforme_tx(),
                    autre_bacterie.getStreptocoques_fecaux(),
                    autre_bacterie.getAnaerobie_sulfo_red(),
                    autre_bacterie.getE_coli(),
                    autre_bacterie.getColiforme_thermo(),
                    autre_bacterie.getAutre_salm(),
                    autre_bacterie.getSalmonelle(),
                    autre_bacterie.getVibrio(),
                    autre_bacterie.getSerotype_salm(),
                    autre_bacterie.getSerotype_vibrio(),                     
                    autre_bacterie.getIdautre_bacterie());
            int statut = preparedStatement.executeUpdate();
           
           
            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return autre_bacterie;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        AutreBacterie autre_bacterie = (AutreBacterie) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, autre_bacterie.getIdautre_bacterie());
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
