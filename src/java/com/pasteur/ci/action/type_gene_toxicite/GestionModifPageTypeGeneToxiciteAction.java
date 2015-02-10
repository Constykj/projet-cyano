/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pasteur.ci.action.type_gene_toxicite;

import com.pasteur.ci.bean.TypeGeneCyano;
import com.pasteur.ci.bean.TypeGeneToxicite;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.type_gene_cyano.dao.TypeGeneCyanoDAOImplement;
import com.pasteur.ci.type_gene_toxicite.dao.TypeGeneToxiciteDAOImplement;
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
public class GestionModifPageTypeGeneToxiciteAction extends org.apache.struts.action.Action {

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
          int comId  =(Integer)  PropertyUtils.getProperty(form, "idtyp_gene_toxicite");

        TypeGeneToxicite typ_gene_toxicite = new TypeGeneToxicite();

        typ_gene_toxicite.setIdtyp_gene_toxicite(comId);
        TypeGeneToxiciteDAOImplement cdaoi = new TypeGeneToxiciteDAOImplement(DAOFactory.getInstance());

        typ_gene_toxicite = (TypeGeneToxicite) cdaoi.find(typ_gene_toxicite);

        request.setAttribute("tygeneToxi_trouve", typ_gene_toxicite);
        return mapping.findForward(SUCCESS);
    }
}
