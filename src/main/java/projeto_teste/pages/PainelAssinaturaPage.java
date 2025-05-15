package projeto_teste.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PainelAssinaturaPage {

    private WebDriver driver;

    public PainelAssinaturaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrirPainelDeAssinatura() {
        driver.findElement(By.xpath("//i[@class='fa fa-bars fa-1x']")).click();
        driver.findElement(By.cssSelector("a[href='https://applications.fsbr.com.br/homolog/assine--frontend/usuario/assinatura-eletronica']")).click();


    
}
}

