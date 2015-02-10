/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.gene;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author abouchou
 */
public class EnregistreModifGeneForm extends org.apache.struts.action.ActionForm {

    private int idgene_cyano;

    public int getIdgene_cyano() {
        return idgene_cyano;
    }

    public void setIdgene_cyano(int idgene_cyano) {
        this.idgene_cyano = idgene_cyano;
    }

    public String getDesign_gene_cyano() {
        return design_gene_cyano;
    }

    public void setDesign_gene_cyano(String design_gene_cyano) {
        this.design_gene_cyano = design_gene_cyano;
    }

    

    private String design_gene_cyano;
    private Boolean visib;

    public Boolean getVisib() {
        return visib;
    }

    public void setVisib(Boolean visib) {
        this.visib = visib;
    }

    public EnregistreModifGeneForm() {
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
