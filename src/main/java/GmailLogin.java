import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLogin {

    private WebDriver driver;

    public GmailLogin(WebDriver driver) {
        this.driver = driver;
    }



    private By emailField = By.xpath("//input[@type=\"email\"]");
    private By confirmEmail = By.xpath("//div[@id=\"identifierNext\"]");
    private By passwordField = By.xpath("//input[@type=\"password\"][@name=\"password\"]");
    private By confirmPassword = By.xpath("//div[@id=\"passwordNext\"]");

    private void waitAndClick(By xpath){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        driver.findElement(xpath).click();
    }
    public void sendKeys(By xpath,String keys){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        driver.findElement(xpath).sendKeys(keys);

    }
    public GmailLogin loginToGmail(){
        driver.get("https://mail.google.com/");
        sendKeys(emailField,"testingabsoft@gmail.com");
        waitAndClick(confirmEmail);
        sendKeys(passwordField,"Iwillworkforyou");
        waitAndClick(confirmPassword);

        return this;
    }
}
