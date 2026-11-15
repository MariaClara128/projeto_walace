package ed2.projeto.algoritmosordenacao;

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

        System.out.println("\nESCOLHA O ALGORITMO");
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Insertion Sort");
        System.out.println("3 - Selection Sort");
        System.out.println("4 - Merge Sort");
        System.out.println("5 - Quick Sort");
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
