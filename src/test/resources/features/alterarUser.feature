#language: pt
Funcionalidade: Alterar User Test

  Esquema do Cenario: Alterar User com sucesso metodo PUT
    Dado que possua "<name>" e "<job>" validos para alteracao PUT
    Quando eu executo alterar PUT um user
    Entao devo receber HttpStatus 200
    E alterar PUT usuario com sucesso
    E a resposta da requisicao deve estar de acordo com o schema "ALTERAR_USER_RESOURCES"

    Exemplos:
      | name     | job |
      | morpheus | DBA |

  Esquema do Cenario: Alterar User com sucesso metodo PATCH
    Dado que possua "<name_patch>" e "<job_patch>" validos para alteracao PATCH
    Quando eu executo alterar um user
    Entao devo receber HttpStatus 200
    E alterar PATCH usuario com sucesso
    E a resposta da requisicao deve estar de acordo com o schema "ALTERAR_USER_RESOURCES"

    Exemplos:
      | name_patch | job_patch |
      | priscila   | analist   |
