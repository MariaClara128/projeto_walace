package ed2.projeto.algoritmosordenacao;

// Criando a classe InsertionSort que utiliza a interface IAlgoritmoOrdenacao
public class InsertionSort implements IAlgoritmoOrdenacao {

  @Override
  // Função que organiza os números do vetor  
  public void ordenarVetor(int[] vetor) {
    // Verifica se o vetor está vazio ou tem apenas um número, e se tiver não precisa organizar
    if (vetor == null || vetor.length <= 1) {
      return;
    }
    
    // Percorre o vetor começando pelo segundo número
    for(int i = 1; i < vetor.length; i++) {
      
      // Guarda o número que vai ser colocado na posição correta
       int aux = vetor[i];
      
       // Começa a comparação pelo número anterior      
       int indiceJ = i - 1;

      // Verifica se o número anterior é maior que o número guardado
       while ( indiceJ >= 0 && aux < vetor[indiceJ] ) {

         // Move o número maior uma posição para frente
         vetor[indiceJ + 1] = vetor[indiceJ];

         // Volta uma posição para continuar comparando
         indiceJ = indiceJ - 1;
                       
       }
       // Coloca o número guardado na posição correta           
       vetor[ indiceJ + 1 ] = aux;

     } // Fim da comparação dos números
                 
  }

  @Override

  // Retorna o nome do algoritmo
  public String toString() {
    
    return "InsertionSort";
    
  }

}
