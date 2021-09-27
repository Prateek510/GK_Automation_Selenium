package StepDefinition;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Hook {
     public static WebDriver driver;
     public static Properties prop;
     @Before
    public void setup(){
        System.out.println("Before login scenario");
        //System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Resources1\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void get_URL() throws IOException, InterruptedException {
        prop=new Properties();
        FileInputStream instream=new FileInputStream("src/test/resources/Config.properties");
        prop.load(instream);
        driver.get(prop.getProperty("Saucedemo_URL"));
        Thread.sleep(3000);
        try {
            Assert.assertEquals(driver.getTitle(), "Swag Labs");
            System.out.println("The user is navigated to the correct URL");
        }
               catch(AssertionError e){
                   e.printStackTrace();
               }
            }

            @After
    public void teardown(){
         driver.quit();
            }

    }

