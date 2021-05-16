import java.util.Scanner;

public class O_Jogo {

	public static Scanner entrada = new Scanner(System.in);
	public static String opcao = "";
	public static int dificuldade = 0;
	public static String nomeJogador = "";

	// -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-MAIN-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
	public static void main(String[] args) {

		boolean cond = true;

		do {

			System.out.print("\t\t\t\t\t\t\t\t---Menu---\n");
			System.out.println("\n\t\t\t1 - Intruções\t\t\t\t\t\t\t2 - Jogar");
			System.out.println("\t\t\t3 - Créditos\t\t\t\t\t\t\t4 - Sair\n");
			String opcao_Menu = Option();

			switch (opcao_Menu) {

			case "1":
				Instruções();
				break;

			case "2":

				Jogar();
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
				System.out.println("\nOpção não é válida!\n");

			}

		} while (cond);

	}

	// -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-JOGO-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

	// PROCEDIMENTO PARA ARMAZENAR AS INFORMAÇÕES DAS INTRUÇÕES
	public static void Instruções() {

		Texto_Formatado("\nO objetivo do jogo é auxiliar o jogador em alguns conhecimentos da matemática."
				+ " Ao longo da jornada, serão apresentados conteúdos sobre a matéria em questão e "
				+ "apresentadas perguntas ao jogador. O mesmo deverá selecionar as opções válidas para que ele possa"
				+ " avançar no jogo e a cada questão, o jogador sofrerá um dano se errar, diminuindo assim sua vida."
				+ " O objetivo final do jogador, é avançar por todos os templos para derrotar o último chefe, sem perder toda a sua vida");

		Sair();

	}

	// PROCEDIMENTO PARA FAZER A 1º CHAMADA DO JOGO, PARA COLETAR AS INFORMAÇÕES DO NOME DO JOGADOR, MAIS A DIFICULDADE DO JOGO
	public static void Jogar() {

		Texto_Formatado(
				"\n\t\t\t\t\t\t---Escolha a sua dificuldade de jogo---\n\n\t\t1 - Fácil\t\t\t\t\t2 - Normal\t\t\t\t\t3 - Difícil");

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
				System.out.println("Opção não é válida!\n");

			}
		} while (cond);
		
		Texto_Formatado("\n\t\t\t\t\t\t---Escolha o nome do seu jogador---");
	 	nomeJogador = Option();
		
		 boolean cond2 = true;
		 do { 
			 	
				System.out.print("\n\t\t\t\t\tVocê deseja que o nome do seu jogador seja " + nomeJogador + " ? (S/N)");
				String opcao_Menu = Option();
 			 
				switch (opcao_Menu.toUpperCase())
			 {
			 	case "S": 
			 		cond2 = false;
			 		break;
		 		case "N":
		 			Texto_Formatado("\n\t\t\t\t\t\t---Escolha o nome do seu jogador---");
		 		 	nomeJogador = Option();
		 			break;
	 			default:
	 				System.out.println("\nOpção não é válida!\n");
	 				}
			 }while(cond2);
		
		
	}

	// PROCEDIMENTO PARA ARMAZENAR AS INFORMAÇÕES DOS CRÉDITOS
	public static void Créditos() {

		Texto_Formatado("\n-Caio Gonçalves\n\t-Gustavo Tozeti\n\t\t-Matheus Cavalcanti\n\t\t\t-Renan Kesper");
		Sair();

	}

	// -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-FERRAMENTAS-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

	// PROCEDIMENTO CRIADO PARA FORMATAR QUALQUER TEXTO, PARA PADRONIZAR O LAYOUT DA
	// MENSAGEM COM BASE EM UM VALOR PRÉ DETERMINADO
	public static void Texto_Formatado(String frase) {

		String texto = frase;
		StringBuilder novoTexto = new StringBuilder();

		String[] palavras = texto.split(" ");

		int contadorQntLetras = 0;
		int limiteLinha = 140;

		for (String palavra : palavras) {

			if (contadorQntLetras + palavra.length() >= limiteLinha) {
				contadorQntLetras = 0;
				novoTexto.append('\n');
			}

			novoTexto.append(palavra);
			novoTexto.append(' ');
			contadorQntLetras += palavra.length() + 1;
		}
		System.out.println("\n");
		for (int i = 0; i < limiteLinha; i++) {
			System.out.print("=");
		}

		System.out.print("\n" + novoTexto + "\n\n");

		for (int i = 0; i < limiteLinha; i++) {
			System.out.print("=");
		}
		

	}

	// FUNÇÃO CRIADA PARA RETONAR UMA OPÇÃO DESEJADA DO USUÁRIO
	public static String Option() {
		System.out.print("\n***Digite sua opção: ");
		opcao = entrada.next();
		return opcao;
	}

	// PROCEDIMENTO CRIADO PARA VALIDAR  SIM OU NÃO DE UMA PERGUNTA
	 public static void Option_S_N (){
		
		 }
	 

	// PROCEDIMENTO CRIADO PARA SAIR DE UMA OPÇÃO DE UM MENU
	public static void Sair() {
		System.out.print("\nPressione qualquer tecla para voltar!");
		String sair = entrada.next();
	}
	// -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-TEMPLOS-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_

}
