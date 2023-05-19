#language: pt
Funcionalidade: Criar Email Test

  Esquema do Cenario: Criar Email User valido
    Dado que possua "<email>" e "<password>"
    Quando eu executo a criacao de um email
    Entao devo receber HttpStatus <status>

    Exemplos:
      | email              | password | status |
      | eve.holt@reqres.in | pistol   | 201    |
      | 123456@89878775.in | 123456   | 201    |

  Cenario: Criar Email User invalido
    Quando eu executo a criacao de um email sem password
    Entao devo receber HttpStatus 400

