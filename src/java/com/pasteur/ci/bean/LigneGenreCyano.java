/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class LigneGenreCyano {

    private int idligne_genre_cyano;
    private int idcyano;
    private int idgenre_cyano;
    private int idespece_cyano;
    private int denombrement_esp_cyano;
    
     public int getIdcyano() {
        return idcyano;
    }

    public void setIdcyano(int idcyano) {
        this.idcyano = idcyano;
    }

    public int getIdgenre_cyano() {
        return idgenre_cyano;
    }

    public void setIdgenre_cyano(int idgenre_cyano) {
        this.idgenre_cyano = idgenre_cyano;
    }

    public int getIdligne_genre_cyano() {
        return idligne_genre_cyano;
    }

    public void setIdligne_genre_cyano(int idligne_genre_cyano) {
        this.idligne_genre_cyano = idligne_genre_cyano;
    }

    /**
     * @return the denombrement_esp_cyano
     */
    public int getDenombrement_esp_cyano() {
        return denombrement_esp_cyano;
    }

    /**
     * @param denombrement_esp_cyano the denombrement_esp_cyano to set
     */
    public void setDenombrement_esp_cyano(int denombrement_esp_cyano) {
        this.denombrement_esp_cyano = denombrement_esp_cyano;
    }

    /**
     * @return the idespece_cyano
     */
    public int getIdespece_cyano() {
        return idespece_cyano;
    }

    /**
     * @param idespece_cyano the idespece_cyano to set
     */
    public void setIdespece_cyano(int idespece_cyano) {
        this.idespece_cyano = idespece_cyano;
    }
}
