package ed2.projeto.algoritmosordenacao;

// Criando a classe QuickSort que utiliza a interface IAlgoritmoOrdenacao
public class QuickSort implements IAlgoritmoOrdenacao {

  @Override

  // Função que organiza os números do vetor
  public void ordenarVetor(int[] vetor) {
    // Verifica se o vetor está vazio ou tem apenas um número e se estiver assim nao precisa organizar
    if (vetor == null || vetor.length <= 1) {
      return;
    }
    // Chama a função que realiza a ordenação
    this.quickSort( vetor, 0, ( vetor.length - 1 ) );
  }

  // Função que divide o vetor para organizar os números
  public void quickSort(int[] vetor, int inicio, int fim) {

    // Verifica se ainda existe mais de uma posição para organizar
    if( inicio < fim ) {

      // Encontra a posição que divide o vetor usando o pivô
      int posicaoPivo = this.particiona( vetor, inicio, fim );

      // Organiza a parte esquerda do vetor
      this.quickSort( vetor, inicio, posicaoPivo );

      // Organiza a parte direita do vetor
      this.quickSort( vetor, posicaoPivo + 1, fim );

    }

  }

  // Função que divide os números do vetor de acordo com o pivô
  private int particiona(int[] vetor, int inicio, int fim) {

    // Escolhe o número do meio do vetor como pivô
    int pivo = vetor[ ( inicio + fim ) / 2 ];

    // Cria um índice que começa antes do início do vetor
    int indiceI = inicio - 1;

    // Cria um índice que começa depois do fim do vetor
    int indiceJ = fim + 1;

    // Repete o processo até encontrar a posição de divisão
    while( true ) {

      // Avança o índice I
      do {

        indiceI++;

        // Continua avançando enquanto o número for menor que o pivô
      } while( vetor[indiceI] < pivo );

      // Volta o índice J
      do {

        indiceJ--;

      // Continua voltando enquanto o número for maior que o pivô
      } while( vetor[indiceJ] > pivo );

      // Verifica se os índices se cruzaram ou chegaram à mesma posição
      if( indiceI >= indiceJ ) {

        // Retorna a posição onde o vetor foi dividido
        return indiceJ;

      }

      // Guarda temporariamente um número para realizar a troca
      int aux = vetor[indiceI];

      // Coloca o número da posição J na posição I
      vetor[indiceI] = vetor[indiceJ];

      // Coloca o número guardado na posição J
      vetor[indiceJ] = aux;

    } // Fim do WHILE

  }

  @Override

  // Retorna o nome do algoritmo
  public String toString() {
    
    return "QuickSort";
    
  }

}
