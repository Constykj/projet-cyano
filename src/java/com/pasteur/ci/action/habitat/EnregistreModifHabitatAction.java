/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.habitat;

import com.pasteur.ci.bean.Habitat;
import com.pasteur.ci.bean.LigneHabitat;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.habitat.dao.HabitatDAOImplement;
import com.pasteur.ci.ligne_habitat.dao.LigneHabitatDAOImplement;
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
public class EnregistreModifHabitatAction extends org.apache.struts.action.Action {

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

        int idhabitat = (Integer) PropertyUtils.getProperty(form, "idhabitat");
        String  design_habitat = (String) PropertyUtils.getProperty(form, "design_habitat");
        int effectif = (Integer) PropertyUtils.getProperty(form, "effectif");
        double dist_bord_lagune = (Double) PropertyUtils.getProperty(form, "dist_bord_lagune");
        int idplan_eau = (Integer) PropertyUtils.getProperty(form, "idplan_eau");
        boolean visible = (Boolean) PropertyUtils.getProperty(form, "visible");
        int[] idmateriaux_construction = (int[]) PropertyUtils.getProperty(form, "idmateriaux_construction");

        Habitat habitat = new Habitat();

        habitat.setIdhabitat(idhabitat);
        habitat.setDesign_habitat(design_habitat);
        habitat.setEffectif(effectif);
        habitat.setDist_bord_lagune(dist_bord_lagune);
        habitat.setIdplan_eau(idplan_eau);
        habitat.setVisible(visible);

        HabitatDAOImplement cdaoi = new HabitatDAOImplement(DAOFactory.getInstance());
        habitat = (Habitat) cdaoi.update(habitat);
        
        LigneHabitat lhabitatc = new LigneHabitat();
        lhabitatc.setIdhabitat(habitat.getIdhabitat());
        
        LigneHabitat lhabitat = new LigneHabitat();
        lhabitat.setIdhabitat(habitat.getIdhabitat());//ok
        
        
        LigneHabitatDAOImplement lhab = new LigneHabitatDAOImplement(DAOFactory.getInstance());

        ArrayList<Object> listHabitat = lhab.findS(lhabitat);

        for (Object listHabitat1 : listHabitat) {
            LigneHabitat lh = new LigneHabitat();
            lh = (LigneHabitat) listHabitat1;
            lhab.delete(lh);
        }

  

        for (int i = 0; i < idmateriaux_construction.length; i++) {
            lhabitatc.setIdmateriaux_construction(idmateriaux_construction[i]);
            lhab.create(lhabitatc);
        }

 
        return mapping.findForward(SUCCESS);
    }
}
