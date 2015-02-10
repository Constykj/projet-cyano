/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.config;

import org.jasypt.util.password.BasicPasswordEncryptor;

/**
 *
 * @author HP USER
 */
public class ENCRYPUtilitaire {

     

    public static String traiterMotDePasse(String motDePasse) throws Exception {

        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        String motDePasseChiffre = passwordEncryptor.encryptPassword(motDePasse);
        return motDePasseChiffre;
    }

    public static boolean validerMotDePasse(String motDePasse, String encpasseword) {

        boolean ok = false;
        try {
            BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();             
            ok = passwordEncryptor.checkPassword(motDePasse, encpasseword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

}
