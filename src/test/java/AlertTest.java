import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AlertTest extends TestBase{

    @Test
    public void shouldFillFormWithSuccess(){
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        // kliknąć w przycisk Prompt Pop up

        WebElement promptAllert = driver.findElement(By.xpath("//button[@id='prompt-alert']"));
        promptAllert.click();

        // w alercie wpisz: Jan
        driver.switchTo().alert().sendKeys("Valentyn");

        // w alercie kliknij OK
        driver.switchTo().alert().accept();

        // sprawdź asercją czy tekst pod przyciskiem jest równy
       WebElement promtAllert =  driver.findElement(By.id("prompt-label"));
        // Hello Jan! How are you today?
        String actual = promtAllert.getText();
        Assert.assertEquals(actual,"Hello Valentyn! How are you today?");
    }
}
