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
public class CreerProjetForm extends org.apache.struts.action.ActionForm {

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

    public void setCaract_projet(String caract_prjet) {
        this.caract_projet = caract_prjet;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    
   private String idprojet;
   private String design_projet;
   private String source_financement;
   private String collabor_projet;
   private String debut_projet;
   private String fin_projet;
   private String caract_projet;
   private Boolean visible;
    public CreerProjetForm() {
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
        if (getCaract_projet()== null || getCaract_projet().length() < 1) {
            errors.add("caract", new ActionMessage("error.caract.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        if (getCollabor_projet()== null || getCollabor_projet().length() < 1) {
            errors.add("collabor", new ActionMessage("error.collabor.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        if (getDesign_projet()== null || getDesign_projet().length() < 1) {
            errors.add("sourcef", new ActionMessage("error.sourcef.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        if (getSource_financement()== null || getSource_financement().length() < 1) {
            errors.add("design", new ActionMessage("error.design.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}
