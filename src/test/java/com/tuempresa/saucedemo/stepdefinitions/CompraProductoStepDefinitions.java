package com.tuempresa.saucedemo.stepdefinitions;

import com.tuempresa.saucedemo.questions.ConfirmacionCompra;
import com.tuempresa.saucedemo.tasks.AgregarProductoAlCarrito;
import com.tuempresa.saucedemo.tasks.Autenticarse;
import com.tuempresa.saucedemo.tasks.CompletarFormularioCompra;
import com.tuempresa.saucedemo.tasks.VisualizarCarrito;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CompraProductoStepDefinitions {

    private Actor usuario = Actor.named("Usuario");

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario").wasAbleTo(Open.url("https://www.saucedemo.com/"));
    }

    @Given("^que el usuario se autentica con el usuario \"([^\"]*)\" y contraseña \"([^\"]*)\"$")
    public void queElUsuarioSeAutenticaConUsuarioYContraseña(String usuario, String contraseña) {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario").attemptsTo(Autenticarse.conCredenciales(usuario, contraseña));
    }

    @When("^agrega dos productos al carrito$")
    public void agregaDosProductosAlCarrito() {
        OnStage.theActorCalled("Usuario").attemptsTo(AgregarProductoAlCarrito.dosProductos());
    }

    @When("^visualiza el carrito$")
    public void visualizaElCarrito() {
        OnStage.theActorCalled("Usuario").attemptsTo(VisualizarCarrito.deCompra());
    }

    @When("^completa el formulario de compra$")
    public void completaElFormularioDeCompra() {
        OnStage.theActorCalled("Usuario").attemptsTo(CompletarFormularioCompra.conInformacionDeEnvio("Antonio", "Miles", "12345"));
    }

    @Then("^finaliza la compra con éxito$")
    public void finalizaLaCompraConExito() {

        OnStage.theActorCalled("Usuario").should(seeThat(ConfirmacionCompra.exitosa()));

    }
}
