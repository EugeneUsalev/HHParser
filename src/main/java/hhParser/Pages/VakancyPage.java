package hhParser.Pages;

import hhParser.Vacancy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VakancyPage extends Page{

    private By vacancyTitle = By.cssSelector("[data-qa=\"vacancy-title\"]");
    private By vacancySalary = By.cssSelector(".vacancy-salary");
    private By vacancyCompanyName = By.cssSelector(".vacancy-company-name");
    private By vacancyExperience = By.cssSelector("[data-qa=\"vacancy-experience\"]");
    private By vacancyEmploymentMode = By.cssSelector("[data-qa=\"vacancy-view-employment-mode\"]");
    private By vacancyBody = By.cssSelector("[data-qa=\"vacancy-description\"]");
    private By vacancyDate = By.cssSelector(".vacancy-creation-time");


    public VakancyPage(WebDriver driver) {
        super(driver);
    }

    public Vacancy getVacancy() {
        Vacancy vacancy = new Vacancy(
                driver.findElement(vacancyTitle).getText(),
                driver.findElement(vacancySalary).getText(),
                driver.findElement(vacancyCompanyName).getText(),
                driver.findElement(vacancyExperience).getText(),
                driver.findElement(vacancyEmploymentMode).getText(),
                driver.findElement(vacancyBody).getText(),
                driver.findElement(vacancyDate).getText()

        );

        return vacancy;
    }


}
