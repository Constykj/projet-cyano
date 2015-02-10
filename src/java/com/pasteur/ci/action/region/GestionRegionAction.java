/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.region;

import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.region.dao.RegionDAOImplement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Abouchou
 */
public class GestionRegionAction extends org.apache.struts.action.Action {

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

        RegionDAOImplement rdaoi = new RegionDAOImplement(DAOFactory.getInstance());
        ArrayList<Object> list = rdaoi.find();

        ArrayList<Object> listf = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            listf.add(list.get(i));
        }
        request.setAttribute("liste_reg", listf);

        return mapping.findForward(SUCCESS);
    }
}
