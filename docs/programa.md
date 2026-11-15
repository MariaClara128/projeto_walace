# O programa

## Organização das classes

Todas as classes estão no pacote `ed2.projeto.algoritmosordenacao`, em `src/ed2/projeto/algoritmosordenacao/`.

| Classe | Papel |
|---|---|
| `IAlgoritmoOrdenacao` | Interface comum: método `ordenarVetor(int[] vetor)` |
| `BubbleSort`, `InsertionSort`, `SelectionSort`, `MergeSort`, `QuickSort` | Os cinco algoritmos (ver [algoritmos.md](algoritmos.md)) |
| `Utils` | Funções auxiliares: imprimir, gerar, copiar, ler de arquivo e verificar se o vetor está ordenado |
| `Main` | Menu interativo |
| `TesteAlgoritmos` | Bateria de testes automáticos (ver [testes.md](testes.md)) |
| `MedicaoTempos` | Mede o tempo real dos algoritmos em vários tamanhos (ver [simulacoes.md](simulacoes.md)) |

Cada algoritmo também sobrescreve `toString()`, que devolve o nome dele. Por isso o programa consegue imprimir `"Algoritmo: " + algoritmo` sem precisar de `if`s.

## Menu

```
PROJETO DE ALGORITMOS DE ORDENACAO
1 - Digitar numeros
2 - Gerar numeros automaticamente
3 - Ler numeros de um arquivo .txt
4 - Escolher algoritmo e ordenar
5 - Comparar o tempo dos algoritmos
0 - Sair
```

O menu fica dentro de um `do ... while` que só termina quando o usuário escolhe `0`. Assim é possível fazer quantas ordenações quiser, trocar os dados ou o algoritmo, e encerrar quando terminar.

Os números ficam guardados no atributo `dados` da classe `Main`. As opções 1, 2 e 3 **substituem** esses dados; as opções 4 e 5 **usam** os dados atuais.

### Leitura do teclado

O programa lê o teclado caractere por caractere com `System.in.read()` (método `lerLinha`). O método `lerInteiro` tenta converter o texto com `Integer.parseInt` e, se o usuário digitar algo inválido, mostra uma mensagem e pergunta de novo, em vez de encerrar com erro.

## Entrada de dados

Há três formas de preparar os números:

1. **Digitar** — o usuário informa a quantidade e depois cada número.
2. **Gerar automaticamente** — o usuário informa a quantidade e o maior valor possível. `Utils.gerarVetor` usa um gerador congruente linear (`semente * 1103515245 + 12345`), com a semente tirada de `System.nanoTime()`, para produzir valores entre 1 e o limite.
3. **Ler de arquivo `.txt`** — o usuário informa o caminho, ou aperta ENTER para usar `dados/numeros.txt`. `Utils.lerArquivo`:
   - lê o arquivo linha por linha;
   - aceita números separados por espaço, quebra de linha, vírgula ou ponto e vírgula;
   - aceita números negativos;
   - ignora (com aviso) qualquer coisa que não seja número;
   - guarda os valores em um vetor que dobra de tamanho quando enche e, no final, devolve um vetor com o tamanho exato.

Exemplo de arquivo (o `dados/numeros.txt` do projeto):
```
45 12 89 3 27 12 0 -5 100 8 64 31 7 19 2 56 44 11 90 1
```

### Arquivos de exemplo

A pasta `dados/` traz arquivos prontos para testar situações diferentes. Para usar um deles, escolha a opção 3 e digite o caminho, por exemplo `dados/negativos.txt`.

| Arquivo | Quantidade | Conteúdo | Para que serve |
|---|---|---|---|
| `numeros.txt` | 20 | Valores variados, com um negativo e um repetido | Arquivo padrão (ENTER) |
| `repetidos.txt` | 30 | Só os valores 1, 2, 3, 5, 8 e 13 | Muitos elementos iguais |
| `negativos.txt` | 40 | Entre −500 e 500 | Negativos misturados com positivos |
| `ordenado.txt` | 50 | 1 a 50 em ordem crescente | Melhor caso do Bubble e do Insertion |
| `ordem_inversa.txt` | 50 | 50 a 1 em ordem decrescente | Pior caso dos algoritmos quadráticos |
| `todos_iguais.txt` | 25 | Todos iguais a 7 | Nenhuma troca deveria ser necessária |
| `quase_ordenado.txt` | 100 | 1 a 100 com alguns pares trocados | Insertion Sort se sai muito bem |
| `grande_1000.txt` | 1 000 | Entre −10 000 e 10 000 | Volume médio (a tela mostra só os 100 primeiros) |
| `grande_10000.txt` | 10 000 | Entre −100 000 e 100 000 | Volume grande; diferença de tempo fica visível |

### Mesmos dados para todos os algoritmos

Os algoritmos ordenam o vetor que recebem, ou seja, modificam o vetor original. Por isso, antes de cada ordenação o programa faz `Utils.copiarVetor(dados)` e entrega a **cópia** ao algoritmo. Assim:
- os dados originais nunca são alterados;
- na comparação (opção 5), os cinco algoritmos recebem exatamente a mesma entrada, e a comparação de tempo é justa.

## Exibição dos resultados

Na opção 4, o programa mostra:
- o vetor **antes** da ordenação;
- o vetor **depois** da ordenação;
- o nome do algoritmo;
- o tempo gasto, medido com `System.nanoTime()` e convertido para milissegundos;
- se o resultado está correto, verificado por `Utils.estaOrdenado`, que confere se cada elemento é maior ou igual ao anterior.

Para entradas grandes, `Utils.imprimirVetor` mostra **apenas os 100 primeiros** números e avisa quantos existem no total:
```
Vetor = {...100 primeiros numeros... ... (mostrando somente os 100 primeiros de 5000)}
```

Na opção 5, os cinco algoritmos são executados com os mesmos dados e o resultado aparece em tabela:
```
Algoritmo          Tempo (ms)         Ordenou?
BubbleSort         33,898             Sim
InsertionSort      8,994              Sim
SelectionSort      10,919             Sim
MergeSort          1,329              Sim
QuickSort          0,770              Sim
```
