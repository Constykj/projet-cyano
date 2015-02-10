/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.pratique;

import com.pasteur.ci.bean.Pratique;
import com.pasteur.ci.pratique.dao.PratiqueDAOImplement;
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
public class GestionPratiqueModifAction extends org.apache.struts.action.Action {

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
         String praId = (String) PropertyUtils.getProperty(form,"idpratique");

        Pratique pratiques = new Pratique();
        pratiques.setIdpratique(Integer.parseInt(praId));

        PratiqueDAOImplement cdaoi = new PratiqueDAOImplement(DAOFactory.getInstance());

        pratiques = (Pratique) cdaoi.find(pratiques);

        request.setAttribute("pra_trouve", pratiques);
        
        return mapping.findForward(SUCCESS);
    }
}
