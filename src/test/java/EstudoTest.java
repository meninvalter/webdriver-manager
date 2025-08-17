import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;

//import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

//CLASSES
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Teste de login")


public class EstudoTest {

    //ATRIBUTOS

    private static WebDriver driver;

    //FUNÇÕES, MÉTODOS

    //ANTES DO TESTE
    @BeforeAll

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.edge.driver", "src/test/driver/msedgedriver.exe");
        driver = new ChromeDriver();
        //driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @BeforeEach
    public void padraoCarregamento () {
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
        driver.findElement(By.id("nome")).sendKeys("valter101");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("menninni101@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("a11111111");
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
        //assertThat(driver.findElement(By.linkText("Cadastre-se")).getText(), is("Cadastre-se"));
        driver.findElement(By.linkText("Cadastre-se")).click();
        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys("valter102");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("menninni1020@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("a11111111");
        driver.findElement(By.id("administrador")).click();
        //assertEquals("Cadastrar", driver.findElement(By.cssSelector(".btn-primary")).getText(),"Texto esperado, 'Cadastrar' mas foi exibido outro texto");
        driver.findElement(By.cssSelector(".btn-primary")).click();
        assertEquals("Este email já está sendo usado", driver.findElement(By.cssSelector("div.alert.alert-secondary.alert-dismissible")).getText(),"Texto esperado, 'Este email já está sendo usado' mas foi exibido outro texto");

    }
}

