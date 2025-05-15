package projeto_teste;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTeste {

    @Test
    @DisplayName("Fazer Login na aplicação")
    public void fazerLogin() {
        WebDriver driver = new ChromeDriver(); // Exemplo com ChromeDriver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://applications.fsbr.com.br/homolog/assine--frontend/");
        

        driver.findElement(By.xpath("//body/header/div[@class='buttons-header']/a[1]")).click();

        driver.findElement(By.cssSelector("#login")).sendKeys("priscila.cunha@fsbr.com.br");
        driver.findElement(By.cssSelector("#senha")).sendKeys("Billy@2436");
        driver.findElement(By.xpath("//button[normalize-space()='Entrar']")).click();

        // Fechar o navegador após o teste (opcional, mas recomendado)
        driver.quit();
    }
}
