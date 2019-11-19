package hhParser;

import hhParser.Helpers.WindowHelper;
import hhParser.Pages.CatalogPage;
import hhParser.Pages.StartPage;
import hhParser.Pages.VakancyListPage;
import hhParser.Pages.VakancyPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@Getter
public class ApplicationManager {

    private WebDriver driver;

    private StartPage startPage;
    private CatalogPage catalogPage;
    private VakancyListPage vakancyListPage;
    private WindowHelper windowHelper;
    private VakancyPage vakancyPage;


    public ApplicationManager() {

        this.driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        startPage = new StartPage(driver);
        catalogPage = new CatalogPage(driver);
        vakancyListPage = new VakancyListPage(driver);
        windowHelper = new WindowHelper(driver);
        vakancyPage = new VakancyPage(driver);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}
