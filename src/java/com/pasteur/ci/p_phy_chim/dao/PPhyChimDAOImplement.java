/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.p_phy_chim.dao;

import com.pasteur.ci.bean.PPhyChim;
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
public class PPhyChimDAOImplement implements BaseDAO {

    private DAOFactory daoFactory;
    private static final String SQL_SELECT = "select * from p_phy_chim where idp_phy_chim = ? ";
    private static final String SQL_SELECT_ALL = "select idp_phy_chim,ideclairage,phosphore,phosphate,azote_totale,oxygene_dissout,transparence,ph,temperature,salinite,conductivite,nitrate,chlorophyle_a,tubidite,fer,cadmium,plomb,seleniuml,nickel,arsenic,mercure,zinc,cuivre,couleur_eau_brute,potentiel_redox,amminium,MES,hydrogene_sulfure,DCO,DBO5,COT,manganese,visible from p_phy_chim";
    private static final String SQL_CREATE = "insert into p_phy_chim (ideclairage,phosphore,phosphate,azote_totale,oxygene_dissout,transparence,ph,temperature,salinite,conductivite,nitrate,chlorophyle_a,tubidite,fer,cadmium,plomb,seleniuml,nickel,arsenic,mercure,zinc,cuivre,couleur_eau_brute,potentiel_redox,amminium,MES,hydrogene_sulfure,DCO,DBO5,COT,manganese,visible) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "update p_phy_chim set ideclairage=?,phosphore = ?,phosphate = ?,azote_totale = ?,oxygene_dissout = ?,transparence = ?,ph = ?,temperature = ?,salinite = ?,conductivite = ?,nitrate = ?,chlorophyle_a = ?,tubidite = ?,fer = ?,cadmium = ?,plomb = ?,seleniuml = ?,nickel = ?,arsenic = ?,mercure = ?,zinc = ?,cuivre = ? ,couleur_eau_brute=?,potentiel_redox=?,amminium=?,MES=?,hydrogene_sulfure=?,DCO=?,DBO5=?,COT=?,manganese=? where idp_phy_chim = ?";
    private static final String SQL_DELETE = "delete from p_phy_chim where idp_phy_chim = ? ";

    public PPhyChimDAOImplement(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Object find(Object obj) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        PPhyChim p_phy_chim = (PPhyChim) obj;
        //Quartier quartier = (Quartier) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT, false, p_phy_chim.getIdp_phy_chim());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                p_phy_chim.setIdp_phy_chim(resultSet.getInt("idp_phy_chim"));
                p_phy_chim.setIdeclairage(resultSet.getInt("ideclairage"));
                p_phy_chim.setPhosphore(resultSet.getDouble("phosphore"));
                p_phy_chim.setPhosphate(resultSet.getDouble("phosphate"));
                p_phy_chim.setAzote_totale(resultSet.getDouble("azote_totale"));
                p_phy_chim.setOxygene_dissout(resultSet.getDouble("oxygene_dissout"));
                p_phy_chim.setTransparence(resultSet.getDouble("transparence"));
                p_phy_chim.setPh(resultSet.getDouble("ph"));
                p_phy_chim.setTemperature(resultSet.getDouble("temperature"));
                p_phy_chim.setSalinite(resultSet.getDouble("salinite"));
                p_phy_chim.setConductivite(resultSet.getDouble("conductivite"));
                p_phy_chim.setNitrate(resultSet.getDouble("nitrate"));
                p_phy_chim.setChlorophyle_a(resultSet.getDouble("chlorophyle_a"));
                p_phy_chim.setFer(resultSet.getDouble("fer"));
                p_phy_chim.setCadmium(resultSet.getDouble("cadmium"));
                p_phy_chim.setPlomb(resultSet.getDouble("plomb"));
                p_phy_chim.setSeleniuml(resultSet.getDouble("seleniuml"));
                p_phy_chim.setNickel(resultSet.getDouble("nickel"));
                p_phy_chim.setArsenic(resultSet.getDouble("arsenic"));
                p_phy_chim.setMercure(resultSet.getDouble("mercure"));
                p_phy_chim.setZinc(resultSet.getDouble("zinc"));
                p_phy_chim.setCuivre(resultSet.getDouble("cuivre"));
                p_phy_chim.setTubidite(resultSet.getDouble("tubidite"));
                p_phy_chim.setCouleur_eau_brute(resultSet.getByte("couleur_eau_brute"));
                p_phy_chim.setPotentiel_redox(resultSet.getDouble("potentiel_redox"));
                p_phy_chim.setAmminium(resultSet.getDouble("amminium"));
                p_phy_chim.setMES(resultSet.getDouble("MES"));
                p_phy_chim.setHydrogene_sulfure(resultSet.getDouble("hydrogene_sulfure"));
                p_phy_chim.setDCO(resultSet.getDouble("DCO"));
                p_phy_chim.setDBO5(resultSet.getDouble("DBO5"));
                p_phy_chim.setCOT(resultSet.getDouble("COT"));
                p_phy_chim.setManganese(resultSet.getDouble("manganese"));
                p_phy_chim.setVisible(resultSet.getBoolean("visible"));

            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return p_phy_chim;
    }

