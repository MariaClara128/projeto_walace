package ed2.projeto.algoritmosordenacao;

// Criando a classe que reúne funções utilizadas em várias partes do projeto
public class Utils {

  // Impede que seja criado um objeto dessa classe
  private Utils() {

  }
// Função que mostra os números do vetor na tela
  public static void imprimirVetor(int[] vetor) {

    // Verifica se nenhum vetor foi informado
    if( vetor == null ) {

      // Mostra um aviso na tela
      System.out.println("Nenhum vetor foi informado.");

      // Encerra a função
      return;

    }

    // Guarda a quantidade de números que serão mostrados
    int limite = vetor.length;

    // Verifica se o vetor possui mais de 100 números
    if( limite > 100 ) {

      // Limita a exibição aos 100 primeiros números
      limite = 100;

    }

    // Mostra o início da impressão do vetor
    System.out.print("Vetor = {");

    // Percorre o vetor para mostrar os números
    for(int i = 0; i < limite; i++) {

      // Mostra o número da posição atual
      System.out.print( vetor[i] );

      // Verifica se ainda existem outros números para mostrar
      if( i < limite - 1 ) {

        // Separa os números com uma vírgula
        System.out.print(", ");

      }

    } // Fim do FOR ELEMENTOS VETOR

    // Verifica se o vetor possui mais de 100 números
    if( vetor.length > 100 ) {
      
      // Avisa que somente os 100 primeiros números foram mostrados
      System.out.print(" ... (mostrando somente os 100 primeiros de " + vetor.length + ")");

    }

    // Finaliza a impressão do vetor
    System.out.println("}");

  }

  // Função que cria um vetor com números aleatórios
  public static int[] gerarVetor(int tamanhoVetor, int limiteSuperior) {

    // Verifica se o tamanho ou o limite informado é inválido
    if( tamanhoVetor <= 0 || limiteSuperior <= 0 ) {

      // Retorna vazio caso algum dos valores seja inválido
      return null;

    }

    // Cria um vetor com o tamanho informado
    int[] vetor = new int[tamanhoVetor];

    // Cria um valor inicial para gerar os números aleatórios
    long semente = System.nanoTime() & 0x7fffffffL;

    // Percorre o vetor para preencher todas as posições
    for(int i = 0; i < tamanhoVetor; i++) {

      // Atualiza a semente para gerar um novo número
      semente = ( semente * 1103515245L + 12345L ) & 0x7fffffffL;

      // Guarda um número aleatório entre 1 e o limite informado
      vetor[i] = (int) ( semente % limiteSuperior ) + 1;

    } // Fim do FOR ELEMENTOS VETOR

    // Retorna o vetor preenchido
    return vetor;

  }

  // Função que cria uma cópia de um vetor
  public static int[] copiarVetor(int[] vetor) {

    // Verifica se o vetor informado está vazio
    if( vetor == null ) {

      // Retorna vazio caso não exista vetor
      return null;

    }

    // Cria um novo vetor com o mesmo tamanho do original
    int[] copia = new int[vetor.length];

    // Percorre o vetor original
    for(int i = 0; i < vetor.length; i++) {

      // Copia cada número para a mesma posição no novo vetor
      copia[i] = vetor[i];

    } // Fim FOR ELEMENTOS VETOR

    // Retorna o vetor copiado
    return copia;

  }

  // Função que verifica se os números do vetor estão em ordem crescente
  public static boolean estaOrdenado(int[] vetor) {

    // Verifica se o vetor informado está vazio
    if( vetor == null ) {

      // Retorna falso caso não exista vetor
      return false;

    }

    // Percorre o vetor começando pela segunda posição
    for(int i = 1; i < vetor.length; i++) {

      // Verifica se o número anterior é maior que o atual
      if( vetor[i - 1] > vetor[i] ) {

        // Retorna falso caso encontre números fora de ordem
        return false;

      }

    } // Fim do FOR ELEMENTOS VETOR

    // Retorna verdadeiro se todos os números estiverem em ordem
    return true;

  }

  // Função que lê os números de um arquivo
  public static int[] lerArquivo(String caminho) {

    // Cria um vetor inicial com espaço para 16 números
    int[] vetor = new int[16];

    // Controla a quantidade de números encontrados
    int quantidade = 0;

    // Tenta abrir o arquivo informado para realizar a leitura
    try ( java.io.BufferedReader leitor = new java.io.BufferedReader( new java.io.FileReader( caminho ) ) ) {

      // Lê a primeira linha do arquivo
      String linha = leitor.readLine();

      // Continua a leitura enquanto existir uma linha
      while( linha != null ) {

        // Separa os números quando encontrar espaços, vírgulas ou ponto e vírgula
        String[] partes = linha.trim().split("[\\s,;]+");

        // Percorre as partes encontradas na linha
        for(int i = 0; i < partes.length; i++) {

          // Verifica se a parte está vazia
          if( partes[i].isEmpty() ) {

            // Pula essa parte e continua a leitura
            continue;

          }

          // Tenta transformar o texto em um número inteiro
          try {

            int numero = Integer.parseInt( partes[i] );

            // Verifica se o vetor já está cheio
            if( quantidade == vetor.length ) {

              // Cria um vetor maior, com o dobro do espaço
              int[] maior = new int[vetor.length * 2];

              // Copia os números para o novo vetor
              for(int j = 0; j < quantidade; j++) {

                maior[j] = vetor[j];

              } // Fim do  FOR COPIA

              // Substitui o vetor antigo pelo novo
              vetor = maior;

            }

            // Guarda o número na próxima posição livre
            vetor[quantidade] = numero;

            // Aumenta a quantidade de números lidos
            quantidade++;

          } catch (NumberFormatException erro) {

            // Avisa quando encontrar um valor que não pode ser convertido em número
            System.out.println("Valor ignorado no arquivo: " + partes[i]);

          }

        } // Fim do FOR PARTES DA LINHA

        // Lê a próxima linha do arquivo
        linha = leitor.readLine();

      } // Fim do WHILE LINHAS

    } catch (java.io.IOException erro) {

      // Retorna vazio caso aconteça algum problema ao ler o arquivo
      return null;

    }

    // Cria um novo vetor com o tamanho exato da quantidade de números encontrados
    int[] resultado = new int[quantidade];

    // Percorre os números que foram lidos
    for(int i = 0; i < quantidade; i++) {

      // Copia os números para o vetor final
      resultado[i] = vetor[i];

    } // Fim do FOR ELEMENTOS VETOR

    // Retorna o vetor com os números lidos
    return resultado;

  }

}
