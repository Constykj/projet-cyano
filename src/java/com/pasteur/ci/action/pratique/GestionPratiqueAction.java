/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.pratique;

import com.pasteur.ci.pratique.dao.PratiqueDAOImplement;
import com.pasteur.ci.config.DAOFactory;
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
public class GestionPratiqueAction extends org.apache.struts.action.Action {

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
              
        PratiqueDAOImplement cdaoi = new PratiqueDAOImplement(DAOFactory.getInstance());
        ArrayList<Object> list = cdaoi.find();
         
         ArrayList<Object> listf = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            listf.add(list.get(i));
        }
        request.setAttribute("liste_pra", listf);
        return mapping.findForward(SUCCESS);
    }
}
