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
import org.jfree.chart.*;
import simu.Acheteurs;
import simu.Actions;
import simu.Marche;
import simu.Titres;

/**
 *
 * @author pierucci
 */
public class userPanel extends JPanel implements ActionListener {

    private identPanel identPanel;
    private walletPanelModel walletModel;
    private WalletTotal walletTotal;
    private TotalWealthPanel totalWealthPanel;
    private Marche marche;
    private Acheteurs user;
    private CashPanel cashPanel;
    private JScrollPane scroll;
    private double initialWealth;

    public userPanel(Marche marche) {
        identPanel = new identPanel(marche);
        walletModel = new walletPanelModel(marche);
        walletTotal = new WalletTotal();
        totalWealthPanel = new TotalWealthPanel();
        user = marche.getAcheteurs().iterator().next();
        cashPanel = new CashPanel();
        cashPanel.getCashAmount().setValue(user.getArgent());
        initialWealth = user.getArgent();
        JTable walletTable = new JTable(walletModel);
        scroll = new JScrollPane(walletTable);
        this.buildContentPanel();
    }

    private void buildContentPanel() {
        
        this.add(identPanel);
        this.add(scroll);
        this.add(walletTotal);
        this.add(cashPanel);
        this.add(totalWealthPanel);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public Acheteurs getUser() {
        return user;
    }

    void update() {
        walletModel.update();
        cashPanel.cashAmount.setValue(user.getArgent());     
        walletTotal.setWalletTotal(user.getProtefeuilleValue());
        totalWealthPanel.setTotalWealth(user.getArgent()+user.getProtefeuilleValue(),initialWealth);
    }

    public walletPanelModel getWalletModel() {
        return walletModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
