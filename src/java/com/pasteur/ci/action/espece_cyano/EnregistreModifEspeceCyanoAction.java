/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.espece_cyano;

import com.pasteur.ci.bean.EspeceCyano;
import com.pasteur.ci.bean.GenreCyano;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.espece_cyano.dao.EspeceCyanoDAOImplement;
import com.pasteur.ci.genre_cyano.dao.GenreCyanoDAOImplement;
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
public class EnregistreModifEspeceCyanoAction extends org.apache.struts.action.Action {

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
        int idespece_cyano = (Integer) PropertyUtils.getProperty(form, "idespece_cyano");
        int idgenre_cyano = (Integer) PropertyUtils.getProperty(form, "idgenre_cyano");
        String design_espece_cyano = (String) PropertyUtils.getProperty(form, "design_espece_cyano");
        boolean visible = (Boolean) PropertyUtils.getProperty(form, "visible");
        EspeceCyano cyano = new EspeceCyano();
        cyano.setIdespece_cyano((idespece_cyano));
        cyano.setIdgenre_cyano((idgenre_cyano));
        cyano.setDesign_espece_cyano(design_espece_cyano);
        cyano.setVisible(visible);
        EspeceCyanoDAOImplement qdaoi = new EspeceCyanoDAOImplement(DAOFactory.getInstance());
        qdaoi.update(cyano);
        return mapping.findForward(SUCCESS);
    }
}
