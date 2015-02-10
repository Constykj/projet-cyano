/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.point_prelevement;

import com.pasteur.ci.bean.PointPrelevement;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.action.point_prelevement.dao.PointPrelevementDAOImplement;
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
public class CreerPtprAction extends org.apache.struts.action.Action {

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

        String designation = (String) PropertyUtils.getProperty(form, "designation");
        int idstat = (Integer) PropertyUtils.getProperty(form, "idstat");
        double profondeur =  (Double) PropertyUtils.getProperty(form, "profondeur");
        
        boolean visible = (Boolean) PropertyUtils.getProperty(form, "visible");


       PointPrelevement ptpr = new PointPrelevement();

        ptpr.setDesignation(designation);
        ptpr.setProfondeur(profondeur);
        ptpr.setIdstat(idstat);
        ptpr.setVisible(visible);


        PointPrelevementDAOImplement pdaoi = new PointPrelevementDAOImplement(DAOFactory.getInstance());
        pdaoi.create(ptpr);



        return mapping.findForward(SUCCESS);
    }
}
