public class teste001 {
    // busca binária com Strings

    public static void main(String[] args) {
        String[] vetor = { "Matheus", "Gustavo", "Arthur", "Isabella", "Fabiane", "Vitoria", "Joao", "Maria" };
        String palavra = "Kleber";

        vetor = OrganizaVetor(vetor);
        imprimir(vetor);
        int index = BinarySearch(vetor, palavra);

        System.out.println("Palavra está no Index = " + index);
    }

    public static int BinarySearch(String[] vetor, String palavra) {
        int min, max, mid;

        min = 0;
        max = vetor.length;

        while (min <= max) {
            mid = (min + max) / 2;

            if (palavra.equals(vetor[mid])) {
                return mid;
            } else if (palavra.compareToIgnoreCase(vetor[mid]) < 0) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return -1;
    }

    public static String[] OrganizaVetor(String[] vetor) {
        
        int menorIndex, j;
        String aux;
        j = 0;

        while (j < vetor.length) {
            menorIndex = j;
            
            for (int i = j + 1; i < vetor.length; i++) {
                if(vetor[menorIndex].compareToIgnoreCase(vetor[i]) > 0) {
                    menorIndex = i;
                }
            }

            aux = vetor[j];
            vetor[j] = vetor[menorIndex];
            vetor[menorIndex] = aux;

            j++;
        }

        return vetor;
    }

    public static void imprimir (String[] vetor) {
        for (String i : vetor) {
            System.out.println(i);
        }
        System.out.println();
    }
}
