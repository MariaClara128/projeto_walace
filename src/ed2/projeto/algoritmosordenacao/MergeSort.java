package ed2.projeto.algoritmosordenacao;

public class MergeSort implements IAlgoritmoOrdenacao {

    @Override
    public void ordenarVetor(int[] vetor) {

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

        int i = inicio;
        int j = meio + 1;
        int k = inicio;

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

            i++;
            k++;
        }

        // Copia os elementos que sobraram da segunda parte
        while (j <= fim) {

            auxiliar[k] = vetor[j];

            j++;
            k++;
        }

        // Devolve os elementos ordenados para o vetor original
        for (int posicao = inicio; posicao <= fim; posicao++) {

            vetor[posicao] = auxiliar[posicao];
        }
    }

    @Override
    public String toString() {

        return "Merge Sort";
    }
}