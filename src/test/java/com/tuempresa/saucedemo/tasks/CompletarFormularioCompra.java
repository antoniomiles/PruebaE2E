package com.tuempresa.saucedemo.tasks;

import com.tuempresa.saucedemo.userinterface.SauceDemoPagina;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompletarFormularioCompra implements Task {

    private String nombre;
    private String apellido;
    private String codigoPostal;

    public CompletarFormularioCompra(String nombre, String apellido, String codigoPostal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoPostal = codigoPostal;
    }

    public static CompletarFormularioCompra conInformacionDeEnvio(String nombre, String apellido, String codigoPostal) {
        return new CompletarFormularioCompra(nombre, apellido, codigoPostal);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombre).into(SauceDemoPagina.INPUT_NOMBRE),
                Enter.theValue(apellido).into(SauceDemoPagina.INPUT_APELLIDO),
                Enter.theValue(codigoPostal).into(SauceDemoPagina.INPUT_CODIGO_POSTAL),
                Click.on(SauceDemoPagina.BOTON_CONTINUAR),
                WaitUntil.the(SauceDemoPagina.BOTON_FINALIZAR, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(SauceDemoPagina.BOTON_FINALIZAR),
                WaitUntil.the(SauceDemoPagina.CONFIRMACION_COMPRA, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}