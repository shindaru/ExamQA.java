import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMyAccountLink() {
        driver.findElement(By.linkText("My Account")).click();
    }
    public void clickRegister(){
        driver.findElement(By.linkText("Register")).click();
    }
}
