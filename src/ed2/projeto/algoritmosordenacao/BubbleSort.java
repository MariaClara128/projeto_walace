package ed2.projeto.algoritmosordenacao;

// Criando a classe 'BubbleSort' que utiliza a interface 'IAlgoritmoOrdenacao'
public class BubbleSort implements IAlgoritmoOrdenacao {

  @Override

  // Função que organiza os números do vetor
  public void ordenarVetor(int[] vetor) {

    // Verifica se o vetor está vazio ou possui apenas um número. Nesse caso não precisa organizar
    if (vetor == null || vetor.length <= 1) {
      return;
    }

    // Verifica se aconteceu alguma troca
    boolean isTroca;

    // Guarda o tamanho do vetor sem contar a última posição
    int tamanhoVetorMenosUm = vetor.length - 1;

    // Repete enquanto acontece alguma coisa
    do {
      // Começa de cada repetição considerando que nenhuma troca aconteceu           
      isTroca = false;
      
      // Percorre o vetor comparando os números vizinhos
      for(int i = 0; i < tamanhoVetorMenosUm ; i++) {
        
         // Verifica se o número atual é maior que o próximo         
        if( vetor[i] > vetor[i + 1] ) {
          
          // Guarda temporariamente o número atual para fazer a troca          
          int aux = vetor[i];

          // Coloca o próximo número na posição atual
          vetor[i] = vetor[i + 1];

          // Coloca o número que estava guardado na posição seguinte
          vetor[i + 1] = aux;

          // Avisa que aconteceu uma troca e que o vetor precisa ser percorrido novamente
          isTroca = true;
          
        }
        
      } // Fim do FOR que percorre os números do vetor
        
    } while( isTroca ); // Repete enquanto houver alguma troca
    
  }
  
  @Override
  
  // Retorna o nome do algoritmo  
  public String toString() {
    
    return "BubbleSort";
    
  }
    
}
