#language: pt
Funcionalidade: Validar Email Test

  Esquema do Cenario: Validar Email User
    Dado que possua "<email>" e "<password>"
    Quando eu executo a validacao de um email
    Entao devo receber HttpStatus <status>

    Exemplos:
      | email                   | password | status |
      | eve.holt@reqres.in      | pistol   | 200    |
      | no_register@89878775.in | 123456   | 400    |

  Cenario: Enviar request null
    Quando eu executo a validacao de um email sem password
    Entao devo receber HttpStatus 400