    @Override
    public ArrayList<Object> find() throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Object> p_phy_chimx = new ArrayList<Object>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PPhyChim p_phy_chim = new PPhyChim();
                p_phy_chim.setIdp_phy_chim(resultSet.getInt("idp_phy_chim"));
                p_phy_chim.setIdeclairage(resultSet.getInt("idreclairage"));
                p_phy_chim.setPhosphore(resultSet.getDouble("phosphore"));
                p_phy_chim.setPhosphate(resultSet.getDouble("phosphate"));
                p_phy_chim.setAzote_totale(resultSet.getDouble("azote_totale"));
                p_phy_chim.setOxygene_dissout(resultSet.getDouble("oxygene_dissout"));
                p_phy_chim.setTransparence(resultSet.getDouble("transparence"));
                p_phy_chim.setPh(resultSet.getDouble("ph"));
                p_phy_chim.setTemperature(resultSet.getDouble("temperature"));
                p_phy_chim.setSalinite(resultSet.getDouble("salinite"));
                p_phy_chim.setConductivite(resultSet.getDouble("conductivite"));
                p_phy_chim.setNitrate(resultSet.getDouble("nitrate"));
                p_phy_chim.setChlorophyle_a(resultSet.getDouble("chlorophyle_a"));
                p_phy_chim.setFer(resultSet.getDouble("fer"));
                p_phy_chim.setCadmium(resultSet.getDouble("cadmium"));
                p_phy_chim.setPlomb(resultSet.getDouble("plomb"));
                p_phy_chim.setSeleniuml(resultSet.getDouble("seleniuml"));
                p_phy_chim.setNickel(resultSet.getDouble("nickel"));
                p_phy_chim.setArsenic(resultSet.getDouble("arsenic"));
                p_phy_chim.setMercure(resultSet.getDouble("mercure"));
                p_phy_chim.setZinc(resultSet.getDouble("zinc"));
                p_phy_chim.setCuivre(resultSet.getDouble("cuivre"));
                p_phy_chim.setTubidite(resultSet.getDouble("tubidite"));
                p_phy_chim.setCouleur_eau_brute(resultSet.getByte("couleur_eau_brute"));
                p_phy_chim.setPotentiel_redox(resultSet.getDouble("potentiel_redox"));
                p_phy_chim.setAmminium(resultSet.getDouble("amminium"));
                p_phy_chim.setMES(resultSet.getDouble("MES"));
                p_phy_chim.setHydrogene_sulfure(resultSet.getDouble("hydrogene_sulfure"));
                p_phy_chim.setDCO(resultSet.getDouble("DCO"));
                p_phy_chim.setDBO5(resultSet.getDouble("DBO5"));
                p_phy_chim.setCOT(resultSet.getDouble("COT"));
                p_phy_chim.setManganese(resultSet.getDouble("anganese"));
                p_phy_chim.setVisible(resultSet.getBoolean("visible"));
                p_phy_chimx.add(p_phy_chim);
            }
            DAOUtilitaire.fermetureSilencieuse(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return p_phy_chimx;
    }

    @Override
    public Object create(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet valeurAutoGeneree;
        PPhyChim p_phy_chim = (PPhyChim) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_CREATE, true,
                    p_phy_chim.getIdeclairage(),
                    p_phy_chim.getPhosphore(),
                    p_phy_chim.getPhosphate(),
                    p_phy_chim.getAzote_totale(),
                    p_phy_chim.getOxygene_dissout(),
                    p_phy_chim.getTransparence(),
                    p_phy_chim.getPh(),
                    p_phy_chim.getTemperature(),
                    p_phy_chim.getSalinite(),
                    p_phy_chim.getConductivite(),
                    p_phy_chim.getNitrate(),
                    p_phy_chim.getChlorophyle_a(),
                    p_phy_chim.getTubidite(),
                    p_phy_chim.getFer(),
                    p_phy_chim.getCadmium(),
                    p_phy_chim.getPlomb(),
                    p_phy_chim.getSeleniuml(),
                    p_phy_chim.getNickel(),
                    p_phy_chim.getArsenic(),
                    p_phy_chim.getMercure(),
                    p_phy_chim.getZinc(),
                    p_phy_chim.getCuivre(),
                    p_phy_chim.getCouleur_eau_brute(),
                    p_phy_chim.getPotentiel_redox(),
                    p_phy_chim.getAmminium(),
                    p_phy_chim.getMES(),
                    p_phy_chim.getHydrogene_sulfure(),
                    p_phy_chim.getDCO(),
                    p_phy_chim.getDBO5(),
                    p_phy_chim.getCOT(),
                    p_phy_chim.getManganese(),
                    p_phy_chim.isVisible());
