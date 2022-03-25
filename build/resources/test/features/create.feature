# new feature
# Tags: optional

Feature: Creacion de usuario
  como posible usuario del sistema
  deseo validar que la operacion de crear usuario
  para saber que se puede hacer de manera correcta

  Scenario: create exitoso
    Given cuando el usuario hace un peticion create
    When el usuario hace la peticion con el name "morpheus" y el job "leader"
    Then el usuario debera ver el codigo de respuesta exitosa

