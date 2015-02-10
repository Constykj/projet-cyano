/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.materiaux;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Abouchou
 */
public class gestionMateriauxModifForm extends org.apache.struts.action.ActionForm {
    
     private  String idmateriaux_construction;

    public String getIdmateriaux_construction() {
        return idmateriaux_construction;
    }

    public void setIdmateriaux_construction(String idmateriaux_construction) {
        this.idmateriaux_construction = idmateriaux_construction;
    }
    
    public gestionMateriauxModifForm() {
        super();
        // TODO Auto-generated constructor stub
    }

 public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
         
        return errors;
    }
}