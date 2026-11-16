package ed2.projeto.algoritmosordenacao;

// Criando a classe responsável por testar os algoritmos de ordenação
public class TesteAlgoritmos {

  // Guarda a quantidade total de testes realizados
  private static int totalTestes = 0;

  // Guarda a quantidade de testes que falharam
  private static int totalFalhas = 0;

  // Função principal do programa
  public static void main(String[] args) {

    // Cria uma lista com os cinco algoritmos que serão testados
    IAlgoritmoOrdenacao[] algoritmos = {
      new BubbleSort(),
      new InsertionSort(),
      new SelectionSort(),
      new MergeSort(),
      new QuickSort()
    };

    // Gera um vetor grande com números positivos e negativos
    int[] grandeAleatorio = gerarComNegativos( 20000 );

    // Guarda os nomes dos casos que serão testados
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

    // Cria os vetores que serão usados em cada teste
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

      // Lê os números dos arquivos para usar nos testes
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

    // Adiciona o vetor grande gerado anteriormente
    for(int c = 0; c < casos.length; c++) {

      // Verifica se algum arquivo não foi encontrado
      if( casos[c] == null ) {

        // Mostra um aviso informando que o arquivo não foi encontrado
        System.out.println("[AVISO] " + nomesCasos[c] + ": arquivo nao encontrado (rode a partir da raiz do projeto).");

        // Pula esse caso e continua os próximos testes
        continue;

      }

      // Cria uma cópia do vetor original para guardar o resultado esperado
      int[] esperado = Utils.copiarVetor( casos[c] );

      // Usa o método do Java para ordenar a cópia e definir o resultado correto
      java.util.Arrays.sort( esperado );

      // Percorre todos os algoritmos de ordenação
      for(int a = 0; a < algoritmos.length; a++) {

        // Cria uma cópia do vetor original para cada algoritmo
        int[] copia = Utils.copiarVetor( casos[c] );

        // Executa o algoritmo para organizar os números da cópia
        algoritmos[a].ordenarVetor( copia );

        // Compara o resultado obtido com o resultado esperado
        verificar( algoritmos[a] + " - " + nomesCasos[c], copia, esperado );

      } // Fim do FOR ALGORITMOS

    } // Fim do FOR CASOS

    // Mostra quantos testes passaram e quantos foram realizados
    System.out.println("\n" + ( totalTestes - totalFalhas ) + " de " + totalTestes + " testes passaram.");

    // Verifica se aconteceu alguma falha
    if( totalFalhas > 0 ) {

      // Encerra o programa indicando que houve algum erro
      System.exit(1);

    }

  }

  // Função que verifica se o resultado obtido está correto
  private static void verificar(String descricao, int[] obtido, int[] esperado) {

    // Aumenta a quantidade total de testes
    totalTestes++;

    // Verifica se os dois vetores possuem o mesmo tamanho
    boolean igual = obtido.length == esperado.length;

    // Percorre os vetores para comparar os números de cada posição
    for(int i = 0; igual && i < obtido.length; i++) {

      // Verifica se os números das posições são diferentes
      if( obtido[i] != esperado[i] ) {

        // Indica que os resultados são diferentes
        igual = false;

      }

    } // Fim do FOR ELEMENTOS VETOR

    // Verifica se o resultado obtido está correto
    if( igual ) {

      // Mostra que o teste passou
      System.out.println("[OK]    " + descricao);

    } else {

      // Aumenta a quantidade de testes que falharam
      totalFalhas++;

      // Mostra que o teste apresentou uma falha
      System.out.println("[FALHA] " + descricao);

    }

  }

  // Função que gera um vetor com números positivos e negativos
  private static int[] gerarComNegativos(int tamanho) {

    // Gera um vetor com números aleatórios
    int[] vetor = Utils.gerarVetor( tamanho, 2000 );

    // Percorre o vetor para transformar parte dos números em negativos
    for(int i = 0; i < vetor.length; i++) {

      // Subtrai 1000 de cada número
      vetor[i] = vetor[i] - 1000;

    } // Fim do FOR ELEMENTOS VETOR

    // Retorna o vetor gerado
    return vetor;

  }

}
