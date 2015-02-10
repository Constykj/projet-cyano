/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.espece_algue;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Abouchou
 */
public class EnregistreModifEspeceAlg extends org.apache.struts.action.ActionForm {

    public String getIdespece_algue() {
        return idespece_algue;
    }

    public void setIdespece_algue(String idespece_algue) {
        this.idespece_algue = idespece_algue;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    private String idespece_algue;

    public String getDesign_espece_algue() {
        return design_espece_algue;
    }

    public void setDesign_espece_algue(String design_espece_algue) {
        this.design_espece_algue = design_espece_algue;
    }

  

    public Boolean isVisible() {
        return visible;
    }

    private int idgenre_algue;
    private String design_espece_algue;

    public int getIdgenre_algue() {
        return idgenre_algue;
    }

    public void setIdgenre_algue(int idgenre_algue) {
        this.idgenre_algue = idgenre_algue;
    }

  
    private Boolean visible;

    public EnregistreModifEspeceAlg() {
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
