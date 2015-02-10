/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author abouchou
 */
public class EspeceCyanos {

    public int getIdespece_cyano() {
        return idespece_cyano;
    }

    public void setIdespece_cyano(int idespece_cyano) {
        this.idespece_cyano = idespece_cyano;
    }

    public int getIdgenre_cyano() {
        return idgenre_cyano;
    }

    public void setIdgenre_cyano(int idgenre_cyano) {
        this.idgenre_cyano = idgenre_cyano;
    }

    public String getDesign_espece_cyano() {
        return design_espece_cyano;
    }

    public void setDesign_espece_cyano(String design_espece_cyano) {
        this.design_espece_cyano = design_espece_cyano;
    }

    public String getGenre_cyano() {
        return genre_cyano;
    }

    public void setGenre_cyano(String genre_cyano) {
        this.genre_cyano = genre_cyano;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    private int idespece_cyano;
    private int idgenre_cyano;
    private String design_espece_cyano;
    private String genre_cyano;
    private boolean visible;

}
