#language: pt
Funcionalidade: Fazer Login Test

  Esquema do Cenario: Fazer Login
    Dado que possua "<email>" e "<password>"
    Quando eu faco login
    Entao devo receber HttpStatus <status>

    Exemplos:
      | email                      | password | status |
      | eve.holt@reqres.in         | pistol   | 200    |
      | user_not_found@89878775.in | 123456   | 400    |

  Cenario: Enviar request null
    Quando eu executo a criacao de um login sem password
    Entao devo receber HttpStatus 400
    E deve apresentar msg da ausencia do password

