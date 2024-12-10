package tests.TestFiles;

import helper.BaseTestHelper;
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

public class ErrorValidationTest extends BaseTest {

    @Test(dataProvider = "errorTestDataForLogin", groups = "setup")
    public void validateInvalidLoginUsers(HashMap<String, String> map) throws IOException {
        String message = login.loginActionErrorValidation(map.get("email"),map.get("password"));
        if(map.get("email").contains("locked")){
            Assert.assertEquals(message,"Epic sadface: Sorry, this user has been locked out.");
        }
    }

    @DataProvider
    public Object[][] errorTestDataForLogin() throws IOException {
        List<HashMap<String, String>> dataObjects = DataReader.getJSONDataToMap(System.getProperty("user.dir") + "//resources//testData//testDataError.json");
        return new Object[][]{{dataObjects.get(0)}};
    }


}
