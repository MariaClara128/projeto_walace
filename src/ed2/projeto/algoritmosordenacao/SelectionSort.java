package ed2.projeto.algoritmosordenacao;

// Criando a classe SelectionSort que utiliza a interface IAlgoritmoOrdenacao
public class SelectionSort implements IAlgoritmoOrdenacao {

  @Override

  // Função que organiza os números do vetor 
  public void ordenarVetor(int[] vetor) {
    // Verifica se o vetor está vazio ou tem apenas um número e se tiver assim não precisa organizar
    if (vetor == null || vetor.length <= 1) {
      return;
    }

    // Percorre o vetor até a penúltima posição
    for(int i = 0; i < vetor.length - 1; i++) {

      // Considera que o número atual é o menor
      int indiceMenor = i;

      // Percorre as próximas posições procurando um número menor
      for(int j = i + 1; j < vetor.length; j++) {

        // Verifica se encontrou um número menor que o atual menor
        if( vetor[j] < vetor[indiceMenor] ) {

          // Guarda a posição do novo menor número
          indiceMenor = j;

        }

      } // Fim do FOR PROCURA MENOR

      if( indiceMenor != i ) {

        // Verifica se o menor número está em uma posição diferente da atual
        int aux = vetor[i];

        // Coloca o menor número na posição atual
        vetor[i] = vetor[indiceMenor];

        // Coloca o número guardado na posição onde estava o menor
        vetor[indiceMenor] = aux;

      }

    } // Fim do FOR ELEMENTOS VETOR

  }

  @Override
    
  public String toString() {

    // Retorna o nome do algoritmo
    return "SelectionSort";
    
  }

}
