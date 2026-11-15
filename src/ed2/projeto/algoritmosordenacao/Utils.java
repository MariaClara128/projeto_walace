package ed2.projeto.algoritmosordenacao;

public class Utils {

  private Utils() {

  }

  public static void imprimirVetor(int[] vetor) {

    if( vetor == null ) {

      System.out.println("Nenhum vetor foi informado.");

      return;

    }

    int limite = vetor.length;

    if( limite > 100 ) {

      limite = 100;

    }

    System.out.print("Vetor = {");

    for(int i = 0; i < limite; i++) {

      System.out.print( vetor[i] );

      if( i < limite - 1 ) {

        System.out.print(", ");

      }

    } // FOR ELEMENTOS VETOR

    if( vetor.length > 100 ) {

      System.out.print(" ... (mostrando somente os 100 primeiros de " + vetor.length + ")");

    }

    System.out.println("}");

  }

  public static int[] gerarVetor(int tamanhoVetor, int limiteSuperior) {

    if( tamanhoVetor <= 0 || limiteSuperior <= 0 ) {

      return null;

    }

    int[] vetor = new int[tamanhoVetor];

    long semente = System.nanoTime() & 0x7fffffffL;

    for(int i = 0; i < tamanhoVetor; i++) {

      semente = ( semente * 1103515245L + 12345L ) & 0x7fffffffL;

      vetor[i] = (int) ( semente % limiteSuperior ) + 1;

    } // FOR ELEMENTOS VETOR

    return vetor;

  }

  public static int[] copiarVetor(int[] vetor) {

    if( vetor == null ) {

      return null;

    }

    int[] copia = new int[vetor.length];

    for(int i = 0; i < vetor.length; i++) {

      copia[i] = vetor[i];

    } // FOR ELEMENTOS VETOR

    return copia;

  }

  public static boolean estaOrdenado(int[] vetor) {

    if( vetor == null ) {

      return false;

    }

    for(int i = 1; i < vetor.length; i++) {

      if( vetor[i - 1] > vetor[i] ) {

        return false;

      }

    } // FOR ELEMENTOS VETOR

    return true;

  }

}
