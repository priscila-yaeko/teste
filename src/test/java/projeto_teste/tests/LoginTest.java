package projeto_teste.tests;

import io.qameta.allure.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import projeto_teste.pages.LoginPage;

import java.time.Duration;

@Epic("Login")
@Feature("Tela de Login")
public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://applications.fsbr.com.br/homolog/assine--frontend/");

        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Story("Login com credenciais válidas")
    @DisplayName("Fazer Login na aplicação")
    @Description("Teste que faz login com email e senha vindos do arquivo .env ou variáveis de ambiente")
    @Severity(SeverityLevel.CRITICAL)
    public void fazerLogin() {
        loginPage.fazerLogin(); // ✅ agora funciona corretamente
    }
}
