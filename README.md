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
  - vaccineName
  - Objeto Usuario com campo "id"

Comando para rodar todos os testes:
```mvn test -Pintegration-tests```
