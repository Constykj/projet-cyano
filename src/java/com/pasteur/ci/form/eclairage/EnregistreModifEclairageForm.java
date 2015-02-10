/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.eclairage;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Abouchou
 */
public class EnregistreModifEclairageForm extends org.apache.struts.action.ActionForm {
    
     private String ideclairage;
    private String designation;
    private Boolean visible;

    public String getIdeclairage() {
        return ideclairage;
    }

    public void setIdeclairage(String ideclairage) {
        this.ideclairage = ideclairage;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public EnregistreModifEclairageForm() {
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
        if (getDesignation()== null || getDesignation().length() < 1) {
            errors.add("designation", new ActionMessage("error.designation.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}
