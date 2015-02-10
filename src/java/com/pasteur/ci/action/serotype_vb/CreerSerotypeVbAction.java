/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.serotype_vb;

import com.pasteur.ci.bean.Region;
import com.pasteur.ci.bean.SerotypeVb;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.region.dao.RegionDAOImplement;
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
public class CreerSerotypeVbAction extends org.apache.struts.action.Action {

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
        String design_serotype = (String) PropertyUtils.getProperty(form, "design_serotype");

        boolean visible = (Boolean) PropertyUtils.getProperty(form, "visible");


        SerotypeVb serotype_vb = new SerotypeVb();
        //quartier.setIdquartier(idq);
        serotype_vb.setDesign_serotype(design_serotype);
        serotype_vb.setVisible(visible);

        SerotypeVbDAOImplement rdaoi = new SerotypeVbDAOImplement(DAOFactory.getInstance());
        rdaoi.create(serotype_vb);
        return mapping.findForward(SUCCESS);
    }
}
