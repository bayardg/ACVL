/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.*;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import simu.*;

/**
 *
 * @author pierucci
 */
public class walletPanelModel extends AbstractTableModel {

    private final List<Titres> titres = new ArrayList<Titres>();
    private final String[] header = {"Title", "Value (€) ", "Variation"};
    Marche marche;

    public walletPanelModel(Marche marche) {

        super();
        this.marche = marche;

        //titres.add(new Actions(0, 0, 0, "me", "action"));
    }

    @Override
    public int getRowCount() {
        return titres.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return header[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return titres.get(rowIndex).getId();
            case 1:
                //System.out.println(titres.get(rowIndex).getId());
                return String.format("%.2f",(marche.getTitre(titres.get(rowIndex)).getValeur()));
            case 2:
                return String.format("%.2f",(marche.getTitre(titres.get(rowIndex)).getValeur()-marche.getTitre(titres.get(rowIndex)).getPrix_emission())/(marche.getTitre(titres.get(rowIndex)).getPrix_emission())* 100) + " %";
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    public void addTitre(Titres titre) {
        titres.add(titre);

        fireTableRowsInserted(titres.size() - 1, titres.size() - 1);
    }

    public void removeTitre(Titres titre) {
        titres.remove(titre);
    }

    public List<Titres> getTitres() {
        return titres;
    }

    void update() {
        this.fireTableDataChanged();
    }

    /*double getWalletValue() {
        double value = 0;
        return 0;
    }*/
}
