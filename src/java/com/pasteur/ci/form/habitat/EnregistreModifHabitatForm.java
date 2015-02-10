/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.habitat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author abouchou
 */
public class EnregistreModifHabitatForm extends org.apache.struts.action.ActionForm {

    private int idhabitat;
    private String design_habitat;
    private double dist_bord_lagune;
    private int effectif;
    private int idplan_eau;
    private boolean visible;
    // ajout mat const
    private int[] idmateriaux_construction;

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

    public int getIdplan_eau() {
        return idplan_eau;
    }

    public void setIdplan_eau(int idplan_eau) {
        this.idplan_eau = idplan_eau;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
//        if (getName() == null || getName().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
//            // TODO: add 'error.name.required' key to your resources
//        }
        return errors;
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
