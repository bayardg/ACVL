/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author administrateur
 */
package simu;

import java.util.*;

public class Marche {

    private ArrayList<Titres> ListeTitres;  //liste des titres financiers disponibles
    private ArrayList<Acheteurs> acheteurs; //liste des acheteurs inscrits dans le marché financier

    public Marche(ArrayList<Titres> ListeTitres, ArrayList<Acheteurs> acheteurs) {
        this.ListeTitres = ListeTitres;
        this.acheteurs = acheteurs;
    }

    public ArrayList<Titres> getListeTitres() {
        return ListeTitres;
    }
    
    public Titres getTitre(Titres titre) {
        Iterator<Titres> it = ListeTitres.iterator();
        Titres cour;
        while (it.hasNext()) {
            cour = it.next();
            if (cour.getId().equals(titre.getId())) {
                return cour;
            }
        }
        return null;
    }

    public void setAcheteurs(ArrayList<Acheteurs> acheteurs) {
        this.acheteurs = acheteurs;
    }

    public ArrayList<Acheteurs> getAcheteurs() {
        return acheteurs;
    }

    public void setListeTitres(ArrayList<Titres> ListeTitres) {
        this.ListeTitres = ListeTitres;
    }

    public void voirListeTitres() {  //permet de visualiser les titres disponibles sur le marché
        Iterator<Titres> it = getListeTitres().iterator();
        while (it.hasNext()) {
            Titres titre = it.next();
            System.out.println(titre.getId());
        }
    }

    public void update() {
        Iterator<Titres> it = getListeTitres().iterator();
        while (it.hasNext()) {
            Titres titre = it.next();
            titre.update();
        }
    }

}
