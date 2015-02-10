/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.region;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Abouchou
 */
public class CreerRegionForm extends org.apache.struts.action.ActionForm {
    
       private String idregion;
    private String designation;
    private boolean visible;

    public String getIdregion() {
        return idregion;
    }

    public void setIdregion(String idregion) {
        this.idregion = idregion;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

   
    public CreerRegionForm() {
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
        if (getDesignation() == null || getDesignation().length() < 1) {
            errors.add("desigerror", new ActionMessage("error.design.required"));
      
        }
        return errors;
    }
}
