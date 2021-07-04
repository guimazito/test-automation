package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class informacoesUsuarioTest3 {

    private WebDriver navegador;

    @BeforeEach
    public void setUp(){
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","D:\\Dados\\DOCUMENTOS\\Cursos\\Udemy - Automação de Testes com Selenium WebDriver em Java\\Ambiente\\chromedriver_win32\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Navegando para a página do Taskit!
        navegador.get("http://www.juliodelima.com.br/taskit");
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        //Clicar no link que possui o texto "Sign in"
        WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));
        linkSignIn.click();

        //Identificando o formulário de login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo com name "login" que está dentro do formulário de id "signinbox" o texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        //Digitar no campo com name "passwor" que está dentro do formulário de id "signinbox" o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        //Clicar em um link que possui a class "me"
        navegador.findElement(By.className("me")).click();

        //Clicar em um link que possui "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        //Clicar no botão através do seu xpath //button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //Identificar a popup onde está o formulário de id addmoredata
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        //Na combo de name "type" escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");

        //No campo de name "contact" digitar "+5511888888888"
        popupAddMoreData.findElement(By.name("contact")).sendKeys("+5592888888888");

        //Clicar no link de text "SAVE" que está na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        //Na mensagem de id "toast-container" validar que o texto "Your contact has been added!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals("Your contact has been added!", mensagem);
    }

    @AfterEach
    public void tearDown(){
        //Fechar todas as abas do navegador
        //navegador.quit();
        //Fechar somente a aba que estiver aberta, caso tenha muitas abas
        //navegador.close();
    }
}
