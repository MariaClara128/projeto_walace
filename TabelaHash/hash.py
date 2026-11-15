# Criando a classe 'Aluno'
class Aluno:
    def __init__(self, matricula, nome, idade): # método de inicialização dos atributos
        self.matricula = matricula 
        self.nome = nome
        self.idade = idade
        self.proximo = None # o atributo 'proximo' tem como padrão o valor None, visto que um aluno é sempre inserido no final de uma posição e aponta para um valor nulo

# Criando a classe 'TabelaHash'
class TabelaHash:
    def __init__(self, m): # método de inicialização do atributos
        self.m = m # o 'm' representa o Mod da função, ou seja, quantas posições a tabela possui
        self.lista = [None] * m # a tabela é representada por uma lista com m None's

    # Método utilizado para calcular a posição em que o aluno será cadastrado
    def calcular_posicao(self, matricula): # passa como único parâmetro a matrícula do aluno
        posicao = matricula % self.m # a posição da chave é calculada usando a fórmula "número da matrícula % Mod"
        return posicao # retorna a posição da chave calculada

    # Método responsável pela inserção do aluno na tabela
    def inserir_aluno(self, aluno): # passa como parâmetro uma instância da classe 'Aluno'
        posicao = self.calcular_posicao(aluno.matricula) # chamando a função de cálculo da posição do aluno na tabela
        atual = self.lista[posicao] # variável que armazena o nó que está sendo "observado" durante o percorrimento da lista 
        # Caso 1: aquela posição não tem nenhum aluno e esse novo será o primeiro
        if atual is None: 
            self.lista[posicao] = aluno
            print("Aluno cadastrado com sucesso!")
        # Caso 2: a posição não está vazia
        else:
            while atual.proximo is not None: # enquanto ele não chegar no último aluno daquela posição:
                # Verificando se o aluno observado não é o que estamos querendo cadastrar
                if atual.matricula != aluno.matricula: # se não for:
                    atual = atual.proximo # o nó que o atual está apontando se atribui à variável 
                # O aluno que está sendo observado é o que queremos cadastrar
                else:
                    print("O aluno já está cadastrado.")
                    return
            # Chegou no último nó
            if atual.matricula != aluno.matricula: # se o aluno já não estiver cadastrado:
                atual.proximo = aluno # o antigo último nó começa a apontar para o nó que está sendo inserido
                print("Aluno cadastrado com sucesso!")
            # Caso do aluno já estar cadastrado
            else:
                print("O aluno já está cadastrado.")

    # Método de busca de alunos na tabela
    def buscar_aluno(self, matricula): # passa como parâmetro a matrícula do aluno a ser procurado
        posicao = self.calcular_posicao(matricula) 
        atual = self.lista[posicao]
        # Loop infinito que só termina se o aluno for encontrado ou se perceber que o aluno não existe
        while True:
            # 'atual' só fica None se a posição estiver vazia ou quando passar do último nó dela, e se ela passou do último nó é porque o aluno não existe
            if atual is None:
                print("Aluno não encontrado.")
                break
            # Se um nó estiver sendo observado:
            else:
                if atual.matricula != matricula: # se a matrícula dele for diferente da que está sendo procurada:
                    atual = atual.proximo # 'atual' vira o nó que vinha depois do que ele estava observando 
                else: # se a matrícula for igual:
                    print(f"Matricula: {atual.matricula}\nNome: {atual.nome}\nIdade: {atual.idade}")
                    return atual

    # Método para remover um aluno da tabela
    def remover_aluno(self, matricula): # passa como parâmetro a matrícula do aluno a ser removido
        posicao = self.calcular_posicao(matricula)
        # Serão utilizadas duas variáveis para armazenar nós, um que guarda o nó atual e o que guarda o anterior a ele, visto que é necessário guardar este segundo para fazer ele apontar para o que vem depois do 'atual' ao invés do 'atual'
        anterior = self.lista[posicao]
        if anterior is not None: # se a posição não estiver vazia:
            atual = anterior.proximo # é criado o atual
            # Caso 1: o nó a ser removido é o primeiro da posição
            if anterior.matricula == matricula:
                self.lista[posicao] = atual # mudamos diretamente na lista o valor do primeiro nó
                print("Aluno removido com sucesso!")
                return
            # Caso 2: o nó a ser removido pode estar entre o meio e o final da lista
            while True: # loop infinito que só se encerra quando o nó a ser removido é encontrado ou for percebido que ele não existe
                if atual is None: # se o 'atual' chegar no None é porque ele passou do último nó, e se ele passou do último nó é porque o nó a ser removido não existe  
                    print("Aluno não cadastrado.")
                    break
                else: # se não for None:
                    if atual.matricula == matricula: # se ele for o nó que queremos remover:
                        anterior.proximo = atual.proximo # 'anterior' passa a apontar para o próximo de 'atual', desenfileirando 'atual'
                        print("Aluno removido com sucesso!")
                        break
                    else: # se não for o que queremos remover:
                        anterior = atual # 'anterior' passa a ser o nó que vem depois dele
                        atual = atual.proximo # 'atual' passa a ser o nó que vem depois dele
        # A posição está vazia
        else:
            print("Aluno não cadastrado.")

    # Método para mostrar a tabela inteira
    def mostrar_tabela(self): # nenhum parâmetro é necessário
        for posicao in range(self.m): # é feito um laço para iterar todos os itens da lista que representa a tabela
            aluno = self.lista[posicao] # 'aluno' vai armazenar o primeiro nó da posição que está sendo percorrida
            print(f'[{posicao}] -> ', end="") # printa o número da posição
            while aluno is not None: # enquanto não chegar no final da lista:
                print(f'({aluno.matricula} / {aluno.nome} / {aluno.idade}) -> ', end="") # printa as informações do aluno sem quebrar a linha
                aluno = aluno.proximo # 'aluno' passa a ser o nó que vem depois dele
            print('None') # quando printa o último aluno, printa None para representar o final da posição