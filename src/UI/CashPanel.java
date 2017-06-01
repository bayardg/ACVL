/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import simu.Marche;

/**
 *
 * @author pierucci
 */
public class CashPanel extends JPanel {

    JLabel cashLabel;
    JSpinner cashAmount;
    Marche marche;

    public CashPanel() {
        cashLabel = new JLabel("Bank");
        cashAmount = new JSpinner();
        this.marche = marche;
        buildContentPanel();
    }

    public JSpinner getCashAmount() {
        return cashAmount;
    }

    private void buildContentPanel() {
        this.add(cashLabel);
        this.add(cashAmount);
        this.setLayout(new FlowLayout());
    }

}
