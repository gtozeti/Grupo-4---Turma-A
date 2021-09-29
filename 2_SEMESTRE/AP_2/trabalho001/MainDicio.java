import java.io.FileReader;
import java.io.BufferedReader;

public class MainDicio {
    public static void main(String[] args) throws Exception {
        FileReader arquivo = new FileReader("meuarquivo.txt");
        BufferedReader leitor = new BufferedReader(arquivo);

        ListaDicio lista = new ListaDicio();
        String[] palavras;
        String linha;
        boolean condicao = true;

        lista.IniciaLista();

        while (condicao) {
            linha = leitor.readLine();

            if (linha == null) {
                break;
            } else {
                palavras = linha.split(" ");
                lista.AdicionaVetor(palavras);
            }
        }

        leitor.close();
        lista.Imprimir();
    }
}
