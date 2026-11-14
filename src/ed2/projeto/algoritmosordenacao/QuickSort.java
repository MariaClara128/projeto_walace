package ed2.projeto.algoritmosordenacao;

public class QuickSort implements IAlgoritmoOrdenacao {

    @Override
    public void ordenarVetor(int[] vetor) {

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
        }
    }

    @Override
    public String toString() {

        return "Quick Sort";
    }
}