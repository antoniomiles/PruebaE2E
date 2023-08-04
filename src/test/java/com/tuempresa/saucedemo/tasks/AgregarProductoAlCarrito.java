package com.tuempresa.saucedemo.tasks;
import com.tuempresa.saucedemo.userinterface.SauceDemoPagina;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarProductoAlCarrito implements Task {

    private String producto1;
    private String producto2;

    public AgregarProductoAlCarrito(String producto1, String producto2) {
        this.producto1 = producto1;
        this.producto2 = producto2;
    }

    public static AgregarProductoAlCarrito deReferencias(String producto1, String producto2) {
        return new AgregarProductoAlCarrito(producto1, producto2);
    }

    public static AgregarProductoAlCarrito dosProductos() {
        return new AgregarProductoAlCarrito("Sauce Labs Backpack", "Sauce Labs Bike Light");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SauceDemoPagina.NOMBRE_PRODUCTO.of(producto1)),
                Click.on(SauceDemoPagina.BOTON_AGREGAR_AL_CARRITO),
                WaitUntil.the(SauceDemoPagina.BOTON_REMOVER_DEL_CARRITO.of(producto1), isVisible()).forNoMoreThan(10).seconds()
        );

        actor.attemptsTo(
                Scroll.to(SauceDemoPagina.NOMBRE_PRODUCTO.of(producto2)),
                Click.on(SauceDemoPagina.BOTON_AGREGAR_AL_CARRITO),
                WaitUntil.the(SauceDemoPagina.BOTON_REMOVER_DEL_CARRITO.of(producto2), isVisible()).forNoMoreThan(10).seconds()
        );
    }
}