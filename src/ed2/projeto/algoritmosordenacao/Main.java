package ed2.projeto.algoritmosordenacao;

<<<<<<< HEAD
// Classe principal: apresenta o menu e controla o programa.
public class Main {

    private static int[] dados;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\nPROJETO DE ALGORITMOS DE ORDENACAO");
            System.out.println("1 - Digitar numeros");
            System.out.println("2 - Gerar numeros automaticamente");
            System.out.println("3 - Escolher algoritmo e ordenar");
            System.out.println("4 - Comparar o tempo dos algoritmos");
            System.out.println("0 - Sair");
            opcao = lerInteiro("Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    digitarNumeros();
                    break;
                case 2:
                    gerarNumeros();
                    break;
                case 3:
                    ordenarDados();
                    break;
                case 4:
                    compararAlgoritmos();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
    }

    // Le uma linha do teclado sem utilizar Scanner.
    private static String lerLinha() {
        String texto = "";
        int caractere;

        try {
            while ((caractere = System.in.read()) != -1 && caractere != '\n') {
                if (caractere != '\r') {
                    texto = texto + (char) caractere;
                }
            }
        } catch (java.io.IOException erro) {
            System.out.println("Erro ao ler a entrada.");
            return "";
        }

        return texto.trim();
    }

    // Le um numero inteiro e repete a pergunta se a entrada for invalida.
    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = lerLinha();

            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException erro) {
                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }

    // Recebe os numeros que serao ordenados.
    private static void digitarNumeros() {
        int quantidade = lerInteiro("Quantos numeros deseja digitar? ");

        if (quantidade <= 0) {
            System.out.println("A quantidade deve ser maior que zero.");
            return;
        }

        dados = new int[quantidade];
        for (int i = 0; i < quantidade; i++) {
            dados[i] = lerInteiro("Digite o numero " + (i + 1) + ": ");
        }

        System.out.println("Dados cadastrados:");
        Utils.imprimirVetor(dados);
    }

    // Gera um vetor com numeros aleatorios.
    private static void gerarNumeros() {
        int quantidade = lerInteiro("Quantos numeros deseja gerar? ");

        if (quantidade <= 0) {
            System.out.println("A quantidade deve ser maior que zero.");
            return;
        }

        int limite = lerInteiro("Qual o maior valor possivel? ");
        if (limite <= 0) {
            System.out.println("O limite deve ser maior que zero.");
            return;
        }

        dados = Utils.gerarVetor(quantidade, limite);
        System.out.println("Vetor gerado:");
        Utils.imprimirVetor(dados);
    }

    // Permite escolher um dos cinco algoritmos.
    private static void ordenarDados() {
        if (dados == null || dados.length == 0) {
            System.out.println("Primeiro digite ou gere os numeros.");
            return;
        }

=======
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

>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
        System.out.println("\nESCOLHA O ALGORITMO");
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Insertion Sort");
        System.out.println("3 - Selection Sort");
        System.out.println("4 - Merge Sort");
        System.out.println("5 - Quick Sort");
<<<<<<< HEAD
        int escolha = lerInteiro("Opcao: ");

        IAlgoritmoOrdenacao algoritmo = criarAlgoritmo(escolha);
        if (algoritmo == null) {
            System.out.println("Algoritmo invalido.");
            return;
        }

        int[] copia = Utils.copiarVetor(dados);
        System.out.println("Vetor antes da ordenacao:");
        Utils.imprimirVetor(copia);

        long inicio = System.nanoTime();
        algoritmo.ordenarVetor(copia);
        long fim = System.nanoTime();

        System.out.println("Vetor depois da ordenacao:");
        Utils.imprimirVetor(copia);
        System.out.println("Algoritmo: " + algoritmo);
        System.out.println("Tempo: " + ((fim - inicio) / 1000000.0) + " ms");
        System.out.println("Resultado correto: " + (Utils.estaOrdenado(copia) ? "Sim" : "Nao"));
    }

    // Cria o algoritmo escolhido no menu.
    private static IAlgoritmoOrdenacao criarAlgoritmo(int escolha) {
        switch (escolha) {
            case 1: return new BubbleSort();
            case 2: return new InsertionSort();
            case 3: return new SelectionSort();
            case 4: return new MergeSort();
            case 5: return new QuickSort();
            default: return null;
        }
    }

    // Executa todos os algoritmos sobre copias dos mesmos dados e compara os tempos.
    private static void compararAlgoritmos() {
        if (dados == null || dados.length == 0) {
            System.out.println("Primeiro digite ou gere os numeros.");
            return;
        }

        IAlgoritmoOrdenacao[] algoritmos = {
            new BubbleSort(),
            new InsertionSort(),
            new SelectionSort(),
            new MergeSort(),
            new QuickSort()
        };

        System.out.println("\nCOMPARACAO DOS ALGORITMOS");
        System.out.println("Quantidade de elementos: " + dados.length);
        System.out.printf("%-18s %-18s %-12s%n", "Algoritmo", "Tempo (ms)", "Ordenou?");

        for (int i = 0; i < algoritmos.length; i++) {
            int[] copia = Utils.copiarVetor(dados);

            long inicio = System.nanoTime();
            algoritmos[i].ordenarVetor(copia);
            long fim = System.nanoTime();

            double tempo = (fim - inicio) / 1000000.0;
            String resultado = Utils.estaOrdenado(copia) ? "Sim" : "Nao";
            System.out.printf("%-18s %-18.3f %-12s%n", algoritmos[i], tempo, resultado);
        }

        System.out.println("Os tempos podem variar conforme o computador e a quantidade de dados.");
    }
}
=======

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
>>>>>>> 92bd3a25a35d47038ff86ea5db5b88db734c1b36