//);

            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la creation");
            }

            valeurAutoGeneree = preparedStatement.getGeneratedKeys();

            if (valeurAutoGeneree.next()) {
                p_phy_chim.setIdp_phy_chim(valeurAutoGeneree.getInt(1));
                // quartier.setIdquartier(valeurAutoGeneree.getInt(1));
            } else {
                throw new DAOException("Echect a la creation, aucun ID retorne");
            }
            DAOUtilitaire.fermetureSilencieuse(valeurAutoGeneree, preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return p_phy_chim;
    }

    @Override
    public Object update(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        PPhyChim p_phy_chim = (PPhyChim) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_UPDATE, false,
                    p_phy_chim.getIdeclairage(),
                    p_phy_chim.getPhosphore(),
                    p_phy_chim.getPhosphate(),
                    p_phy_chim.getAzote_totale(),
                    p_phy_chim.getOxygene_dissout(),
                    p_phy_chim.getTransparence(),
                    p_phy_chim.getPh(),
                    p_phy_chim.getTemperature(),
                    p_phy_chim.getSalinite(),
                    p_phy_chim.getConductivite(),
                    p_phy_chim.getNitrate(),
                    p_phy_chim.getChlorophyle_a(),
                    p_phy_chim.getTubidite(),
                    p_phy_chim.getFer(),
                    p_phy_chim.getCadmium(),
                    p_phy_chim.getPlomb(),
                    p_phy_chim.getSeleniuml(),
                    p_phy_chim.getNickel(),
                    p_phy_chim.getArsenic(),
                    p_phy_chim.getMercure(),
                    p_phy_chim.getZinc(),
                    p_phy_chim.getCuivre(),
                    p_phy_chim.getCouleur_eau_brute(),
                    p_phy_chim.getPotentiel_redox(),
                    p_phy_chim.getAmminium(),
                    p_phy_chim.getMES(),
                    p_phy_chim.getHydrogene_sulfure(),
                    p_phy_chim.getDCO(),
                    p_phy_chim.getDBO5(),
                    p_phy_chim.getCOT(),
                    p_phy_chim.getManganese(),
                    p_phy_chim.getIdp_phy_chim());
            int statut = preparedStatement.executeUpdate();

            if (statut == 0) {
                throw new DAOException("Echec a la mise a jour");
            }
            DAOUtilitaire.fermetureSilencieuse(preparedStatement, connection);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return p_phy_chim;
    }

    @Override
    public void delete(Object obj) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement;
        PPhyChim p_phy_chim = (PPhyChim) obj;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_DELETE, false, p_phy_chim.getIdp_phy_chim());
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
