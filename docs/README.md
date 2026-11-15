# Documentação — Algoritmos de Ordenação

Esta pasta explica como funciona a parte de ordenação do projeto: os algoritmos, o programa que os executa, os testes e a análise de desempenho.

| Documento | Conteúdo |
|---|---|
| [algoritmos.md](algoritmos.md) | Como cada um dos cinco algoritmos funciona, com exemplo e complexidade |
| [programa.md](programa.md) | Organização das classes, menu, entrada de dados e exibição dos resultados |
| [testes.md](testes.md) | Casos de teste e como executá-los |
| [simulacoes.md](simulacoes.md) | Tempos medidos, tempos estimados pela IA e tabela comparativa |

## Como compilar e executar

Todos os comandos são executados a partir da **raiz do projeto** (a pasta que contém `src/` e `dados/`).

```bash
# Compilar (os .class vão para out/, que é ignorada pelo Git)
javac -d out src/ed2/projeto/algoritmosordenacao/*.java

# Programa principal (menu)
java -cp out ed2.projeto.algoritmosordenacao.Main

# Bateria de testes
java -cp out ed2.projeto.algoritmosordenacao.TesteAlgoritmos

# Medição de tempos (demora cerca de 2 minutos)
java -cp out ed2.projeto.algoritmosordenacao.MedicaoTempos
```
