/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pasteur.ci.action.type_toxine;

import com.pasteur.ci.bean.TypeToxine;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.type_toxine.dao.TypeToxineDAOImplement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author abouchou
 */
public class GestionModifPageTypeToxineAction extends org.apache.struts.action.Action {

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
          int comId  =(Integer)  PropertyUtils.getProperty(form, "idtype_toxine");

        TypeToxine type_toxine = new TypeToxine();

        type_toxine.setIdtype_toxine(comId);
        TypeToxineDAOImplement cdaoi = new TypeToxineDAOImplement(DAOFactory.getInstance());

        type_toxine = (TypeToxine) cdaoi.find(type_toxine);

        request.setAttribute("tyToxi_trouve", type_toxine);
        return mapping.findForward(SUCCESS);
    }
}
