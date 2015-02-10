/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.espece_cyano;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author abouchou
 */
public class EnregistreModifEspeceCyanoForm extends org.apache.struts.action.ActionForm {

    private int idespece_cyano;
    private String design_espece_cyano;
    private boolean visible;
    private int idgenre_cyano;

    public int getIdespece_cyano() {
        return idespece_cyano;
    }

    public int getIdgenre_cyano() {
        return idgenre_cyano;
    }

    public void setIdgenre_cyano(int idgenre_cyano) {
        this.idgenre_cyano = idgenre_cyano;
    }

    public void setIdespece_cyano(int idespece_cyano) {
        this.idespece_cyano = idespece_cyano;
    }

    public String getDesign_espece_cyano() {
        return design_espece_cyano;
    }

    public void setDesign_espece_cyano(String design_espece_cyano) {
        this.design_espece_cyano = design_espece_cyano;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public EnregistreModifEspeceCyanoForm() {
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
