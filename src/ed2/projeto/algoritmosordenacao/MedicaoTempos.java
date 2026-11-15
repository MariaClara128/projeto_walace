package ed2.projeto.algoritmosordenacao;

public class MedicaoTempos {

  private static final int REPETICOES = 5;

  public static void main(String[] args) {

    int[] tamanhos = { 10, 100, 1000, 10000, 100000 };

    IAlgoritmoOrdenacao[] algoritmos = {
      new BubbleSort(),
      new InsertionSort(),
      new SelectionSort(),
      new MergeSort(),
      new QuickSort()
    };

    aquecer( algoritmos );

    System.out.println("TEMPOS MEDIDOS (media de " + REPETICOES + " execucoes, em ms)");
    System.out.printf("%-15s", "Algoritmo");

    for(int t = 0; t < tamanhos.length; t++) {

      System.out.printf("%15s", "n=" + tamanhos[t]);

    } // FOR TAMANHOS

    System.out.println();

    for(int a = 0; a < algoritmos.length; a++) {

      System.out.printf("%-15s", algoritmos[a]);

      for(int t = 0; t < tamanhos.length; t++) {

        double soma = 0;

        for(int r = 0; r < REPETICOES; r++) {

          int[] vetor = Utils.gerarVetor( tamanhos[t], 1000000 );

          long inicio = System.nanoTime();

          algoritmos[a].ordenarVetor( vetor );

          long fim = System.nanoTime();

          soma = soma + ( fim - inicio ) / 1000000.0;

        } // FOR REPETICOES

        System.out.printf("%15.4f", soma / REPETICOES);

      } // FOR TAMANHOS

      System.out.println();

    } // FOR ALGORITMOS

  }

  private static void aquecer(IAlgoritmoOrdenacao[] algoritmos) {

    for(int i = 0; i < 20; i++) {

      for(int a = 0; a < algoritmos.length; a++) {

        algoritmos[a].ordenarVetor( Utils.gerarVetor( 2000, 1000000 ) );

      } // FOR ALGORITMOS

    } // FOR AQUECIMENTO

  }

}
