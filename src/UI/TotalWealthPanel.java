/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

/**
 *
 * @author pierucci
 */
public class TotalWealthPanel extends JPanel {

    private final JLabel labelWealth;
    private final JLabel labelEvolution;
    private final JSpinner valueWealth;

    public TotalWealthPanel() {
        labelWealth = new JLabel("Overall Wealth");
        valueWealth = new JSpinner();
        labelEvolution = new JLabel();
        this.buildContentPanel();
    }

    private void buildContentPanel() {
        this.add(labelWealth);
        this.add(valueWealth);
        this.add(labelEvolution);
        this.setLayout(new FlowLayout());
    }

    void setTotalWealth(double valeur, double initialValue) {
        valueWealth.setValue(valeur);
        double pourcentage = (valeur - initialValue)/initialValue * 100;
        if (valeur > initialValue) {
            labelEvolution.setForeground(new Color(0, 128, 0));
            labelEvolution.setText("+ " + String.format("%.2f",pourcentage) + " %");
        } else {
            labelEvolution.setForeground(Color.red);
            labelEvolution.setText(String.format("%.2f",pourcentage) + " %");
        }
        
    }
}
