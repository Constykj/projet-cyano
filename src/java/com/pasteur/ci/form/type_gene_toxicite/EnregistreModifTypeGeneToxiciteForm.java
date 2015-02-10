/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pasteur.ci.form.type_gene_toxicite;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author abouchou
 */
public class EnregistreModifTypeGeneToxiciteForm extends org.apache.struts.action.ActionForm {
    
      private int idtyp_gene_toxicite;

    public int getIdtyp_gene_toxicite() {
        return idtyp_gene_toxicite;
    }

    public void setIdtyp_gene_toxicite(int idtyp_gene_toxicite) {
        this.idtyp_gene_toxicite = idtyp_gene_toxicite;
    }

    public String getDesign_typ_gene_toxicite() {
        return design_typ_gene_toxicite;
    }

    public void setDesign_typ_gene_toxicite(String design_typ_gene_toxicite) {
        this.design_typ_gene_toxicite = design_typ_gene_toxicite;
    }

    public double getConc_typ_gene_toxicite() {
        return conc_typ_gene_toxicite;
    }

    public void setConc_typ_gene_toxicite(double conc_typ_gene_toxicite) {
        this.conc_typ_gene_toxicite = conc_typ_gene_toxicite;
    }
    private String design_typ_gene_toxicite;
    private double conc_typ_gene_toxicite;
    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    private boolean visible;
    public EnregistreModifTypeGeneToxiciteForm() {
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
