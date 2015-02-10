/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.eclairage;

import com.pasteur.ci.bean.Eclairage;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.eclairage.dao.EclairageDAOImplement;
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
public class GestionEclairageModfiAction extends org.apache.struts.action.Action {

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
        String comId = (String) PropertyUtils.getProperty(form, "ideclairage");

        Eclairage eclairage = new Eclairage();
        eclairage.setIdeclairage(Integer.parseInt(comId));

        EclairageDAOImplement cdaoi = new EclairageDAOImplement(DAOFactory.getInstance());

        eclairage = (Eclairage) cdaoi.find(eclairage);

        request.setAttribute("eclai_trouve", eclairage);
        return mapping.findForward(SUCCESS);
    }
}
