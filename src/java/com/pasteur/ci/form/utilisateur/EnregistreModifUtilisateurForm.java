/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.utilisateur;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author HP USER
 */
public class EnregistreModifUtilisateurForm extends org.apache.struts.action.ActionForm {

    private String iduser;
    private String nom;
    private String prenoms;
    private String identifiant;
    private String mot_de_passe;
    private boolean valide;
    private String droit;

    public EnregistreModifUtilisateurForm() {
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

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenoms
     */
    public String getPrenoms() {
        return prenoms;
    }

    /**
     * @param prenoms the prenoms to set
     */
    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    /**
     * @return the identifiant
     */
    public String getIdentifiant() {
        return identifiant;
    }

    /**
     * @param identifiant the identifiant to set
     */
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    /**
     * @return the mot_de_passe
     */
    public String getMot_de_passe() {
        return mot_de_passe;
    }

    /**
     * @param mot_de_passe the mot_de_passe to set
     */
    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    /**
     * @return the iduser
     */
    public String getIduser() {
        return iduser;
    }

    /**
     * @param iduser the iduser to set
     */
    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    /**
     * @return the valide
     */
    public boolean isValide() {
        return valide;
    }

    /**
     * @param valide the valide to set
     */
    public void setValide(boolean valide) {
        this.valide = valide;
    }

    /**
     * @return the droit
     */
    public String getDroit() {
        return droit;
    }

    /**
     * @param droit the droit to set
     */
    public void setDroit(String droit) {
        this.droit = droit;
    }
    /**
     * @return the valide
     */
}
