/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class Habitat {
    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    private int idhabitat;
    private String design_habitat;
    private double dist_bord_lagune;
    private int effectif;
    private int idplan_eau;
    private boolean visible;

    public String getDesign_habitat() {
        return design_habitat;
    }

    public void setDesign_habitat(String design_habitat) {
        this.design_habitat = design_habitat;
    }

    /**
     * @return the idhabitat
     */
    public int getIdhabitat() {
        return idhabitat;
    }

    /**
     * @param idhabitat the commune to set
     */
    public void setIdhabitat(int habitat) {
        this.idhabitat = habitat;
    }

    /**
     * @return the dist_bord_lagune
     */
    public double getDist_bord_lagune() {
        return dist_bord_lagune;
    }

    /**
     * @param dist_bord_lagune the designation to set
     */
    public void setDist_bord_lagune(double dist_bord_lagune) {
        this.dist_bord_lagune = dist_bord_lagune;
    }

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return the idplan_eau
     */
    public int getIdplan_eau() {
        return idplan_eau;
    }

    /**
     * @param idplan_eau the commune to set
     */
    public void setIdplan_eau(int idplan_eau) {
        this.idplan_eau = idplan_eau;
    }

    public int getEffectif() {
        return effectif;
    }

    public void setEffectif(int effectif) {
        this.effectif = effectif;
    }
}
