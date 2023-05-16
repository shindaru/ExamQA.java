import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Random;


import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    private WebDriver driver;
    private HomePage homePage;
    private RegistrationPage registrationPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://shop.pragmatic.bg/admin");

        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testRegistration() {
        driver.get("http://shop.pragmatic.bg");

        homePage.clickMyAccountLink();

        homePage.clickRegister();

        registrationPage.fillRegistrationForm("John", "Doe", generateRandomEmail(), "1234567890", "password");

        registrationPage.clickContinueButton();

        Assert.assertTrue(registrationPage.isSuccessMessageDisplayed(), "The success message is incorrect or not found.");
    }

    private String generateRandomEmail() {
        String baseEmail = "johndoe";
        int randomNumber = new Random().nextInt(1000);
        return baseEmail + randomNumber + "@example.com";
    }
}
