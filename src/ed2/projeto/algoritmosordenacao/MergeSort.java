package ed2.projeto.algoritmosordenacao;

<<<<<<< HEAD
// Divide o vetor em partes menores e depois intercala as partes ordenadas.
=======
>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
public class MergeSort implements IAlgoritmoOrdenacao {

    @Override
    public void ordenarVetor(int[] vetor) {
<<<<<<< HEAD
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
=======

        // Cria um vetor auxiliar para ajudar na ordenacao
        int[] auxiliar = new int[vetor.length];

        dividir(vetor, auxiliar, 0, vetor.length - 1);
    }

    // Divide o vetor em partes menores
    private void dividir(int[] vetor, int[] auxiliar, int inicio, int fim) {

        if (inicio < fim) {

            int meio = (inicio + fim) / 2;

            // Divide a primeira metade
            dividir(vetor, auxiliar, inicio, meio);

            // Divide a segunda metade
            dividir(vetor, auxiliar, meio + 1, fim);

            // Junta as partes em ordem
            intercalar(vetor, auxiliar, inicio, meio, fim);
        }
    }

    // Junta os elementos das duas partes
    private void intercalar(int[] vetor, int[] auxiliar, int inicio, int meio, int fim) {

>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
        int i = inicio;
        int j = meio + 1;
        int k = inicio;

<<<<<<< HEAD
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
=======
        // Compara os elementos das duas partes
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

        // Copia os elementos que sobraram da primeira parte
        while (i <= meio) {

            auxiliar[k] = vetor[i];

>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
            i++;
            k++;
        }

<<<<<<< HEAD
        while (j <= fim) {
            auxiliar[k] = vetor[j];
=======
        // Copia os elementos que sobraram da segunda parte
        while (j <= fim) {

            auxiliar[k] = vetor[j];

>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
            j++;
            k++;
        }

<<<<<<< HEAD
        for (int posicao = inicio; posicao <= fim; posicao++) {
=======
        // Devolve os elementos ordenados para o vetor original
        for (int posicao = inicio; posicao <= fim; posicao++) {

>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
            vetor[posicao] = auxiliar[posicao];
        }
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Merge Sort";
    }
}
=======

        return "Merge Sort";
    }
}
>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
