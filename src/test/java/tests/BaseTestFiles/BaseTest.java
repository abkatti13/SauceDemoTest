package tests.BaseTestFiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver = null;
    public LoginPage login;
    Properties properties = new Properties();

    @Test
    private WebDriver initializeDriver() throws IOException {
        properties.load(new FileInputStream("src/main/java/resources/GlobalData.properties"));
        String browserName = properties.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }


    @BeforeMethod(alwaysRun = true)
    public LoginPage loadApplication() throws IOException {
        driver = initializeDriver();
        login = new LoginPage(driver);
        login.goTo(properties.getProperty("url"));
        return login;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }

    public String getscreenshot(String testcaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(System.getProperty("user.dir")+"\\reports\\Screenshots"+testcaseName+".png");
        FileUtils.copyFile(source, targetFile);
        return System.getProperty("user.dir")+"\\reports\\Screenshots"+testcaseName+".png";
    }
}
