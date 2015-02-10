/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.cyano;

import com.pasteur.ci.bean.Cyanobacterie;
import com.pasteur.ci.bean.Utilisateurs;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.cyanobacterie.dao.CyanobacterieDAOImplement;
import com.pasteur.ci.utilisateurs.dao.UtilisateursDAOImplement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Abouchou
 */
public class CreerCyanoAction extends org.apache.struts.action.Action {

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
        
         

        Cyanobacterie  cyano  = new Cyanobacterie();          
        
         

        CyanobacterieDAOImplement udaoi = new CyanobacterieDAOImplement(DAOFactory.getInstance());
        udaoi.create(cyano);
        
        return mapping.findForward(SUCCESS);
    }
}
