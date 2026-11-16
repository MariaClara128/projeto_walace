package ed2.projeto.algoritmosordenacao;

// Criando a classe MergeSort que utiliza a interface IAlgoritmoOrdenacao
public class MergeSort implements IAlgoritmoOrdenacao {

  @Override
  // Função que organiza os números do vetor  
  public void ordenarVetor(int[] vetor) {

    // Verifica se o vetor está vazio ou tem apenas um número e se tiver assim não precisa organizar
    if (vetor == null || vetor.length <= 1) {
      return;
    }
    // Chama a função que divide e organiza o vetor
    this.mergeSort( vetor, 0, ( vetor.length - 1 ) );
  }

  // Função que divide o vetor em partes menores
  public void mergeSort(int[] vetor, int inicio, int fim) {

    // Variável que guarda a posição do meio do vetor
    int meio;

    // Verifica se ainda existe mais de um número para dividir
    if( inicio < fim ) {

      // Encontra a posição do meio
      meio = ( inicio + fim ) / 2;

      // Organiza a primeira metade do vetor
      this.mergeSort( vetor, inicio, meio );

      // Organiza a segunda metade do vetor
      this.mergeSort( vetor, meio + 1, fim );

      // Junta as duas metades já organizadas
      this.intercala( vetor, inicio, fim, meio );
          
    }
        
  }
  // Função que junta as partes do vetor em ordem
  private void intercala(int[] vetor, int inicio, int fim, int meio) {

    // Variáveis que controlam as posições das duas partes
    int posLivre, inicioVetor1, inicioVetor2;

    // Calcula quantos números existem nessa parte do vetor
    int tamanho = fim - inicio + 1;

    // Cria um vetor auxiliar para guardar os números organizados
    int aux[] = new int[tamanho];

    // Marca o início da primeira metade
    inicioVetor1 = inicio;
    
    // Marca o início da segunda metade
    inicioVetor2 = meio + 1;

    // Começa a preencher o vetor auxiliar pela primeira posição
    posLivre = 0;

    // Compara os números das duas metades enquanto ainda houver números nas duas
    while( ( inicioVetor1 <= meio ) && ( inicioVetor2 <= fim ) ) {

      // Verifica qual dos dois números é menor
      if( vetor[inicioVetor1] <= vetor[inicioVetor2] ) {

        // Coloca o menor número no vetor auxiliar
        aux[posLivre] = vetor[inicioVetor1];

        // Avança para o próximo número da primeira metade
        inicioVetor1++; 
            
      } else {

        // Coloca o número da segunda metade no vetor auxiliar
        aux[posLivre] = vetor[inicioVetor2];

        // Avança para o próximo número da segunda metade
        inicioVetor2++;
            
      }
      // Avança para a próxima posição livre do vetor auxiliar
      posLivre++;
          
    } // Fim do WHILE
        
    for(int i = inicioVetor1; i <= meio; i++) {
        
      aux[posLivre] = vetor[i];
          
      posLivre++;
          
    } // FOR VETOR 1

    // Copia os números que sobraram da primeira metade
    for(int i = inicioVetor2; i <= fim; i++) {
      
      aux[posLivre] = vetor[i];
          
      posLivre++;
          
    } // Fim do FOR VETOR 2

    // Copia os números organizados de volta para o vetor original
    for(int i = 0; i < tamanho; i++) {
            
      vetor[inicio + i] = aux[i];
          
    } // F im do FOR VETOR COMPLETO
            
  }

  @Override

  // Retorna o nome do algoritmo
  public String toString() {
    
    return "MergeSort";
    
  }
  
}
