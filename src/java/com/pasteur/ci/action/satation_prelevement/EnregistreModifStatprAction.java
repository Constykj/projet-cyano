/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.satation_prelevement;

import com.pasteur.ci.bean.StatPrelevement;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.stat_prelevement.dao.StatPrelevementDAOImplement;
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
public class EnregistreModifStatprAction extends org.apache.struts.action.Action {

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
        String idstat_prelevement = (String) PropertyUtils.getProperty(form, "idstat_prelevement");
        int idhabitat=(Integer)PropertyUtils.getProperty(form, "idhabitat");
        double gps_lat = (Double) PropertyUtils.getProperty(form, "gps_lat");
        double gps_long = (Double) PropertyUtils.getProperty(form, "gps_long");
        int idplan_eau = (Integer) PropertyUtils.getProperty(form, "idplan_eau");
        int idstat = (Integer) PropertyUtils.getProperty(form, "idstat");
        boolean visible = (Boolean) PropertyUtils.getProperty(form, "visible");


        StatPrelevement statpr = new StatPrelevement();

        statpr.setIdStat_prelevement(idstat_prelevement);
        statpr.setIdhabitat(idhabitat);
        statpr.setIdstat(idstat);
        statpr.setIdplan_eau(idplan_eau);
        statpr.setGps_lat(gps_lat);
        statpr.setGps_long(gps_long);
        statpr.setVisible(visible);


        StatPrelevementDAOImplement cdaoi = new StatPrelevementDAOImplement(DAOFactory.getInstance());
        cdaoi.update(statpr);
        
        
        return mapping.findForward(SUCCESS);
    }
}
