/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.FlowLayout;
import java.util.Iterator;
import javax.swing.*;
import simu.Acheteurs;
import simu.Marche;
import simu.Titres;

/**
 *
 * @author pierucci
 */
public class identPanel extends JPanel {

    private final JLabel askIdent;
    //private final JComboBox comboAcheteurs;
    private Marche marche;
    //private final JButton buttonConfirm;

    public identPanel(Marche marche) {
        this.marche = marche;
        askIdent = new JLabel("PortFolio Manager");
        //buttonConfirm = new JButton("Apply");
        //comboAcheteurs = new JComboBox();
        Iterator<Acheteurs> it = marche.getAcheteurs().iterator();
        /*while (it.hasNext()) {
            comboAcheteurs.addItem(it.next().getId());
        }*/
        //comboAcheteurs.setColumns(10);
        this.buildContentPanel();
    }

    private void buildContentPanel() {
        this.add(askIdent);
        //this.add(comboAcheteurs);
        //this.add(buttonConfirm);
        this.setLayout(new FlowLayout());
    }

}
