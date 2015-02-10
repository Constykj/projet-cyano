/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author HP USER
 */
public class LoginappForm extends org.apache.struts.action.ActionForm {
    
    
  private  String userId;
  private  String passWd;
    
    /**
     *
     */
    public LoginappForm() {
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
        if (getUserId()== null || getUserId().length() < 1) {
            errors.add("login", new ActionMessage("error.login.required"));             
        }
         if (getPassWd()== null || getPassWd().length() < 1) {
            errors.add("password", new ActionMessage("error.password.required"));             
        }
        return errors;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the passWd
     */
    public String getPassWd() {
        return passWd;
    }

    /**
     * @param passWd the passWd to set
     */
    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }
}
