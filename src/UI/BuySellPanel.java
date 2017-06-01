/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author pierucci
 */
public class BuySellPanel extends JPanel implements ActionListener {

    JButton buyButton;
    JButton sellButton;

    public BuySellPanel() {
        buyButton = new JButton("Buy");
        sellButton = new JButton("Sell");
        this.buildContentPanel();
    }

    private void buildContentPanel() {
        this.add(buyButton);
        this.add(sellButton);
        this.setLayout(new FlowLayout());
    }

    public JButton getBuyButton() {
        return buyButton;
    }

    public JButton getSellButton() {
        return sellButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
