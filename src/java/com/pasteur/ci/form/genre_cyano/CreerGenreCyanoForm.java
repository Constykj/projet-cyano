/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.genre_cyano;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author abouchou
 */
public class CreerGenreCyanoForm extends org.apache.struts.action.ActionForm {
    
    private int idgenre_cyano;
    private String design_genre_cyano;
    private boolean visible;

    public int getIdgenre_cyano() {
        return idgenre_cyano;
    }

    public void setIdgenre_cyano(int idgenre_cyano) {
        this.idgenre_cyano = idgenre_cyano;
    }

    public String getDesign_genre_cyano() {
        return design_genre_cyano;
    }

    public void setDesign_genre_cyano(String design_genre_cyano) {
        this.design_genre_cyano = design_genre_cyano;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public CreerGenreCyanoForm() {
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
