package ed2.projeto.algoritmosordenacao;

<<<<<<< HEAD
// Ordena o vetor inserindo cada elemento na posicao correta.
=======
>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
public class InsertionSort implements IAlgoritmoOrdenacao {

    @Override
    public void ordenarVetor(int[] vetor) {
<<<<<<< HEAD
        for (int i = 1; i < vetor.length; i++) {
            int valor = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] > valor) {
                vetor[j + 1] = vetor[j];
                j--;
            }

            vetor[j + 1] = valor;
=======

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
>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
        }
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Insertion Sort";
    }
}
=======

        return "Insertion Sort";
    }
}
>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
