import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class O_Jogo {

// -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-VARIAVÉIS GLOBAIS-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
	public static Scanner entrada = new Scanner(System.in);
	public static String opcao = "";
	public static int dificuldade = 0;
	public static String nomeJogador = "";
	public static int thread1 = 1000;
	public static int thread2 = 0;
	public static int thread3 = 50;
	
	
		//CORES DO TEXTO
		public static final String RESET = "\u001B[30m";
		public static final String RED = "\u001B[31m";
		public static final String GREEN = "\u001B[32m";
		public static final String YELLOW = "\u001B[33m";
		public static final String BLUE = "\u001B[34m";
		public static final String MAGENTA = "\u001B[35m";
		public static final String CYAN = "\u001B[36m";
		public static final String WHITE = "\u001B[37m";
	
		//CORES DO FUNDO DO TEXTO
		public static final String RESET_BACKGROUND = "\u001B[0m";
		public static final String BLACK_BACKGROUND = "\u001B[40m";
		public static final String RED_BACKGROUND = "\u001B[41m";
		public static final String GREEN_BACKGROUND = "\u001B[42m";
		public static final String YELLOW_BACKGROUND = "\u001B[43m";
		public static final String BLUE_BACKGROUND = "\u001B[44m";
		public static final String PURPLE_BACKGROUND = "\u001B[45m";
		public static final String CYAN_BACKGROUND = "\u001B[46m";
		public static final String WHITE_BACKGROUND = "\u001B[47m";
			
	
	
// -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-MAIN-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
	public static void main(String[] args) {

		boolean cond = true;
		int[] status = {100, 2}; 

		do {
			

			System.out.print(Tabula1(6,"---Menu---\n\n" ));
			System.out.print(Tabula2(2,"[1] Intruções",6,"[2] Jogar\n"));
			System.out.print(Tabula2(2,"[3] Créditos",6,"[4] Sair\n"));
			
			
			
			String opcao_Menu = Option();

			switch (opcao_Menu) {

			case "1":
				Instruções();
				break;

			case "2":

				Jogar();
				ExecutaTemplo3(status);
				/*
				 * Templo_1(); Templo_2(); Templo_3(); Big_Boss();
				 */
				break;

			case "3":
				Créditos();
				break;

			case "4":

				cond = false;
				break;

			default:
				
				System.out.print(RED + Tabula1(6,"Opção não é válida!\n\n") + RESET);
				
			}

		} while (cond);

	}

// -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-JOGO-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

	// PROCEDIMENTO PARA ARMAZENAR AS INFORMAÇÕES DAS INTRUÇÕES
	public static void Instruções() {

	System.out.print("\n");
	Texto_Formatado("\nO objetivo do jogo é auxiliar o jogador em alguns conhecimentos da matemática."
			+ " Ao longo da jornada, serão apresentados conteúdos sobre a matéria em questão e "
			+ "apresentadas perguntas ao jogador. O mesmo deverá selecionar as opções válidas para que ele possa"
			+ " avançar no jogo e a cada questão, o jogador sofrerá um dano se errar, diminuindo assim sua vida."
			+ " O objetivo final do jogador, é avançar por todos os templos para derrotar o último chefe, sem perder toda a sua vida");
	System.out.print("\n");
	Sair();

}

	// PROCEDIMENTO PARA FAZER A 1º CHAMADA DO JOGO, PARA COLETAR AS INFORMAÇÕES DO NOME DO JOGADOR, MAIS A DIFICULDADE DO JOGO
	public static void Jogar() {

	
	Texto_Formatado(Tabula1(4, "---Escolha a sua dificuldade de jogo---\n\n")+Tabula3(1,"[1] Fácil",3,"[2] Normal",3,"[3] Difícil"));
	
	
	boolean cond = true;

	do {

		String opcao_Menu = Option();
		switch (opcao_Menu) {

		case "1":
			dificuldade = 1;
			cond = false;
			break;

		case "2":
			dificuldade = 2;
			cond = false;
			break;

		case "3":
			dificuldade = 3;
			cond = false;
			break;

		default:
			System.out.print(RED + Tabula1(6,"Opção não é válida!\n\n") + RESET);

		}
	} while (cond);
	
	Texto_Formatado(Tabula1(4,"   ---Escolha o nome do seu jogador---"));
 	nomeJogador = Option();
	
	 boolean cond2 = true;
	 do { 
		 	
		 Texto_Formatado(Tabula1(4,"---Você deseja que o nome do seu jogador seja " +RED+ nomeJogador +RESET+ " ?---\n\n")+Tabula2(4,GREEN+"[S]"+RESET,6,RED+"[N]"+RESET));
			String opcao_Menu = Option();
		 
			switch (opcao_Menu.toUpperCase())
		 {
		 	case "S": 
		 		cond2 = false;
		 		break;
	 		case "N":
	 			Texto_Formatado(Tabula1(4,"---Escolha o nome do seu jogador---"));
	 		 	nomeJogador = Option();
	 			break;
 			default:
 				System.out.print(RED + Tabula1(6,"Opção não é válida!\n\n") + RESET);
 				}
		 }while(cond2);
	
	
}

	// PROCEDIMENTO PARA ARMAZENAR AS INFORMAÇÕES DOS CRÉDITOS
	public static void Créditos() {
	
			System.out.print("\n");
			Texto_Formatado("\n-Gustavo Tozeti\n\t\t-Matheus Cavalcanti\n\t\t\t-Renan Kesper");
			System.out.print("\n");
			Sair();
	
		}

// -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-FERRAMENTAS-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

	// PROCEDIMENTO CRIADO PARA FORMATAR QUALQUER TEXTO, PARA PADRONIZAR O LAYOUT DA
	// MENSAGEM COM BASE EM UM VALOR PRÉ DETERMINADO
	public static void Texto_Formatado(String frase) {

		String texto = frase;
		String[] palavras = texto.split(" ");

		int contadorQntLetras = 0;
		int limiteLinha = 140;

		
		
		for (int i = 0; i < limiteLinha; i++) {
			System.out.print(RED + "=" + RESET);
		}
		System.out.print("\n");
			
		for (String palavra : palavras) {

			if (contadorQntLetras + palavra.length() >= limiteLinha) {
				contadorQntLetras = 0;
				System.out.print("\n");
			}

			System.out.print(palavra + " ");
			Timer2();
			contadorQntLetras += palavra.length() + 1;
		}
		System.out.println("\n");
		 
		for (int i = 0; i < limiteLinha; i++) {
			System.out.print(RED + "=" + RESET);
		}
		

	}

	// PROCEDIMENTO CRIADO PARA TABULAR QUALQUER TEXTO, PARA PADRONIZAR O LAYOUT DA
	// MENSAGEM 
	public static String Tabula1(int t,String s) {
		
		String tab = "\t";
		String frase = "";
		for (int i =0; i <= t; i++) {
			frase += tab;
		}
		frase += s;
		
		return frase;
	}
	
	public static String Tabula2(int t,String s,int tt,String ss) {
		
		String tab = "\t";
		String frase = "";
		
		
		
		for (int i =0; i <= t; i++) {
			frase += tab;
		}
		frase += s;
		for (int i =0; i <= tt; i++) {
			frase += tab;
		}
		frase += ss;
		return frase;
	}
	
	public static String Tabula3(int t,String s,int tt,String ss,int ttt,String sss) {
		
		String tab = "\t";
		String frase = "";
		
		
		
		for (int i =0; i <= t; i++) {
			frase += tab;
		}
		frase += s;
		for (int i =0; i <= tt; i++) {
			frase += tab;
		}
		frase += ss;
		for (int i =0; i <= ttt; i++) {
			frase += tab;
		}
		frase += sss;
		return frase;
	}
	
	// FUNÇÃO CRIADA PARA RETONAR UMA OPÇÃO DESEJADA DO USUÁRIO
	public static String Option() {
		System.out.print(BLACK_BACKGROUND + WHITE + "\n***Digite sua opção:"+ RESET + RESET_BACKGROUND +" ");
		opcao = entrada.next();
		System.out.print("\n");
		return opcao;
	}

	// PROCEDIMENTO CRIADO PARA SAIR DE UMA OPÇÃO DE UM MENU
	public static void Sair() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nPressione a tecla ENTER para voltar!\n");
		sc.nextLine();
		System.out.println(" ");
	}
	
	static int DanoRespostaErrada(int healthPoints) {
	        Random dado = new Random();
	        int jogada;

	        System.out.println("\nA resposta está...");
	        Timer();
	        System.out.println("...");
	        Timer();
	        System.out.println("...");
	        Timer();
	        System.out.println(RED+"Errada :("+RESET);
	        System.out.println("\nAgora iremos jogar o dado para saber quanto de dano você irá tomar.");
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
	            healthPoints = healthPoints - (20 + (5*dificuldade));
	        } else if (jogada > 15) {
	            System.out.println("Você tomou dano crítico!");
	            healthPoints = healthPoints - (30 + (5*dificuldade));
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

    static void Timer() {
	        try {
	            Thread.sleep(thread1);
	        } catch (Exception e) {

	        }
	    }

    static void Timer2() {
	        try {
	            Thread.sleep(thread2);
	        } catch (Exception e) {

	        }
	    }
	    
    static void Timer3() {
        try {
            Thread.sleep(thread3);
        } catch (Exception e) {

        }
    }

    static void AcertouResposta(int healthPoints) {
        System.out.println("\nA resposta está...");
        Timer();
        System.out.println("...");
        Timer();
        System.out.println("...");
        Timer();
        System.out.println(GREEN+"Certa! :D\n"+RESET);

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
        	
            resposta = Option().toUpperCase();
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
	   
	
// -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-TEMPLOS-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

   		//TEMPLO 3
		static int[] ExecutaTemplo3(int[] status) {
    Scanner sc = new Scanner(System.in);
    boolean condicao = true;

    do {
        status = Desafio1_Templo3(status);
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

    System.out.print("\nAperte ENTER para começar o segundo Deafio");
    sc.nextLine();
    System.out.println(" ");

    do {
        status = Desafio2_Templo3(status);
        if (status[0] > 0) {
            System.out.println("\nVocê concluiu o segundo desafio!");
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

    System.out.print("\nAperte ENTER para começar o último Deafio");
    sc.nextLine();
    System.out.println(" ");

    do {
        status = Desafio3_Templo3(status);
        if (status[0] > 0) {
            System.out.println("\nVocê concluiu o último desafio!");
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

    Timer();
    System.out.println("Você conseguiu concluiro o Templo das Conversões");
    Timer2();
    FormataTexto1("Você está preparado para o ");
    FormataTexto2("F I N A L ");
    FormataTexto2("B O S S ");
    FormataTexto2("? ? ?");
    System.out.println("\n");
    return status;
}
			
		//DESAFIO É CONVERTER UM NÚMERO QUE ESTÁ EM UMA BASE PARA OUTRA
		static int[] Desafio1_Templo3(int[] status) { 
    int baseInicial, baseConversao;
    String respostaCerta;

    String[] numeroInicial = new String[1];
    String[] opcoes = new String[5];
    ArrayList<String> respostaErrada = new ArrayList();
    
    ////////////////////////////////////////////////////////////////////////
    //Area para preparar os numeros
    baseInicial = DeterminaBase_Templo3(); //Determinando a base standard

    do {
        baseConversao = DeterminaBase_Templo3(); //Determinando a base de conversao
    } while (baseConversao == baseInicial);

    numeroInicial[0] = DeterminaNumero_Templo3(baseInicial); //Determinando o numero standard

    respostaCerta = DeterminaNumeroConv_Templo3(numeroInicial, baseInicial, baseConversao); // Determinando o numero de conversao (certo)

    respostaErrada.add(respostaCerta); //Adicionando a resposta certa nas opcoes

    for (int i = 0; i < 4; i++) {
        respostaErrada.add(DeterminaOpcoes(baseConversao, respostaCerta)); //Adicionando opcoes erradas 
    }

    Collections.shuffle(respostaErrada); // Embaralhando as opcoes para que haja uma aleatoriedade
    Collections.shuffle(respostaErrada);

    for (int i = 0; i < opcoes.length; i++) {
        opcoes[i] = respostaErrada.get(i); // Transferindo as opcoes do ArrayList para uma String[] 
    }

    ////////////////////////////////////////////////////////////////////////
    //Area de logica do game
    Texto_Formatado(Tabula1(4,"***\tWELCOME TO THE 1ST GAME\t***\n"));
   
    System.out.printf("\nConverta o numero %S que esta na base %d para a base %d\n\n", numeroInicial[0], baseInicial, baseConversao);
    Timer2();

    status = ProcessoAlternativas_Geral(opcoes, status, respostaCerta);

    return status;
}

		//DESAFIO É SOMAR DOIS NÚMEROS QUE ESTÃO EM UMA BASE E CONVERTER PARA OUTRO
		static int[] Desafio2_Templo3(int[] status) { 
    //Area para inicializar variaveis
    int baseInicial, baseConversao;
    String respostaCerta;

    String[] numeroInicial = new String[2];
    String[] opcoes = new String[5];
    ArrayList<String> respostaErrada = new ArrayList();
    ////////////////////////////////////////////////////////////////////////
    //Area para declarar os numeros

    baseInicial = DeterminaBase_Templo3(); //Gerar a base standard

    do {
        baseConversao = DeterminaBase_Templo3(); //Gerar a base para conversao
    } while (baseConversao == baseInicial);

    numeroInicial[0] = DeterminaNumero_Templo3(baseInicial); //Gerar o numero standard A
    numeroInicial[1] = DeterminaNumero_Templo3(baseInicial); //Gerar o numero standard B

    respostaCerta = DeterminaNumeroConv_Templo3(numeroInicial, baseInicial, baseConversao); //Gerar a resposta certa

    respostaErrada.add(respostaCerta); //Adicionando a resposta certa no ArrayList

    for (int i = 0; i <= 3; i++) {
        respostaErrada.add(DeterminaOpcoes(baseConversao, respostaCerta)); //Criando respostas erradas para o ArrayList
    }

    Collections.shuffle(respostaErrada); //Embaralhando as opcoes
    Collections.shuffle(respostaErrada);

    for (int i = 0; i < opcoes.length; i++) {
        opcoes[i] = respostaErrada.get(i); //Adicionando as opcoes embaralhadas numa String para fazer o desafio
    }

    
    Texto_Formatado(Tabula1(4,"***\tWELCOME TO THE 2ND GAME\t***\n"));
    Timer2();
    System.out.printf("\nFaça a seguinte conversão:\n%S + %S (na base %d) = X (na base %d)\n\n", numeroInicial[0], numeroInicial[1], baseInicial, baseConversao);
    Timer2();

    ProcessoAlternativas_Geral(opcoes, status, respostaCerta);

    return status;
}

		static int[] Desafio3_Templo3(int[] status) {
    //Area para declarar variaveis
    int baseInicial, baseConversao, aux;
    String respostaCerta;

    String[] numeroInicial = new String[2];
    String[] opcoes = new String[5];
    ArrayList<String> respostaErrada = new ArrayList();
    ////////////////////////////////////////////////////////////////////////
    //Area para iniciar variaveis
    baseInicial = DeterminaBase_Templo3(); // Gerar a base inicial

    do {
        baseConversao = DeterminaBase_Templo3(); // Gerar a base para conversao
    } while (baseConversao == baseInicial);

    numeroInicial[0] = DeterminaNumero_Templo3(baseInicial); // Gerar numero standard A
    numeroInicial[1] = DeterminaNumero_Templo3(baseInicial); // Gerar numero standard B

    aux = (Integer.parseInt(numeroInicial[0], baseInicial)) * (Integer.parseInt(numeroInicial[1], baseInicial)); // Convertendo o produto dos numeros standard para int

    respostaCerta = Integer.toString(aux, baseConversao); // Convertendo o produto dos numeros standard para a base de conversao

    respostaErrada.add(respostaCerta); // Adicionando a resposta certa nas opcoes

    for (int i = 0; i <= 3; i++) {
        respostaErrada.add(DeterminaOpcoes(baseConversao, respostaCerta)); // Adicionando as opcoes erradas
    }

    Collections.shuffle(respostaErrada); // Embaralhando as opcoes
    Collections.shuffle(respostaErrada);

    for (int i = 0; i < opcoes.length; i++) {
        opcoes[i] = respostaErrada.get(i);// Adicionando as opcoes em String para fazer o desafio
    }

    
    Texto_Formatado(Tabula1(4,"***\tWELCOME TO THE 3ND GAME\t***\n"));
    
    System.out.printf("\nFaça a seguinte conversão:\n%S * %S (na base %d) = X (na base %d)\n\n", numeroInicial[0], numeroInicial[1], baseInicial, baseConversao);
    Timer2();

    ProcessoAlternativas_Geral(opcoes, status, respostaCerta);

    return status;
}
				
				//FUNÇÕES DO TEMPLO 3

				static int DeterminaBase_Templo3() {

    ArrayList<Integer> bases = new ArrayList();

    bases.add(2);
    bases.add(8);
    bases.add(10);
    bases.add(16);

    Collections.shuffle(bases);
    Collections.shuffle(bases);

    return bases.get(0);
}

				static String DeterminaNumero_Templo3(int baseInicial) {

    Random dado = new Random();
    int numRandom;
    String baseAconv = null;

    do {
        numRandom = dado.nextInt(2000);
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

				static String DeterminaOpcoes(int baseConversao, String respostaCerta) {
    Random dado = new Random();
    int aux = Integer.parseInt(respostaCerta, baseConversao);
    String opcoesFalsas;

    do {
        aux = aux + dado.nextInt(30);
        aux = aux - 15;
        opcoesFalsas = Integer.toString(aux, baseConversao);
    } while (opcoesFalsas.equals(respostaCerta));

    return opcoesFalsas;
}

				static String DeterminaNumeroConv_Templo3(String[] numeroInicial, int baseInicial, int baseConversao) {
    int aux = 0;
    String respostaConversao;

    for (int i = 0; i < numeroInicial.length; i++) {
        aux = aux + Integer.parseInt(numeroInicial[i], baseInicial);
    }

    respostaConversao = Integer.toString(aux, baseConversao);

    return respostaConversao;
}


}
