/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste_Templo1;

import static TestesProjeto.Templo3_Completo.GREEN;
import static TestesProjeto.Templo3_Completo.RED;
import static TestesProjeto.Templo3_Completo.RESET;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 *
 * @author Matheus
 */
import java.util.Scanner;
public class Teste3 {

    public static void main(String[] args) {
        int[] status = {100, 2}; // {Health Points, Quantidade de Potions}
        
        ExecutaTemplo1(status);
    }
    
    //Area de funcoes para o Templo 1
    
    static int[] ExecutaTemplo1(int[] status) {
        Scanner sc = new Scanner(System.in);
        boolean condicao = true;

        do {
            status = Desafio1_Templo1(status);
            if (status[0] > 0) {
                System.out.println("\nVocê concluiu o primeiro desafio!");
                Timer2();
                System.out.println("Parabéns, você ganhou uma Poção!");
                status[1]++;
                Timer2();
                System.out.println("HP: " + status[0]);
                Timer2();
                System.out.println("Poção: " + status[1]);
                Timer();
                System.out.println(" ");

                condicao = false;
            } else {
                System.out.println("Você terá que refazer o desafio\n");
                status[0] = 100;
            }
        } while (condicao);

        System.out.print("\nAperte ENETER para começar o segundo Deafio");
        sc.nextLine();
        System.out.println(" ");
        return status;
    }
    
    static int[] Desafio1_Templo1(int[] status) {
        //Area para declarar variaveis
        int[] numeroInicial = new int[2];
        String[] opcoes = new String[5];
        
        ArrayList<String> respostaErrada = new ArrayList();
        
        String respostaCerta;
        
        //Area para processos
        numeroInicial = DeterminaNumeroInicial_Templo1(); //Determinando o numero A[0] e numero B[1]
        
        respostaCerta = Integer.toString(-numeroInicial[1] / numeroInicial[0]); //Determinando a resposta certa
        
        respostaErrada.add(respostaCerta); //Adicinando a resposta certa nas opcoes
        
        for (int i = 0; i < 4; i++) {
            respostaErrada.add(DeterminaOpcoesErradas_Templo1(numeroInicial, respostaCerta)); //Gerando respostas erradas para o desafio
        }
        
        Collections.shuffle(respostaErrada); //Deixando de forma aleatoria as opcoes
        Collections.shuffle(respostaErrada);
        
        for (int i = 0; i < opcoes.length; i++) {
            opcoes[i] = respostaErrada.get(i); // Adicionando as opcoes em String para fazer o desafio
        }
        
        System.out.println("***\tWELCOME TO THE FIRST CHALLENGE/t***");
        
        if (numeroInicial[1] > 0) {
            System.out.printf("Faça a seguinte conta:\n\ny = %dx + %d\n\n", numeroInicial[0], numeroInicial[1]);
        } else {
            System.out.printf("Faça a seguinte conta:\n\ny = %dx + (%d)\n\n", numeroInicial[0], numeroInicial[1]);
        }
        
        status = ProcessoAlternativas_Geral(opcoes, status, respostaCerta);
        
        return status;
    }
    
    static int[] Desafio2_Templo1(int[] status) {
        //Area para declarar variaveis
        
        
        //Area para processos
        
        
        return status;
    }

    static int[] DeterminaNumeroInicial_Templo1() {
        //Area para declarar variaveis
        Random dado = new Random();

        double[] numeroInicial = new double[2];
        int[] numeroConv = new int[2];

        //Area para fazer processos
        do {
            do {
                numeroInicial[0] = dado.nextInt(1000);
                numeroInicial[1] = dado.nextInt(10000);
            } while (numeroInicial[1] % numeroInicial[0] != 0);
        } while (numeroInicial[0] < 10);

        for (int i = 0; i < numeroInicial.length; i++) {
            numeroConv[i] = (int) numeroInicial[i];
        }

        return numeroConv;
    }
    
    static String DeterminaOpcoesErradas_Templo1(int[] numeroInicial, String respostaCerta) {
        String respostaErrada;
        int auxiliar = Integer.parseInt(respostaCerta);
        Random dado = new Random();
        
        do {
            auxiliar = auxiliar + dado.nextInt(15) - 4;
            
            respostaErrada = Integer.toString(auxiliar);
            
        } while (respostaErrada.equals(respostaCerta));
        
        
        return respostaErrada;
    }
    
    //Area de funcoes gerais
    
    static int DanoRespostaErrada(int healthPoints) {
        Random dado = new Random();
        int jogada;

        System.out.println("A resposta está...");
        Timer();
        System.out.println("...");
        Timer();
        System.out.println("...");
        Timer();
        System.out.println("Errada :(");
        System.out.println("Agora iremos jogar o dado para saber quanto de dano você irá tomar.");
        System.out.println("O número que caiu no dado é...");
        Timer();
        System.out.println("...");
        Timer();
        System.out.println("...");
        Timer();

        jogada = dado.nextInt(20) + 1;

        System.out.printf("**\t%d\t**\n", jogada);

        if (jogada <= 5) {
            System.out.println("Parece que você deu sorte e se esquivou do dano.");
        } else if (jogada > 5 && jogada <= 15) {
            System.out.println("Você levou 20 de dano");
            healthPoints = healthPoints - 20;
        } else if (jogada > 15) {
            System.out.println("Você tomou dano crítico!");
            healthPoints = healthPoints - 30;
        }
        
        if (healthPoints < 0) {
            do {
                healthPoints++;
            } while (healthPoints < 0);
        }
        
        System.out.printf("Total HP: %d\n\n", healthPoints);
        return healthPoints;
    }

