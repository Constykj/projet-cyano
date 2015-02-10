/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class LigneProjet {

    private int idechantillon;
    private int idprojet;
    private  int idligne_projet;
    
     public int getIdechantillon() {
        return idechantillon;
    }

    public void setIdechantillon(int idechantillon) {
        this.idechantillon = idechantillon;
    }

    public int getIdprojet() {
        return idprojet;
    }

    public void setIdprojet(int idprojet) {
        this.idprojet = idprojet;
    }

    public int getIdligne_projet() {
        return idligne_projet;
    }

    public void setIdligne_projet(int idligne_projet) {
        this.idligne_projet = idligne_projet;
    }
}
