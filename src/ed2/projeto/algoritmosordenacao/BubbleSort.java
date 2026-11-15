package ed2.projeto.algoritmosordenacao;

// Ordena o vetor comparando elementos vizinhos.
public class BubbleSort implements IAlgoritmoOrdenacao {

    @Override
    public void ordenarVetor(int[] vetor) {
        boolean houveTroca;
        int limite = vetor.length - 1;

        do {
            houveTroca = false;

            for (int i = 0; i < limite; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    int auxiliar = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = auxiliar;
                    houveTroca = true;
                }
            }

            limite--;
        } while (houveTroca && limite > 0);
    }

    @Override
    public String toString() {
        return "Bubble Sort";
    }
}
