package projeto_teste;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;

import java.time.Duration;

public class LoginTest {

    @Test
    @DisplayName("Fazer Login na aplicação")
    public void fazerLogin() {

        // Carrega variáveis do .env localmente (ignora se arquivo não existir)
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        // Pega as variáveis do sistema primeiro, se não tiver, usa do .env
        String email = System.getenv("LOGIN_EMAIL");
        if (email == null) {
            email = dotenv.get("LOGIN_EMAIL");
        }

        String senha = System.getenv("LOGIN_SENHA");
        if (senha == null) {
            senha = dotenv.get("LOGIN_SENHA");
        }

        if (email == null || senha == null) {
            throw new IllegalStateException("LOGIN_EMAIL e LOGIN_SENHA não definidos");
        }

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // rodar sem UI
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://applications.fsbr.com.br/homolog/assine--frontend/");

        driver.findElement(By.xpath("//body/header/div[@class='buttons-header']/a[1]")).click();

        driver.findElement(By.cssSelector("#login")).sendKeys(email);
        driver.findElement(By.cssSelector("#senha")).sendKeys(senha);
        driver.findElement(By.xpath("//button[normalize-space()='Entrar']")).click();

        driver.quit();
    }
}
