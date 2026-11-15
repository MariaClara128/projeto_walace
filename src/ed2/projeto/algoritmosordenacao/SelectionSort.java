package ed2.projeto.algoritmosordenacao;

<<<<<<< HEAD
// Encontra o menor elemento e coloca na proxima posicao do vetor.
=======
>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
public class SelectionSort implements IAlgoritmoOrdenacao {

    @Override
    public void ordenarVetor(int[] vetor) {
<<<<<<< HEAD
        for (int i = 0; i < vetor.length - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[indiceMenor]) {
=======

        // Percorre o vetor procurando o menor numero
        for (int i = 0; i < vetor.length; i++) {

            int indiceMenor = i;

            // Procura o menor elemento da parte restante
            for (int j = i + 1; j < vetor.length; j++) {

                if (vetor[j] < vetor[indiceMenor]) {

>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
                    indiceMenor = j;
                }
            }

<<<<<<< HEAD
            if (indiceMenor != i) {
                int auxiliar = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = auxiliar;
=======
            // Troca o menor numero com a posicao atual
            if (indiceMenor != i) {

                int aux = vetor[i];

                vetor[i] = vetor[indiceMenor];

                vetor[indiceMenor] = aux;
>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
            }
        }
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Selection Sort";
    }
}
=======

        return "Selection Sort";
    }
}
>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
