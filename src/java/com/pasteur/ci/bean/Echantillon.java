/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class Echantillon {

    private int idechantillon;
    private int idpoint_prelevement;
    private String num_echantillon;
    private boolean visible;
    private String date_prelevement;
    private int idparasite;
    private int idvirus;
    private int idp_phy_chim;
    private int nombre;

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getIdprojet() {
        return idprojet;
    }

    public void setIdprojet(int idprojet) {
        this.idprojet = idprojet;
    }

    public int getIdautre_bacterie() {
        return idautre_bacterie;
    }

    public void setIdautre_bacterie(int idautre_bacterie) {
        this.idautre_bacterie = idautre_bacterie;
    }

    public int getIdautre_algue() {
        return idautre_algue;
    }

    public void setIdautre_algue(int idautre_algue) {
        this.idautre_algue = idautre_algue;
    }

    public int getIdcyano() {
        return idcyano;
    }

    public void setIdcyano(int idcyano) {
        this.idcyano = idcyano;
    }
    private int idprojet;
    private int idautre_bacterie;
    private int idautre_algue;
    private int idcyano ;
    
    
    
    
     public int getIdechantillon() {
        return idechantillon;
    }
    public void setIdechantillon(int idechantillon) {
        this.idechantillon = idechantillon;
    } 
    public int getIdparasite() {
        return idparasite;
    }
    public void setIdparasite(int idparasite) {
        this.idparasite = idparasite;
    } 
    public int getIdvirus(){
        return idvirus;
    }

    public void setIdvirus(int idvirus) {
        this.idvirus = idvirus;
    }
    
    public int getIdp_phy_chim() {
        return idp_phy_chim;
    }

    public void setIdp_phy_chim(int idp_phy_chim) {
        this.idp_phy_chim = idp_phy_chim;
    }

    public int getIdpoint_prelevement() {
        return idpoint_prelevement;
    }

    public void setIdpoint_prelevement(int idpoint_prelevement) {
        this.idpoint_prelevement = idpoint_prelevement;
    }

    public String getNum_echantillon() {
        return num_echantillon;
    }

    public void setNum_echantillon(String num_echantillon) {
        this.num_echantillon = num_echantillon;
    }

    public String getDate_prelevement() {
        return date_prelevement;
    }

    public void setDate_prelevement(String date_prelevement) {
        this.date_prelevement = date_prelevement;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
