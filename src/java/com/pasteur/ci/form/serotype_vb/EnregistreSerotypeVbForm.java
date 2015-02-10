/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.serotype_vb;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author abouchou
 */
public class EnregistreSerotypeVbForm extends org.apache.struts.action.ActionForm {

   

    public String getDesign_serotype() {
        return design_serotype;
    }

    public void setDesign_serotype(String design_serotype) {
        this.design_serotype = design_serotype;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getIdserotype_vb() {
        return idserotype_vb;
    }

    public void setIdserotype_vb(int idserotype_vb) {
        this.idserotype_vb = idserotype_vb;
    }
    
      private int idserotype_vb;
    private String design_serotype;
    private boolean visible;
    public EnregistreSerotypeVbForm() {
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
