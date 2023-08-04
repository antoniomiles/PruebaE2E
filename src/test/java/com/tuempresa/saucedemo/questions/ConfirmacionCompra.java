package com.tuempresa.saucedemo.questions;

import com.tuempresa.saucedemo.userinterface.SauceDemoPagina;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ConfirmacionCompra implements Question<Boolean> {

    public static ConfirmacionCompra exitosa() {
        return new ConfirmacionCompra();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return SauceDemoPagina.CONFIRMACION_COMPRA.resolveFor(actor).isVisible();
    }
}