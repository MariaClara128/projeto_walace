from hash import Aluno, TabelaHash # importando as duas classes

tabela = TabelaHash(m=11) # instanciando a tabela passando como parâmetro 11 que é o Mod do enunciado

# Função responsável por permitir apenas a entrada de valores inteiros 
def ler_inteiro(mensagem): # tem como parâmetro a mensagem do input
    while True: # loop infinito que só se encerra quando for digitado um número inteiro
        try:
            numero = int(input(mensagem))
            return numero # é retornado o número que foi digitado
        except ValueError: # caso dê um erro de tipagem na entrada do dado:
            print("Digite um número inteiro.") # printa uma mensagem e repete o input

while True: # loop infinito que só se encerra quando for selecionada a opção de encerrar o sistema
    opcao = '' # "inicialização" da variável para que o segundo loop se inicie
    while opcao not in ['1','2','3','4','5']: # só é possível digitar um número que está dentro das opções
        opcao = input("Escolha a ação que você quer realizar: \n[1] Inserir novo aluno\n[2] Buscar aluno\n[3] Remover aluno\n[4] Exibir todos os alunos cadastrados\n[5] Encerrar sistema\n")
        if opcao not in ['1','2','3','4','5']:
            print(f"Essa opção não existe, tente novamente.")

    # Inserção do aluno
    if opcao == '1':
        matricula = ler_inteiro(mensagem="Matrícula: ") # entrada da matrícula
        nome = input("Nome: ") # entrada do nome
        idade = ler_inteiro(mensagem="Idade: ") # entrada da idade
        novo_aluno = Aluno(matricula, nome, idade) # instancia a classe Aluno
        tabela.inserir_aluno(novo_aluno) # chama o método de inserção passando como argumento o novo aluno criado

    # Buscar um aluno
    elif opcao == '2':
        matricula = ler_inteiro(mensagem="Matrícula do aluno: ") 
        tabela.buscar_aluno(matricula) # chama o método de busca e passa como argumento a matrícula

    # Remoção de aluno
    elif opcao == '3':
        matricula = ler_inteiro(mensagem="Matrícula do aluno: ") 
        tabela.remover_aluno(matricula) # chama o método de remoção e passa como argumento a matrícula

    # Mostrar a tabela
    elif opcao == '4':
        tabela.mostrar_tabela() # chama o método de amostra

    # Finalização do sistema
    elif opcao == '5':
        print("Fechando sistema...")
        break # finaliza o loop infinito