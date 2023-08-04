package com.tuempresa.saucedemo.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SauceDemoPagina {

    public static final Target INPUT_USUARIO = Target.the("Campo de Usuario").located(By.id("user-name"));
    public static final Target INPUT_CONTRASEÑA = Target.the("Campo de Contraseña").located(By.id("password"));
    public static final Target BOTON_LOGIN = Target.the("Botón de Iniciar Sesión").located(By.id("login-button"));
    public static final Target BOTON_MENU = Target.the("Botón de Menú").located(By.id("react-burger-menu-btn"));

    public static final Target NOMBRE_PRODUCTO = Target.the("Nombre del Producto").locatedBy("//div[contains(@class, 'inventory_item_name')][text()='{0}']");
    public static final Target BOTON_AGREGAR_AL_CARRITO = Target.the("Botón Agregar al Carrito").located(By.xpath("//button[contains(text(),'Add to cart')]"));
    public static final Target BOTON_REMOVER_DEL_CARRITO = Target.the("Botón Remover del Carrito").locatedBy("//div[contains(@class, 'inventory_item_name')][text()='{0}']/ancestor::div[@class='inventory_item']//button[text()='Remove']");

    public static final Target BOTON_CARRITO = Target.the("Botón del Carrito").located(By.className("shopping_cart_link"));
    public static final Target BOTON_CONTINUAR = Target.the("Botón Continuar").located(By.id("continue"));
    public static final Target BOTON_FINALIZAR = Target.the("Botón Finalizar").located(By.id("finish"));
    public static final Target CONFIRMACION_COMPRA = Target.the("Confirmación de Compra").located(By.className("complete-header"));
    public static final Target INPUT_NOMBRE = Target.the("Campo Nombre").located(By.id("first-name"));
    public static final Target INPUT_APELLIDO = Target.the("Campo Apellido").located(By.id("last-name"));
    public static final Target INPUT_CODIGO_POSTAL = Target.the("Campo Código Postal").located(By.id("postal-code"));
    public static final Target BOTON_IR_A_CHECKOUT = Target.the("Botón Ir a Checkout").located(By.id("checkout"));

}