/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.creation;

import com.pasteur.ci.bean.LigneGenreCyano;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author HP USER
 */
public class ExempleAction extends org.apache.struts.action.Action {

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

        String list = (String) PropertyUtils.getProperty(form, "listeGenreCyano");

        System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + list);
        
         String[] tb = list.split(",");
        int bk = tb.length / 3;
        //creer un arraylist d'objet
         ArrayList<Object> ligne_genre_cyanos = new ArrayList<Object>();
        int cp = 0;
        for (int i = 0; i < bk; i++) {
            LigneGenreCyano ligne_genre_cyano = new LigneGenreCyano();
            for (int j = 0; j < 3; j++) {

                if (j == 0) {
                    //A chaque item remplir une propriete
                    System.out.println("idgenre_cyano: " + tb[cp++]);
                    ligne_genre_cyano.setIdcyano(Integer.parseInt(tb[cp++]));
                }
                if (j == 1) {
                    //A chaque item remplir une propriete
                    System.out.println("Denombrement: " + tb[cp++]);
                       ligne_genre_cyano.setIdespece_cyano(Integer.parseInt(tb[cp++]));
                }
                if (j == 2) {
                    //A chaque item remplir une propriete
                    System.out.println("idespece_cyano: " + tb[cp++]);
                       if(tb[cp++] != ""){
                            ligne_genre_cyano.setDenombrement_esp_cyano(Integer.parseInt(tb[cp++]));
                       }
                      
                }
            }
            //Apres chaque boucle ajoute l'objet creer et remplis a l'arrayList
            System.out.println("---------");
            ligne_genre_cyanos.add(ligne_genre_cyano);

        }
        return mapping.findForward(SUCCESS);
    }
    
}
