#language: pt
Funcionalidade: Criar User Test

  Esquema do Cenario: Criar User com sucesso
    Dado que possua "<name>" e "<job>" validos
    Quando eu executo a criacao de um user
    Entao devo receber HttpStatus 201
    E criar o usuario com sucesso
    E a resposta da requisicao deve estar de acordo com o schema "CRIAR_USER_RESOURCES"

    Exemplos:
      | name     | job    |
      | morpheus | leader |
