/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.famille;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Abouchou
 */
public class CreerFamilleForm extends org.apache.struts.action.ActionForm {
    
    private String idfamille;
    private String design_famille;
    private Boolean visible;

    public String getIdfamille() {
        return idfamille;
    }

    public void setIdfamille(String idfamille) {
        this.idfamille = idfamille;
    }

    public String getDesign_famille() {
        return design_famille;
    }

    public void setDesign_famille(String design_famille) {
        this.design_famille = design_famille;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    
    public CreerFamilleForm() {
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
        if (getDesign_famille()== null || getDesign_famille().length() < 1) {
            errors.add("designation", new ActionMessage("error.designation.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}
