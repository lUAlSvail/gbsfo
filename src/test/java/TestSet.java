import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestSet {
    private WebDriver driver;
    private GooglePage googlePage;
    private GoogleListing googleListing;
    private GmailLogin gmailLogin;
    private ApacheHttp apacheHttp;

    @Before
    public void PreparingToTheTest(){
        System.setProperty("webdriver.chrome.driver", "/home/svail/IdeaProjects/drivers/chromedriver");

        driver = new ChromeDriver();
        googlePage = new GooglePage(driver);
        googleListing = new GoogleListing(driver);
        gmailLogin = new GmailLogin(driver);

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        gmailLogin.loginToGmail();
        googlePage.searchGoogle(googleListing.searchRequest);

    }
    @Test
    public void openLastHourResults(){
        Assert.assertTrue(googleListing.setLastHourResult());
    }
    @Test
    public void openSearchResult(){
        Assert.assertEquals(googleListing.searchRequest.toUpperCase(),googleListing.openLink());
    }

    @After
    public void closeBrowserWindow(){
        driver.quit();
    }
}
