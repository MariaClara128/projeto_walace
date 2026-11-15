package ed2.projeto.algoritmosordenacao;

// Ordena usando um pivo para separar os menores e os maiores elementos.
public class QuickSort implements IAlgoritmoOrdenacao {

    @Override
    public void ordenarVetor(int[] vetor) {
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
        }
    }

    @Override
    public String toString() {
        return "Quick Sort";
    }
}
