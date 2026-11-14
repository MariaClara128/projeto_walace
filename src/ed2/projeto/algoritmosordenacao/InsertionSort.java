package ed2.projeto.algoritmosordenacao;

public class InsertionSort implements IAlgoritmoOrdenacao {

    @Override
    public void ordenarVetor(int[] vetor) {

        // Comeca pelo segundo elemento
        for (int i = 1; i < vetor.length; i++) {

            int aux = vetor[i];

            int j = i - 1;

            // Move os numeros maiores uma posicao para frente
            while (j >= 0 && vetor[j] > aux) {

                vetor[j + 1] = vetor[j];

                j--;
            }

            // Coloca o numero na posicao correta
            vetor[j + 1] = aux;
        }
    }

    @Override
    public String toString() {

        return "Insertion Sort";
    }
}