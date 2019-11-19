package hhParser.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class VakancyListPage extends Page {

    public VakancyListPage(WebDriver driver) {
        super(driver);
    }
    private By orderBy = By.cssSelector(".search-filters__item select");
    private By vacancyName = By.cssSelector(".resume-search-item__name");
    private String orderByDate = "publication_time";
    private List<WebElement> vacancyNamesList;
    private Iterator<WebElement> vakancyIterator;

    public void orderByDate(){
        Select selectOrderBy = new Select(driver.findElement(orderBy));
        selectOrderBy.selectByValue(orderByDate);
    }

    // добавить перелистывание страниц

    public void setVacancyNamesList() {
        vacancyNamesList = driver.findElements(vacancyName);
        vakancyIterator  = vacancyNamesList.iterator();
    }

    public boolean hasNextVacancy() { return vakancyIterator.hasNext(); }

    public void openNextVacancy() {
        vakancyIterator.next().click();
    }
}
