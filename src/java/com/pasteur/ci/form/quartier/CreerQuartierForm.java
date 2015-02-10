/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.quartier;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author HP USER
 */
public class CreerQuartierForm extends org.apache.struts.action.ActionForm {

    private String idquartier;
    private String designation;
    private boolean visible;

    public String getIdquartier() {
        return idquartier;
    }

    public void setIdquartier(String idquartier) {
        this.idquartier = idquartier;
    }

    /**
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();


        if (getDesignation() == null || getDesignation().length() < 1) {
            errors.add("desigerror", new ActionMessage("error.design.required"));
        }


        return errors;
    }

    /**
     * @return the nom
     */
    public CreerQuartierForm() {
        super();
        // TODO Auto-generated constructor stub 
    }

    /**
     * @return the idcommune
     */
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
