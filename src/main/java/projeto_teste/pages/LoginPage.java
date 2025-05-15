package projeto_teste.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By btnEntrarHome = By.xpath("//body/header/div[@class='buttons-header']/a[1]");
    private By inputEmail = By.cssSelector("#login");
    private By inputSenha = By.cssSelector("#senha");
    private By btnEntrar = By.xpath("//button[normalize-space()='Entrar']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Métodos para interagir com a página

    public void clicarEntrarHome() {
        driver.findElement(btnEntrarHome).click();
    }

    public void preencherEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void preencherSenha(String senha) {
        driver.findElement(inputSenha).sendKeys(senha);
    }

    public void clicarBotaoEntrar() {
        driver.findElement(btnEntrar).click();
    }

    // Método para realizar o login completo
    public void fazerLogin(String email, String senha) {
        clicarEntrarHome();
        preencherEmail(email);
        preencherSenha(senha);
        clicarBotaoEntrar();
    }
}
