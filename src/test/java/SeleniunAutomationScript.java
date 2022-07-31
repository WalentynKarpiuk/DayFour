import io.cucumber.java.Before;
import io.cucumber.java.eo.Se;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.session.ChromeFilter;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class SeleniunAutomationScript {

    WebDriver driver;

   @BeforeMethod
   void setUp(){
       WebDriverManager.chromedriver().setup();
       ChromeOptions options = new ChromeOptions();
       options.addArguments("start-maximized");
       //inicjalizacjia webdrivera
       driver = new ChromeDriver(options);
       //otwieranie konkretnej strony
       driver.get("https://seleniumui.moderntester.pl/form.php");

   }
   @AfterMethod
   void tearDown(){
       driver.quit(); // zamykanie jednej karty
   }


    @Test
    public void login() throws InterruptedException {
        //przygotowanie
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //inicjalizacjia webdrivera
        WebDriver driver = new ChromeDriver(options);
        //otwieranie konkretnej strony
        driver.get("https://seleniumui.moderntester.pl/form.php");
        // odpala zamkniecie Drawera
        //Thread.sleep(5000);
        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Valentyn");
       // Thread.sleep(5000);
        //szukamy za pomocą xPath
        WebElement lastName = driver.findElement(By.xpath("//*[@id='inputLastName3']"));
        lastName.sendKeys("Karpiuk");
        //WebElement mail = driver.findElement(By.cssSelector("#inputEmail3"))
        //firstName.clear();
        driver.findElement(By.cssSelector("#inputEmail3")).sendKeys("test@test.com");
       WebElement Sex = driver.findElement(By.xpath("//*[@id='gridRadiosMale']"));
       Sex.click();

       //List<WebElement> sexOptios = driver.findElements(By.xpath("//div[@class='col-sm-10'][3]"));
        List<WebElement> elements = driver.findElements(By.xpath("//input[@name='gridRadiosSex']"));

        for(WebElement element:elements) {
            element.click();
            //Thread.sleep(1000);
        }
        //pole age

        WebElement age = driver.findElement(By.cssSelector("#inputAge3"));
        age.sendKeys("39");
        // year of experience

        WebElement year = driver.findElement(By.xpath("//input[@id='gridRadios1']"));
        year.click();
        //continents

        WebElement profession = driver.findElement(By.xpath("//input[@id='gridCheckAutomationTester']"));
        profession.click();

        //WebElement continents = driver.findElement(By.xpath("//select[@id='selectContinents']"));
        //continents.sendKeys("Europe"); // Też działa

        WebElement continentss = driver.findElement(By.xpath("//select[@id='selectContinents']"));
        Select continents = new Select(continentss);
        continents.selectByValue("europe");
        Thread.sleep(1000);
        continents.selectByIndex(4);

//        WebElement seleniumCommands = driver.findElement(By.xpath("//option[@value='browser-commands']"));
//        seleniumCommands.click();

        WebElement commands = driver.findElement(By.xpath("//select[@id='selectSeleniumCommands']"));
        Select commandsSelect = new Select(commands);
        for(int i=0; i<=4; i++){
            commandsSelect.selectByIndex(i);
            //Thread.sleep(500);
        }

       // WebElement file = driver.findElement(By.xpath("//input[@id='chooseFile']"));
//        file.

//        WebElement additionalInformations = driver.findElement(By.xpath("//textarea[@id='additionalInformations']"));
//        additionalInformations.sendKeys("Form is completed successfully!");

       // WebElement download = driver.findElement(By.xpath("//a[@role='button']"));
       // firstName.clear();
        WebElement file = driver.findElement(By.xpath("//input[@id='chooseFile']"));
        file.sendKeys("C:\\WORKsPACE\\File.file.txt");
       // Thread.sleep(500);

        WebElement additionalInformations = driver.findElement(By.xpath("//textarea[@id='additionalInformations']"));
        additionalInformations.sendKeys("Form is completed successfully!");
        //Thread.sleep(500);

        WebElement testFile = driver.findElement(By.xpath("//a[normalize-space()='Test File to Download']"));
        testFile.click();
       // Thread.sleep(1000);

        WebElement sendSign = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
        sendSign.click();
         //Co można zrobić, aby poczekać na komunikat potwierdzenia i dopiero dalej?
       // Thread.sleep(1000);

        //firstName.clear();

        String expectedMessage = "Form send with success";
        WebElement confirmationMessage = driver.findElement(By.xpath("(//div[@id='validator-message'])[1]"));
        String actualMessage = confirmationMessage.getText();
        System.out.println("Formulaż został wysłany z wiadomością: " + actualMessage);
        assertEquals(expectedMessage, actualMessage);

        Thread.sleep(1000);


    }
}
