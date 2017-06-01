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
public class Actions extends Titres {
    private double dividendes;

    public Actions(double dividendes, double valeur, double prix_emission, String detenteur, String id) {
        super(valeur, prix_emission, detenteur, id);
        this.dividendes = dividendes;
    }
    

    @Override
    public void setPrix_emission(double prix_emission) {
        super.setPrix_emission(prix_emission); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public double getPrix_emission() {
        return super.getPrix_emission(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getValeur() {
        return super.getValeur(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValeur(double valeur) {
        super.setValeur(valeur); //To change body of generated methods, choose Tools | Templates.
    }
    
    public double getDividendes() {
	return this.dividendes;
    }
    
}
