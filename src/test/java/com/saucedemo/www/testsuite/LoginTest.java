package com.saucedemo.www.testsuite;

import com.saucedemo.www.pages.InventoryPage;
import com.saucedemo.www.pages.LoginPage;
import com.saucedemo.www.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    private InventoryPage inventoryPage1;

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        loginPage.enterUserNameField("standard_user");
        loginPage.enterPasswordField("secret_sauce");
        loginPage.clickOnLoginButton();
        String actualMessage = inventoryPage.getProductText();
        Assert.assertEquals(actualMessage, "Products", "error");
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        loginPage.enterUserNameField("standard_user");
        loginPage.enterPasswordField("secret_sauce");
        loginPage.clickOnLoginButton();
        int actualMessage = inventoryPage.getFindActualNumberOfProducts();
        int expected = 6;
        Assert.assertEquals(actualMessage, expected, "error");
    }
}
