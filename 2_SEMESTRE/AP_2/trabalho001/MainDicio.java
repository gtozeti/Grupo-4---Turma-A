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

        lista.Adiciona(palavras[0]);        
        lista.Adiciona(palavras[1]);        
        lista.Adiciona(palavras[2]);        
        lista.Adiciona(palavras[3]);        
        lista.Adiciona(palavras[4]);        
        lista.Adiciona(palavras[5]);        
        lista.Adiciona(palavras[6]);        


        lista.Imprimir();
    }
}
