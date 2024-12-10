package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CartPage;

import java.time.Duration;

public class CommonUtils {

    WebDriver driver;
    WebDriverWait explicitWait;
    private By breadcrumb = By.id("react-burger-menu-btn");
    private By logout = By.id("logout_sidebar_link");

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //replace below with By locators
        PageFactory.initElements(driver, this);
    }

    public void waitForElementToAppear(By findBy){
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForWebElementToAppear(WebElement element){
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToDissapear(WebElement loadingIcon) throws InterruptedException {
        Thread.sleep(1000);
//        explicitWait.until(ExpectedConditions.invisibilityOf(loadingIcon));
    }

    public void waitForVisibilityOf(WebElement dropDownValues){
        explicitWait.until(ExpectedConditions.visibilityOf(dropDownValues));
    }

    public void logout(){
        driver.findElement(breadcrumb).click();
        driver.findElement(logout).click();
    }

/*    public void exportDataToFile(){

    }*/
}
