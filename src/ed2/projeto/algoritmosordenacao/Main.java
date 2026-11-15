package ed2.projeto.algoritmosordenacao;

// Criando a classe principal do projeto
public class Main {

  // Caminho padrão do arquivo que contém os números
  private static final String ARQUIVO_PADRAO = "dados/numeros.txt";

  // Variável que guarda os números utilizados no programa
  private static int[] dados;

  // Função principal, responsável por iniciar o programa
  public static void main(String[] args) {

    // Tenta carregar os números do arquivo padrão ao iniciar
    carregarArquivoInicial();
    
    // Variável que guarda a opção escolhida pelo usuário
    int opcao;

    // Repete o menu enquanto o usuário não escolher sair
    do {

      // Mostra as opções disponíveis no programa
      System.out.println("\nPROJETO DE ALGORITMOS DE ORDENACAO");
      System.out.println("1 - Digitar numeros");
      System.out.println("2 - Gerar numeros automaticamente");
      System.out.println("3 - Ler numeros de um arquivo .txt");
      System.out.println("4 - Escolher algoritmo e ordenar");
      System.out.println("5 - Comparar o tempo dos algoritmos");
      System.out.println("0 - Sair");

      // Recebe a opção escolhida pelo usuário
      opcao = lerInteiro("Escolha uma opcao: ");

      // Verifica qual opção foi escolhida
      switch( opcao ) {

        // Opção para digitar os números manualmente
        case 1:
          digitarNumeros();
          break;

        // Opção para gerar números automaticamente
        case 2:
          gerarNumeros();
          break;

        // Opção para ler números de um arquivo
        case 3:
          lerArquivo();
          break;

        // Opção para escolher um algoritmo e ordenar os números
        case 4:
          ordenarDados();
          break;

        // Opção para comparar o tempo dos algoritmos
        case 5:
          compararAlgoritmos();
          break;

        // Encerra o programa
        case 0:
          System.out.println("Programa encerrado.");
          break;

        // Mostra uma mensagem caso o usuário digite uma opção inválida
        default:
          System.out.println("Opcao invalida.");

      } //  Fim do SWITCH

    } while( opcao != 0 ); // Continua mostrando o menu enquanto a opção for diferente de zero

  }

  // Função que tenta carregar os números do arquivo padrão
  private static void carregarArquivoInicial() {

    // Lê os números que estão no arquivo e guarda em um vetor
    int[] lidos = Utils.lerArquivo( ARQUIVO_PADRAO );

    // Verifica se o arquivo não foi encontrado ou não possui números
    if( lidos == null || lidos.length == 0 ) {

      // Mostra um aviso e informa outras formas de adicionar números
      System.out.println("Aviso: nao foi possivel carregar " + ARQUIVO_PADRAO + ". Use as opcoes 1, 2 ou 3.");

      return;

    }

    // Guarda os números lidos na variável dados
    dados = lidos;

    // Mostra a quantidade de números carregados e o caminho do arquivo
    System.out.println(dados.length + " numeros carregados de " + ARQUIVO_PADRAO + ":");

    // Mostra os números que foram carregados
    Utils.imprimirVetor( dados );

  }

  // Função que recebe uma linha digitada pelo usuário
  private static String lerLinha() {

    // Variável que vai guardar o texto digitado
    String texto = "";

    // Guarda o caractere que está sendo lido
    int caractere;

    try {

      // Lê o primeiro caractere digitado
      caractere = System.in.read();

      // Continua lendo até encontrar uma quebra de linha ou o final da entrada
      while( caractere != -1 && caractere != '\n' ) {

        // Ignora o caractere de retorno de carro
        if( caractere != '\r' ) {

          // Junta cada caractere ao texto digitado
          texto = texto + (char) caractere;

        }

        // Lê o próximo caractere
        caractere = System.in.read();

      } // Fim do WHILE

      // Verifica se a entrada terminou e nenhum texto foi digitado
      if( caractere == -1 && texto.isEmpty() ) {

        // Mostra a mensagem de encerramento
        System.out.println("\nPrograma encerrado.");

        // Finaliza o programa
        System.exit(0);

      }

    } catch (java.io.IOException erro) {

      // Mostra uma mensagem caso aconteça algum erro na leitura
      System.out.println("Erro ao ler a entrada.");

      return "";

    }

    // Retorna o texto digitado sem espaços no início ou no final
    return texto.trim();

  }

