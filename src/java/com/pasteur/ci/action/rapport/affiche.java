/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.rapport;

import com.pasteur.ci.action.point_prelevement.dao.PointPrelevementDAOImplement;
import com.pasteur.ci.bean.Echantillon;
import com.pasteur.ci.bean.PlanEau;
import com.pasteur.ci.bean.PointPrelevement;
import com.pasteur.ci.bean.RapportEchantillon2;
import com.pasteur.ci.bean.StatPrelevement;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.echantillon.dao.EchantillonDAOImplement;
import com.pasteur.ci.plan_eau.dao.PlanEauDAOImplement;
import com.pasteur.ci.stat_prelevement.dao.StatPrelevementDAOImplement;
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
public class affiche extends org.apache.struts.action.Action {

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

        EchantillonDAOImplement echant = new EchantillonDAOImplement(DAOFactory.getInstance());
        PointPrelevementDAOImplement ppt = new PointPrelevementDAOImplement(DAOFactory.getInstance());
        StatPrelevementDAOImplement statP = new StatPrelevementDAOImplement(DAOFactory.getInstance());
        PlanEauDAOImplement planE = new PlanEauDAOImplement(DAOFactory.getInstance());
        
        ArrayList<Object> listEchantillon = echant.find();
        ArrayList<Object> listPointPrev = ppt.find();
        ArrayList<Object> listStation = statP.find();
        ArrayList<Object> listPlanE = planE.find();
        
 
        RapportEchantillon2 rapportE2 = new RapportEchantillon2();
        rapportE2.setNbEchantillons(listEchantillon.size());
        rapportE2.setNbPointP(listPointPrev.size() - 1);
        rapportE2.setNbStationP( listStation.size() - 1);
        rapportE2.setNbPlanE(listPlanE.size() - 1);
        
        request.setAttribute("liste_nombre", rapportE2);

        EchantillonDAOImplement edaoi = new EchantillonDAOImplement(DAOFactory.getInstance());
        ArrayList  listRapEchan  = edaoi.findSS();

        request.setAttribute("liste_echant", listRapEchan);

        return mapping.findForward(SUCCESS);
    }

}
