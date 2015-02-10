/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.commune;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Abouchou
 */
public class gestionCommuneModifForm extends org.apache.struts.action.ActionForm {
    
 
    private String idcommune;
 

    /**
     * @return
     */
    public String getIdcommune() {
        return idcommune;
    }

    /**
     * @param i
     */
    public void setIdcommune(String idcommune) {
        this.idcommune = idcommune;
    }

    /**
     *
     */
    public gestionCommuneModifForm() {
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
