import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.Random;

class O_JogoTest {

	public static Random random = new Random();

	// VALIDAR SE - O VALOR QUE RETORNA DO DANO DO DADO, NÃO AUMENTE A VIDA!

	@Test
	public void testDanoRespostaErrada() {

		int teste = O_Jogo.DanoRespostaErrada(100);

		assertTrue(teste <= 100);

	}

	// VALIDAR SE - INDEPENDENTE DO VALOR DA VIDA E NÃO ESTIVER COM POTION, NÃO
	// VÁ AUMENTAR A VIDA E RETORNA O MESMO VALOR!

	@Test
	public void testUsePotion1() {

		int vida = (random.nextInt(100) + 1);

		int teste[] = O_Jogo.UsePotion(vida, 0);

		assertTrue(teste[0] == vida && teste[1] == 0);

	}

	// VALIDAR SE - INDEPENDENTE DO VALOR DA VIDA E ESTIVER COM POTION, VÁ
	// AUMENTAR A VIDA E DIMINUIR A POTION!

	@Test
	public void testUsePotion2() {

		int vida = (random.nextInt(100) + 1);
		int potion = (random.nextInt(3) + 1);

		int teste[] = O_Jogo.UsePotion(vida, potion);

		assertTrue(teste[0] > vida && teste[1] < potion);

	}

	// VALIDAR SE - INDEPENDENTE DO VALOR DA VIDA E ESTIVER COM POTION, E EU NÃO
	// USAR NÃO VÁ AUMENTAR A VIDA E NEM DIMINUIR A POTION!

	@Test
	public void testUsePotion3() {

		int vida = (random.nextInt(100) + 1);
		int potion = (random.nextInt(3) + 1);

		int teste[] = O_Jogo.UsePotion(vida, potion);

		assertTrue(teste[0] == vida && teste[1] == potion);

	}

	// VALIDAR SE - O NÚMERO DA BASE VAI SER 2 OU 8 OU 10 OU 16

	@Test
	public void testDeterminaBase_Templo3() {

		boolean cond = false;
		int valor = O_Jogo.DeterminaBase_Templo3();

		if (valor == 2 || valor == 8 || valor == 10 || valor == 16) {
			cond = true;
		}

		assertTrue(cond);
	}

	// VALIDAR SE - AS MENSAGENS DE EXIBIÇÃO ESTÃO DE ACORDO
	@Test
	public void testMensagens() {

		O_Jogo.Instruções();
		O_Jogo.Créditos();
		O_Jogo.Hist_1();
		O_Jogo.Texto_Formatado("TESTE");
		O_Jogo.Dialogo("TESTE", O_Jogo.BLUE);
		O_Jogo.Vitoria_Frase();
		O_Jogo.Derrota_Frase();
		O_Jogo.AcertouResposta(20);
		O_Jogo.AcertouResposta(40);
		O_Jogo.GameOver();

	}

	// VALIDAR SE - AS INPUTS DE EXIBIÇÃO ESTÃO DE ACORDO
	@Test
	public void testInput() {

		O_Jogo.Option();
		O_Jogo.Sair();

	}

	/*
	 * 
	 * // VALIDAR SE - O TEMPLO 3 ESTÁ DE ACORDO
	 * 
	 * @Test public void testExecutaTemplo3() {
	 * 
	 * O_Jogo.ExecutaTemplo3(O_Jogo.status);
	 * 
	 * }
	 * 
	 * // VALIDAR SE - O TEMPLO 2 ESTÁ DE ACORDO
	 * 
	 * @Test public void testExecutaTemplo2() {
	 * 
	 * O_Jogo.ExecutaTemplo2();
	 * 
	 * }
	 * 
	 * // VALIDAR SE - O TEMPLO 1 ESTÁ DE ACORDO
	 * 
	 * @Test public void testExecutaTemplo1() {
	 * 
	 * O_Jogo.ExecutaTemplo1();
	 * 
	 * }
	 */
}
