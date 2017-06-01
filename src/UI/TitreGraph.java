/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.Iterator;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import simu.Actions;
import simu.Marche;
import simu.Titres;

/**
 *
 * @author pierucci
 */
public class TitreGraph extends ApplicationFrame {

    XYDataset dataset = createDataset();
    JFreeChart chart = createChart(dataset);
    public ChartPanel chartPanel = new ChartPanel(chart);
    Marche marche;
    String titreCourant;
    Titres titre;

    public Titres getTitre() {
        return titre;
    }

    public TitreGraph(final String title, Marche marche) {
        super(title);
        this.marche = marche;
        dataset = createDataset();
        chart = createChart(dataset);
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));
        chartPanel.setMouseZoomable(true, false);
        titre = marche.getListeTitres().iterator().next();
        setContentPane(chartPanel);
    }

    private XYDataset createDataset() {
        final TimeSeries series = new TimeSeries("Random Data");
        Second current = new Second();

        return new TimeSeriesCollection(series);
    }

    private JFreeChart createChart(final XYDataset dataset) {
        return ChartFactory.createTimeSeriesChart(
                "",
                "Time",
                "Value (€)",
                dataset,
                false,
                false,
                false);
    }

    public void buildContentPanel() {

    }

    public void changeGraph(String nomTitre) {
        
        //System.out.println("Titre selctionné : " + nomTitre);

        /*final TimeSeries series = new TimeSeries("Random Data");
        Second current = new Second();
        double value = 100.0;

        for (int i = 0; i < 4000; i++) {

            try {
                value = value + 0.5 - 0.5;
                series.add(current, new Double(value));
                current = (Second) current.next();
            } catch (SeriesException e) {
                System.err.println("Error adding to series");
            }
        }*/

        //chart.getXYPlot().setDataset(new TimeSeriesCollection(series));
        Iterator<Titres> it = marche.getListeTitres().iterator();
        Titres cour = new Actions(0, 0, 0, "ERROR", "ERROR"); 
        while (it.hasNext()) {
            cour = it.next();
            if (cour.getId().equals(nomTitre)) {
                break;
            }
        }
        
        if (cour.getId().equals("ERROR")) {
            
        } else {
            titreCourant = cour.getId();
            titre = cour;
        }
        
        System.out.println("Prix de l'actif : " + cour.getId() + " : " + cour.getValeur());
    }
    
    void update() {
        final TimeSeries series = new TimeSeries("Random Data");
        Second current = new Second();
        double value = 100.0;

        for (int i = 0; i < titre.getHist().size(); i++) {

            try {
                value = titre.getHist().get(i);
                series.add(current, new Double(value));
                current = (Second) current.next();
            } catch (SeriesException e) {
                System.err.println("Error adding to series");
            }
        }

        chart.getXYPlot().setDataset(new TimeSeriesCollection(series));
    }

}
