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

import java.util.ArrayList;

public abstract class Titres {
    private double valeur;  //valeure nominale du titre
    private double prix_emission;  //prix de vente du titre
    private String detenteur; //id du détenteur du titre
    private String id;  //id du titre financier pour l'identifier
    private ArrayList<Double> hist;

    public Titres(double valeur, double prix_emission, String detenteur, String id) {
        this.valeur = valeur;
        this.prix_emission = prix_emission;
        this.detenteur = detenteur;
        this.id = id;
        hist = new ArrayList<>();
    }
    
   

    public double getPrix_emission() {
        return prix_emission;
    }

    public double getValeur() {
        return valeur;
    }

    public void setPrix_emission(double prix_emission) {
        this.prix_emission = prix_emission;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public String getDetenteur() {
        return detenteur;
    }

    public void setDetenteur(String detenteur) {
        this.detenteur = detenteur;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Double> getHist() {
        return hist;
    }
    
    public void update() {
        hist.add(valeur);
        valeur = valeur + Math.random() -0.5;
    }
    
}