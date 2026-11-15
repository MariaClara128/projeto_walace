package ed2.projeto.algoritmosordenacao;

<<<<<<< HEAD
// Ordena o vetor comparando elementos vizinhos.
=======
>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
public class BubbleSort implements IAlgoritmoOrdenacao {

    @Override
    public void ordenarVetor(int[] vetor) {
<<<<<<< HEAD
        boolean houveTroca;
        int limite = vetor.length - 1;

        do {
            houveTroca = false;

            for (int i = 0; i < limite; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    int auxiliar = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = auxiliar;
=======

        boolean houveTroca;
        int tamanho = vetor.length;

        // Continua enquanto acontecer alguma troca
        do {

            houveTroca = false;

            // Compara os numeros vizinhos
            for (int i = 0; i < tamanho - 1; i++) {

                if (vetor[i] > vetor[i + 1]) {

                    // Troca os numeros de posicao
                    int aux = vetor[i];

                    vetor[i] = vetor[i + 1];

                    vetor[i + 1] = aux;

>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
                    houveTroca = true;
                }
            }

<<<<<<< HEAD
            limite--;
        } while (houveTroca && limite > 0);
=======
            // Diminui o tamanho porque o maior ja foi para o final
            tamanho--;

        } while (houveTroca);
>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Bubble Sort";
    }
}
=======

        return "Bubble Sort";
    }
}
>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
