/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pasteur.ci.action.type_gene_toxicite;

import com.pasteur.ci.bean.GeneCyano;
import com.pasteur.ci.bean.TypeGeneCyano;
import com.pasteur.ci.bean.TypeGeneToxicite;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.gene_cyano.dao.GeneCyanoDAOImplement;
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
public class CreerTypeGeneToxiciteAction extends org.apache.struts.action.Action {

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
        
        String design_typ_gene_toxicite = (String) PropertyUtils.getProperty(form, "design_typ_gene_toxicite");
        double conc_typ_gene_toxicite=(Double) PropertyUtils.getProperty(form, "conc_typ_gene_toxicite");
        boolean visible = (Boolean) PropertyUtils.getProperty(form, "visible");
        TypeGeneToxicite type_gene_toxicite = new TypeGeneToxicite();
        type_gene_toxicite.setDesign_typ_gene_toxicite(design_typ_gene_toxicite);

        type_gene_toxicite.setVisible(visible);
        TypeGeneToxiciteDAOImplement gdaoi = new TypeGeneToxiciteDAOImplement(DAOFactory.getInstance());
        gdaoi.create(type_gene_toxicite);
        return mapping.findForward(SUCCESS);
    }
}
