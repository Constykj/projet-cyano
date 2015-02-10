/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.espece_algue;

import com.pasteur.ci.bean.EspeceAlgue;
import com.pasteur.ci.bean.GenreAlgue;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.espece_algue.dao.EspeceAlgueDAOImplement;
import com.pasteur.ci.genre_algue.dao.GenreAlgueDAOImplement;
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
public class CreerEspeceAlgAction extends org.apache.struts.action.Action {

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

        //int idespece_algue = (int) PropertyUtils.getProperty(form, "idespece_algue");
        int idgenre_algue = (Integer) PropertyUtils.getProperty(form, "idgenre_algue");
        String design_espece_algue = (String) PropertyUtils.getProperty(form, "design_espece_algue");
        boolean visible = (Boolean) PropertyUtils.getProperty(form, "visible");
        
        EspeceAlgue espece_algue = new EspeceAlgue();
        
        //espece_algue.setIdespece_algue(idespece_algue);
        espece_algue.setIdgenre_algue((idgenre_algue));
        espece_algue.setDesign_espece_algue(design_espece_algue);
        espece_algue.setVisible(visible);
        
        EspeceAlgueDAOImplement especeDAO = new EspeceAlgueDAOImplement(DAOFactory.getInstance());
        
        especeDAO.create(espece_algue);
        
        
        return mapping.findForward(SUCCESS);
    }
}
