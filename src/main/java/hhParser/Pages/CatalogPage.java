package hhParser.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogPage extends Page {

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    private By item = By.cssSelector(".catalog__item-link");
    private By expandAll = By.cssSelector("span.bloko-link-switch.bloko-link-switch_tertiary");

    public void expandAll(){
        driver.findElement(expandAll).click();
    }

    public void selectItem(String itemTitle){
        List<WebElement> itemsList = driver.findElements(item);
        for(WebElement item: itemsList){
            if(item.getText().contains(itemTitle)){
                item.click();
                break;
            }
        }
    }
}

