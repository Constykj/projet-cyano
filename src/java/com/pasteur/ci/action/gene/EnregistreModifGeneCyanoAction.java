/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pasteur.ci.action.gene;

import com.pasteur.ci.bean.GeneCyano;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.gene_cyano.dao.GeneCyanoDAOImplement;
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
public class EnregistreModifGeneCyanoAction extends org.apache.struts.action.Action {

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
        int idgene_cyano = (Integer) PropertyUtils.getProperty(form, "idgene_cyano");
        String design_gene_cyano = (String) PropertyUtils.getProperty(form, "design_gene_cyano");
        boolean visib = (Boolean) PropertyUtils.getProperty(form, "visib");
        GeneCyano gene_cyano = new GeneCyano();
        gene_cyano.setIdgene_cyano(idgene_cyano);
        gene_cyano.setDesign_gene_cyano(design_gene_cyano);
        gene_cyano.setVisib(visib);
        GeneCyanoDAOImplement gdaoi = new GeneCyanoDAOImplement(DAOFactory.getInstance());
        gdaoi.update(gene_cyano);
        return mapping.findForward(SUCCESS);
    }
}
