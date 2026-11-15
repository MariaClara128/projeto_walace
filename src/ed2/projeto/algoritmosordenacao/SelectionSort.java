package ed2.projeto.algoritmosordenacao;

// Encontra o menor elemento e coloca na proxima posicao do vetor.
public class SelectionSort implements IAlgoritmoOrdenacao {

    @Override
    public void ordenarVetor(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            if (indiceMenor != i) {
                int auxiliar = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = auxiliar;
            }
        }
    }

    @Override
    public String toString() {
        return "Selection Sort";
    }
}
