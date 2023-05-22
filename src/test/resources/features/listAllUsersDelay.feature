#language: pt
Funcionalidade: Listar test delay

  Cenario: Listar Users delay com sucesso
    Quando eu executo a listagem com delay de todos users
    Entao devo receber HttpStatus 200
    E a resposta da requisicao deve estar de acordo com o schema "LISTAR_ALL_USERS_DELAY"

