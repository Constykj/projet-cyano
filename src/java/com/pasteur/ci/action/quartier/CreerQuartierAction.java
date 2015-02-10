/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.quartier;

import com.pasteur.ci.bean.Quartier;

import com.pasteur.ci.quartier.dao.QuartierDAOImplement;
import com.pasteur.ci.config.DAOFactory;

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
public class CreerQuartierAction extends org.apache.struts.action.Action {

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
        
        //String idquartier = (String) PropertyUtils.getProperty(form, "idquartier");
        //int idq = Integer.parseInt(idquartier);
        String designation = (String) PropertyUtils.getProperty(form, "designation");
        
        boolean visible = (Boolean) PropertyUtils.getProperty(form, "visible");
       

        Quartier quartier = new Quartier();          
        //quartier.setIdquartier(idq);
        quartier.setDesignation(designation);
        quartier.setVisible(visible);

        QuartierDAOImplement qdaoi = new QuartierDAOImplement(DAOFactory.getInstance());
        qdaoi.create(quartier);
        
        return mapping.findForward(SUCCESS);
    }
}
