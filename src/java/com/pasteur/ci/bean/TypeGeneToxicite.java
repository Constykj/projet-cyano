/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author abouchou
 */
public class TypeGeneToxicite {

    private int idtyp_gene_toxicite;
    private String design_typ_gene_toxicite;

    public int getIdtyp_gene_toxicite() {
        return idtyp_gene_toxicite;
    }

    public void setIdtyp_gene_toxicite(int idtyp_gene_toxicite) {
        this.idtyp_gene_toxicite = idtyp_gene_toxicite;
    }

    private boolean visible;

   

    public String getDesign_typ_gene_toxicite() {
        return design_typ_gene_toxicite;
    }

    public void setDesign_typ_gene_toxicite(String design_typ_gene_toxicite) {
        this.design_typ_gene_toxicite = design_typ_gene_toxicite;
    }

   

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
