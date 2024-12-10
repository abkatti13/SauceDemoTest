package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;
import java.util.List;

public class ProductCatalogue extends CommonUtils {

    public ProductCatalogue(){
        super(null);
    }
    WebDriver driver;

    public String getFirstProductName() {
        return firstProductName;
    }

    public String getFirstProductPrice() {
        return firstProductPrice;
    }

    private String firstProductName = null;
    private String firstProductPrice = null;

    //Multiple matches
    private By productNames = By.className("inventory_item_name");
    //Multiple Matches
    private By productPrice = By.className("inventory_item_price");
    //Single match
    private By addToCartBackpack = By.id("add-to-cart-sauce-labs-backpack");
    //Single match
    private By productsPageTitle = By.className("title");
    private  By productTiles = By.className("inventory_item_description");
    private By cartIcon = By.className("shopping_cart_link");

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getProductsPageTitle(){
       return driver.findElement(productsPageTitle).getText();
    }

    public CartPage goToCart(){
        driver.findElement(cartIcon).click();
        return new CartPage(driver);
    }

    public void addFirstProduct(){

        List<WebElement> productsTilesLocators = driver.findElements(productTiles);

        for(int i=0; i<productsTilesLocators.size();i++){
            firstProductName = productsTilesLocators.get(i).findElement(productNames).getText();
            firstProductPrice = productsTilesLocators.get(i).findElement(productPrice).getText();
            productsTilesLocators.get(i).findElement(addToCartBackpack).click();
            break;
        }

    }
}
