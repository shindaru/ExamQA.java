import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRegistrationForm(String firstName, String lastName, String email, String telephone, String password) {
        driver.findElement(By.id("input-firstname")).sendKeys(firstName);
        driver.findElement(By.id("input-lastname")).sendKeys(lastName);
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(telephone);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(password);
        driver.findElement(By.name("agree")).click();
    }

    public void clickContinueButton() {
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.getPageSource().contains("Your Account Has Been Created!");
    }
}
