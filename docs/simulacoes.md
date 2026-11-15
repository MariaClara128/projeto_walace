# Simulações de desempenho

Este documento compara o desempenho dos cinco algoritmos para entradas de tamanho **n, n², n³ e n¹⁰**, usando **n = 10**:

| | n | n² | n³ | n¹⁰ |
|---|---|---|---|---|
| Quantidade de elementos | 10 | 100 | 1 000 | 10 000 000 000 (10¹⁰) |

Os números aqui são de dois tipos, que **não devem ser confundidos**:

- **Tempo medido** — o programa realmente executou e o tempo foi cronometrado.
- **Tempo estimado** — calculado pela IA a partir da complexidade de cada algoritmo; o algoritmo não foi executado nesse tamanho.

## IA utilizada

- **IA:** Claude Opus 5.5 (Anthropic), modelo `claude-opus-5-5`, usado pelo Claude Code.
- **Como foi feito:** o código-fonte de cada algoritmo foi fornecido à IA, que identificou a complexidade de cada um (O(n²) para Bubble, Insertion e Selection; O(n log n) para Merge e Quick) e calculou os tempos estimados ajustando essas fórmulas a uma medição real de referência (n = 100 000), descrita abaixo.

## Ambiente das medições

- Processador: AMD Ryzen 7 5700U
- Java: OpenJDK 25
- Programa: `MedicaoTempos.java` — dados aleatórios entre 1 e 1 000 000, média de 5 execuções por tamanho, com uma fase de "aquecimento" antes para que a JVM já tenha compilado o código.

## 1. Tempos medidos

Valores em **milissegundos**, média de 5 execuções.

| Algoritmo | n = 10 | n = 100 | n = 1 000 | n = 10 000 | n = 100 000 |
|---|---|---|---|---|---|
| Bubble Sort | 0,0004 | 0,0153 | 1,0277 | 121,33 | 17 703,65 (≈ 17,7 s) |
| Insertion Sort | 0,0003 | 0,0019 | 0,0676 | 5,97 | 607,52 |
| Selection Sort | 0,0004 | 0,0051 | 0,2220 | 18,41 | 1 817,99 (≈ 1,8 s) |
| Merge Sort | 0,0008 | 0,0086 | 0,0858 | 0,98 | 11,62 |
| Quick Sort | 0,0008 | 0,0043 | 0,0512 | 0,59 | 6,88 |

Os tempos variam um pouco a cada execução e de um computador para outro, mas a ordem entre os algoritmos se mantém.

## 2. Tempos estimados pela IA

### Como a estimativa é calculada

Usando o tempo medido em n₀ = 100 000 como referência:

- **Algoritmos O(n²):** T(n) ≈ T(n₀) × (n / n₀)²
- **Algoritmos O(n log n):** T(n) ≈ T(n₀) × (n · log n) / (n₀ · log n₀)

Exemplo para o Quick Sort em n¹⁰ = 10¹⁰:
T ≈ 6,88 ms × (10¹⁰ × 10) / (10⁵ × 5) = 6,88 ms × 200 000 ≈ 1 376 000 ms ≈ **23 minutos**.

Exemplo para o Bubble Sort em 10¹⁰:
T ≈ 17,70 s × (10¹⁰ / 10⁵)² = 17,70 s × 10¹⁰ ≈ 1,77 × 10¹¹ s ≈ **5 600 anos**.

### Tabela comparativa (estimado × medido)

