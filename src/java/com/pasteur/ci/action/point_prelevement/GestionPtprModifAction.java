/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.point_prelevement;

import com.pasteur.ci.bean.PointPrelevement;
import com.pasteur.ci.bean.StatPrelevement;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.action.point_prelevement.dao.PointPrelevementDAOImplement;
import com.pasteur.ci.stat_prelevement.dao.StatPrelevementDAOImplement;
import java.util.ArrayList;
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
public class GestionPtprModifAction extends org.apache.struts.action.Action {

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

        String ptprId = (String) PropertyUtils.getProperty(form, "idpoint_prelevement");

        PointPrelevement ptpr = new PointPrelevement();
        ptpr.setIdpoint_prelevement(Integer.parseInt(ptprId));
        PointPrelevementDAOImplement ptdaoi = new PointPrelevementDAOImplement(DAOFactory.getInstance());
        ptpr = (PointPrelevement) ptdaoi.find(ptpr);


        double _pronf = ptpr.getProfondeur();
        int _idpp = ptpr.getIdpoint_prelevement();
        int _stat = ptpr.getIdstat();
        Boolean _visb = ptpr.isVisible();


        StatPrelevementDAOImplement stdaoi = new StatPrelevementDAOImplement(DAOFactory.getInstance());
        StatPrelevement statprev = new StatPrelevement();
        statprev.setIdstat(_stat);
        statprev = (StatPrelevement) stdaoi.find(statprev);

        ArrayList<Object> listStat = stdaoi.find();

        request.setAttribute("ptpr_trouve", ptpr);
        request.setAttribute("statp_trouve", listStat);
        return mapping.findForward(SUCCESS);
    }
}
