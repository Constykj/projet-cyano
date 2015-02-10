/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pasteur.ci.action.type_gene_cyano;

import com.pasteur.ci.bean.TypeGeneCyano;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.type_gene_cyano.dao.TypeGeneCyanoDAOImplement;
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
public class GestionModifPageTypeGeneCyanoAction extends org.apache.struts.action.Action {

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
          int comId  =(Integer)  PropertyUtils.getProperty(form, "idtyp_gene_cyano");

        TypeGeneCyano typ_gene_cyano = new TypeGeneCyano();

        typ_gene_cyano.setIdtyp_gene_cyano(comId);
        TypeGeneCyanoDAOImplement cdaoi = new TypeGeneCyanoDAOImplement(DAOFactory.getInstance());

        typ_gene_cyano = (TypeGeneCyano) cdaoi.find(typ_gene_cyano);

        request.setAttribute("tygeneCyan_trouve", typ_gene_cyano);
        return mapping.findForward(SUCCESS);
    }
}
