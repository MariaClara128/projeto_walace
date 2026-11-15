# Simulações de desempenho

Este documento apresenta as medições e as estimativas de desempenho dos cinco algoritmos de ordenação para entradas de tamanho **n, n², n³ e n¹⁰**, considerando **n = 10**.

| | n | n² | n³ | n¹⁰ |
|---|---:|---:|---:|---:|
| Quantidade de elementos | 10 | 100 | 1.000 | 10.000.000.000 (10¹⁰) |

É importante distinguir os dois tipos de resultado:

- **Tempo medido:** o algoritmo foi executado e o tempo foi cronometrado.
- **Tempo estimado:** valor calculado por extrapolação da complexidade, sem executar o algoritmo nesse tamanho.

## IA utilizada

- **IA:** Claude Opus 5.5 (Anthropic), modelo `claude-opus-5-5`, usado pelo Claude Code.
- **Procedimento:** os códigos-fonte dos algoritmos foram fornecidos à IA. A partir das complexidades consideradas — O(n²) para Bubble Sort, Insertion Sort e Selection Sort; O(n log n) para Merge Sort e Quick Sort — foram calculadas estimativas usando como referência os tempos medidos para 100.000 elementos.

## Ambiente e metodologia das medições

- **Processador:** AMD Ryzen 7 5700U.
- **Java:** OpenJDK 25.
- **Programa:** `MedicaoTempos.java`.
- **Dados:** vetores gerados aleatoriamente, com valores entre 1 e 1.000.000.
- **Aquecimento:** 3 execuções por algoritmo com vetores de 200 elementos.
- **Repetições da medição:** 5 execuções para cada tamanho até 10.000 elementos e 2 execuções para 100.000 elementos. Foi utilizada essa quantidade menor no maior vetor para reduzir o tempo total da medição.
- **Resultado apresentado:** média aritmética dos tempos das execuções realizadas para cada combinação de algoritmo e tamanho.

## 1. Tempos medidos

Valores em **milissegundos (ms)**, conforme a execução mais recente do programa:

| Algoritmo | n = 10 | n = 100 | n = 1.000 | n = 10.000 | n = 100.000 |
|---|---:|---:|---:|---:|---:|
| Bubble Sort | 0,0010 | 0,0331 | 1,4478 | 87,3622 | 17.346,9457 |
| Insertion Sort | 0,0018 | 0,0583 | 0,9411 | 15,8244 | 534,3241 |
| Selection Sort | 0,0381 | 0,0613 | 0,9717 | 18,0351 | 1.690,7390 |
| Merge Sort | 0,0017 | 0,0123 | 0,1320 | 4,0593 | 24,1593 |
| Quick Sort | 0,0017 | 0,0259 | 0,1624 | 1,0434 | 10,6108 |

Os valores são específicos do computador e das condições dessa execução. Podem variar em novas execuções. Para 100.000 elementos, a média foi calculada com 2 repetições; para os demais tamanhos, com 5.

## 2. Estimativas de tempo

As estimativas abaixo usam o tempo medido para **100.000 elementos** como referência (`n₀ = 100.000`) e aplicam uma aproximação baseada na complexidade assintótica:

- **O(n²):** `T(n) ≈ T(n₀) × (n / n₀)²`.
- **O(n log n):** `T(n) ≈ T(n₀) × [n log₂(n) / (n₀ log₂(n₀))]`.

A tabela mostra as estimativas para n, n², n³ e n¹⁰. Os valores não são novas medições; são extrapolações matemáticas a partir da referência de 100.000 elementos.

| Algoritmo | n = 10 (estimado) | n² = 100 (estimado) | n³ = 1.000 (estimado) | n¹⁰ = 10¹⁰ (estimado) |
|---|---:|---:|---:|---:|
| Bubble Sort | 0,000173 ms | 0,017347 ms | 1,734695 ms | 5.496,9 anos |
| Insertion Sort | 0,000005 ms | 0,000534 ms | 0,053432 ms | 169,3 anos |
| Selection Sort | 0,000017 ms | 0,001691 ms | 0,169074 ms | 535,8 anos |
| Merge Sort | 0,000483 ms | 0,009664 ms | 0,144956 ms | 80,5 minutos |
| Quick Sort | 0,000212 ms | 0,004244 ms | 0,063665 ms | 35,4 minutos |

