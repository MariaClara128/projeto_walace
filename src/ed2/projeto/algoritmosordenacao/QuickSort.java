package ed2.projeto.algoritmosordenacao;

<<<<<<< HEAD
// Ordena usando um pivo para separar os menores e os maiores elementos.
=======
>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
public class QuickSort implements IAlgoritmoOrdenacao {

    @Override
    public void ordenarVetor(int[] vetor) {
<<<<<<< HEAD
        if (vetor.length > 1) {
            quickSort(vetor, 0, vetor.length - 1);
        }
    }

    private void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = particiona(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
    }

    // Particionamento de Hoare: devolve a divisao entre as duas partes.
    private int particiona(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio + (fim - inicio) / 2];
        int i = inicio - 1;
        int j = fim + 1;

        while (true) {
            do {
                j--;
            } while (vetor[j] > pivo);

            do {
                i++;
            } while (vetor[i] < pivo);

            if (i >= j) {
                return j;
            }

            int auxiliar = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = auxiliar;
=======

        ordenar(vetor, 0, vetor.length - 1);
    }

    // Organiza as partes do vetor
    private void ordenar(int[] vetor, int inicio, int fim) {

        int i = inicio;
        int j = fim;

        // Escolhe o elemento do meio como pivo
        int pivo = vetor[(inicio + fim) / 2];

        while (i <= j) {

            // Procura um numero maior ou igual ao pivo
            while (vetor[i] < pivo) {
                i++;
            }

            // Procura um numero menor ou igual ao pivo
            while (vetor[j] > pivo) {
                j--;
            }

            // Troca os elementos que estao nas posicoes erradas
            if (i <= j) {

                int aux = vetor[i];

                vetor[i] = vetor[j];

                vetor[j] = aux;

                i++;
                j--;
            }
        }

        // Ordena a parte esquerda
        if (inicio < j) {
            ordenar(vetor, inicio, j);
        }

        // Ordena a parte direita
        if (i < fim) {
            ordenar(vetor, i, fim);
>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
        }
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Quick Sort";
    }
}
=======

        return "Quick Sort";
    }
}
>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
