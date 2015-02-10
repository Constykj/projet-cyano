/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pasteur.ci.action.type_gene_cyano;

import com.pasteur.ci.bean.GeneCyano;
import com.pasteur.ci.bean.TypeGeneCyano;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.gene_cyano.dao.GeneCyanoDAOImplement;
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
public class CreerTypeGeneCyanoAction extends org.apache.struts.action.Action {

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
        
        String design_typ_gene_cyano = (String) PropertyUtils.getProperty(form, "design_typ_gene_cyano");
        double conc_typ_gene_cyano=(Double) PropertyUtils.getProperty(form, "conc_typ_gene_cyano");
        boolean visible = (Boolean) PropertyUtils.getProperty(form, "visible");
        TypeGeneCyano type_gene_cyano = new TypeGeneCyano();
        type_gene_cyano.setDesign_typ_gene_cyano(design_typ_gene_cyano);
       
        type_gene_cyano.setVisible(visible);
        TypeGeneCyanoDAOImplement gdaoi = new TypeGeneCyanoDAOImplement(DAOFactory.getInstance());
        gdaoi.create(type_gene_cyano);
        return mapping.findForward(SUCCESS);
    }
}
