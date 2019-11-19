package hhParser.Helpers;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowHelper {

    private String mainWindowHandler;
    private WebDriver driver;

    public WindowHelper(WebDriver driver){
        this.driver = driver;
        mainWindowHandler = driver.getWindowHandle();
    }

    public void switchToNewWindow() {
        Set<String> allWindowsHandlers = driver.getWindowHandles();

            for (String windowHandler : allWindowsHandlers) {
                if (windowHandler.equals(mainWindowHandler)) continue;
                driver.switchTo().window(windowHandler);
            }
    }

    public void closeСurrentWindow(){
        driver.close();
    }

    public void switchToMainWindow(){
        driver.switchTo().window(mainWindowHandler);
    }


}