    static void GameOver() {
        System.out.println("Seu HP chegou a 0");

        String game = "G A M E";
        String over = "O V E R";

        FormataTexto2(game);
        FormataTexto2(over);

        System.out.println("\n");
    }

    static int[] UsePotion(int healthPoints, int qntPotions) {

        Scanner input = new Scanner(System.in);
        boolean condicao = true;
        char opcao = 0;
        int[] status = new int[2];

        System.out.printf("HP atual: %d\nQuantidade de potions: %d\n\n", healthPoints, qntPotions);

        do {
            try {
                System.out.println("Você tem certeza que quer usar uma potion?\n" + GREEN + "[S]" + RESET + " ou " + RED + "[N]\n" + RESET);
                System.out.print("Escolha: ");
                opcao = input.next().toUpperCase().charAt(0);
            } catch (Exception e) {
                System.out.println("Caracter invalido.");
            }

            if (qntPotions > 0) {
                switch (opcao) {
                    case 'S':
                        healthPoints = healthPoints + 20;
                        qntPotions--;

                        if (healthPoints > 100) {
                            do {
                                healthPoints--;
                            } while (healthPoints != 100);
                        }
                        System.out.println("Você usou uma potion.");
                        System.out.printf("Quantidade potions: %d\n", qntPotions);
                        System.out.printf("Total HP: %d\n\n", healthPoints);
                        condicao = false;
                        break;
                    case 'N':
                        System.out.println("Você guardou a potion de volta na bolsa\n");
                        condicao = false;
                        break;
                }
            } else {
                System.out.println("Você não tem potions");
                condicao = false;
            }

        } while (condicao);

        status[0] = healthPoints;
        status[1] = qntPotions;

        return status;
    }

    static void AcertouResposta(int healthPoints) {
        System.out.println("A resposta está...");
        Timer();
        System.out.println("...");
        Timer();
        System.out.println("...");
        Timer();
        System.out.println("Certa! :D\n");

        if (healthPoints >= 30 && healthPoints < 65) {
            System.out.println("Parece que foi um desafio para você.");
        }
        if (healthPoints < 30) {
            System.out.println("Foi por pouco que você conseguiu passar!");
        }

    }

    static int[] ProcessoAlternativas_Geral(String[] opcoes, int[] status, String respostaCerta) {
        //Area para declarar variaveis
        Scanner sc = new Scanner(System.in);
        String resposta;
        boolean condicao = true;

        System.out.printf("[ A ] %S\n", opcoes[0]);
        Timer2();
        System.out.printf("[ B ] %S\n", opcoes[1]);
        Timer2();
        System.out.printf("[ C ] %S\n", opcoes[2]);
        Timer2();
        System.out.printf("[ D ] %S\n", opcoes[3]);
        Timer2();
        System.out.printf("[ E ] %S\n\n", opcoes[4]);
        Timer2();
        System.out.println("Resposta certa: " + respostaCerta.toUpperCase());
        Timer2();

        ////////////////////////////////////////////////////////////////////////
        //Area para processo de alternativas
        do {
            System.out.print("Escolha: ");
            resposta = sc.next().toUpperCase();
            if (status[0] <= 0) {
                GameOver();
                condicao = false;
            }

            switch (resposta.charAt(0)) {
                case 'A':
                    if (opcoes[0].equals(respostaCerta)) {
                        AcertouResposta(status[0]);
                        condicao = false;
                    } else {
                        status[0] = DanoRespostaErrada(status[0]);
                        if (status[0] <= 0) {
                            GameOver();
                            condicao = false;
                        }
                    }
                    break;
                case 'B':
                    if (opcoes[1].equals(respostaCerta)) {
                        AcertouResposta(status[0]);
                        condicao = false;
                    } else {
                        status[0] = DanoRespostaErrada(status[0]);
                        if (status[0] <= 0) {
                            GameOver();
                            condicao = false;
                        }
                    }
                    break;

                case 'C':
                    if (opcoes[2].equals(respostaCerta)) {
                        AcertouResposta(status[0]);
                        condicao = false;
                    } else {
                        status[0] = DanoRespostaErrada(status[0]);
                        if (status[0] <= 0) {
                            GameOver();
                            condicao = false;
                        }
                    }
                    break;
                case 'D':
                    if (opcoes[3].equals(respostaCerta)) {
                        AcertouResposta(status[0]);
                        condicao = false;
                    } else {
                        status[0] = DanoRespostaErrada(status[0]);
                        if (status[0] <= 0) {
                            GameOver();
                            condicao = false;
                        }
                    }
                    break;
                case 'E':
                    if (opcoes[4].equals(respostaCerta)) {
                        AcertouResposta(status[0]);
                        condicao = false;
                    } else {
                        status[0] = DanoRespostaErrada(status[0]);
                        if (status[0] <= 0) {
                            GameOver();
                            condicao = false;
                        }
                    }
                    break;
                case 'P':
                    status = UsePotion(status[0], status[1]);
            }
        } while (condicao);

        return status;
    }

    static void FormataTexto1(String frase) {

        String[] palavra = frase.split(" ");

        for (String each : palavra) {
            System.out.print(each + " ");
            Timer2();
        }
    }

    static void FormataTexto2(String frase) {

        String[] palavra = frase.split(" ");

        for (String each : palavra) {
            System.out.print(each);
            Timer2();
        }

        System.out.print(" ");
    }
    
    static void Timer() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
    }

    static void Timer2() {
        try {
            Thread.sleep(300);
        } catch (Exception e) {

        }
    }
}
