/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action;

import com.pasteur.ci.bean.Utilisateurs;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.utilisateurs.dao.UtilisateursDAOImplement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.pasteur.ci.config.ENCRYPUtilitaire;

/**
 *
 * @author HP USER
 */
public class LoginappAction extends org.apache.struts.action.Action {

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

        HttpSession session = request.getSession();
        

        String userID = (String) PropertyUtils.getProperty(form, "userId");
        String passWd = (String) PropertyUtils.getProperty(form, "passWd");

        Utilisateurs utilisateurs = new Utilisateurs();
        utilisateurs.setIdentifiant(userID);
        utilisateurs.setMot_de_passe(passWd);

        UtilisateursDAOImplement udaoi = new UtilisateursDAOImplement(DAOFactory.getInstance());

        ActionMessages errors = new ActionMessages();
        utilisateurs = (Utilisateurs) udaoi.findUser(utilisateurs);
        if ( utilisateurs!= null && ENCRYPUtilitaire.validerMotDePasse(passWd,  utilisateurs.getMot_de_passe())) {

            session.setAttribute("nomUtil", utilisateurs.getNom());
            session.setAttribute("prenomUtil", utilisateurs.getPrenoms());
            session.setAttribute("droitUtil", utilisateurs.getDroit());
             
            if (!utilisateurs.getValide()) {
                session.invalidate();
                errors.add("errcon", new ActionMessage("error.connect.false"));
                saveErrors(request, errors);
                return mapping.getInputForward();
            } else {
                return mapping.findForward(SUCCESS);
            }
            

        } else {
            session.invalidate();
            errors.add("errcon", new ActionMessage("error.connect.false"));
            saveErrors(request, errors);
            return mapping.getInputForward();
        }
 
    }
}
