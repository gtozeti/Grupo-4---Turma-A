/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestesProjeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Matheus
 */
public class Implementacao_Templo {

    public static void main(String[] args) {
        //Aqui correrao apenas tres laçoes do-while para que caso a pessoa não
        //passe em um desafio ela precise fazê-lo novamente
        int healthPoints = 100, qntPotions = 2;

        healthPoints = Desafio1(healthPoints, qntPotions);
        
        System.out.println("Você terminou o primeiro desafio.");
    }

    static int Desafio1(int healthPoints, int qntPotions) {
        System.out.println("Bem-vindo ao primeiro desafio.\n");

        System.out.println("O 'player' precisa passar por este primeiro desafio para"
                + " abrir a porta e conseguir explorar o templo.\n"
                + "Ao se deparar com a porta o 'player' observa que existem alguns"
                + " símbolos em outra linguagem e ele precisa traduzí-los para continuar sua aventura.");

        //**********************************************************************
        int baseInicial, baseConversao, auxNum;
        String numeroInicial, respostaCerta, respostaPlayer;
        boolean condicao = true;

        ArrayList<String> respostaErrada = new ArrayList();
        String[] opcoes = new String[5];

        Scanner input = new Scanner(System.in);

        //Determinando as bases 
        baseInicial = DeterminaBase();

        do {
            baseConversao = DeterminaBase();
        } while (baseConversao == baseInicial);

        //Determinando o numero para a base inicial
        numeroInicial = DeterminaNumero(baseInicial);

        //Determinar o numero para a baseConversao
        respostaCerta = DeterminaNumeroConv(numeroInicial, baseInicial, baseConversao);

        //Fazer processo das perguntas erradas
        respostaErrada.add(respostaCerta);
        auxNum = Integer.parseInt(numeroInicial, baseInicial);
        for (int i = 0; i <= 4; i++) {
            respostaErrada.add(DeterminaOpcoes(auxNum, baseConversao, respostaCerta));
        }

        Collections.shuffle(respostaErrada);
        Collections.shuffle(respostaErrada);
        Collections.shuffle(respostaErrada);

        for (int i = 0; i < 5; i++) {
            opcoes[i] = respostaErrada.get(i);
        }

        //**********************************************************************
        //Fazer processo de desafio com opcoes
        System.out.printf("\n***Texto para começar o primeiro desafio***\nConverter o numero %S que está na base %d para a base %d\n\n", numeroInicial, baseInicial, baseConversao);

        System.out.printf("a) %S\nb) %S\nc) %S\nd) %S\ne) %S\n\n", opcoes[0], opcoes[1], opcoes[2], opcoes[3], opcoes[4]);
        
        System.out.println("Resposta certa: " + respostaCerta);

        do {
            try {
                System.out.print("Escolha uma opção: ");
                respostaPlayer = input.next();
                respostaPlayer = respostaPlayer.toUpperCase();
                System.out.println(" ");
                
                switch (respostaPlayer.charAt(0)) {
                    case 'A':
                        if (opcoes[0].equals(respostaCerta)) {
                            AcertouResposta(healthPoints);
                            condicao = false;
                        } else {
                            healthPoints = DanoRespostaErrada(healthPoints);
                            if (healthPoints <= 0) {
                                GameOver();
                                condicao = false;
                            }
                        }
                        break;
                    case 'B':
                        if (opcoes[1].equals(respostaCerta)) {
                            AcertouResposta(healthPoints);
                            condicao = false;
                        } else {
                            healthPoints = DanoRespostaErrada(healthPoints);
                            if (healthPoints <= 0) {
                                GameOver();
                                condicao = false;
                            }
                        }
                        break;
                    case 'C':
                        if (opcoes[2].equals(respostaCerta)) {
                            AcertouResposta(healthPoints);
                            condicao = false;
                        } else {
                            healthPoints = DanoRespostaErrada(healthPoints);
                            if (healthPoints <= 0) {
                                GameOver();
                                condicao = false;
                            }
                        }
                        break;
                    case 'D':
                        if (opcoes[3].equals(respostaCerta)) {
                            AcertouResposta(healthPoints);
                            condicao = false;
                        } else {
                            healthPoints = DanoRespostaErrada(healthPoints);
                            if (healthPoints <= 0) {
                                GameOver();
                                condicao = false;
                            }
                        }
                        break;
                    case 'E':
                        if (opcoes[4].equals(respostaCerta)) {
                            AcertouResposta(healthPoints);
                            condicao = false;
                        } else {
                            healthPoints = DanoRespostaErrada(healthPoints);
                            if (healthPoints <= 0) {
                                GameOver();
                                condicao = false;
                            }
                        }
                        break;
                    case 'P':
                        healthPoints = UsePotion(healthPoints, qntPotions);
                }
            } catch (Exception e) {
                System.out.println("Digite um caracter válido.\nOu algo deu errado com o codigo");
            }
        } while (condicao);

        return healthPoints;
    }

