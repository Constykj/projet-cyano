/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.projet;

import com.pasteur.ci.bean.Projet;
import com.pasteur.ci.projet.dao.ProjetDAOImplement;
import com.pasteur.ci.config.DAOFactory;
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
public class EnregistreModifProjetAction extends org.apache.struts.action.Action {

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
        
        String idprojet =  (String) PropertyUtils.getProperty(form, "idprojet");       
        String design_projet = (String) PropertyUtils.getProperty(form, "design_projet");
        String source_financement = (String) PropertyUtils.getProperty(form, "source_financement");
        String collabor_projet = (String) PropertyUtils.getProperty(form, "collabor_projet");
        String debut_projet = (String) PropertyUtils.getProperty(form, "debut_projet");
        String fin_projet = (String) PropertyUtils.getProperty(form, "fin_projet");
        String caract_projet = (String) PropertyUtils.getProperty(form, "caract_projet");
        boolean visible = (Boolean) PropertyUtils.getProperty(form, "visible");
        
        Projet projet = new Projet();
        
        projet.setIdprojet(Integer.valueOf(idprojet));
        projet.setDesign_projet(design_projet);
        projet.setCaract_projet(caract_projet);
        projet.setSource_financement(source_financement);
        projet.setCollabor_projet(collabor_projet);
        projet.setDebut_projet(debut_projet);
        projet.setFin_projet(fin_projet);
        projet.setVisible(visible);


       ProjetDAOImplement prdaoi = new ProjetDAOImplement(DAOFactory.getInstance());
        prdaoi.update(projet);
        
      
        return mapping.findForward(SUCCESS);
    }
}
