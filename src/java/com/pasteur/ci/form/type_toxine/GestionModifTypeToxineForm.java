/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pasteur.ci.form.type_toxine;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author abouchou
 */
public class GestionModifTypeToxineForm extends org.apache.struts.action.ActionForm {
    
  private int idtype_toxine;

    public int getIdtype_toxine() {
        return idtype_toxine;
    }

    public void setIdtype_toxine(int idtype_toxine) {
        this.idtype_toxine = idtype_toxine;
    }
   
    
     
    public GestionModifTypeToxineForm() {
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
//        if (getName() == null || getName().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
//            // TODO: add 'error.name.required' key to your resources
//        }
        return errors;
    }
}
