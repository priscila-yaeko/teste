package projeto_teste.pages;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private Dotenv dotenv;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.dotenv = Dotenv.configure().ignoreIfMissing().load();
    }

    public void fazerLogin() {
        String email = System.getenv("LOGIN_EMAIL");
        if (email == null) email = dotenv.get("LOGIN_EMAIL");

        String senha = System.getenv("LOGIN_SENHA");
        if (senha == null) senha = dotenv.get("LOGIN_SENHA");

        if (email == null || senha == null) {
            throw new IllegalStateException("LOGIN_EMAIL e LOGIN_SENHA não definidos");
        }

        driver.findElement(By.xpath("//body/header/div[@class='buttons-header']/a[1]")).click();
        driver.findElement(By.cssSelector("#login")).sendKeys(email);
        driver.findElement(By.cssSelector("#senha")).sendKeys(senha);
        driver.findElement(By.xpath("//button[normalize-space()='Entrar']")).click();
    }
}
