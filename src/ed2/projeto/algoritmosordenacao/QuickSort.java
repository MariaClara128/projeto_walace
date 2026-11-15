package ed2.projeto.algoritmosordenacao;

public class QuickSort implements IAlgoritmoOrdenacao {

  @Override
    
  public void ordenarVetor(int[] vetor) {
    if (vetor == null || vetor.length <= 1) {
      return;
    }
    this.quickSort( vetor, 0, ( vetor.length - 1 ) );
  }

  public void quickSort(int[] vetor, int inicio, int fim) {

    if( inicio < fim ) {

      int posicaoPivo = this.particiona( vetor, inicio, fim );

      this.quickSort( vetor, inicio, posicaoPivo );
      this.quickSort( vetor, posicaoPivo + 1, fim );

    }

  }

  private int particiona(int[] vetor, int inicio, int fim) {

    int pivo = vetor[ ( inicio + fim ) / 2 ];

    int indiceI = inicio - 1;
    int indiceJ = fim + 1;

    while( true ) {

      do {

        indiceI++;

      } while( vetor[indiceI] < pivo );

      do {

        indiceJ--;

      } while( vetor[indiceJ] > pivo );

      if( indiceI >= indiceJ ) {

        return indiceJ;

      }

      int aux = vetor[indiceI];

      vetor[indiceI] = vetor[indiceJ];

      vetor[indiceJ] = aux;

    } // WHILE

  }

  @Override
    
  public String toString() {
    
    return "QuickSort";
    
  }

}
