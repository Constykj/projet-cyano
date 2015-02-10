/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.config;

import com.pasteur.ci.exception.DAOConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author HP USER
 */
public class DAOFactory {

    private static final String FICHIER_PROPERTIES = "com/pasteur/ci/config/dao.properties";
    private static final String PROPERTIES_URL = "url";
    private static final String PROPERTIES_driver = "driver";
    private static final String PROPERTIES_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTIES_MOT_DE_PASSE = "motdepasse";
    private String url;
    private String username;
    private String password;

    public DAOFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DAOFactory getInstance() throws DAOConfigurationException {

        Properties properties = new Properties();
        String url;
        String driver;
        String nomUtilisateur;
        String motDePasse;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.
                getResourceAsStream(FICHIER_PROPERTIES);

        if (fichierProperties == null) {
            throw new DAOConfigurationException("Le fichier de configuration " + FICHIER_PROPERTIES + ""
                    + "est introuvable ");
        }

        try {
            properties.load(fichierProperties);
            url = properties.getProperty(PROPERTIES_URL);
            driver = properties.getProperty(PROPERTIES_driver);
            nomUtilisateur = properties.getProperty(PROPERTIES_NOM_UTILISATEUR);
            motDePasse = properties.getProperty(PROPERTIES_MOT_DE_PASSE);


        } catch (IOException e) {
            throw new DAOConfigurationException("Impossible de charger le fichier " + FICHIER_PROPERTIES, e);
        }

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new DAOConfigurationException("Le driver est introuvable dans le classpath", e);
        }

        DAOFactory instance = new DAOFactory(url, nomUtilisateur, motDePasse);

        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
 
}
