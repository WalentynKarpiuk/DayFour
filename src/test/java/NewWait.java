import io.netty.channel.WriteBufferWaterMark;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewWait extends TestBase {
    @Test
    public void verifyDragAndDrop() {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement click = driver.findElement(By.id("delayed-alert"));
        click.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

}