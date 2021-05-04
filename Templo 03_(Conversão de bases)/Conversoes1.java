/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestesProjeto;

import java.util.Scanner;

/**
 *
 * @author Matheus
 */
public class Conversoes1 {

    public static void main(String[] args) {
        // Testes de como convertes bases

        Scanner input = new Scanner(System.in);
        boolean condicao = true;
        int valorConv;
        
        do {
            System.out.println("Fazer conversão - 1\nSair do programa - 2");

            System.out.print("Escolha uma opção: ");
            byte escolhaMenu = input.nextByte();

            switch (escolhaMenu) {
                case 1:
                    System.out.print("Escolha um valor para ser convertido: ");
                    int valor = input.nextInt();

                    System.out.print("Informe a base numérica do valor escolhido: ");
                    byte baseValor = input.nextByte();

                    System.out.print("Informe a base numérca para qual o valor deverá ser convertido: ");
                    byte baseConv = input.nextByte();

                    switch (baseValor) {
                        case 2:
                            
                        case 8:
                        case 10:
                        case 16:
                        default:
                            System.out.println("Base inválida.\n");
                    }
                    break;
                case 2:
                    System.out.println("Você saiu do programa.");
                    condicao = false;
                    break;
                default:
                    System.err.println("Valor inválido");
            }

        } while (condicao);
    }
}
