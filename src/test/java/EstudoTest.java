import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

//CLASSES
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Teste de login")


public class EstudoTest {
    String nomeUser =  "menin";
    String nomeEmail = "menninni4@gmail.com";
    String nomeEmailErr = "menninnixyz@gmail.com";
    String textSenha = "a123";

    //ATRIBUTOS

    private static WebDriver driver;

    //FUNÇÕES, MÉTODOS

    //ANTES DO TESTE
    @BeforeAll
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
    }


    @BeforeEach
    public void padraoCarregamento () {

        //System.setProperty("webdriver.edge.driver", "src/test/driver/msedgedriver.exe");
        driver = new ChromeDriver();
        //driver = new EdgeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://front.serverest.dev/login");
    }


    //DEPOIS DO TESTE
    @AfterAll
    public static void tearDown() {
        System.out.println("Teste Finalizado!!!");
        driver.quit();
    }


    //TESTE 1
    @Test
    @Order(1)
    @DisplayName("Teste realizado!")
    public void testCadastroSimplesComDadosValidos() {
        //assertThat(driver.findElement(By.linkText("Cadastre-se")).getText(), is("Cadastre-se"));
        driver.findElement(By.linkText("Cadastre-se")).click();
        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys(nomeUser);
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys(nomeEmail);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys(textSenha);
        driver.findElement(By.id("administrador")).click();
        //assertEquals("Cadastrar", driver.findElement(By.cssSelector(".btn-primary")).getText(),"Texto esperado, 'Cadastrar' mas foi exibido outro texto");
        driver.findElement(By.cssSelector(".btn-primary")).click();
        assertEquals("Cadastro realizado com sucesso", driver.findElement(By.cssSelector("a.alert-link")).getText(),"Texto esperado, 'Cadastro realizado com sucesso' mas foi exibido outro texto");
        }

    //TESTE 2
    @Test
    @Order(2)
    @DisplayName("Teste realizado! Email já existente...")
    public void testCadastroComDadosJaUtilizados() {

         String lTexto0 = "Este email já está sendo usado";

        //assertThat(driver.findElement(By.linkText("Cadastre-se")).getText(), is("Cadastre-se"));
        driver.findElement(By.linkText("Cadastre-se")).click();
        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys(nomeUser);
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys(nomeEmail);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys(textSenha);
        driver.findElement(By.id("administrador")).click();
     //   assertEquals("Cadastrar", driver.findElement(By.cssSelector(".btn-primary")).getText(),"Texto esperado, 'Cadastrar' mas foi exibido outro texto");
        driver.findElement(By.cssSelector(".btn-primary")).click();
        String lTexto2 = driver.findElement(By.cssSelector("div.alert.alert-secondary.alert-dismissible")).getText();
        assertEquals(lTexto0.replaceAll("[^a-zA-Z0-9\\\\s]", ""), lTexto2.replaceAll("[^a-zA-Z0-9\\\\s]", ""),"Texto esperado, 'Este email já está sendo usado' mas foi exibido outro texto");
    }
    //TESTE 3
    @Test
    @Order(3)
    @DisplayName("Teste realizado con login já cadastrado...")
    public void testLoginCaminhoFeliz() {
        driver.findElement(By.id("email")).sendKeys(nomeEmail);
        driver.findElement(By.id("password")).sendKeys(textSenha);
        driver.findElement(By.cssSelector("[data-testid='entrar']")).click();
        assertEquals("Este é seu sistema para administrar seu ecommerce.", driver.findElement(By.cssSelector("p.lead")).getText(),"Texto esperado, 'Este é seu sistema para administrar seu ecommerce.' mas foi exibido outro texto");

    }

    //TESTE 4
    @Test
    @Order(4)
    @DisplayName("Teste realizado con login não cadastrado...")
    public void testLoginDadosInvalidos() {
        String lTexto0 = "Email e/ou senha inválidos";
        driver.findElement(By.id("email")).sendKeys(nomeEmailErr);
        driver.findElement(By.id("password")).sendKeys(textSenha);
        driver.findElement(By.cssSelector("[data-testid='entrar']")).click();
        String lTexto2 = driver.findElement(By.cssSelector("div.alert.alert-secondary.alert-dismissible")).getText();
        assertEquals(lTexto0.replaceAll("[^a-zA-Z0-9\\\\s]", ""), lTexto2.replaceAll("[^a-zA-Z0-9\\\\s]", ""),"Texto esperado, 'Email e/ou senha inválidos' mas foi exibido outro texto");
        //System.out.println(lTexto0.replaceAll("[^a-zA-Z0-9\\\\s]", "") + lTexto2.replaceAll("[^a-zA-Z0-9\\\\s]", ""));
    }
}

