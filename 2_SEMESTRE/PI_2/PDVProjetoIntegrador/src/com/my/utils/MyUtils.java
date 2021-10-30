/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.utils;

/**
 *
 * @author Matheus
 */
public class MyUtils {
    public static String corta(String s, int inicio, int fim) {
        String[] aux = s.split("");

        s = "";

        for (int i = inicio; i <= fim; i++) {
            s += aux[i];
        }

        return s;
    }
}
