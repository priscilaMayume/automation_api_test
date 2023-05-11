#language: pt
Funcionalidade: Listar test

  Cenario: Listar Users
    Quando eu executo a listagem de todos users
    Entao devo receber HttpStatus 200
    E a resposta da requisicao deve estar de acordo com o schema "LISTAR_ALL_USERS"

  Cenario: Listar Sigle User
    Dado que envie request com user valido
    Quando eu executo a listagem dos users por IdCliente
    Entao devo receber HttpStatus 200
    E a resposta da requisicao deve estar de acordo com o schema "LISTAR_SINGLE_USER"
    E listar os dados do usuario com sucesso

