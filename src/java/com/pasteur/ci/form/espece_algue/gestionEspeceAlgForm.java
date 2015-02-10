/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.espece_algue;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Abouchou
 */
public class gestionEspeceAlgForm extends org.apache.struts.action.ActionForm {
    
    private int idespece_algue;

    public int getIdespece_algue() {
        return idespece_algue;
    }

    public void setIdespece_algue(int idespece_algue) {
        this.idespece_algue = idespece_algue;
    }

    
     
    public gestionEspeceAlgForm() {
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
