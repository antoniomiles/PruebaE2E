Feature: Compra de productos en SauceDemo

  Scenario: Realizar una compra exitosa
    Given que el usuario se autentica con el usuario "standard_user" y contraseña "secret_sauce"
    When agrega dos productos al carrito
    And visualiza el carrito
    And completa el formulario de compra
    Then finaliza la compra con éxito