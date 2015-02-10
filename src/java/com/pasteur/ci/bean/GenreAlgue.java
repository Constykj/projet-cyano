/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class GenreAlgue {

    private int idgenre_algue;
    private int idfamille;
    private String design_genre_algue;
    private boolean visible;
    private String genreAlgue;

    public int getIdfamille() {
        return idfamille;
    }

    public void setIdfamille(int idfamille) {
        this.idfamille = idfamille;
    }

    public int getIdgenre_algue() {
        return idgenre_algue;
    }

    public void setIdgenre_algue(int idgenre_algue) {
        this.idgenre_algue = idgenre_algue;
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

    /**
     * @return the genreAlgue
     */
    public String getGenreAlgue() {
        return genreAlgue;
    }

    /**
     * @param genreAlgue the genreAlgue to set
     */
    public void setGenreAlgue(String genreAlgue) {
        this.genreAlgue = genreAlgue;
    }
}
