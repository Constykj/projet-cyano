/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.habitat;

import com.pasteur.ci.bean.Habitat;
import com.pasteur.ci.bean.Habitats;
import com.pasteur.ci.bean.LigneHabitat;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.habitat.dao.HabitatDAOImplement;
import com.pasteur.ci.ligne_habitat.dao.LigneHabitatDAOImplement;
import com.pasteur.ci.materiaux_construction.dao.MateriauxConstructionDAOImplement;
import com.pasteur.ci.plan_eau.dao.PlanEauDAOImplement;
import java.util.ArrayList;
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
public class GestionHabitatModifAction extends org.apache.struts.action.Action {

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

        int habitatID = (Integer) PropertyUtils.getProperty(form, "idhabitat");
        Habitat habitat = new Habitat();
        Habitats habitats = new Habitats();
        habitat.setIdhabitat(habitatID);

        HabitatDAOImplement hpdeao = new HabitatDAOImplement(DAOFactory.getInstance());
        habitat = (Habitat) hpdeao.find(habitat);

        habitats.setIdhabitat(habitatID);
        habitats.setDesign_habitat(habitat.getDesign_habitat());
        habitats.setDist_bord_lagune(habitat.getDist_bord_lagune());
        habitats.setEffectif(habitat.getEffectif());
        habitats.setIdplan_eau(habitat.getIdplan_eau());

        PlanEauDAOImplement pdeao = new PlanEauDAOImplement(DAOFactory.getInstance());

        ArrayList<Object> listPlanEau = pdeao.find();

        LigneHabitatDAOImplement lhdaoi = new LigneHabitatDAOImplement(DAOFactory.getInstance());
        LigneHabitat ligneHabitat = new LigneHabitat();
        ligneHabitat.setIdhabitat(habitatID);

        ArrayList<Object> ligne_mat_const_hab = lhdaoi.findS(ligneHabitat);

        int[] mtcst = new int[ligne_mat_const_hab.size()];

        for (int i = 0; i < ligne_mat_const_hab.size(); i++) {
            LigneHabitat lh;
            lh = (LigneHabitat) ligne_mat_const_hab.get(i);
            mtcst[i] = lh.getIdmateriaux_construction();
        }

        habitats.setIdmateriaux_construction(mtcst);
        habitats.setMateriaux_construction(ligne_mat_const_hab);

        MateriauxConstructionDAOImplement mdeao = new MateriauxConstructionDAOImplement(DAOFactory.getInstance());

        ArrayList<Object> listMatCns = mdeao.find();

//        request.setAttribute("mat_trouve_sp", ligne_mat_const_hab);
        request.setAttribute("mat_trouve", listMatCns);
        request.setAttribute("habitat_trouve", habitats);
        request.setAttribute("planeau_trouve", listPlanEau);

        return mapping.findForward(SUCCESS);
    }
}
