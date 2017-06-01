/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import simu.Marche;

/**
 *
 * @author pierucci
 */
public class MainWindow extends JFrame implements ActionListener {

    private JSplitPane panneau;
    private marketPanel marketPanel;
    private userPanel userPanel;
    private Marche marche;

    public MainWindow(Marche marche) {
        this.marche = marche;
        this.setTitle("Jeu de simulation Boursière - ACVL");
        this.setSize(300, 100);
        this.setVisible(true);
        this.setContentPane(buildContentPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marketPanel.getBuyButton().addActionListener(this);
        marketPanel.getSellButton().addActionListener(this);
        this.pack();
    }

    private JPanel buildContentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        marketPanel = new marketPanel(marche);
        userPanel = new userPanel(marche);
        panneau = new JSplitPane();
        panneau.setLeftComponent(userPanel);
        panneau.setRightComponent(marketPanel);
        panel.add(panneau);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == marketPanel.getBuyButton()) {
            System.out.println("[INFO] ACHAT");
            if (userPanel.getUser().getArgent() > marketPanel.getCurrentTitre().getValeur()) {
                userPanel.getWalletModel().addTitre(marketPanel.getCurrentTitre());
                userPanel.getUser().acheter(marketPanel.getCurrentTitre(), marche);
            } else {
                System.out.println("[WARNING] Pas assez d'argent pour acheter le titre !");
            }

        } else if (source == marketPanel.getSellButton()) {
            System.out.println("[INFO] VENTE");
            if (userPanel.getUser().getPortefeuille().contains(marketPanel.getCurrentTitre())) {
                userPanel.getUser().vendre(marketPanel.getCurrentTitre(), marche);
                userPanel.getWalletModel().removeTitre(marketPanel.getCurrentTitre());
            } else {
                System.out.println("[WARNING] Impossible de vendre ce titre : il n'est pas dans le portefeuille");
            }
        }

        /*if (source == buttonConfirm) {
            System.out.println("LOL");
        } */
    }

    public void update() {
        marketPanel.update();
        userPanel.update();
    }

}