    //**************************************************************************
    static int DeterminaBase() {

        ArrayList<Integer> bases = new ArrayList();

        bases.add(2);
        bases.add(8);
        bases.add(10);
        bases.add(16);

        Collections.shuffle(bases);
        Collections.shuffle(bases);

        return bases.get(0);
    }

    static String DeterminaNumero(int baseInicial) {

        int numRandom;
        String baseAconv = null;

        do {
            numRandom = (int) (Math.random() * 1000);
        } while (numRandom <= 50);

        switch (baseInicial) {
            case 2:
                baseAconv = Integer.toBinaryString(numRandom);
                break;
            case 8:
                baseAconv = Integer.toOctalString(numRandom);
                break;
            case 10:
                baseAconv = Integer.toString(numRandom);
                break;
            case 16:
                baseAconv = Integer.toHexString(numRandom);
                break;
        }

        return baseAconv;
    }

    static String DeterminaOpcoes(int numeroInicial, int baseConversao, String respostaCerta) {

        String opcoesFalsas;

        do {
            numeroInicial = (int) (numeroInicial + (Math.random() * 50));
            numeroInicial = numeroInicial - 35;
            opcoesFalsas = Integer.toString(numeroInicial, baseConversao);
        } while (opcoesFalsas.equals(respostaCerta));

        return opcoesFalsas;
    }

    static String DeterminaNumeroConv(String numeroInicial, int baseInicial, int baseConversao) {
        int aux;
        String respostaConversao;

        aux = Integer.parseInt(numeroInicial, baseInicial);
        respostaConversao = Integer.toString(aux, baseConversao);

        return respostaConversao;
    }

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
        
        System.out.printf("Total HP: %d\n\n", healthPoints);
        return healthPoints;
    }

    static void GameOver() {
        System.out.println("Seu HP chegou a 0");
        System.out.println("GAME OVER");
    }

    static int UsePotion(int healthPoints, int qntPotions) {

        Scanner input = new Scanner(System.in);
        boolean condicao = true;
        char opcao;

        System.out.printf("HP atual: %d\n", healthPoints);

        do {
            try {
                System.out.println("Você tem certeza que quer usar uma potion?\nS / N\n");
                System.out.print("Escolha: ");
                opcao = input.next().charAt(0);

                switch (opcao) {
                    case 'S':
                    case 's':
                        healthPoints = healthPoints + 20;
                        qntPotions = qntPotions - 1;

                        if (healthPoints > 100) {
                            do {
                                healthPoints--;
                            } while (healthPoints != 100);
                        }
                        System.out.println("Você usou uma potion.");
                        System.out.printf("Quantidade potions: %d", qntPotions);
                        System.out.printf("Total HP: %d\n\n", healthPoints);
                        condicao = false;
                        break;
                    case 'N':
                    case 'n':
                        System.out.println("Você guardou a potion de volta na bolsa\n");
                        condicao = false;
                        break;
                }
            } catch (Exception e) {
                System.err.println("Digite uma opção válida.\n");
            }

        } while (condicao);

        return healthPoints;
    }

    static void Timer() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
    }

    static void AcertouResposta(int healthPoints) {
        System.out.println("A resposta está...");
        Timer();
        System.out.println("...");
        Timer();
        System.out.println("...");
        System.out.println("Certa! :D");
        Timer();
        
        if (healthPoints >= 30 && healthPoints < 65) {
            System.out.println("Parece que foi um desafio para você.");
        }
        if (healthPoints < 30) {
            System.out.println("Foi por pouco que você conseguiu passar!");
        }
        
        
    }
}
