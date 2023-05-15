#language: pt
Funcionalidade: Deletar test

  Cenario: Listar Users com sucesso
    Dado que envie request com user valido
    Quando eu executo a delecao de um users por IdCliente
    Entao devo receber HttpStatus 204



