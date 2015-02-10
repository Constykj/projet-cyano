/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.point_prelevement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
 

/**
 *
 * @author Abouchou
 */
public class CreerPtprForm extends org.apache.struts.action.ActionForm {
    private int  idpoint_prelevement;
    private int idstat;

   
    
    private double profondeur;
 private String designation;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public double getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(double profondeur) {
        this.profondeur = profondeur;
    }
    private boolean visible;

    public int getIdpoint_prelevement() {
        return idpoint_prelevement;
    }

    public void setIdpoint_prelevement(int idpoint_prelevement) {
        this.idpoint_prelevement = idpoint_prelevement;
    }

    public int getIdstat() {
        return idstat;
    }

    public void setIdstat(int idstat) {
        this.idstat = idstat;
    }

   
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public CreerPtprForm() {
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
        //}
        return errors;
    }
}
