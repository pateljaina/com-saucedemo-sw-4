package com.saucedemo.www.pages;

import com.saucedemo.www.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage extends Utility {
    By productsText = By.xpath("//span[contains(text(),'Products')]");

    public String getProductText() {
        return getTextFromElement(productsText);
    }

    public int getFindActualNumberOfProducts() {
        List<WebElement> productNo = driver.findElements(By.className("inventory_item"));
        // int totalProducts = productNo.size();

        return productNo.size();
    }
}
