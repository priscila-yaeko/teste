package projeto_teste;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import java.time.Duration;

@Owner("Priscila Yaeko Cunha")
public class LoginTest {

    @Test
    @DisplayName("Fazer Login na aplicação")
    @Description("Testa o login na aplicação com usuário válido e senha válida.")
    @Severity(SeverityLevel.CRITICAL)
    public void fazerLogin() {
        WebDriver driver = setupDriver();

        try {
            abrirPagina(driver);
            clicarBotaoLogin(driver);
            preencherCredenciais(driver);
            clicarBotaoEntrar(driver);
        } finally {
            driver.quit();
        }
    }

    @Step("Configurar WebDriver Chrome headless")
    private WebDriver setupDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    @Step("Abrir página inicial")
    private void abrirPagina(WebDriver driver) {
        driver.get("https://applications.fsbr.com.br/homolog/assine--frontend/");
    }

    @Step("Clicar no botão login")
    private void clicarBotaoLogin(WebDriver driver) {
        driver.findElement(By.xpath("//body/header/div[@class='buttons-header']/a[1]")).click();
    }

    @Step("Preencher as credenciais de login")
    private void preencherCredenciais(WebDriver driver) {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

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

        driver.findElement(By.cssSelector("#login")).sendKeys(email);
        driver.findElement(By.cssSelector("#senha")).sendKeys(senha);
    }

    @Step("Clicar no botão entrar")
    private void clicarBotaoEntrar(WebDriver driver) {
        driver.findElement(By.xpath("//button[normalize-space()='Entrar']")).click();
    }
}
