#language: pt
Funcionalidade: Listar test

  Cenario: Listar Users com sucesso
    Quando eu executo a listagem de todos users
    Entao devo receber HttpStatus 200
    E a resposta da requisicao deve estar de acordo com o schema "LISTAR_ALL_USERS"

  Cenario: Listar Sigle User com sucesso
    Dado que envie request com user valido
    Quando eu executo a listagem dos users por IdCliente
    Entao devo receber HttpStatus 200
    E a resposta da requisicao deve estar de acordo com o schema "LISTAR_SINGLE_USER"
    E listar os dados do usuario com sucesso

  Cenario: Listar Sigle User Invalido
    Dado que envie request com user invalido
    Quando eu executo a listagem dos users por IdCliente
    Entao devo receber HttpStatus 404
    E devo receber o response vazio

  Cenario: Listar All Resources com sucesso
    Quando eu executo a listagem dos recursos
    Entao devo receber HttpStatus 200
    E a resposta da requisicao deve estar de acordo com o schema "LISTAR_ALL_RESOURCES"
    E listar todos os recursos com sucesso

  Cenario: Listar Single Resources com sucesso
    Dado que envie request com user valido
    Quando eu executo a listagem dos recursos por IdCliente
    Entao devo receber HttpStatus 200
    E a resposta da requisicao deve estar de acordo com o schema "LISTAR_SINGLE_RESOURCES"
    E listar todos os recursos do usuario com sucesso

  Cenario: Listar Single Resources Invalido
    Dado que envie request com user invalido
    Quando eu executo a listagem dos recursos por IdCliente
    Entao devo receber HttpStatus 404
    E devo receber o response vazio
