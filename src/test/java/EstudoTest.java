import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;

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


    //TESTE
    @Test
    @DisplayName("Teste realizado no caminho feliz com sucesso.")
    public void testCadastroSimplesComDadosValidos() {
        driver.findElement(By.linkText("Cadastre-se")).click();
        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys("valter311");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("menninni211@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("a11111111");
        driver.findElement(By.id("administrador")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.linkText("Listar")).click();

    }
}