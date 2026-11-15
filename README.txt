
# PROJETO DE ESTRUTURA DE DADOS II

Projeto desenvolvido para a disciplina de Estrutura de Dados II, reunindo implementações de algoritmos de ordenação em Java e uma estrutura de Tabela Hash em Python.

## Integrantes

- Maria Clara Lacerda
- Maria Julia Braga
- Amanda Cristina
- Lívia Santos Alves
- Daniel Duarte
- Jonatha Nunes

## 1. Algoritmos de Ordenação (Java)

Foram implementados cinco algoritmos de ordenação:

- Bubble Sort
- Insertion Sort
- Selection Sort
- Merge Sort
- Quick Sort

### Funcionalidades

- Entrada manual de números;
- Geração automática de vetores;
- Leitura de números a partir de arquivos TXT da pasta `dados/`;
- Escolha do algoritmo de ordenação;
- Exibição dos dados de entrada e saída;
- Limitação da exibição a 100 elementos em vetores grandes;
- Medição do tempo de execução;
- Comparação do desempenho dos cinco algoritmos;
- Verificação da ordenação dos vetores;
- Testes automatizados com diferentes tipos de entrada;
- Simulações e estimativas para entradas de tamanho `n`, `n²`, `n³` e `n¹⁰`.

### Como compilar e executar

Execute os comandos a partir da pasta raiz do projeto, que contém as pastas `src/` e `dados/`.

```bash
# Compilar os arquivos Java
javac -d out src/ed2/projeto/algoritmosordenacao/*.java

# Executar o menu principal
java -cp out ed2.projeto.algoritmosordenacao.Main

# Executar os testes automatizados
java -cp out ed2.projeto.algoritmosordenacao.TesteAlgoritmos

# Executar a medição dos tempos
java -cp out ed2.projeto.algoritmosordenacao.MedicaoTempos
```

Os tempos de execução podem variar conforme o computador e as condições da execução. A classe `MedicaoTempos` informa a quantidade de repetições utilizada em cada tamanho de vetor.

## 2. Tabela Hash (Python)

Implementação de uma estrutura de dados do tipo Tabela Hash, com tratamento de colisões por encadeamento.

### Funcionalidades

- Inserção de alunos;
- Busca de alunos pela matrícula;
- Remoção de alunos;
- Exibição da tabela;
- Menu interativo para selecionar as operações.

A implementação está localizada na pasta `TabelaHash/`, nos arquivos `hash.py` e `menu.py`.

### Como executar

Com o Python instalado, abra o terminal na pasta `TabelaHash/` e execute:

```bash
python menu.py
```

## 3. Organização do projeto

```text
projeto_walace-main/
├── TabelaHash/        # Implementação da Tabela Hash em Python
├── dados/             # Arquivos TXT usados como entradas para os testes
├── docs/              # Documentação dos algoritmos, programa, testes e simulações
└── src/               # Código Java dos algoritmos de ordenação
```

## 4. Tecnologias utilizadas

- Java
- Python
- Visual Studio Code

## 5. Documentação

A documentação detalhada da parte de ordenação está na pasta `docs/`. Para começar, consulte `docs/README.md`.

Os documentos incluem:

- `algoritmos.md`: explicação dos algoritmos de ordenação;
- `programa.md`: organização e funcionamento do programa;
- `testes.md`: casos de teste e instruções de execução;
- `simulacoes.md`: medições, estimativas e comparação de desempenho.

## 6. Objetivo

Aplicar os conhecimentos de estruturas de dados e algoritmos, compreendendo o funcionamento das implementações, realizando operações de inserção, busca e remoção na Tabela Hash e analisando o desempenho de diferentes algoritmos de ordenação.
