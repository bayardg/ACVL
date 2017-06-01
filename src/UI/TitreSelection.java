/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import simu.Marche;
import simu.Titres;

/**
 *
 * @author pierucci
 */
public class TitreSelection extends JPanel implements ActionListener {

    JLabel choseTitre;
    JComboBox comboBox;
    Marche marche;

    public TitreSelection(Marche marche) {
        comboBox = new JComboBox();
        Iterator<Titres> it = marche.getListeTitres().iterator();
        while (it.hasNext()) {
            comboBox.addItem(it.next().getId());
        }
        //comboBox.addItem("lala");
        choseTitre = new JLabel("Chose a Financial Title");
        this.buildContentPanel();
    }

    private void buildContentPanel() {
        this.add(choseTitre);
        this.add(comboBox);
        this.setLayout(new FlowLayout());
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
