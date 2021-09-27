import java.io.BufferedReader;
import java.io.FileReader;

public class LeitorDicio {
    String linha;
    String[] palavras;

    public void LerArquivo(String nomeArquivo) throws Exception {
        FileReader arquivo = new FileReader(nomeArquivo);
        BufferedReader leitor = new BufferedReader(arquivo);

        linha = leitor.readLine();
        leitor.close();
    }

    public String[] SeparaPalavras() throws Exception {
        palavras = linha.split(" ");

        return palavras;
    }
}
