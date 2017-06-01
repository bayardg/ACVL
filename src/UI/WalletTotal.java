/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author pierucci
 */
public class WalletTotal extends JPanel {

    private final JLabel labelTotal;
    private final JSpinner totalValue;

    public WalletTotal() {
        labelTotal = new JLabel("Portfolio Value");
        totalValue = new JSpinner();
        //totalValue.set(10);
        this.buildContentPanel();
    }

    private void buildContentPanel() {
        this.add(labelTotal);
        this.add(totalValue);
        this.setLayout(new FlowLayout());
    }
    
    void setWalletTotal(double valeur) {
        totalValue.setValue(valeur);
    }

}
