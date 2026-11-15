package ed2.projeto.algoritmosordenacao;

import java.util.HashMap;
import java.util.Map;

public class TesteAlgoritmos {

    private static int totalTestes = 0;
    private static int totalFalhas = 0;

    public static void main(String[] args) {

        IAlgoritmoOrdenacao[] algoritmos = {
            new BubbleSort(),
            new InsertionSort(),
            new SelectionSort(),
            new MergeSort(),
            new QuickSort()
        };

        int[] grandeAleatorio = gerarComNegativos(20000);

        String[] nomesCasos = {
            "Vetor vazio",
            "Um elemento",
            "Dois elementos invertidos",
            "Pequeno aleatorio",
            "Numeros repetidos",
            "Todos iguais",
            "Numeros negativos",
            "Ja ordenado",
            "Ordem inversa",
            "Arquivo dados/numeros.txt",
            "Arquivo dados/repetidos.txt",
            "Arquivo dados/negativos.txt",
            "Arquivo dados/ordenado.txt",
            "Arquivo dados/ordem_inversa.txt",
            "Arquivo dados/todos_iguais.txt",
            "Arquivo dados/quase_ordenado.txt",
            "Arquivo dados/grande_1000.txt",
            "Arquivo dados/grande_10000.txt",
            "Grande aleatorio (20000, com negativos)"
        };

        int[][] casos = {
            {},
            {42},
            {2, 1},
            {45, 12, 89, 3, 27, 8, 64},
            {5, 3, 5, 1, 3, 5, 1, 1},
            {7, 7, 7, 7, 7, 7},
            {-3, 10, -50, 0, -1, 25, -50},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
            Utils.lerArquivo("dados/numeros.txt"),
            Utils.lerArquivo("dados/repetidos.txt"),
            Utils.lerArquivo("dados/negativos.txt"),
            Utils.lerArquivo("dados/ordenado.txt"),
            Utils.lerArquivo("dados/ordem_inversa.txt"),
            Utils.lerArquivo("dados/todos_iguais.txt"),
            Utils.lerArquivo("dados/quase_ordenado.txt"),
            Utils.lerArquivo("dados/grande_1000.txt"),
            Utils.lerArquivo("dados/grande_10000.txt"),
            grandeAleatorio
        };

        for (int c = 0; c < casos.length; c++) {

            if (casos[c] == null) {
                System.out.println("[AVISO] " + nomesCasos[c]
                    + ": arquivo nao encontrado (rode a partir da raiz do projeto).");
                continue;
            }

            for (int a = 0; a < algoritmos.length; a++) {

                int[] copia = Utils.copiarVetor(casos[c]);

                algoritmos[a].ordenarVetor(copia);

                verificar(
                    algoritmos[a] + " - " + nomesCasos[c],
                    casos[c],
                    copia
                );
            }
        }

        System.out.println("\n" + (totalTestes - totalFalhas)
            + " de " + totalTestes + " testes passaram.");

        if (totalFalhas > 0) {
            System.exit(1);
        }
    }

    private static void verificar(String descricao, int[] original, int[] obtido) {

        totalTestes++;

        boolean igual = original.length == obtido.length;

        // Verifica se o vetor esta em ordem crescente.
        for (int i = 1; igual && i < obtido.length; i++) {

            if (obtido[i - 1] > obtido[i]) {
                igual = false;
            }
        }

        // Verifica se todos os numeros originais foram preservados.
        if (igual) {

            Map<Integer, Integer> frequencias = new HashMap<>();

            for (int numero : original) {
                frequencias.put(
                    numero,
                    frequencias.getOrDefault(numero, 0) + 1
                );
            }

            for (int numero : obtido) {

                if (!frequencias.containsKey(numero)) {
                    igual = false;
                    break;
                }

                int quantidade = frequencias.get(numero);

                if (quantidade == 1) {
                    frequencias.remove(numero);
                } else {
                    frequencias.put(numero, quantidade - 1);
                }
            }

            if (!frequencias.isEmpty()) {
                igual = false;
            }
        }

        if (igual) {
            System.out.println("[OK]    " + descricao);
        } else {
            totalFalhas++;
            System.out.println("[FALHA] " + descricao);
        }
    }

    private static int[] gerarComNegativos(int tamanho) {

        int[] vetor = Utils.gerarVetor(tamanho, 2000);

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = vetor[i] - 1000;
        }

        return vetor;
    }
}

}
