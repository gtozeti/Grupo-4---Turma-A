public class DicioMain {
    public static void main(String[] args) {
        ListaDicio teste = new ListaDicio();
        LeitorDicio leitor = new LeitorDicio();
        String[] lista;

        teste.IniciaLista();

        try {
        leitor.LerArquivo("meuarquivo.txt");

        lista = leitor.SeparaPalavras();
        } catch (Exception e) {
        lista = new String[1];
        lista[0] = "lista vazia";
        }
        
        for (int i = 0; i < lista.length; i++) {
            teste.Adiciona(lista[i]);
        }

        teste.Imprimir();

    }
}
