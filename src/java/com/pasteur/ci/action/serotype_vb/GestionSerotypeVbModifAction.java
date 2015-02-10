/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.serotype_vb;


import com.pasteur.ci.bean.SerotypeVb;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.serotype_vb.dao.SerotypeVbDAOImplement;
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
public class GestionSerotypeVbModifAction extends org.apache.struts.action.Action {

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

        int idserotype_vb = (Integer) PropertyUtils.getProperty(form, "idserotype_vb");

        SerotypeVb serotype_vb = new SerotypeVb();
        serotype_vb.setIdserotype_vb(idserotype_vb);


         SerotypeVbDAOImplement rdaoi = new SerotypeVbDAOImplement(DAOFactory.getInstance());
        serotype_vb = (SerotypeVb) rdaoi.find(serotype_vb);

        request.setAttribute("seroVb", serotype_vb);

        return mapping.findForward(SUCCESS);
    }
}
