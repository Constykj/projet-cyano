/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.creationpage;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author HP USER
 */
public class ajaxPointPrelevPForm extends org.apache.struts.action.ActionForm {
   
    private int idpoint_prelevement;
 
    /**
     * @return
     */
    public int getIdpoint_prelevement() {
        return idpoint_prelevement;
    }

    /**
     * @param i
     */
    public void setIdpoint_prelevement(int i) {
       idpoint_prelevement = i;
    }

    /**
     *
     */
    public ajaxPointPrelevPForm() {
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
