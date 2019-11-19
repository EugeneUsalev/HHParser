package hhParser.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage extends Page {

    private By professionsListLink = By.cssSelector("a.bloko-link:nth-child(2)");

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public void goToProfessionList(){
        waitVisible(professionsListLink);
        WebElement element = driver.findElement(professionsListLink);
        element.click();
    }
}
