package projeto_teste;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class LoginTest {

    @Test
    @DisplayName("Fazer Login na aplicação")
    public void fazerLogin() {

        WebDriverManager.chromedriver().setup();

       // Configuração do Chrome para rodar em ambiente CI (como GitHub Actions)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Executa sem interface gráfica
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://applications.fsbr.com.br/homolog/assine--frontend/");
        

        driver.findElement(By.xpath("//body/header/div[@class='buttons-header']/a[1]")).click();

        String email = System.getenv("LOGIN_EMAIL");
        String senha = System.getenv("LOGIN_SENHA");
        

        driver.findElement(By.cssSelector("#login")).sendKeys(email);
        driver.findElement(By.cssSelector("#senha")).sendKeys(senha);
        driver.findElement(By.xpath("//button[normalize-space()='Entrar']")).click();

        // Fechar o navegador após o teste (opcional, mas recomendado)
        driver.quit();
    }
}