**Atenção:** estimativas para tamanhos muito diferentes da referência devem ser interpretadas apenas como aproximações teóricas. O comportamento real também depende de memória, cache, JVM, distribuição dos dados e implementação. Em particular, o tempo real para 10¹⁰ elementos não pode ser obtido com segurança apenas por essa extrapolação.

### Exemplo de cálculo para n¹⁰

Para o Quick Sort, usando 10,6108 ms como tempo medido para 100.000 elementos:

`T(10¹⁰) ≈ 10,6108 × [(10¹⁰ × log₂(10¹⁰)) / (100.000 × log₂(100.000))]`

O fator de crescimento aproximado é 200.000. Portanto, o resultado estimado é 2.122.160 ms, ou cerca de **35,4 minutos**.

Para o Bubble Sort, a estimativa quadrática é:

`T(10¹⁰) ≈ 17.346,9457 ms × (10¹⁰ / 100.000)²`

O resultado aproximado é **5.496,9 anos**.

## 3. Por que n¹⁰ não foi medido

Um vetor com 10¹⁰ valores do tipo `int` exigiria aproximadamente 40 GB apenas para armazenar os elementos (considerando 4 bytes por inteiro), sem contar memória adicional usada pelo programa. Além disso, esse tamanho ultrapassa o limite prático de posições de um único vetor Java. Por isso, o caso n¹⁰ foi tratado como **estimativa teórica**, e não como execução medida.

## 4. Análise dos resultados

Na execução registrada, o **Quick Sort** apresentou o menor tempo para 100.000 elementos (10,6108 ms), seguido pelo **Merge Sort** (24,1593 ms). Entre os algoritmos quadráticos, o **Insertion Sort** foi o mais rápido (534,3241 ms), seguido pelo **Selection Sort** (1.690,7390 ms); o **Bubble Sort** apresentou o maior tempo (17.346,9457 ms).

A diferença entre os algoritmos fica mais evidente conforme o tamanho do vetor aumenta. Os algoritmos quadráticos têm crescimento proporcional a n² na análise teórica, enquanto Merge Sort e Quick Sort têm crescimento O(n log n) nos casos considerados. Isso ajuda a explicar por que os algoritmos O(n log n) foram mais rápidos nos maiores vetores desta execução.

Os resultados para entradas pequenas devem ser interpretados com cuidado: os tempos são muito baixos e podem sofrer influência significativa dos custos fixos de execução e da precisão do cronômetro. Além disso, a tabela registra uma execução específica, não uma garantia de que a mesma ordem será observada em todos os computadores e cenários.

## 5. Limitações

- A medição de 100.000 elementos utilizou 2 repetições, enquanto os tamanhos menores utilizaram 5; portanto, a média do maior tamanho tem menor quantidade de amostras.
- Os tempos dependem do hardware, da JVM, do sistema operacional e das condições do computador durante a execução.
- As estimativas pressupõem que o crescimento teórico continue seguindo a mesma aproximação e não representam uma medição real.
- O Quick Sort pode apresentar comportamento diferente conforme a distribuição dos dados e a escolha do pivô; a complexidade O(n log n) é a referência média considerada nesta comparação.

## 6. Ranking observado para 100.000 elementos

1. **Quick Sort** — 10,6108 ms.
2. **Merge Sort** — 24,1593 ms.
3. **Insertion Sort** — 534,3241 ms.
4. **Selection Sort** — 1.690,7390 ms.
5. **Bubble Sort** — 17.346,9457 ms.

Esse ranking corresponde aos tempos da execução apresentada neste documento.