package ed2.projeto.algoritmosordenacao;

// Ordena o vetor inserindo cada elemento na posicao correta.
public class InsertionSort implements IAlgoritmoOrdenacao {

    @Override
    public void ordenarVetor(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int valor = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] > valor) {
                vetor[j + 1] = vetor[j];
                j--;
            }

            vetor[j + 1] = valor;
        }
    }

    @Override
    public String toString() {
        return "Insertion Sort";
    }
}
