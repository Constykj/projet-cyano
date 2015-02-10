/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

import java.util.ArrayList;

/**
 *
 * @author abouchou
 */
public class Habitats {

    private int idplan_eau;
    private String design_habitat;
    private int[] idmateriaux_construction;
    private int idhabitat;
    private double dist_bord_lagune;
    private int effectif;
    private String plan_eau;
    private String mat_const;
    private int idligne_habitat;
    private boolean visible;
    private ArrayList materiaux_construction;

    public String getDesign_habitat() {
        return design_habitat;
    }

    public void setDesign_habitat(String design_habitat) {
        this.design_habitat = design_habitat;
    }
    

    public int getIdhabitat() {
        return idhabitat;
    }

    public void setIdhabitat(int idhabitat) {
        this.idhabitat = idhabitat;
    }

    public double getDist_bord_lagune() {
        return dist_bord_lagune;
    }

    public void setDist_bord_lagune(double dist_bord_lagune) {
        this.dist_bord_lagune = dist_bord_lagune;
    }

    public int getEffectif() {
        return effectif;
    }

    public void setEffectif(int effectif) {
        this.effectif = effectif;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

//    public String getIdmateriaux_construction() {
//        return idmateriaux_construction;
//    }
//
//    public void setIdmateriaux_construction(String idmateriaux_construction) {
//        this.idmateriaux_construction = idmateriaux_construction;
//    }
    public int getIdligne_habitat() {
        return idligne_habitat;
    }

    public void setIdligne_habitat(int idligne_habitat) {
        this.idligne_habitat = idligne_habitat;
    }

    /**
     * @return the materiaux_construction
     */
    public ArrayList getMateriaux_construction() {
        return materiaux_construction;
    }

    /**
     * @param materiaux_construction the materiaux_construction to set
     */
    public void setMateriaux_construction(ArrayList materiaux_construction) {
        this.materiaux_construction = materiaux_construction;
    }

    /**
     * @return the plan_eau
     */
    public String getPlan_eau() {
        return plan_eau;
    }

    /**
     * @param plan_eau the plan_eau to set
     */
    public void setPlan_eau(String plan_eau) {
        this.plan_eau = plan_eau;
    }

    /**
     * @return the mat_const
     */
    public String getMat_const() {
        return mat_const;
    }

    /**
     * @param mat_const the mat_const to set
     */
    public void setMat_const(String mat_const) {
        this.mat_const = mat_const;
    }

    /**
     * @return the idplan_eau
     */
    public int getIdplan_eau() {
        return idplan_eau;
    }

    /**
     * @param idplan_eau the idplan_eau to set
     */
    public void setIdplan_eau(int idplan_eau) {
        this.idplan_eau = idplan_eau;
    }

    /**
     * @return the idmateriaux_construction
     */
    public int[] getIdmateriaux_construction() {
        return idmateriaux_construction;
    }

    /**
     * @param idmateriaux_construction the idmateriaux_construction to set
     */
    public void setIdmateriaux_construction(int[] idmateriaux_construction) {
        this.idmateriaux_construction = idmateriaux_construction;
    }

}
