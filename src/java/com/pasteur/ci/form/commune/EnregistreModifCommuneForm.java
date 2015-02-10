/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.commune;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author HP USER
 */
public class EnregistreModifCommuneForm extends org.apache.struts.action.ActionForm {

    private String idcommune;
    private String designation;
    private boolean visible;
    

    public EnregistreModifCommuneForm() {
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

    /**
     * @return the nom
     */
    public String getIdcommune() {
        return idcommune;
    }

    /**
     * @param nom the nom to set
     */
    public void setIdcommune(String idcommune) {
        this.idcommune = idcommune;
    }

    /**
     * @return the prenoms
     */
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation){
        this.designation=designation;
    }

    /**
     * @param prenoms the prenoms to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return the identifiant
     */
    public boolean getVisible() {
        return visible;
    }
    /**
     * @return the valide
     */
}
