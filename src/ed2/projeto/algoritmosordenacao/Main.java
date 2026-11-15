package ed2.projeto.algoritmosordenacao;

public class Main {

  private static final String ARQUIVO_PADRAO = "dados/numeros.txt";

  private static int[] dados;

  public static void main(String[] args) {

    int opcao;

    do {

      System.out.println("\nPROJETO DE ALGORITMOS DE ORDENACAO");
      System.out.println("1 - Digitar numeros");
      System.out.println("2 - Gerar numeros automaticamente");
      System.out.println("3 - Ler numeros de um arquivo .txt");
      System.out.println("4 - Escolher algoritmo e ordenar");
      System.out.println("5 - Comparar o tempo dos algoritmos");
      System.out.println("0 - Sair");

      opcao = lerInteiro("Escolha uma opcao: ");

      switch( opcao ) {

        case 1:
          digitarNumeros();
          break;

        case 2:
          gerarNumeros();
          break;

        case 3:
          lerArquivo();
          break;

        case 4:
          ordenarDados();
          break;

        case 5:
          compararAlgoritmos();
          break;

        case 0:
          System.out.println("Programa encerrado.");
          break;

        default:
          System.out.println("Opcao invalida.");

      } // SWITCH

    } while( opcao != 0 );

  }

  private static String lerLinha() {

    String texto = "";

    int caractere;

    try {

      caractere = System.in.read();

      while( caractere != -1 && caractere != '\n' ) {

        if( caractere != '\r' ) {

          texto = texto + (char) caractere;

        }

        caractere = System.in.read();

      } // WHILE

      if( caractere == -1 && texto.isEmpty() ) {

        System.out.println("\nPrograma encerrado.");

        System.exit(0);

      }

    } catch (java.io.IOException erro) {

      System.out.println("Erro ao ler a entrada.");

      return "";

    }

    return texto.trim();

  }

  private static int lerInteiro(String mensagem) {

    while( true ) {

      System.out.print( mensagem );

      String texto = lerLinha();

      try {

        return Integer.parseInt( texto );

      } catch (NumberFormatException erro) {

        System.out.println("Digite um numero inteiro valido.");

      }

    } // WHILE

  }

  private static void digitarNumeros() {

    int quantidade = lerInteiro("Quantos numeros deseja digitar? ");

    if( quantidade <= 0 ) {

      System.out.println("A quantidade deve ser maior que zero.");

      return;

    }

    dados = new int[quantidade];

    for(int i = 0; i < quantidade; i++) {

      dados[i] = lerInteiro("Digite o numero " + ( i + 1 ) + ": ");

    } // FOR ELEMENTOS VETOR

    System.out.println("Dados cadastrados:");

    Utils.imprimirVetor( dados );

  }

  private static void gerarNumeros() {

    int quantidade = lerInteiro("Quantos numeros deseja gerar? ");

    if( quantidade <= 0 ) {

      System.out.println("A quantidade deve ser maior que zero.");

      return;

    }

    int limite = lerInteiro("Qual o maior valor possivel? ");

    if( limite <= 0 ) {

      System.out.println("O limite deve ser maior que zero.");

      return;

    }

    dados = Utils.gerarVetor( quantidade, limite );

    System.out.println("Vetor gerado:");

    Utils.imprimirVetor( dados );

  }

  private static void lerArquivo() {

    System.out.print("Caminho do arquivo (ENTER para " + ARQUIVO_PADRAO + "): ");

    String caminho = lerLinha();

    if( caminho.isEmpty() ) {

      caminho = ARQUIVO_PADRAO;

    }

    int[] lidos = Utils.lerArquivo( caminho );

    if( lidos == null ) {

      System.out.println("Nao foi possivel ler o arquivo: " + caminho);

      return;

    }

    if( lidos.length == 0 ) {

      System.out.println("O arquivo nao possui numeros.");

      return;

    }

    dados = lidos;

    System.out.println(dados.length + " numeros lidos do arquivo:");

    Utils.imprimirVetor( dados );

  }

  private static void ordenarDados() {

    if( dados == null || dados.length == 0 ) {

      System.out.println("Primeiro digite, gere ou leia os numeros.");

      return;

    }

    System.out.println("\nESCOLHA O ALGORITMO");
    System.out.println("1 - Bubble Sort");
    System.out.println("2 - Insertion Sort");
    System.out.println("3 - Selection Sort");
    System.out.println("4 - Merge Sort");
    System.out.println("5 - Quick Sort");

    int escolha = lerInteiro("Opcao: ");

    IAlgoritmoOrdenacao algoritmo = criarAlgoritmo( escolha );

    if( algoritmo == null ) {

      System.out.println("Algoritmo invalido.");

      return;

    }

    int[] copia = Utils.copiarVetor( dados );

    System.out.println("Vetor antes da ordenacao:");

    Utils.imprimirVetor( copia );

    long inicio = System.nanoTime();

    algoritmo.ordenarVetor( copia );

    long fim = System.nanoTime();

    System.out.println("Vetor depois da ordenacao:");

    Utils.imprimirVetor( copia );

    System.out.println("Algoritmo: " + algoritmo);
    System.out.println("Tempo: " + ( ( fim - inicio ) / 1000000.0 ) + " ms");
    System.out.println("Resultado correto: " + ( Utils.estaOrdenado( copia ) ? "Sim" : "Nao" ));

  }

  private static IAlgoritmoOrdenacao criarAlgoritmo(int escolha) {

    switch( escolha ) {

      case 1:
        return new BubbleSort();

      case 2:
        return new InsertionSort();

      case 3:
        return new SelectionSort();

      case 4:
        return new MergeSort();

      case 5:
        return new QuickSort();

      default:
        return null;

    } // SWITCH

  }

  private static void compararAlgoritmos() {

    if( dados == null || dados.length == 0 ) {

      System.out.println("Primeiro digite, gere ou leia os numeros.");

      return;

    }

    IAlgoritmoOrdenacao[] algoritmos = {
      new BubbleSort(),
      new InsertionSort(),
      new SelectionSort(),
      new MergeSort(),
      new QuickSort()
    };

    System.out.println("\nCOMPARACAO DOS ALGORITMOS");
    System.out.println("Quantidade de elementos: " + dados.length);
    System.out.printf("%-18s %-18s %-12s%n", "Algoritmo", "Tempo (ms)", "Ordenou?");

    for(int i = 0; i < algoritmos.length; i++) {

      int[] copia = Utils.copiarVetor( dados );

      long inicio = System.nanoTime();

      algoritmos[i].ordenarVetor( copia );

      long fim = System.nanoTime();

      double tempo = ( fim - inicio ) / 1000000.0;

      String resultado = Utils.estaOrdenado( copia ) ? "Sim" : "Nao";

      System.out.printf("%-18s %-18.3f %-12s%n", algoritmos[i], tempo, resultado);

    } // FOR ALGORITMOS

    System.out.println("Os tempos podem variar conforme o computador e a quantidade de dados.");

  }

}
