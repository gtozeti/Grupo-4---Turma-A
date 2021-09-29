public class MainDicio {
    public static void main(String[] args) {
        LeitorDicio leitor = new LeitorDicio();
        ListaDicio lista = new ListaDicio();
        String[] palavras;
        
        lista.IniciaLista();

        try {
            palavras = leitor.LerArquivo("meuarquivo.txt");
        } catch (Exception e) {
            palavras = new String[1];
            palavras[0] = "Tem nada";
        }
        
        for (int i = 0; i < palavras.length; i++) {
            lista.Adiciona(palavras[i]);
        }

        lista.Imprimir();
    }
}
