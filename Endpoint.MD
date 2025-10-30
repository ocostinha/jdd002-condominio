# API Condomino

Esta API servirá para gerencia o cadastro dos condominos

## Funcionalidades:

### Cadastrar condomino

#### Resorce: 
/condomino

#### Método:
POST

#### Contrato de Entrada:
* Nome Completo*
* CPF*
* Email
* Telefone
* Bloco*
* Apartamento*

#### Response Status Code:
* 201 - Created
* 400 - BadRequest (Validação do contrato)
* 422 - Unprocessable Entity (Validar se o CPF já está cadastrado)

#### Contrato de Saída:
* ID
* Nome Completo
* CPF
* Email
* Telefone
* Bloco
* Apartamento

### Atualizar condomino

#### Resorce:
/condomino/{id}

#### Método:
PUT

#### Contrato de Entrada:
* Nome Completo*
* Email
* Telefone
* Bloco*
* Apartamento*

#### Response Status Code:
* 200 - OK
* 400 - BadRequest
* 404 - Not Found

#### Contrato de Saída:
* ID
* Nome Completo
* CPF
* Email
* Telefone
* Bloco
* Apartamento

### Consultar condomino com filtros

#### Resorce:
/condomino/filtros

#### Parametros:
* nome
* cpf
* bloco
* apartamento

#### Método:
GET

#### Contrato de Entrada:
Não Aplicavel

#### Response Status Code:
* 200 - OK
* 204 - No Content / 404 - Not Found

#### Contrato de Saída:
Array [
* ID
* Nome Completo
* CPF
* Email
* Telefone
* Bloco
* Apartamento]

### Consultar listagem de condominos

#### Resorce:
/condomino

#### Método:
GET

#### Contrato de Entrada:
Não Aplicavel

#### Response Status Code:
200 - OK

#### Contrato de Saída:
Array [
* ID
* Nome Completo
* CPF
* Email
* Telefone
* Bloco
* Apartamento]

### Deletar condomino

#### Resorce:
/condomino/{id}

#### Método:
DELETE

#### Contrato de Entrada:
Não Aplicavel

#### Response Status Code:
200 - OK / 202 - Accepted / 204 - No Content
400 - Bad Request
404 - Not Found / 422 - Unprocessable Entity

#### Contrato de Saída:
Não Aplicavel 

