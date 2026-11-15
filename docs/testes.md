# Testes

A classe `TesteAlgoritmos` executa automaticamente os cinco algoritmos sobre vários vetores e compara cada resultado com o resultado de referência, obtido com `java.util.Arrays.sort`. Se algum resultado for diferente, o teste aparece como `[FALHA]` e o programa termina com código de erro 1.

## Como executar

A partir da raiz do projeto:

```bash
javac -d out src/ed2/projeto/algoritmosordenacao/*.java
java -cp out ed2.projeto.algoritmosordenacao.TesteAlgoritmos
```

## Casos testados

| Caso | Vetor | Por que é importante |
|---|---|---|
| Vetor vazio | `[]` | Não pode dar erro de índice |
| Um elemento | `[42]` | Caso mínimo |
| Dois elementos invertidos | `[2, 1]` | Menor caso que exige uma troca |
| Pequeno aleatório | `[45, 12, 89, 3, 27, 8, 64]` | Caso comum |
| Números repetidos | `[5, 3, 5, 1, 3, 5, 1, 1]` | Comparações com `<`, `<=` precisam tratar iguais |
| Todos iguais | `[7, 7, 7, 7, 7, 7]` | O Quick Sort precisa terminar mesmo sem "menores" e "maiores" |
| Números negativos | `[-3, 10, -50, 0, -1, 25, -50]` | Negativos, zero e repetidos juntos |
| Já ordenado | `[1, 2, ..., 10]` | Melhor caso do Bubble e do Insertion |
| Ordem inversa | `[10, 9, ..., 1]` | Pior caso dos quadráticos |
| Arquivos | os 9 arquivos de `dados/` (ver [programa.md](programa.md#arquivos-de-exemplo)) | Testa a leitura de arquivo junto com a ordenação, em vários formatos de dados |
| Grande aleatório | 20 000 números entre −999 e 1000 | Volume grande com negativos e muitos repetidos |

São 19 casos × 5 algoritmos = **95 testes**.

## Resultado

```
...
[OK]    BubbleSort - Grande aleatorio (20000, com negativos)
[OK]    InsertionSort - Grande aleatorio (20000, com negativos)
[OK]    SelectionSort - Grande aleatorio (20000, com negativos)
[OK]    MergeSort - Grande aleatorio (20000, com negativos)
[OK]    QuickSort - Grande aleatorio (20000, com negativos)

95 de 95 testes passaram.
```

Além disso, o próprio programa confere cada ordenação: as opções 4 e 5 do menu mostram `Resultado correto: Sim` / `Ordenou? Sim`, calculado por `Utils.estaOrdenado`.
