package ed2.projeto.algoritmosordenacao;

public class Main {

    public static void main(String[] args) {

        int[] dados = null;

        while (true) {

            System.out.println("\nALGORITMOS DE ORDENACAO");
            System.out.println("1 - Digitar numeros");
            System.out.println("2 - Gerar numeros aleatorios");
            System.out.println("3 - Escolher algoritmo e ordenar");
            System.out.println("4 - Comparar tempo dos algoritmos");
            System.out.println("0 - Sair");

            int op = lerInt("Opcao: ");

            switch (op) {

                case 1:

                    dados = lerNumeros();

                    System.out.println("\nVetor informado:");
                    Utils.imprimirVetor(dados);

                    break;

                case 2:

                    int quantidade = lerInt("Quantidade de numeros: ");

                    int limite = lerInt("Maior limite exclusivo: ");

                    try {

                        dados = Utils.gerarVetor(quantidade, limite);

                        System.out.println("\nVetor aleatorio gerado:");
                        Utils.imprimirVetor(dados);

                    } catch (IllegalArgumentException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 3:

                    if (!existeDados(dados)) {
                        break;
                    }

                    ordenar(dados);

                    break;

                case 4:

                    if (!existeDados(dados)) {
                        break;
                    }

                    comparar(dados);

                    break;

                case 0:

                    System.out.println("\nPrograma encerrado.");

                    return;

                default:

                    System.out.println("Opcao invalida.");
            }
        }
    }

    // Recebe os numeros digitados pelo usuario
    private static int[] lerNumeros() {

        int quantidade = lerInt("Quantidade de numeros: ");

        if (quantidade <= 0) {

            System.out.println("A quantidade deve ser maior que zero.");

            return null;
        }

        int[] vetor = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {

            vetor[i] = lerInt("Digite o numero " + (i + 1) + ": ");
        }

        return vetor;
    }

    // Verifica se existem dados para ordenar
    private static boolean existeDados(int[] dados) {

        if (dados == null || dados.length == 0) {

            System.out.println("\nNenhum numero disponivel.");
            System.out.println("Digite ou gere numeros primeiro.");

            return false;
        }

        return true;
    }

    // Apresenta os algoritmos disponiveis
    private static void ordenar(int[] dados) {

        System.out.println("\nESCOLHA O ALGORITMO");
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Insertion Sort");
        System.out.println("3 - Selection Sort");
        System.out.println("4 - Merge Sort");
        System.out.println("5 - Quick Sort");

        int op = lerInt("Escolha: ");

        IAlgoritmoOrdenacao algoritmo = criarAlgoritmo(op);

        if (algoritmo == null) {

            System.out.println("Algoritmo invalido.");

            return;
        }

        // Copia o vetor para preservar os dados originais
        int[] copia = Utils.copiarVetor(dados);

        System.out.println("\nVetor original:");
        Utils.imprimirVetor(copia);

        // Marca o inicio da ordenacao
        long inicio = System.nanoTime();

        algoritmo.ordenarVetor(copia);

        // Marca o final da ordenacao
        long fim = System.nanoTime();

        System.out.println("\nVetor ordenado:");
        Utils.imprimirVetor(copia);

        double tempo = (fim - inicio) / 1000000.0;

        System.out.println("\nAlgoritmo utilizado: " + algoritmo);
        System.out.println("Tempo de execucao: " + tempo + " ms");

        // Confere se o resultado esta correto
        if (estaOrdenado(copia)) {

            System.out.println("Ordenacao realizada corretamente.");

        } else {

            System.out.println("Erro na ordenacao.");
        }
    }

    // Retorna o algoritmo escolhido pelo usuario
    private static IAlgoritmoOrdenacao criarAlgoritmo(int op) {

        switch (op) {

            case 1:
                return new BubbleSort();

            case 2:
                return new InsertionSort();

            case 3:
                return new SelectionSort();

            case 4:
                return new MergeSort();

            case 5:
                return new QuickSort();

            default:
                return null;
        }
    }

    // Compara o tempo dos cinco algoritmos
    private static void comparar(int[] dados) {

        System.out.println("\nCOMPARACAO DE ALGORITMOS");

        System.out.println("Vetor utilizado:");
        Utils.imprimirVetor(dados);

        // Executa os cinco algoritmos usando o mesmo vetor
        for (int op = 1; op <= 5; op++) {

            IAlgoritmoOrdenacao algoritmo = criarAlgoritmo(op);

            // Cada algoritmo recebe uma copia dos mesmos dados
            int[] copia = Utils.copiarVetor(dados);

            long inicio = System.nanoTime();

            algoritmo.ordenarVetor(copia);

            long fim = System.nanoTime();

            double tempo = (fim - inicio) / 1000000.0;

            System.out.println("\nAlgoritmo: " + algoritmo);

            System.out.println("Tempo: " + tempo + " ms");

            System.out.println("Ordenacao correta: " + estaOrdenado(copia));

            System.out.println("Resultado:");
            Utils.imprimirVetor(copia);
        }

        System.out.println("\nComparacao finalizada.");
    }

    // Verifica se os numeros estao em ordem crescente
    private static boolean estaOrdenado(int[] vetor) {

        for (int i = 1; i < vetor.length; i++) {

            if (vetor[i - 1] > vetor[i]) {

                return false;
            }
        }

        return true;
    }

    // Recebe uma linha digitada pelo usuario
    private static String lerLinha() {

        String texto = "";

        try {

            int caractere = System.in.read();

            while (caractere != -1 && caractere != '\n') {

                if (caractere != '\r') {

                    texto = texto + (char) caractere;
                }

                caractere = System.in.read();
            }

            if (caractere == -1 && texto.isEmpty()) {

                System.out.println("\nPrograma encerrado.");
                System.exit(0);
            }

        } catch (java.io.IOException e) {

            System.out.println("Erro ao receber os dados.");
            System.exit(1);
        }

        return texto;
    }

    // Recebe e verifica se o usuario digitou um numero inteiro
    private static int lerInt(String mensagem) {

        while (true) {

            System.out.print(mensagem);

            String entrada = lerLinha().trim();

            try {

                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {

                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }
}