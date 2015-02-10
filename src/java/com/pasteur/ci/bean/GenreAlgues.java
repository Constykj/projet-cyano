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
public class GenreAlgues {
    
    private int idgenre_algue;
    private int idfamille;
     private String famille;

    public int getIdgenre_algue() {
        return idgenre_algue;
    }

    public void setIdgenre_algue(int idgenre_algue) {
        this.idgenre_algue = idgenre_algue;
    }

    public int getIdfamille() {
        return idfamille;
    }

    public void setIdfamille(int idfamille) {
        this.idfamille = idfamille;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public String getDesign_genre_algue() {
        return design_genre_algue;
    }

    public void setDesign_genre_algue(String design_genre_algue) {
        this.design_genre_algue = design_genre_algue;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    private String design_genre_algue;
    private boolean visible;
}
