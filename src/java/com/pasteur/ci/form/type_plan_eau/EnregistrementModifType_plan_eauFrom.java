/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.type_plan_eau;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Abouchou
 */
public class EnregistrementModifType_plan_eauFrom extends org.apache.struts.action.ActionForm {
    
     private String idtype_plan_eau;

    public String getIdtype_plan_eau() {
        return idtype_plan_eau;
    }

    public void setIdtype_plan_eau(String idtype_plan_eau) {
        this.idtype_plan_eau = idtype_plan_eau;
    }
    private String designation;
    private Boolean visible;

    

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

    
    public EnregistrementModifType_plan_eauFrom() {
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
       
        return errors;
    }
}
