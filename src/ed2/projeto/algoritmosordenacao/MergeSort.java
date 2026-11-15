package ed2.projeto.algoritmosordenacao;

// Divide o vetor em partes menores e depois intercala as partes ordenadas.
public class MergeSort implements IAlgoritmoOrdenacao {

    @Override
    public void ordenarVetor(int[] vetor) {
        if (vetor.length > 1) {
            int[] auxiliar = new int[vetor.length];
            mergeSort(vetor, auxiliar, 0, vetor.length - 1);
        }
    }

    private void mergeSort(int[] vetor, int[] auxiliar, int inicio, int fim) {
        if (inicio < fim) {
            int meio = inicio + (fim - inicio) / 2;
            mergeSort(vetor, auxiliar, inicio, meio);
            mergeSort(vetor, auxiliar, meio + 1, fim);
            intercala(vetor, auxiliar, inicio, meio, fim);
        }
    }

    private void intercala(int[] vetor, int[] auxiliar, int inicio, int meio, int fim) {
        int i = inicio;
        int j = meio + 1;
        int k = inicio;

        while (i <= meio && j <= fim) {
            if (vetor[i] <= vetor[j]) {
                auxiliar[k] = vetor[i];
                i++;
            } else {
                auxiliar[k] = vetor[j];
                j++;
            }
            k++;
        }

        while (i <= meio) {
            auxiliar[k] = vetor[i];
            i++;
            k++;
        }

        while (j <= fim) {
            auxiliar[k] = vetor[j];
            j++;
            k++;
        }

        for (int posicao = inicio; posicao <= fim; posicao++) {
            vetor[posicao] = auxiliar[posicao];
        }
    }

    @Override
    public String toString() {
        return "Merge Sort";
    }
}
