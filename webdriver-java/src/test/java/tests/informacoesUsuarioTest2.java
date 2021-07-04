package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class informacoesUsuarioTest2 {

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

        //Validar que dentro do elemento com class "me" está com o texto "Hi, Julio"
        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();
        assertEquals("Hi, Julio", textoNoElementoMe);
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario2(){
        //Clicar no link que possui o texto "Sign in"
        WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));
        linkSignIn.click();

        //Identificando o formulário de login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo com name "login" que está dentro do formulário de id "signinbox" o texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0002");

        //Digitar no campo com name "passwor" que está dentro do formulário de id "signinbox" o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("654321");

        //Clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        //Validar que dentro do elemento com class "me" está com o texto "Hi, Julio"
        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();
        assertEquals("Hi, Julio", textoNoElementoMe);
    }

    @AfterEach
    public void tearDown(){
        //Fechar todas as abas do navegador
        navegador.quit();
        //Fechar somente a aba que estiver aberta, caso tenha muitas abas
        //navegador.close();
    }
}
