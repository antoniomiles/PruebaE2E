package com.tuempresa.saucedemo.tasks;

import com.tuempresa.saucedemo.userinterface.SauceDemoPagina;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VisualizarCarrito implements Task {

    public static VisualizarCarrito deCompra() {
        return new VisualizarCarrito();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SauceDemoPagina.BOTON_CARRITO),
                WaitUntil.the(SauceDemoPagina.BOTON_CARRITO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(SauceDemoPagina.BOTON_CARRITO),
                WaitUntil.the(SauceDemoPagina.BOTON_IR_A_CHECKOUT, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(SauceDemoPagina.BOTON_IR_A_CHECKOUT),
                // Agregar una espera adicional para asegurarse de que la página del carrito se cargue completamente
                WaitUntil.the(SauceDemoPagina.BOTON_CONTINUAR, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
