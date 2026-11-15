package ed2.projeto.algoritmosordenacao;

public class SelectionSort implements IAlgoritmoOrdenacao {

  @Override
    
  public void ordenarVetor(int[] vetor) {
    if (vetor == null || vetor.length <= 1) {
      return;
    }

    for(int i = 0; i < vetor.length - 1; i++) {

      int indiceMenor = i;

      for(int j = i + 1; j < vetor.length; j++) {

        if( vetor[j] < vetor[indiceMenor] ) {

          indiceMenor = j;

        }

      } // FOR PROCURA MENOR

      if( indiceMenor != i ) {

        int aux = vetor[i];

        vetor[i] = vetor[indiceMenor];

        vetor[indiceMenor] = aux;

      }

    } // FOR ELEMENTOS VETOR

  }

  @Override
    
  public String toString() {
    
    return "SelectionSort";
    
  }

}
