# vacina-brasil
Demo project


Necessita o docker instalado. Rodar imagem do banco com o comando
```sudo docker-compose -f stack.yml up```


  **Endpoint para método post de Usuario**
http://localhost:8080/usuarios
  Recebe os campos:
  - name
  - cpf
  - age
  - email
  

  **Endpoint para método post de Vacina**
http://localhost:8080/vacinas
  Recebe os campos:
  - vaccineName (número 1 para CORONAVAC, número 2 para ASTRAZENECA)
  - Objeto Usuario com campo "id" (usuario deve estar previamente cadastrado)

Comando para rodar todos os testes:
```mvn test -Pintegration-tests```
