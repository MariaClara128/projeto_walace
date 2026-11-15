package ed2.projeto.algoritmosordenacao;

public class TesteAlgoritmos {

  private static int totalTestes = 0;

  private static int totalFalhas = 0;

  public static void main(String[] args) {

    IAlgoritmoOrdenacao[] algoritmos = {
      new BubbleSort(),
      new InsertionSort(),
      new SelectionSort(),
      new MergeSort(),
      new QuickSort()
    };

    int[] grandeAleatorio = gerarComNegativos( 20000 );

    String[] nomesCasos = {
      "Vetor vazio",
      "Um elemento",
      "Dois elementos invertidos",
      "Pequeno aleatorio",
      "Numeros repetidos",
      "Todos iguais",
      "Numeros negativos",
      "Ja ordenado",
      "Ordem inversa",
      "Arquivo dados/numeros.txt",
      "Arquivo dados/repetidos.txt",
      "Arquivo dados/negativos.txt",
      "Arquivo dados/ordenado.txt",
      "Arquivo dados/ordem_inversa.txt",
      "Arquivo dados/todos_iguais.txt",
      "Arquivo dados/quase_ordenado.txt",
      "Arquivo dados/grande_1000.txt",
      "Arquivo dados/grande_10000.txt",
      "Grande aleatorio (20000, com negativos)"
    };

    int[][] casos = {
      {},
      { 42 },
      { 2, 1 },
      { 45, 12, 89, 3, 27, 8, 64 },
      { 5, 3, 5, 1, 3, 5, 1, 1 },
      { 7, 7, 7, 7, 7, 7 },
      { -3, 10, -50, 0, -1, 25, -50 },
      { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
      { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 },
      Utils.lerArquivo("dados/numeros.txt"),
      Utils.lerArquivo("dados/repetidos.txt"),
      Utils.lerArquivo("dados/negativos.txt"),
      Utils.lerArquivo("dados/ordenado.txt"),
      Utils.lerArquivo("dados/ordem_inversa.txt"),
      Utils.lerArquivo("dados/todos_iguais.txt"),
      Utils.lerArquivo("dados/quase_ordenado.txt"),
      Utils.lerArquivo("dados/grande_1000.txt"),
      Utils.lerArquivo("dados/grande_10000.txt"),
      grandeAleatorio
    };

    for(int c = 0; c < casos.length; c++) {

      if( casos[c] == null ) {

        System.out.println("[AVISO] " + nomesCasos[c] + ": arquivo nao encontrado (rode a partir da raiz do projeto).");

        continue;

      }

      int[] esperado = Utils.copiarVetor( casos[c] );

      java.util.Arrays.sort( esperado );

      for(int a = 0; a < algoritmos.length; a++) {

        int[] copia = Utils.copiarVetor( casos[c] );

        algoritmos[a].ordenarVetor( copia );

        verificar( algoritmos[a] + " - " + nomesCasos[c], copia, esperado );

      } // FOR ALGORITMOS

    } // FOR CASOS

    System.out.println("\n" + ( totalTestes - totalFalhas ) + " de " + totalTestes + " testes passaram.");

    if( totalFalhas > 0 ) {

      System.exit(1);

    }

  }

  private static void verificar(String descricao, int[] obtido, int[] esperado) {

    totalTestes++;

    boolean igual = obtido.length == esperado.length;

    for(int i = 0; igual && i < obtido.length; i++) {

      if( obtido[i] != esperado[i] ) {

        igual = false;

      }

    } // FOR ELEMENTOS VETOR

    if( igual ) {

      System.out.println("[OK]    " + descricao);

    } else {

      totalFalhas++;

      System.out.println("[FALHA] " + descricao);

    }

  }

  private static int[] gerarComNegativos(int tamanho) {

    int[] vetor = Utils.gerarVetor( tamanho, 2000 );

    for(int i = 0; i < vetor.length; i++) {

      vetor[i] = vetor[i] - 1000;

    } // FOR ELEMENTOS VETOR

    return vetor;

  }

}