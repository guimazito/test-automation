package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class informacoesUsuarioTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","D:\\Dados\\DOCUMENTOS\\Cursos\\Udemy - Automação de Testes com Selenium WebDriver em Java\\Ambiente\\chromedriver_win32\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando para a página do Taskit!
        navegador.get("http://www.juliodelima.com.br/taskit");

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

        //Validar que dentro do elemento com class "me" está com o texto "Hi, Julio"
        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();
        assertEquals("Hi, Julio", textoNoElementoMe);

        //Fechar todas as abas do navegador
        navegador.quit();

        //Fechar somente a aba que estiver aberta, caso tenha muitas abas
        //navegador.close();
    }
}
