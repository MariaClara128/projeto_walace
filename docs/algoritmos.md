# Os cinco algoritmos de ordenação

Todos os algoritmos implementam a interface `IAlgoritmoOrdenacao`, que define um único método:

```java
public void ordenarVetor(int[] vetor);
```

Ou seja, cada algoritmo recebe um vetor de inteiros e o ordena **no próprio vetor** (em ordem crescente). Como todos seguem o mesmo "contrato", o programa pode tratá-los da mesma forma e trocar um pelo outro sem mudar o resto do código.

Todos também começam com a mesma proteção: se o vetor for `null` ou tiver 0 ou 1 elemento, não há nada para ordenar e o método retorna imediatamente.

Nos exemplos abaixo usamos o vetor `[5, 2, 4, 1, 3]`.

---

## 1. Bubble Sort (`BubbleSort.java`)

**Ideia:** percorrer o vetor comparando cada elemento com o vizinho da direita e trocando os dois de lugar quando estão fora de ordem. A cada passada, o maior elemento que ainda está fora do lugar "sobe" até o final, como uma bolha.

**Como o código faz:**
- Um `do ... while` repete as passadas.
- A variável `isTroca` registra se houve alguma troca na passada.
- Se uma passada inteira termina **sem nenhuma troca**, o vetor já está ordenado e o algoritmo para.

**Exemplo (1ª passada):**
```
[5, 2, 4, 1, 3]  5 > 2 → troca
[2, 5, 4, 1, 3]  5 > 4 → troca
[2, 4, 5, 1, 3]  5 > 1 → troca
[2, 4, 1, 5, 3]  5 > 3 → troca
[2, 4, 1, 3, 5]  ← o 5 chegou ao final
```

| Melhor caso | Caso médio | Pior caso | Memória extra |
|---|---|---|---|
| O(n) — vetor já ordenado, 1 passada sem trocas | O(n²) | O(n²) | O(1) |

---

## 2. Insertion Sort (`InsertionSort.java`)

**Ideia:** é como organizar cartas na mão. O início do vetor é tratado como uma parte já ordenada; cada novo elemento é retirado (`aux`) e **inserido na posição certa** dessa parte, deslocando para a direita os maiores que ele.

**Como o código faz:**
- O `for` percorre do índice 1 até o fim.
- O `while` anda para trás (`indiceJ`) enquanto encontrar elementos maiores que `aux`, empurrando cada um uma posição para a direita.
- No final, `aux` é colocado no espaço que sobrou.

**Exemplo:**
```
[5 | 2, 4, 1, 3]   parte ordenada: [5]
[2, 5 | 4, 1, 3]   insere 2 antes do 5
[2, 4, 5 | 1, 3]   insere 4 entre 2 e 5
[1, 2, 4, 5 | 3]   insere 1 no início
[1, 2, 3, 4, 5]    insere 3 entre 2 e 4
```

| Melhor caso | Caso médio | Pior caso | Memória extra |
|---|---|---|---|
| O(n) — vetor já ordenado | O(n²) | O(n²) — ordem inversa | O(1) |

É o mais rápido dos três algoritmos quadráticos na prática, porque faz deslocamentos (uma atribuição) em vez de trocas completas (três atribuições) e para cedo quando encontra a posição.

---

## 3. Selection Sort (`SelectionSort.java`)

**Ideia:** a cada rodada, **selecionar o menor** elemento da parte ainda não ordenada e colocá-lo na próxima posição.

**Como o código faz:**
- O `for` externo marca a posição `i` que será preenchida.
- O `for` interno procura o índice do menor elemento entre `i` e o final (`indiceMenor`).
- Se o menor não estiver já na posição `i`, os dois são trocados.

**Exemplo:**
```
[5, 2, 4, 1, 3]   menor = 1 → troca com o 5
[1, 2, 4, 5, 3]   menor do resto = 2 → já está no lugar
[1, 2, 4, 5, 3]   menor do resto = 3 → troca com o 4
[1, 2, 3, 5, 4]   menor do resto = 4 → troca com o 5
[1, 2, 3, 4, 5]
```

| Melhor caso | Caso médio | Pior caso | Memória extra |
|---|---|---|---|
| O(n²) | O(n²) | O(n²) | O(1) |

Ele sempre faz o mesmo número de comparações, mesmo se o vetor já estiver ordenado. A vantagem é fazer no máximo n − 1 trocas.

---

## 4. Merge Sort (`MergeSort.java`)

**Ideia:** "dividir para conquistar". O vetor é dividido ao meio repetidamente até sobrarem partes de 1 elemento (que já estão ordenadas). Depois as partes são **intercaladas** (unidas) duas a duas, sempre mantendo a ordem.

**Como o código faz:**
- `mergeSort(vetor, inicio, fim)` calcula o `meio`, chama a si mesmo para a metade esquerda e para a direita, e então chama `intercala`.
- `intercala` usa um vetor auxiliar `aux`: compara o primeiro elemento de cada metade e copia o menor; quando uma metade acaba, copia o que restou da outra; por fim, copia `aux` de volta para o vetor.

**Exemplo:**
```
          [5, 2, 4, 1, 3]
        [5, 2, 4]    [1, 3]        dividir
      [5, 2] [4]    [1] [3]
     [5] [2]
     [2, 5]                         intercalar
      [2, 4, 5]     [1, 3]
          [1, 2, 3, 4, 5]
```

| Melhor caso | Caso médio | Pior caso | Memória extra |
|---|---|---|---|
| O(n log n) | O(n log n) | O(n log n) | O(n) — vetor auxiliar |

O tempo é sempre O(n log n), independentemente da ordem inicial dos dados. O custo é a memória extra do vetor auxiliar. Também é **estável**: elementos iguais mantêm a ordem relativa (por causa do `<=` na comparação).

---

## 5. Quick Sort (`QuickSort.java`)

**Ideia:** também é "dividir para conquistar", mas a divisão é feita por valor. Escolhe-se um **pivô** e o vetor é reorganizado de modo que os menores fiquem à esquerda e os maiores à direita. Depois, cada lado é ordenado recursivamente.

**Como o código faz:**
- O pivô é o elemento do **meio** do intervalo. Isso evita o pior caso em vetores já ordenados, o que aconteceria se o pivô fosse o primeiro ou o último elemento.
- `particiona` usa o esquema de **Hoare**: `indiceI` avança da esquerda até achar alguém `>=` pivô; `indiceJ` recua da direita até achar alguém `<=` pivô; os dois são trocados. Isso se repete até os índices se cruzarem, e então `indiceJ` é o ponto de divisão.
- `quickSort` chama a si mesmo para `[inicio, posicaoPivo]` e `[posicaoPivo + 1, fim]`.

**Exemplo (pivô = 4, o elemento do meio):**
```
[5, 2, 4, 1, 3]   i para no 5, j para no 3 → troca
[3, 2, 4, 1, 5]   i para no 4, j para no 1 → troca
[3, 2, 1, 4, 5]   índices se cruzam → divide em [3, 2, 1] e [4, 5]
```

| Melhor caso | Caso médio | Pior caso | Memória extra |
|---|---|---|---|
| O(n log n) | O(n log n) | O(n²) — pivôs muito ruins | O(log n) — pilha da recursão |

Apesar do pior caso teórico, costuma ser o mais rápido na prática: faz poucas trocas, não precisa de vetor auxiliar e percorre a memória de forma sequencial.

---

## Resumo

| Algoritmo | Melhor | Médio | Pior | Memória extra | Estável? |
|---|---|---|---|---|---|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Sim |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Sim |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | Não |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Sim |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | Não |
