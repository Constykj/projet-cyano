/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.materiaux;

import com.pasteur.ci.bean.Eclairage;
import com.pasteur.ci.bean.MateriauxConstruction;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.eclairage.dao.EclairageDAOImplement;
import com.pasteur.ci.materiaux_construction.dao.MateriauxConstructionDAOImplement;
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
public class CreerMateriauxAction extends org.apache.struts.action.Action {

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

        String lib_materiaux_construction = (String) PropertyUtils.getProperty(form, "lib_materiaux_construction");
        boolean visible = (Boolean) PropertyUtils.getProperty(form, "visible");
        MateriauxConstruction materiaux_construction = new MateriauxConstruction();
        materiaux_construction.setLib_materiaux_construction(lib_materiaux_construction);
        materiaux_construction.setVisible(visible);
        MateriauxConstructionDAOImplement cdaoi = new MateriauxConstructionDAOImplement(DAOFactory.getInstance());
        cdaoi.create(materiaux_construction);


        return mapping.findForward(SUCCESS);
    }
}
