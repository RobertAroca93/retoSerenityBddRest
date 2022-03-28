# new feature
# Tags: optional

Feature: Creacion de usuario
  como posible usuario de la pagina
  deseo crear mi usuario en el sistema
  para poder hacer uso de los servicios que esta ofrece

  Scenario: create exitoso
    Given cuando el usuario hace un peticion create
    When el usuario hace la peticion con el name "morpheus" y el job "leader"
    Then el usuario debera ver el codigo de respuesta exitosa

  Scenario: create exitoso solo con el nombre
    Given dado que el usuario hace una peticion create
    When el usuario realiza el create solo con el name "morpheus"
    Then el usuario debera ver tambien el codigo de respuesta exitoso

