import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EstudoTest {

    //ATRIBUTOS

    private static WebDriver driver;

    //FUNÇÕES, MÉTODOS

    //ANTES DO TESTE

    @BeforeAll

    public static void setUp() {

        //WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.edge.driver", "src/test/driver/msedgedriver.exe");

        //driver = new ChromeDriver();
        driver = new EdgeDriver();

        driver.manage().window().maximize();

    }



    @BeforeEach

    public void inicioTesteUnico () {

        driver.get("https://front.serverest.dev/login");

    }



    //DEPOIS DO TESTE

    @AfterAll

    public static void tearDown() {

        driver.quit();

    }



    //TESTE

    @Test

    public void test02() {

        driver.findElement(By.linkText("Cadastre-se")).click();

        driver.findElement(By.id("nome")).click();

        driver.findElement(By.id("nome")).sendKeys("menin");

        driver.findElement(By.id("email")).click();

        driver.findElement(By.id("email")).sendKeys("menin2@gmail.com");

        driver.findElement(By.id("password")).click();

        driver.findElement(By.id("password")).sendKeys("asasas");

        driver.findElement(By.id("administrador")).click();

        driver.findElement(By.cssSelector(".btn-primary")).click();

    }

}