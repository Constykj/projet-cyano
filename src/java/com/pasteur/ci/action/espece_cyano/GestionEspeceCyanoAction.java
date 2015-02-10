/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.espece_cyano;

import com.pasteur.ci.bean.EspeceAlgue;
import com.pasteur.ci.bean.EspeceAlgues;
import com.pasteur.ci.bean.EspeceCyano;
import com.pasteur.ci.bean.EspeceCyanos;
import com.pasteur.ci.bean.GenreAlgue;
import com.pasteur.ci.bean.GenreCyano;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.espece_cyano.dao.EspeceCyanoDAOImplement;
import com.pasteur.ci.genre_algue.dao.GenreAlgueDAOImplement;
import com.pasteur.ci.genre_cyano.dao.GenreCyanoDAOImplement;
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
public class GestionEspeceCyanoAction extends org.apache.struts.action.Action {

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
         GenreCyanoDAOImplement GenreDAO = new GenreCyanoDAOImplement(DAOFactory.getInstance());
          EspeceCyanoDAOImplement gedaoi = new EspeceCyanoDAOImplement(DAOFactory.getInstance());
        ArrayList<EspeceCyanos> listst = new ArrayList<EspeceCyanos>();
        
        
         ArrayList<Object> list = gedaoi.find();
        for (int i = 0; i < list.size(); i++) {

            EspeceCyano espece_cyano = (EspeceCyano) list.get(i);
            int _idespC = espece_cyano.getIdespece_cyano();
            int _idgenrC = espece_cyano.getIdgenre_cyano();
            String _design = espece_cyano.getDesign_espece_cyano();
            Boolean _visb = espece_cyano.isVisible();

            GenreCyano genreCya = new GenreCyano();
            genreCya.setIdgenre_cyano(_idgenrC);
            genreCya = (GenreCyano) GenreDAO.find(genreCya);

            EspeceCyanos stp = new EspeceCyanos();
            stp.setIdespece_cyano(_idespC);
            stp.setGenre_cyano(genreCya.getDesign_genre_cyano());
            stp.setDesign_espece_cyano(_design);
            stp.setVisible(_visb);
            listst.add(stp);

        }

        
       ArrayList<Object> listf = new ArrayList<>();
        for (int i = 1; i < listst.size(); i++) {
            listf.add(listst.get(i));
        }
        request.setAttribute("liste_espece_cyano", listf);
        return mapping.findForward(SUCCESS);
    }
}