  // Função que recebe um número inteiro digitado pelo usuário
  private static int lerInteiro(String mensagem) {

    // Continua tentando até receber um número inteiro válido
    while( true ) {

      // Mostra a mensagem solicitando um número
      System.out.print( mensagem );

      // Recebe o texto digitado
      String texto = lerLinha();

      
      try {

        // Converte o texto para número inteiro e retorna o valor
        return Integer.parseInt( texto );

      } catch (NumberFormatException erro) {

        // Mostra uma mensagem caso o usuário digite algo que não seja um número inteiro
        System.out.println("Digite um numero inteiro valido.");

      }

    } // Fim do WHILE

  }

  // Função utilizada para o usuário digitar os números manualmente
  private static void digitarNumeros() {

    // Pergunta quantos números o usuário deseja digitar
    int quantidade = lerInteiro("Quantos numeros deseja digitar? ");

    // Verifica se a quantidade informada é válida
    if( quantidade <= 0 ) {

      // Mostra uma mensagem caso a quantidade seja menor ou igual a zero
      System.out.println("A quantidade deve ser maior que zero.");

      return;

    }

    // Cria um vetor com a quantidade de números informada
    dados = new int[quantidade];

    // Percorre o vetor para receber os números digitados
    for(int i = 0; i < quantidade; i++) {

      // Recebe cada número e guarda na posição correspondente do vetor
      dados[i] = lerInteiro("Digite o numero " + ( i + 1 ) + ": ");

    } // Fim do FOR que percorre os números do vetor

    // Mostra uma mensagem informando que os números foram cadastrados
    System.out.println("Dados cadastrados:");

    // Mostra os números digitados
    Utils.imprimirVetor( dados );

  }

  // Função que gera números automaticamente
  private static void gerarNumeros() {

    // Pergunta quantos números devem ser gerados
    int quantidade = lerInteiro("Quantos numeros deseja gerar? ");

    // Verifica se a quantidade informada é válida
    if( quantidade <= 0 ) {

      // Mostra uma mensagem caso a quantidade seja menor ou igual a zero
      System.out.println("A quantidade deve ser maior que zero.");

      return;

    }

    // Pergunta qual será o maior valor que poderá ser gerado
    int limite = lerInteiro("Qual o maior valor possivel? ");

    // Verifica se o limite informado é válido
    if( limite <= 0 ) {

      // Mostra uma mensagem caso o limite seja menor ou igual a zero
      System.out.println("O limite deve ser maior que zero.");

      return;

    }

    // Chama a função que gera os números e guarda o resultado no vetor
    dados = Utils.gerarVetor( quantidade, limite );

    // Mostra uma mensagem informando que o vetor foi gerado
    System.out.println("Vetor gerado:");

    // Mostra os números gerados
    Utils.imprimirVetor( dados );

  }

  // Função utilizada para ler números de um arquivo
  private static void lerArquivo() {

    // Solicita o caminho do arquivo ou permite usar o caminho padrão
    System.out.print("Caminho do arquivo (ENTER para " + ARQUIVO_PADRAO + "): ");

    // Recebe o caminho digitado pelo usuário
    String caminho = lerLinha();

    // Verifica se o usuário apenas apertou ENTER
    if( caminho.isEmpty() ) {

      // Utiliza o caminho padrão do arquivo
      caminho = ARQUIVO_PADRAO;

    }

    // Lê os números do arquivo informado
    int[] lidos = Utils.lerArquivo( caminho );

    // Verifica se aconteceu algum erro ao ler o arquivo
    if( lidos == null ) {

      // Mostra uma mensagem informando que não foi possível ler o arquivo
      System.out.println("Nao foi possivel ler o arquivo: " + caminho);

      return;

    }

    // Verifica se o arquivo não possui nenhum número
    if( lidos.length == 0 ) {

      // Mostra uma mensagem informando que o arquivo está vazio
      System.out.println("O arquivo nao possui numeros.");

      return;

    }

    // Guarda os números lidos no vetor principal
    dados = lidos;

    // Mostra a quantidade de números encontrados no arquivo
    System.out.println(dados.length + " numeros lidos do arquivo:");

    // Mostra os números que foram carregados
    Utils.imprimirVetor( dados );

  }

