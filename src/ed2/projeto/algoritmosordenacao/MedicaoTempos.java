package ed2.projeto.algoritmosordenacao;

// Criando a classe responsável por medir o tempo dos algoritmos
public class MedicaoTempos {

    // Função principal do programa
    public static void main(String[] args) {

        // Define as quantidades de números que serão usadas nos testes
        int[] tamanhos = {10, 100, 1000, 10000, 100000};

        // Cria um vetor com os cinco algoritmos de ordenação
        IAlgoritmoOrdenacao[] algoritmos = {
            new BubbleSort(),
            new InsertionSort(),
            new SelectionSort(),
            new MergeSort(),
            new QuickSort()
        };

        // Executa alguns testes antes de começar a medir os tempos
        aquecer(algoritmos);

        // Mostra o título da tabela de resultados
        System.out.println("TEMPOS MEDIDOS (media das execucoes, em ms)");

        // Informa quantas vezes cada teste será repetido
        System.out.println("Repeticoes: 5 para ate 10.000 elementos e 2 para 100.000.");

        // Mostra o título da primeira coluna da tabela
        System.out.printf("%-15s", "Algoritmo");

        // Percorre os tamanhos dos vetores para mostrar cada coluna
        for (int tamanho : tamanhos) {
            System.out.printf("%15s", "n=" + tamanho);
        }

        // Pula para a próxima linha da tabela
        System.out.println();

        // Percorre todos os algoritmos para medir seus tempos
        for (int a = 0; a < algoritmos.length; a++) {

            // Mostra o nome do algoritmo que está sendo testado
            System.out.printf("%-15s", algoritmos[a]);

            // Percorre as quantidades de números usadas nos testes
            for (int tamanho : tamanhos) {

                // Define duas repetições para 100.000 números e cinco para os demais
                int repeticoes = (tamanho == 100000) ? 2 : 5;

                // Variável que vai somar os tempos de todas as execuções
                double soma = 0;

                // Repete o teste a quantidade de vezes definida
                for (int r = 0; r < repeticoes; r++) {

                    // Gera um vetor com a quantidade de números escolhida e os números podem chegar até 1.000.000
                    int[] vetor = Utils.gerarVetor(
                        tamanho, 1000000
                    );

                    // Guarda o tempo inicial antes da ordenação
                    long inicio = System.nanoTime();

                    // Executa o algoritmo para organizar os números do vetor
                    algoritmos[a].ordenarVetor(vetor);

                    // Guarda o tempo final depois da ordenação
                    long fim = System.nanoTime();

                    // Calcula o tempo da execução em milissegundos e soma ao total
                    soma += (fim - inicio) / 1000000.0;
                }

                // Calcula a média dos tempos das execuções
                double media = soma / repeticoes;

                // Mostra a média do tempo na tabela com quatro casas decimais
                System.out.printf("%15.4f", media);
            }

            // Pula para a próxima linha depois de terminar os testes do algoritmo
            System.out.println();
        }
    }

    // Função que executa alguns testes antes de medir os tempos
    private static void aquecer(IAlgoritmoOrdenacao[] algoritmos) {

        // Repete o aquecimento três vezes
        for (int i = 0; i < 3; i++) {

            // Percorre todos os algoritmos
            for (int a = 0; a < algoritmos.length; a++) {

                // Gera um vetor com 200 números para o teste inicial
                int[] vetor = Utils.gerarVetor(200, 1000000);

                // Executa o algoritmo para ordenar o vetor
                algoritmos[a].ordenarVetor(vetor);
            }
        }
    }
}
