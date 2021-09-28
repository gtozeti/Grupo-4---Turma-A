import java.io.BufferedReader;
import java.io.FileReader;

public class LeitorDicio {
    String linha;
    String[] palavras;

    public String[] LerArquivo(String nomeArquivo) throws Exception {
        FileReader arquivo = new FileReader(nomeArquivo);
        BufferedReader leitor = new BufferedReader(arquivo);

        linha = leitor.readLine();
        leitor.close();
        
        palavras = linha.toUpperCase().split(" ");
        return palavras;
    }
}
