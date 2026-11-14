package ed2.projeto.algoritmosordenacao;

public class SelectionSort implements IAlgoritmoOrdenacao {

    @Override
    public void ordenarVetor(int[] vetor) {

        // Percorre o vetor procurando o menor numero
        for (int i = 0; i < vetor.length; i++) {

            int indiceMenor = i;

            // Procura o menor elemento da parte restante
            for (int j = i + 1; j < vetor.length; j++) {

                if (vetor[j] < vetor[indiceMenor]) {

                    indiceMenor = j;
                }
            }

            // Troca o menor numero com a posicao atual
            if (indiceMenor != i) {

                int aux = vetor[i];

                vetor[i] = vetor[indiceMenor];

                vetor[indiceMenor] = aux;
            }
        }
    }

    @Override
    public String toString() {

        return "Selection Sort";
    }
}