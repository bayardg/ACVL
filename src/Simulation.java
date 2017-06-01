/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author administrateur
 */
import simu.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import UI.*;

public class Simulation {

    public static void main(String[] args) throws InterruptedException {
        Marche marche = new Marche(new ArrayList<>(), new ArrayList<>());
        for (int i = 1; i < 101; i++) {  //on ajoute 100 acheteurs et 1000 actions
            Acheteurs acheteur;
            acheteur = new Acheteurs(new ArrayList<>(), 10000, "acheteur" + i);
            marche.getAcheteurs().add(acheteur); //on ajoute tous ces acheteurs

        }
        Actions action;

        /*Initialisation Interface*/
        action = new Actions(100, 100, 100, "", "Danone");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Total");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Sanofi");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Nokia");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Safran");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Renault");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Vivendi");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "LeGrand");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "CapGemini");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Bouygues");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Atos");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Carrefour");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Sodexo");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Valeo");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Publicis");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Axa");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Vinci");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Danone");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "LVMH");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "L'Oréal");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Credit Agricole");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Société Générale");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Arcelor Mittal");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "AccorsHotels");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "BNP Paribas");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Airbus");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Air Liquide");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Schneider");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Orange");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Lafargeholcim");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Engie");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Kering");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Ricard");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Saint Gobin");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Essilor");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Unibail-Rodamco");
        marche.getListeTitres().add(action);
        action = new Actions(100, 100, 100, "", "Michelin");
        marche.getListeTitres().add(action);
        MainWindow mainWindow = new MainWindow(marche);

        while (true) {
            Thread.sleep(500);
            marche.update();
            mainWindow.update();
        }

    }

}
