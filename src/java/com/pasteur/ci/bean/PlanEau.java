/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class PlanEau {

    private int idplan_eau;
    private int idregion;
    private int idquartier;
    private int idcommune;
    private int idtype_plan_eau;
    private double superficie;
    private String commentaire;
    private boolean matiere_fecale;
    private boolean visible;
    private String designation;
    private int nombre;

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getIdregion() {
        return idregion;
    }

    public void setIdregion(int region) {
        this.idregion = region;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public int getIdquartier() {
        return idquartier;
    }

    public void setIdquartier(int idquartier) {
        this.idquartier = idquartier;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getIdplan_eau() {
        return idplan_eau;
    }

    public void setIdplan_eau(int idplan_eau) {
        this.idplan_eau = idplan_eau;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public boolean getMatiere_fecale() {
        return matiere_fecale;
    }

    public void setMatiere_fecale(boolean matiere_fecale) {
        this.matiere_fecale = matiere_fecale;
    }

    public int getIdtype_plan_eau() {
        return idtype_plan_eau;
    }

    public void setIdtype_plan_eau(int idtype_plan_eau) {
        this.idtype_plan_eau = idtype_plan_eau;
    }

    public int getIdcommune() {
        return idcommune;
    }

    public void setIdcommune(int idcommune) {
        this.idcommune = idcommune;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
