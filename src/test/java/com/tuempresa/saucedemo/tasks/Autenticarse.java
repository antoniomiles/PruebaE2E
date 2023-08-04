package com.tuempresa.saucedemo.tasks;

import com.tuempresa.saucedemo.userinterface.SauceDemoPagina;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Autenticarse implements Task {

    private String usuario;
    private String contraseña;

    public Autenticarse(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public static Autenticarse conCredenciales(String usuario, String contraseña) {
        return new Autenticarse(usuario, contraseña);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(SauceDemoPagina.INPUT_USUARIO),
                Enter.theValue(contraseña).into(SauceDemoPagina.INPUT_CONTRASEÑA),
                Click.on(SauceDemoPagina.BOTON_LOGIN),
                WaitUntil.the(SauceDemoPagina.BOTON_MENU, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}