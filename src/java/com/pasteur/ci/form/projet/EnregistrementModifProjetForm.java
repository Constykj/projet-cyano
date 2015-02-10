/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.projet;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Abouchou
 */
public class EnregistrementModifProjetForm extends org.apache.struts.action.ActionForm {
    
     private String idprojet;
   private String design_projet;
   private String source_financement;
   private String collabor_projet;
   private String debut_projet;
   private String fin_projet;
   private String caract_projet;
   private Boolean visible;

    public String getIdprojet() {
        return idprojet;
    }

    public void setIdprojet(String idprojet) {
        this.idprojet = idprojet;
    }

    public String getDesign_projet() {
        return design_projet;
    }

    public void setDesign_projet(String design_projet) {
        this.design_projet = design_projet;
    }

    public String getSource_financement() {
        return source_financement;
    }

    public void setSource_financement(String source_financement) {
        this.source_financement = source_financement;
    }

    public String getCollabor_projet() {
        return collabor_projet;
    }

    public void setCollabor_projet(String collabor_projet) {
        this.collabor_projet = collabor_projet;
    }

    public String getDebut_projet() {
        return debut_projet;
    }

    public void setDebut_projet(String debut_projet) {
        this.debut_projet = debut_projet;
    }

    public String getFin_projet() {
        return fin_projet;
    }

    public void setFin_projet(String fin_projet) {
        this.fin_projet = fin_projet;
    }

    public String getCaract_projet() {
        return caract_projet;
    }

    public void setCaract_projet(String caract_projet) {
        this.caract_projet = caract_projet;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    public EnregistrementModifProjetForm() {
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
