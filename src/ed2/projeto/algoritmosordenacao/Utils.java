package ed2.projeto.algoritmosordenacao;

<<<<<<< HEAD
// Metodos auxiliares usados pelo programa.
public class Utils {

    private Utils() {
        // Impede a criacao de objetos desta classe.
    }

    // Mostra no maximo os 100 primeiros valores do vetor.
    public static void imprimirVetor(int[] vetor) {
        if (vetor == null) {
            System.out.println("Nenhum vetor foi informado.");
            return;
        }

        System.out.print("Vetor = {");
        int limite = vetor.length;
=======
public class Utils {

    private Utils() {
    }

    // Mostra no maximo os 100 primeiros numeros
    public static void imprimirVetor(int[] vetor) {

        int limite = vetor.length;

>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
        if (limite > 100) {
            limite = 100;
        }

<<<<<<< HEAD
        for (int i = 0; i < limite; i++) {
            System.out.print(vetor[i]);
=======
        System.out.print("[ ");

        for (int i = 0; i < limite; i++) {

            System.out.print(vetor[i]);

>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
            if (i < limite - 1) {
                System.out.print(", ");
            }
        }

<<<<<<< HEAD
        if (vetor.length > 100) {
            System.out.print(" ... (mostrando somente os 100 primeiros)");
        }
        System.out.println("}");
    }

    // Gera numeros inteiros sem usar Random ou outra classe externa.
    public static int[] gerarVetor(int tamanhoVetor, int limiteSuperior) {
        if (tamanhoVetor <= 0 || limiteSuperior <= 0) {
            return null;
        }

        int[] vetor = new int[tamanhoVetor];
        long semente = System.nanoTime() & 0x7fffffffL;

        for (int i = 0; i < tamanhoVetor; i++) {
            semente = (semente * 1103515245L + 12345L) & 0x7fffffffL;
            vetor[i] = (int) (semente % limiteSuperior) + 1;
=======
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
>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
        }

        return vetor;
    }

<<<<<<< HEAD
    // Faz uma copia para que cada algoritmo receba os mesmos dados originais.
    public static int[] copiarVetor(int[] vetor) {
        if (vetor == null) {
            return null;
        }

        int[] copia = new int[vetor.length];
        for (int i = 0; i < vetor.length; i++) {
            copia[i] = vetor[i];
        }
        return copia;
    }

    // Confere se os valores estao em ordem crescente.
    public static boolean estaOrdenado(int[] vetor) {
        if (vetor == null) {
            return false;
        }

        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i - 1] > vetor[i]) {
                return false;
            }
        }
        return true;
    }
}
=======
    // Faz uma copia do vetor original
    public static int[] copiarVetor(int[] original) {

        int[] copia = new int[original.length];

        for (int i = 0; i < original.length; i++) {

            copia[i] = original[i];
        }

        return copia;
    }
}
>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
