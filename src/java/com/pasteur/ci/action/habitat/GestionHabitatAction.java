/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.habitat;

import com.pasteur.ci.bean.Habitat;
import com.pasteur.ci.bean.Habitats;

import com.pasteur.ci.bean.LigneHabitat;
import com.pasteur.ci.bean.MateriauxConstruction;
import com.pasteur.ci.bean.PlanEau;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.habitat.dao.HabitatDAOImplement;
import com.pasteur.ci.ligne_habitat.dao.LigneHabitatDAOImplement;
import com.pasteur.ci.materiaux_construction.dao.MateriauxConstructionDAOImplement;
import com.pasteur.ci.plan_eau.dao.PlanEauDAOImplement;
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
public class GestionHabitatAction extends org.apache.struts.action.Action {

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
 
        HabitatDAOImplement hdaoi = new HabitatDAOImplement(DAOFactory.getInstance());
        PlanEauDAOImplement pdaoi = new PlanEauDAOImplement(DAOFactory.getInstance());
        LigneHabitatDAOImplement lhdaoi = new LigneHabitatDAOImplement(DAOFactory.getInstance());
        MateriauxConstructionDAOImplement mcdaoi = new MateriauxConstructionDAOImplement(DAOFactory.getInstance());

        ArrayList list_hd = new ArrayList();

        ArrayList<Object> list = hdaoi.find();

        for (Object list2 : list) {
            Habitat habitat = (Habitat) list2;
            
            String _design=habitat.getDesign_habitat();
            int _idhabitat = habitat.getIdhabitat();
            double _dist_bord_lagune = habitat.getDist_bord_lagune();
            int _effectif = habitat.getEffectif();
            int _idplan_eau = habitat.getIdplan_eau();
            boolean _visible = habitat.isVisible();

            //
            PlanEau planEau = new PlanEau();
            planEau.setIdplan_eau(_idplan_eau);
            planEau = (PlanEau) pdaoi.find(planEau);
            //

            LigneHabitat ligneHabitat = new LigneHabitat();
            ligneHabitat.setIdhabitat(_idhabitat);
            ArrayList<Object> ligne_mat_const_hab = lhdaoi.findS(ligneHabitat);
            ArrayList mat_const = new ArrayList();
            
            
            for (Object lmch : ligne_mat_const_hab) {
                LigneHabitat _lmch = (LigneHabitat) lmch;
                MateriauxConstruction mc = new MateriauxConstruction();
                mc.setIdmateriaux_construction(_lmch.getIdmateriaux_construction());
                mc = (MateriauxConstruction) mcdaoi.find(mc);
                mat_const.add(mc);
                System.out.print("je suis ici");
            }

            //
            Habitats habitat_detail = new Habitats();
            habitat_detail.setIdhabitat(_idhabitat);
            habitat_detail.setDesign_habitat(_design);
            habitat_detail.setDist_bord_lagune(_dist_bord_lagune);
            habitat_detail.setEffectif(_effectif);
            habitat_detail.setPlan_eau(planEau.getDesignation());
            habitat_detail.setVisible(_visible);
            habitat_detail.setMat_const(ArrayToString(mat_const));

            list_hd.add(habitat_detail);
        }
        
        
        
        ArrayList<Object> listf = new ArrayList<>();
        for (int i = 1; i < list_hd.size(); i++) {
            listf.add(list_hd.get(i));
        }
        request.setAttribute("liste_habitat", listf);
         
        return mapping.findForward(SUCCESS);

    }

    public String ArrayToString(ArrayList list) {

        String vf = "";

        for (Object list1 : list) {
            MateriauxConstruction mc = null;
            mc = (MateriauxConstruction) list1;
            vf += mc.getLib_materiaux_construction() + ";";
        }

        int sz = vf.length();
        if (sz != 0) {
            vf = vf.substring(0, sz - 1);
            vf = vf.replace(";", "; ");
        }

        return vf;
    }

}
