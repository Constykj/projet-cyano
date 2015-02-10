/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.cyano;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Abouchou
 */
public class EnregistreModifCyanoForm extends org.apache.struts.action.ActionForm {
    
     private String idcyano;
    private String type_gene_cyano;
    private String conc_gene_cyano;
    private String gene_toxicite;
     private String gene_cyano;

    public String getGene_cyano() {
        return gene_cyano;
    }

    public void setGene_cyano(String gene_cyano) {
        this.gene_cyano = gene_cyano;
    }
    private String conc_gene_toxicite;
    private String type_gene_toxicite;
    private String conc_microcystine;
    private String type_microcystine;
    private String conc_anatoxine;
    private String conc_saxitoxine;
    private String conc_cylindrospermopsine;
    private boolean visible;

    public String getIdcyano() {
        return idcyano;
    }

    public void setIdcyano(String idcyano) {
        this.idcyano = idcyano;
    }

    public String getType_gene_cyano() {
        return type_gene_cyano;
    }

    public void setType_gene_cyano(String type_gene_cyano) {
        this.type_gene_cyano = type_gene_cyano;
    }

    public String getConc_gene_cyano() {
        return conc_gene_cyano;
    }

    public void setConc_gene_cyano(String conc_gene_cyano) {
        this.conc_gene_cyano = conc_gene_cyano;
    }

    public String getGene_toxicite() {
        return gene_toxicite;
    }

    public void setGene_toxicite(String gene_toxicite) {
        this.gene_toxicite = gene_toxicite;
    }

    public String getConc_gene_toxicite() {
        return conc_gene_toxicite;
    }

    public void setConc_gene_toxicite(String conc_gene_toxicite) {
        this.conc_gene_toxicite = conc_gene_toxicite;
    }

    public String getType_gene_toxicite() {
        return type_gene_toxicite;
    }

    public void setType_gene_toxicite(String type_gene_toxicite) {
        this.type_gene_toxicite = type_gene_toxicite;
    }

    public String getConc_microcystine() {
        return conc_microcystine;
    }

    public void setConc_microcystine(String conc_microcystine) {
        this.conc_microcystine = conc_microcystine;
    }

    public String getType_microcystine() {
        return type_microcystine;
    }

    public void setType_microcystine(String type_microcystine) {
        this.type_microcystine = type_microcystine;
    }

    public String getConc_anatoxine() {
        return conc_anatoxine;
    }

    public void setConc_anatoxine(String conc_anatoxine) {
        this.conc_anatoxine = conc_anatoxine;
    }

    public String getConc_saxitoxine() {
        return conc_saxitoxine;
    }

    public void setConc_saxitoxine(String conc_saxitoxine) {
        this.conc_saxitoxine = conc_saxitoxine;
    }

    public String getConc_cylindrospermopsine() {
        return conc_cylindrospermopsine;
    }

    public void setConc_cylindrospermopsine(String conc_cylindrospermopsine) {
        this.conc_cylindrospermopsine = conc_cylindrospermopsine;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
 
    public EnregistreModifCyanoForm() {
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
