/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.utilisateur;

import com.pasteur.ci.bean.Utilisateurs;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.utilisateurs.dao.UtilisateursDAOImplement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.pasteur.ci.config.ENCRYPUtilitaire;

/**
 *
 * @author HP USER
 */
public class EnregistreModifUtilisateurAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String iduser =  (String) PropertyUtils.getProperty(form, "iduser");
        String nom = (String) PropertyUtils.getProperty(form, "nom");
        String prenoms = (String) PropertyUtils.getProperty(form, "prenoms");
        String identifiant = (String) PropertyUtils.getProperty(form, "identifiant");
        String motDePasse = (String) PropertyUtils.getProperty(form, "mot_de_passe");
        boolean valide = (Boolean) PropertyUtils.getProperty(form, "valide");
        String droit = (String) PropertyUtils.getProperty(form, "droit");

        Utilisateurs utilisateurs = new Utilisateurs();
        utilisateurs.setIduser(Integer.valueOf(iduser));
        utilisateurs.setNom(nom);
        utilisateurs.setPrenoms(prenoms);
        utilisateurs.setIdentifiant(identifiant);
        utilisateurs.setMot_de_passe(ENCRYPUtilitaire.traiterMotDePasse(motDePasse));
        utilisateurs.setValide(valide);
        utilisateurs.setDroit(droit);

        UtilisateursDAOImplement udaoi = new UtilisateursDAOImplement(DAOFactory.getInstance());
        udaoi.update(utilisateurs);
        
        return mapping.findForward(SUCCESS);
    }
}
