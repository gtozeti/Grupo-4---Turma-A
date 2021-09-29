import java.io.FileReader;
import java.io.BufferedReader;

public class teste003 {
    public static void main(String[] args) throws Exception {
        String line;

        for (int i = 0; i < 3; i++) {
            line = lerLinha("meuarquivo.txt");
            System.out.println(line);
        }

    }

    public static String lerLinha(String nomeArquivo) throws Exception{
        FileReader arquivo = new FileReader(nomeArquivo);
        BufferedReader leitor = new BufferedReader(arquivo);

        String linha;

        linha = leitor.readLine();
        leitor.close();

        return linha;
    }

}
