package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonUtils;

public class CartPage extends CommonUtils {

    WebDriver driver;
    private By pageTitle = By.className("title");
    private By productName = By.cssSelector(".inventory_item_name");
    private By productPrice = By.cssSelector(".inventory_item_price");

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getCartPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public String getProductNameInCart(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(productName).getText();
    }

    public String getProductPriceInCart(){
        return driver.findElement(productPrice).getText();
    }
}
