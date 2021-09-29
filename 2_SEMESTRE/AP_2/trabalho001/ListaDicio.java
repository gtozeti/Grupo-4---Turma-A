
public class ListaDicio {
    String[] lista;
    String[] aux;

    private void Adiciona(String palavra) {

        palavra = TrataPalavra(palavra);

        if (lista.length > 1) {
            boolean condicao = BuscaBinaria(palavra);

            if (!condicao) {
                aux = lista;

                lista = new String[aux.length + 1];

                lista[0] = palavra;

                for (int i = 0; i < aux.length; i++) {
                    lista[i + 1] = aux[i];
                }
            }
        } else {
            aux = lista;

            lista = new String[aux.length + 1];

            lista[0] = palavra;

            for (int i = 0; i < aux.length; i++) {
                lista[i + 1] = aux[i];
            }
        }

        OrganizaLista();
    }

    public void AdicionaVetor(String[] vetor) {
        
        for (int i = 0; i < vetor.length; i++) {
            Adiciona(vetor[i]);
        }
    }

    public void IniciaLista() {
        lista = new String[0];
        aux = new String[lista.length];
    }

    public void Imprimir() {
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i].toLowerCase());
        }
        System.out.println("Total palavras = " + (lista.length - 1));
    }

    private boolean BuscaBinaria(String palavra) {
        int min, max, mid;

        min = 0;
        max = lista.length;

        while (min <= max) {
            mid = (min + max) / 2;
            
            if (mid >= lista.length) {
                return false;
            }

            if (palavra.toLowerCase().equals(lista[mid].toLowerCase())) {
                return true;
            } else if (palavra.compareToIgnoreCase(lista[mid]) < 0) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return false;
    }

    private void OrganizaLista() {
        int menorIndex, j;
        String aux;
        j = 0;

        while (j < lista.length) {
            menorIndex = j;

            for (int i = j + 1; i < lista.length; i++) {
                if (lista[menorIndex].compareToIgnoreCase(lista[i]) > 0) {
                    menorIndex = i;
                }
            }

            aux = lista[j];
            lista[j] = lista[menorIndex];
            lista[menorIndex] = aux;

            j++;
        }

    }

    private String TrataPalavra(String palavra) {
        if (palavra.endsWith(".")) {
            palavra = palavra.substring(0, palavra.length() - 1);
        }
        if (palavra.endsWith(",")) {
            palavra = palavra.substring(0, palavra.length() - 1);
        }
        if (palavra.endsWith(";")) {
            palavra = palavra.substring(0, palavra.length() - 1);
        }
        if (palavra.endsWith("-")) {
            palavra = palavra.substring(0, palavra.length() - 1);
        }
        if (palavra.endsWith(":")) {
            palavra = palavra.substring(0, palavra.length() - 1);
        }
        if (palavra.endsWith("–")) {
            palavra = palavra.substring(0, palavra.length() - 1);
        }

        return palavra;
    }
}
