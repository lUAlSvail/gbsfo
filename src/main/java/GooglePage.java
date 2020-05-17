import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
    private WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }
    private By searchField = By.xpath("//input[@role=\"combobox\"][@type=\"text\"]");
    private By searchButton = By.xpath("//li/following-sibling::div//input[@type=\"submit\"]");

    public GoogleListing searchGoogle(String whatYouSearch){
        driver.get("https://www.google.com/");
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(searchField));
        driver.findElement(searchField).sendKeys(whatYouSearch);
        wait.until(ExpectedConditions.presenceOfElementLocated(searchButton));
        driver.findElement(searchButton).click();
        return new GoogleListing(driver);
    }
}
