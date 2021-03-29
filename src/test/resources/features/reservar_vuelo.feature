Feature: Reservar Vuelo
  Yo como cliente
  Quiero reservar un vuelo
  para obtener el vuelo mas barato


  Scenario: Buscar vuelo mas barato
    Given quiero ingresar a la pagina para buscar un vuelo
    When ingreso los datos para buscar y selecciono el mas barato
    Then deberia poder continuar con el vuelo mas barato

