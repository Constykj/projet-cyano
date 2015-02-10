/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class Projet {

    private int idprojet;
    private String design_projet;
    private String source_financement;
    private String collabor_projet;
    private String debut_projet;
    private String fin_projet;
    private String caract_projet;
    private boolean visible;

    public int getIdprojet() {
        return idprojet;
    }

    public void setIdprojet(int idprojet) {
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
