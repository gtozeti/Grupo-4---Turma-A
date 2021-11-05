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

    //Função para validar as informações dos campos
    public static boolean campo(String frase) {
        
        String palavra = frase.strip();
        return (palavra.isBlank() || palavra.isEmpty());
    }
}
