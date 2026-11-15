package ed2.projeto.algoritmosordenacao;

public class MedicaoTempos {

    public static void main(String[] args) {

        int[] tamanhos = {10, 100, 1000, 10000, 100000};

        IAlgoritmoOrdenacao[] algoritmos = {
            new BubbleSort(),
            new InsertionSort(),
            new SelectionSort(),
            new MergeSort(),
            new QuickSort()
        };

        aquecer(algoritmos);

        System.out.println("TEMPOS MEDIDOS (media das execucoes, em ms)");
        System.out.println("Repeticoes: 5 para ate 10.000 elementos e 2 para 100.000.");

        System.out.printf("%-15s", "Algoritmo");

        for (int tamanho : tamanhos) {
            System.out.printf("%15s", "n=" + tamanho);
        }

        System.out.println();

        for (int a = 0; a < algoritmos.length; a++) {

            System.out.printf("%-15s", algoritmos[a]);

            for (int tamanho : tamanhos) {

                int repeticoes = (tamanho == 100000) ? 2 : 5;

                double soma = 0;

                for (int r = 0; r < repeticoes; r++) {

                    int[] vetor = Utils.gerarVetor(
                        tamanho, 1000000
                    );

                    long inicio = System.nanoTime();

                    algoritmos[a].ordenarVetor(vetor);

                    long fim = System.nanoTime();

                    soma += (fim - inicio) / 1000000.0;
                }

                double media = soma / repeticoes;

                System.out.printf("%15.4f", media);
            }

            System.out.println();
        }
    }

    private static void aquecer(IAlgoritmoOrdenacao[] algoritmos) {

        for (int i = 0; i < 3; i++) {

            for (int a = 0; a < algoritmos.length; a++) {

                int[] vetor = Utils.gerarVetor(200, 1000000);

                algoritmos[a].ordenarVetor(vetor);
            }
        }
    }
}
