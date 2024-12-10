package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonUtils;

public class LoginPage extends CommonUtils {


    private WebDriver driver;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ProductCatalogue loginAction(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new ProductCatalogue(driver);
    }

    public String getErrorText(){
        return driver.findElement(errorMessage).getText();
    }

    public void goTo(String url){
        driver.get(url);
    }

    public String loginActionErrorValidation(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return driver.findElement(errorMessage).getText();
    }
}