  // Função responsável por escolher um algoritmo e ordenar os números
  private static void ordenarDados() {

    // Verifica se existem números disponíveis para ordenar
    if( dados == null || dados.length == 0 ) {

      // Informa que primeiro é necessário adicionar ou carregar os números
      System.out.println("Primeiro digite, gere ou leia os numeros.");

      return;

    }

    // Mostra os algoritmos de ordenação disponíveis
    System.out.println("\nESCOLHA O ALGORITMO");
    System.out.println("1 - Bubble Sort");
    System.out.println("2 - Insertion Sort");
    System.out.println("3 - Selection Sort");
    System.out.println("4 - Merge Sort");
    System.out.println("5 - Quick Sort");

    // Recebe a opção de algoritmo escolhida pelo usuário
    int escolha = lerInteiro("Opcao: ");

    // Cria o algoritmo de acordo com a opção escolhida
    IAlgoritmoOrdenacao algoritmo = criarAlgoritmo( escolha );

    // Verifica se a opção escolhida corresponde a algum algoritmo
    if( algoritmo == null ) {

      // Mostra uma mensagem caso o algoritmo seja inválido
      System.out.println("Algoritmo invalido.");

      return;

    }

    // Cria uma cópia do vetor original para realizar a ordenação
    int[] copia = Utils.copiarVetor( dados );

    // Mostra os números antes da ordenação
    System.out.println("Vetor antes da ordenacao:");

    Utils.imprimirVetor( copia );

    // Guarda o tempo inicial antes de começar a ordenação
    long inicio = System.nanoTime();

    // Chama o algoritmo escolhido para ordenar a cópia do vetor
    algoritmo.ordenarVetor( copia );

    // Guarda o tempo final depois da ordenação
    long fim = System.nanoTime();

    // Mostra os números depois da ordenação
    System.out.println("Vetor depois da ordenacao:");

    Utils.imprimirVetor( copia );

    // Mostra o nome do algoritmo utilizado
    System.out.println("Algoritmo: " + algoritmo);

    // Calcula e mostra o tempo que o algoritmo levou para ordenar
    System.out.println("Tempo: " + ( ( fim - inicio ) / 1000000.0 ) + " ms");

    // Verifica se os números foram organizados corretamente
    System.out.println("Resultado correto: " + ( Utils.estaOrdenado( copia ) ? "Sim" : "Nao" ));

  }

  // Função que cria o algoritmo escolhido pelo usuário
  private static IAlgoritmoOrdenacao criarAlgoritmo(int escolha) {

    // Verifica qual algoritmo foi escolhido
    switch( escolha ) {

      // Cria um objeto do Bubble Sort
      case 1:
        return new BubbleSort();

      // Cria um objeto do Insertion Sort
      case 2:
        return new InsertionSort();

      // Cria um objeto do Selection Sort
      case 3:
        return new SelectionSort();

      // Cria um objeto do Merge Sort
      case 4:
        return new MergeSort();

      // Cria um objeto do Quick Sort
      case 5:
        return new QuickSort();

      // Retorna null caso nenhuma opção seja válida
      default:
        return null;

    } // Fim do SWITCH

  }

  // Função responsável por comparar o tempo dos algoritmos de ordenação
  private static void compararAlgoritmos() {

    // Verifica se existem números disponíveis para realizar a comparação
    if( dados == null || dados.length == 0 ) {

      // Informa que primeiro é necessário adicionar ou carregar os números
      System.out.println("Primeiro digite, gere ou leia os numeros.");

      return;

    }

    // Cria um vetor com os cinco algoritmos disponíveis
    IAlgoritmoOrdenacao[] algoritmos = {
      new BubbleSort(),
      new InsertionSort(),
      new SelectionSort(),
      new MergeSort(),
      new QuickSort()
    };

    // Mostra o título da comparação
    System.out.println("\nCOMPARACAO DOS ALGORITMOS");
    
    // Mostra a quantidade de números que serão utilizados no teste
    System.out.println("Quantidade de elementos: " + dados.length);
    
    // Organiza os títulos das colunas que mostram os resultados
    System.out.printf("%-18s %-18s %-12s%n", "Algoritmo", "Tempo (ms)", "Ordenou?");

    // Percorre todos os algoritmos para realizar a comparação
    for(int i = 0; i < algoritmos.length; i++) {

      // Cria uma cópia do vetor original para cada algoritmo
      int[] copia = Utils.copiarVetor( dados );

      // Guarda o tempo inicial antes da ordenação
      long inicio = System.nanoTime();

      // Executa o algoritmo atual para ordenar a cópia do vetor
      algoritmos[i].ordenarVetor( copia );

      // Guarda o tempo final depois da ordenação
      long fim = System.nanoTime();

      // Calcula o tempo gasto pelo algoritmo em milissegundos
      double tempo = ( fim - inicio ) / 1000000.0;

      // Verifica se os números foram ordenados corretamente
      String resultado = Utils.estaOrdenado( copia ) ? "Sim" : "Nao";

      // Mostra o nome do algoritmo, o tempo gasto e se conseguiu ordenar
      System.out.printf("%-18s %-18.3f %-12s%n", algoritmos[i], tempo, resultado);

    } // Fim do FOR que percorre os algoritmos

    // Informa que o tempo pode mudar dependendo do computador e da quantidade de números
    System.out.println("Os tempos podem variar conforme o computador e a quantidade de dados.");

  }

}
