package projeto_teste.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import projeto_teste.pages.LoginPage;
import projeto_teste.pages.PainelAssinaturaPage;
import projeto_teste.setup.BaseTest;

@Epic("Painel de Assinatura")
@Feature("Visualizar a Assinatura salva na aplicação")
public class PainelAssinatura extends BaseTest {

    private LoginPage loginPage;
    private PainelAssinaturaPage painelAssinaturaPage;

    @BeforeEach
    public void setup() {
        super.setup();
        loginPage = new LoginPage(driver);
        painelAssinaturaPage = new PainelAssinaturaPage(driver);
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
    }

    @Test
    @Story("Acessar o painel de assinatura")
    @DisplayName("Acessar o painel de assinatura")
    @Description("Teste que acessa o painel de assinatura após fazer login")
    @Severity(SeverityLevel.NORMAL)

    
    public void acessarPainelDeAssinatura() {
        loginPage.fazerLogin(); // usando dados do .env
        painelAssinaturaPage.abrirPainelDeAssinatura(); // ação do novo PageObject
    }
}
