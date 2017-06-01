/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import simu.Marche;
import simu.Titres;

/**
 *
 * @author pierucci
 */
public class marketPanel extends JPanel implements ActionListener {

    TitreSelection titreSelection;
    TitreGraph titreGraph;
    BuySellPanel buySellPanel;
    Marche marche;

    public marketPanel(Marche marche) {
        titreSelection = new TitreSelection(marche);
        titreGraph = new TitreGraph("Action", marche);
        buySellPanel = new BuySellPanel();
        this.buildContentPanel();

        // Ajout listner comboBox
        titreSelection.getComboBox().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    titreGraph.changeGraph((String) e.getItem());
                }
            }
        });

    }

    private void buildContentPanel() {
        this.add(titreSelection);
        this.add(titreGraph.chartPanel);
        this.add(buySellPanel);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void update() {
        titreGraph.update();
    }

    JButton getSellButton() {
        return buySellPanel.getSellButton();
    }

    JButton getBuyButton() {
        return buySellPanel.getBuyButton();
    }
    
    Titres getCurrentTitre() {
        return titreGraph.getTitre();
    }

}
