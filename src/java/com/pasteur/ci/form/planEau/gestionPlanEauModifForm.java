package com.pasteur.ci.form.planEau;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Abouchou
 */
public class gestionPlanEauModifForm extends org.apache.struts.action.ActionForm {
    
 
    private String idplan_eau;

    public String getIdplan_eau() {
        return idplan_eau;
    }

    public void setIdplan_eau(String idplan_eau) {
        this.idplan_eau = idplan_eau;
    }
 
    public gestionPlanEauModifForm() {
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
