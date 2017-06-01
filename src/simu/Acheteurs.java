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

public class Acheteurs {

    private ArrayList<Titres> portefeuille;
    private double argent;
    private String id;

    public Acheteurs(ArrayList<Titres> portefeuille, double argent, String id) {
        this.portefeuille = portefeuille;
        this.argent = argent;
        this.id = id;
    }

    public double getProtefeuilleValue() {
        double value = 0;
        if (portefeuille.size() == 0) {
            return 0;
        }
        Iterator<Titres> it = portefeuille.iterator();
        Titres cour = null;
        while (it.hasNext()) {
            cour = it.next();
            value = value + cour.getValeur();
        }
        return value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getArgent() {
        return argent;
    }

    public void setArgent(double argent) {
        this.argent = argent;
    }

    /**
     *
     * @return
     */
    public ArrayList<Titres> getPortefeuille() {
        return portefeuille;
    }

    public void setPortefeuille(ArrayList<Titres> portefeuille) {
        this.portefeuille = portefeuille;
    }

    public void acheter(Titres titre, Marche marche) {
        if (marche.getListeTitres().contains(titre) && this.argent >= titre.getPrix_emission()) {
            this.portefeuille.add(titre);
            //marche.getListeTitres().remove(titre);
            this.argent -= titre.getValeur();
            titre.setDetenteur(id); //le detenteur du titre devient l'acheteur
        } else {
            System.out.println("le titre n'existe sur le marché pas ou vous n'avez pas assez d'argent");
        }
    }

    public void vendre(Titres titre, Marche marche) {
        if (this.portefeuille.contains(titre)) {
            portefeuille.remove(titre);
            marche.getListeTitres().add(titre);
            this.argent += titre.getPrix_emission(); //on ajoute le prix de la vente au porte-monnaie de l'acheteur
            titre.setDetenteur(""); //le titre n'appartient plus à personne
        } else {
            System.out.println("vous ne pouvez vendre cette actions car vous ne la possédez pas");

        }
    }

    public void versementDividendes() {
        if (portefeuille == null) {
            return;
        } else {
            Iterator<Titres> it;
            it = portefeuille.iterator();
            while (it.hasNext()) {
                Titres titre = it.next();
                if (titre instanceof Actions) {
                    Actions action = (Actions) titre;
                    this.argent += action.getDividendes();
                }

            }
        }
    }

}
