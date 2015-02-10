/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.planEau;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Abouchou
 */
public class CreerPlanEauForm extends org.apache.struts.action.ActionForm {
    
    private int idplan_eau;
    private int idregion;
    private int idquartier;
    private int idcommune;
    private int idtype_plan_eau;
    private double superficie;
    private String commentaire;
    private boolean matiere_fecale;
    private boolean visible;
    private String designation;
    private int[] idpratiquer;

    public int[] getIdpratiquer() {
        return idpratiquer;
    }

    public void setIdpratiquer(int[] idpratiquer) {
        this.idpratiquer = idpratiquer;
    }

    public int getIdplan_eau() {
        return idplan_eau;
    }

    public void setIdplan_eau(int idplan_eau) {
        this.idplan_eau = idplan_eau;
    }

    public int getIdregion() {
        return idregion;
    }

    public void setIdregion(int idregion) {
        this.idregion = idregion;
    }

    public int getIdquartier() {
        return idquartier;
    }

    public void setIdquartier(int idquartier) {
        this.idquartier = idquartier;
    }

    public int getIdcommune() {
        return idcommune;
    }

    public void setIdcommune(int idcommune) {
        this.idcommune = idcommune;
    }

    public int getIdtype_plan_eau() {
        return idtype_plan_eau;
    }

    public void setIdtype_plan_eau(int idtype_plan_eau) {
        this.idtype_plan_eau = idtype_plan_eau;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public boolean isMatiere_fecale() {
        return matiere_fecale;
    }

    public void setMatiere_fecale(boolean matiere_fecale) {
        this.matiere_fecale = matiere_fecale;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


     
    public CreerPlanEauForm() {
        super();
        // TODO Auto-generated constructor stub
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
}
