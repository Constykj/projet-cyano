/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.genre_algue;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Abouchou
 */
public class EnregistreModifGenreAlgForm extends org.apache.struts.action.ActionForm {

   

    public String getDesign_genre_algue() {
        return design_genre_algue;
    }

    public void setDesign_genre_algue(String design_genre_algue) {
        this.design_genre_algue = design_genre_algue;
    }

    public int getIdgenre_algue() {
        return idgenre_algue;
    }

    public void setIdgenre_algue(int idgenre_algue) {
        this.idgenre_algue = idgenre_algue;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public int getIdfamille() {
        return idfamille;
    }

    public void setIdfamille(int idfamille) {
        this.idfamille = idfamille;
    }
    private int idgenre_algue;
    private int idfamille;
    private String design_genre_algue;
    private Boolean visible;
     
    public EnregistreModifGenreAlgForm() {
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
