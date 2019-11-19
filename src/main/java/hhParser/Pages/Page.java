package hhParser.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected boolean existsElement(By locator) {
        try {
            driver.findElement(locator);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    protected WebElement waitVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10, 100);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected WebElement waitClicable(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10, 100);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
