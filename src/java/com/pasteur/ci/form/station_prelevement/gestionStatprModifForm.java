/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.station_prelevement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
 

/**
 *
 * @author Abouchou
 */
public class gestionStatprModifForm extends org.apache.struts.action.ActionForm {

    public String getIdstat() {
        return idstat;
    }

    public void setIdstat(String idstat) {
        this.idstat = idstat;
    }

     
    
     
    private String idstat;

     

    
 
    public gestionStatprModifForm() {
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
