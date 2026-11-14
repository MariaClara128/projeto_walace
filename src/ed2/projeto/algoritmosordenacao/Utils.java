package ed2.projeto.algoritmosordenacao;

public class Utils {

    private Utils() {
    }

    // Mostra no maximo os 100 primeiros numeros
    public static void imprimirVetor(int[] vetor) {

        int limite = vetor.length;

        if (limite > 100) {
            limite = 100;
        }

        System.out.print("[ ");

        for (int i = 0; i < limite; i++) {

            System.out.print(vetor[i]);

            if (i < limite - 1) {
                System.out.print(", ");
            }
        }

        System.out.println(" ]");

        // Avisa quando existem mais elementos
        if (vetor.length > 100) {

            System.out.println("Mostrando os 100 primeiros de "
                    + vetor.length + " numeros.");
        }
    }

    // Gera numeros aleatorios
    public static int[] gerarVetor(int tamanho, int limite) {

        if (tamanho <= 0 || limite <= 0) {

            throw new IllegalArgumentException(
                    "A quantidade e o limite devem ser maiores que zero.");
        }

        int[] vetor = new int[tamanho];

        // Usa o tempo atual como valor inicial
        long numero = System.nanoTime();

        for (int i = 0; i < tamanho; i++) {

            // Gera um novo valor
            numero = (numero * 1103515245L + 12345L) & 0x7fffffffL;

            // Mantem o numero dentro do limite informado
            vetor[i] = (int) (numero % limite);
        }

        return vetor;
    }

    // Faz uma copia do vetor original
    public static int[] copiarVetor(int[] original) {

        int[] copia = new int[original.length];

        for (int i = 0; i < original.length; i++) {

            copia[i] = original[i];
        }

        return copia;
    }
}