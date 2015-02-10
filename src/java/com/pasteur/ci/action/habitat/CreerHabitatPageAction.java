/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.habitat;

import com.pasteur.ci.type_plan_eau.dao.TypePlanEauDAOImplement;
import com.pasteur.ci.commune.dao.CommuneDAOImplement;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.materiaux_construction.dao.MateriauxConstructionDAOImplement;
import com.pasteur.ci.plan_eau.dao.PlanEauDAOImplement;
import com.pasteur.ci.quartier.dao.QuartierDAOImplement;
import com.pasteur.ci.region.dao.RegionDAOImplement;
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
public class CreerHabitatPageAction extends org.apache.struts.action.Action {

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
        PlanEauDAOImplement qdaoi = new PlanEauDAOImplement(DAOFactory.getInstance());
        MateriauxConstructionDAOImplement mdeao=new MateriauxConstructionDAOImplement(DAOFactory.getInstance());
         
        ArrayList<Object> listPlanE = qdaoi.find();
        
        ArrayList<Object> listMatCns = mdeao.find();
        
        request.setAttribute("mat_trouve", listMatCns);
        request.setAttribute("planE_trouve", listPlanE);
        return mapping.findForward(SUCCESS);
    }
}
