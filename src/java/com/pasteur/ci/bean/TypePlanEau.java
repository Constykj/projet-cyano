/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class TypePlanEau {

    private int idtype_plan_eau;
    private String designation;
    private boolean visible;

    /**
     * @return the idtype_plan_eau
     */
    public int getIdtype_plan_eau() {
        return idtype_plan_eau;
    }

    /**
     * @param idquartier the TypePlanEau to set
     */
    public void setIdtype_plan_eau(int type_plan_eau) {
        this.idtype_plan_eau = type_plan_eau;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
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
}