| Algoritmo | n = 10 | n² = 100 | n³ = 1 000 | n¹⁰ = 10¹⁰ |
|---|---|---|---|---|
| **Bubble Sort** — estimado | 0,0002 ms | 0,0177 ms | 1,77 ms | ≈ 1,8 × 10¹¹ s (**≈ 5 600 anos**) |
| Bubble Sort — medido | 0,0004 ms | 0,0153 ms | 1,03 ms | não executável |
| **Insertion Sort** — estimado | 0,000006 ms | 0,0006 ms | 0,061 ms | ≈ 6,1 × 10⁹ s (**≈ 190 anos**) |
| Insertion Sort — medido | 0,0003 ms | 0,0019 ms | 0,068 ms | não executável |
| **Selection Sort** — estimado | 0,00002 ms | 0,0018 ms | 0,18 ms | ≈ 1,8 × 10¹⁰ s (**≈ 580 anos**) |
| Selection Sort — medido | 0,0004 ms | 0,0051 ms | 0,22 ms | não executável |
| **Merge Sort** — estimado | 0,0002 ms | 0,0046 ms | 0,070 ms | ≈ 2 300 s (**≈ 39 min**) |
| Merge Sort — medido | 0,0008 ms | 0,0086 ms | 0,086 ms | não executável |
| **Quick Sort** — estimado | 0,0001 ms | 0,0028 ms | 0,041 ms | ≈ 1 400 s (**≈ 23 min**) |
| Quick Sort — medido | 0,0008 ms | 0,0043 ms | 0,051 ms | não executável |

### Por que n¹⁰ não pode ser medido

10¹⁰ números `int` ocupam 4 bytes cada, ou seja, **40 GB de memória** (o Merge Sort precisaria de mais 40 GB para o vetor auxiliar). Além disso, em Java um vetor pode ter no máximo cerca de 2,1 × 10⁹ posições, então `new int[10_000_000_000]` nem é permitido. Por isso, para n¹⁰ só existe o tempo **estimado**.

## 3. Análise dos resultados

**Para entradas pequenas (n = 10 e n = 100) quase não há diferença.** Todos terminam em menos de 0,02 ms. Nesses tamanhos, o tempo é dominado por custos fixos (chamada de método, cronômetro, recursão), e não pelo número de comparações. Por isso os tempos medidos ficam **acima** do estimado: a fórmula só considera o crescimento e ignora esse custo fixo. Também por isso o Merge e o Quick, que fazem chamadas recursivas, chegam a ser um pouco mais lentos que o Insertion em n = 10.

**A partir de n = 1 000 a diferença aparece e cresce muito rápido.** Quando n aumenta 10 vezes:
- os algoritmos O(n²) ficam cerca de **100 vezes** mais lentos (de n = 10 000 para 100 000, o Bubble foi de 121 ms para 17 703 ms);
- os algoritmos O(n log n) ficam só cerca de **12 vezes** mais lentos (o Quick foi de 0,59 ms para 6,88 ms).

**Em n¹⁰ a diferença vira algo como "minutos contra séculos".** Quick e Merge levariam dezenas de minutos; os três quadráticos levariam de 190 a 5 600 anos. A escolha do algoritmo importa muito mais do que a velocidade do computador: um computador mil vezes mais rápido ainda levaria anos com o Bubble Sort.

**Entre os quadráticos**, o Insertion foi o mais rápido e o Bubble o mais lento (cerca de 30 vezes mais lento que o Insertion em n = 100 000). O Bubble faz uma troca completa (três atribuições) para cada par fora de ordem; o Insertion apenas desloca elementos e para assim que encontra a posição certa.

**Entre os O(n log n)**, o Quick foi cerca de 1,7 vez mais rápido que o Merge. O Merge copia todos os elementos para o vetor auxiliar e depois de volta a cada nível da recursão; o Quick reorganiza os elementos no próprio vetor.

**Limitações da estimativa:** a extrapolação supõe que o computador se comporta igual em qualquer tamanho. Na prática, em tamanhos enormes, os dados não cabem no cache nem na memória RAM, e o tempo real seria ainda **maior** que o estimado.

### Ranking final (n grande, dados aleatórios)

1. **Quick Sort** — mais rápido
2. **Merge Sort** — quase tão rápido e com tempo garantido O(n log n)
3. **Insertion Sort** — o melhor dos quadráticos; bom para vetores pequenos ou quase ordenados
4. **Selection Sort**
5. **Bubble Sort** — mais lento
