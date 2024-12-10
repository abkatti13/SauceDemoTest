package tests.TestFiles;
import helper.BaseTestHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.ProductCatalogue;
import tests.BaseTestFiles.BaseTest;
import utils.DataReader;
import utils.WriteToFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PositiveFlow extends BaseTest {

    @Test(dataProvider = "validTestDataForLogin", groups = "setup")
    public void validateProductsAddedtoCartSuccesfully(HashMap<String, String> map) throws IOException {
        ProductCatalogue productCatalogue = login.loginAction(map.get("email"),map.get("password"));
        Assert.assertEquals(productCatalogue.getProductsPageTitle(), "Products" );
        productCatalogue.addFirstProduct();
        List<String> productData = new ArrayList<>();
        productData.add("Product Name: " + productCatalogue.getFirstProductName());
        productData.add("Product Price: " + productCatalogue.getFirstProductPrice());
        String subfolderpath = "resources/outputFile/" + BaseTestHelper.Timestamp();
        BaseTestHelper.CreateFolder(subfolderpath);
        WriteToFile.writeMultipleLinesToFile(subfolderpath+"//"+"Output.txt", productData);
        productData.clear();
        CartPage cartPage = productCatalogue.goToCart();
        Assert.assertEquals(cartPage.getCartPageTitle(),"Your Cart");
        Assert.assertEquals(productCatalogue.getFirstProductName(), cartPage.getProductNameInCart());
        Assert.assertEquals(productCatalogue.getFirstProductPrice(), cartPage.getProductPriceInCart());
        cartPage.logout();
    }


    @DataProvider
    public Object[][] validTestDataForLogin() throws IOException {
        List<HashMap<String, String>> dataObjects = DataReader.getJSONDataToMap(System.getProperty("user.dir")+"//resources//testData//testData.json");
        return new Object[][] {{dataObjects.get(0)},
                {dataObjects.get(1)},
                {dataObjects.get(2)}};
    }
}
