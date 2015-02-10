/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.serotype_vb;

import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.region.dao.RegionDAOImplement;
import com.pasteur.ci.serotype_vb.dao.SerotypeVbDAOImplement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author abouchou
 */
public class GestionSerotypeVbAction extends org.apache.struts.action.Action {

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
            
          SerotypeVbDAOImplement rdaoi = new SerotypeVbDAOImplement(DAOFactory.getInstance());
        ArrayList<Object> list = rdaoi.find();


        request.setAttribute("liste_seroVb", list);
        return mapping.findForward(SUCCESS);
    }
}
