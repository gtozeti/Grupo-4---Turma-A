import java.io.BufferedReader;
import java.io.FileReader;

public class DictSamuel {
	
	public static String dictSamuel [] = new String [1000];
	public static int totalPalavras = 0;

	public static void main(String[] args) throws Exception {
		analiseArquivo("Arquivo.txt");
		System.out.println("\n*** Dicionário ***");
		for (int i = 0; i < totalPalavras; i++) {
			System.out.println(dictSamuel[i]);
		}
		
    }
	
	//Função para ler todas as palavras do arquivo "Arquivo.txt"
	public static void analiseArquivo(String nomeArquivo) throws Exception {
		
	    FileReader arquivo = new FileReader(nomeArquivo);
	    BufferedReader leitor = new BufferedReader(arquivo);
	    
	    String linha;
	    String frase[];
	    	    
        while (true) {
        	linha = leitor.readLine();
            if (linha == null) {
            	break;
            }
        	 
            frase = linha.toLowerCase().split(" ");
            
            for (int i =0; i < frase.length; i++) {
            	if (!frase[i].isEmpty()) {
            		System.out.println(frase[i]);
            		if (totalPalavras == 0) {
            			populaDict(frase[i]);
            		}
            		else {
            			System.out.println(verificaDict(frase[i]));
            			if (!verificaDict(frase[i])) {
            				populaDict(frase[i]);
            			}
            		}
            		
            		
            	}
            }
            
        }
        
        leitor.close();   
	    	  
	  }

	// Função de busca binária para verificar se a palavra já consta no dicionário
	public static boolean verificaDict(String palavra) {
		
		int i = 0;
		int f = totalPalavras - 1;
		int m;
		while (i <= f) {
			m = (i + f) / 2;
			if (palavra == dictSamuel[m]) {
				return true;
			}

			if (palavra.codePointAt(0) < dictSamuel[m].codePointAt(0)) {
				f = m - 1;
			} else {
				i = m + 1;
			}
		}
		return false;
	}

	public static void populaDict(String palavra) {
		
		dictSamuel[totalPalavras] = palavra;
		totalPalavras ++;
		
	}
}
