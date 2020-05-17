import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;


public class GoogleListing {
    private WebDriver driver;
    public GoogleListing(WebDriver driver) {
        this.driver = driver;
    }
    public String searchRequest = "gbsfo";

    private By linkTitle = By.xpath(String.format("// h3[text()=\"%s\"]/parent::a",searchRequest.toUpperCase()));
    private By tools = By.xpath("// a[text()=\"Tools\"]");
    private By resultTime = By.xpath("//div[text()=\"Any time\"]");
    private By lastHour = By.xpath("//a[text()=\"Past hour\"]");
    private By displayLastHour = By.xpath("//div[text()=\"Past hour\"]");



    private void waitAndClick(By xpath){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        driver.findElement(xpath).click();
    }

    public String openLink(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(linkTitle));
        String link = driver.findElement(linkTitle).getAttribute("href");
        String newTabOpener = String.format("window.open(\"%s\",'_blank');",link);
        ((JavascriptExecutor)driver).executeScript(newTabOpener);
        Set<String> tab_handles = driver.getWindowHandles();
        int number_of_tabs = tab_handles.size();
        int new_tab_index = number_of_tabs-1;
        driver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());

        return driver.getTitle();
    }
    public boolean setLastHourResult(){
        waitAndClick(tools);
        waitAndClick(resultTime);
        waitAndClick(lastHour);

        return driver.findElement(displayLastHour).isDisplayed();
    }
}
