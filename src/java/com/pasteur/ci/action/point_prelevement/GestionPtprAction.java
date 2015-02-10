/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.point_prelevement;

import com.pasteur.ci.bean.PointPrelevement;
import com.pasteur.ci.bean.Ptpr;
import com.pasteur.ci.bean.StatPrelevement;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.action.point_prelevement.dao.PointPrelevementDAOImplement;
import com.pasteur.ci.stat_prelevement.dao.StatPrelevementDAOImplement;
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
public class GestionPtprAction extends org.apache.struts.action.Action {

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
        StatPrelevementDAOImplement stdaoi = new StatPrelevementDAOImplement(DAOFactory.getInstance());

        PointPrelevement ptpr = new PointPrelevement();
        PointPrelevementDAOImplement ppdaoi = new PointPrelevementDAOImplement(DAOFactory.getInstance());

        ArrayList<Ptpr> listpp = new ArrayList<Ptpr>();

        ArrayList<Object> list = ppdaoi.find();
        for (int i = 0; i < list.size(); i++) {

            PointPrelevement Point_pr = (PointPrelevement) list.get(i);
            int _idstat = Point_pr.getIdstat();
            int _idpp = Point_pr.getIdpoint_prelevement();
            String _design = Point_pr.getDesignation();
            double _idpronf = Point_pr.getProfondeur();
            Boolean _visb = Point_pr.isVisible();

            StatPrelevement stat = new StatPrelevement();
            stat.setIdstat(_idstat);
            stat = (StatPrelevement) stdaoi.find(stat);

            Ptpr stp = new Ptpr();
            stp.setIdpoint_prelevement(_idpp);
            stp.setDesignation(_design);
            stp.setIdstat(stat.getIdstat_prelevement());
            stp.setProfondeur(_idpronf);
            stp.setVisible(_visb);
            listpp.add(stp);

        }

        ArrayList<Object> listf = new ArrayList<>();
        for (int i = 1; i < listpp.size(); i++) {
            listf.add(listpp.get(i));
        }

        request.setAttribute("liste_ptpr", listf);

        return mapping.findForward(SUCCESS);
    }
}
