/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.pratique;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Abouchou
 */
public class gestionPratiqueModifForm extends org.apache.struts.action.ActionForm {

    
    
    private String idpratique;

    public String getIdpratique() {
        return idpratique;
    }

    public void setIdpratique(String idpratique) {
        this.idpratique = idpratique;
    }


 
    /**
     *
     */
    public gestionPratiqueModifForm() {
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
