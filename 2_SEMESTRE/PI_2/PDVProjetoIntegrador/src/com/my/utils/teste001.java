/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.utils;

import java.time.LocalDate;
import javax.swing.JPanel;

/**
 *
 * @author Matheus
 */
public class teste001 {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now();
        
        JPanel p = GraphUtils.createChartPanel(d.minusDays(30), d);
        
        p.setSize(800, 600);
        p.setVisible(true);
    }
}
