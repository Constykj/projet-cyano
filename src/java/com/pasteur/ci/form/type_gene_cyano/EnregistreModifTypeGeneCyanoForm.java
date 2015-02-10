/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pasteur.ci.form.type_gene_cyano;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author abouchou
 */
public class EnregistreModifTypeGeneCyanoForm extends org.apache.struts.action.ActionForm {
    
      private int idtyp_gene_cyano;
    private String design_typ_gene_cyano;
    private double conc_typ_gene_cyano;

    public int getIdtyp_gene_cyano() {
        return idtyp_gene_cyano;
    }

    public void setIdtyp_gene_cyano(int idtyp_gene_cyano) {
        this.idtyp_gene_cyano = idtyp_gene_cyano;
    }

    public String getDesign_typ_gene_cyano() {
        return design_typ_gene_cyano;
    }

    public void setDesign_typ_gene_cyano(String design_typ_gene_cyano) {
        this.design_typ_gene_cyano = design_typ_gene_cyano;
    }

    public double getConc_typ_gene_cyano() {
        return conc_typ_gene_cyano;
    }

    public void setConc_typ_gene_cyano(double conc_typ_gene_cyano) {
        this.conc_typ_gene_cyano = conc_typ_gene_cyano;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    private boolean visible;
    public EnregistreModifTypeGeneCyanoForm() {
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
