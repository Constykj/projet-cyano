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
public class CreerMateriauxForm extends org.apache.struts.action.ActionForm {
    
    private String idmateriaux_construction;
    private String lib_materiaux_construction;
    private Boolean visible;

    public String getIdmateriaux_construction() {
        return idmateriaux_construction;
    }

    public void setIdmateriaux_construction(String idmateriaux_construction) {
        this.idmateriaux_construction = idmateriaux_construction;
    }

    public String getLib_materiaux_construction() {
        return lib_materiaux_construction;
    }

    public void setLib_materiaux_construction(String lib_materiaux_construction) {
        this.lib_materiaux_construction = lib_materiaux_construction;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
//        if (getLib_materiaux_construction()== null || getLib_materiaux_construction().length() < 1) {
//            errors.add("designation", new ActionMessage("error.design.required"));
//            // TODO: add 'error.name.required' key to your resources
//        }
        return errors;
    }
    public CreerMateriauxForm() {
        super();
        // TODO Auto-generated constructor stub
    }
}
