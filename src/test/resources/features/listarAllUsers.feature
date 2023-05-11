#language: pt
Funcionalidade: Listar teste

  Cenario: Listar teste
    Quando eu executo a listagem de todos users
    Entao devo receber HttpStatus 200
    E a resposta da requisicao deve estar de acordo com o schema "LISTAR_ALL_USERS"

