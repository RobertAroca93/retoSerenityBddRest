# new feature
# Tags: optional

Feature: consultar posts
  yo como usuario de la pagina web place holder
  deseo consultar los post realizados
  para conocer la opinion de los usuarios



  Scenario: consulta exitosa
    Given dado que me encuentro en la pagina web
    When deseo hacer la consulta de los post realizados
    Then el usuario debera ver el codigo de respuesta exitoso

  Scenario: consulta exitosa de informacion de un usuario
    Given dado que me encuentro dentro de la pagina web
    When deseo hacer la consulta de la informacion del userId2
    Then el usuario debera ver el codigo de respuesta correcta


