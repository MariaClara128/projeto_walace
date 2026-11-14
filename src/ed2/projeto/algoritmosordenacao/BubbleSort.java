package ed2.projeto.algoritmosordenacao;

public class BubbleSort implements IAlgoritmoOrdenacao {

    @Override
    public void ordenarVetor(int[] vetor) {

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

                    houveTroca = true;
                }
            }

            // Diminui o tamanho porque o maior ja foi para o final
            tamanho--;

        } while (houveTroca);
    }

    @Override
    public String toString() {

        return "Bubble Sort";
    }
}