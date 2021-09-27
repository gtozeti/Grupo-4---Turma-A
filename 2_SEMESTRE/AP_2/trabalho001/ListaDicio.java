
public class ListaDicio {
    String[] lista;
    String[] aux;

    public void Adiciona(String palavra) {
        aux = lista;

        
        lista = new String[aux.length + 1];

        lista[0] = palavra;

        for (int i = 0; i < aux.length; i++) {
            lista[i + 1] = aux[i];
        }

    }

    public void IniciaLista() {
        lista = new String[0];
        aux = new String[lista.length];
    }

    public void Imprimir() {
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }
    }

    
}
