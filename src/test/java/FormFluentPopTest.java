import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class FormFluentPopTest extends TestBase {
    File file;
    FormPage formPage;

    @BeforeMethod
    public void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/form.php");
        file = new File("src/main/resources/file.txt");
        formPage = new FormPage(driver);
    }

    @Test
    public void shouldFillFormWithSuccess() {
        formPage.setFirstName("Mateusz")
                .setLastName("Nowak")
                .selectMaleGender()
                .setAge("55")
                .setEmail("mk@wp.pl")
                .selectExperience(3)
                .selectManualTester()
                .selectContinent("europe")
                .selectSeleniumCommands("switch-commands")
                .uploadFile(file)
                .sendFormButton();

        Assert.assertEquals(formPage.getValidatorMessage(), "Form send with success");
    }

    @Test
    public void shouldFillFormWithSuccess2() {
        Assert.assertEquals(
                formPage
                        .setFirstName("Mateusz")
                        .setLastName("Nowak")
                        .selectMaleGender()
                        .setAge("55")
                        .setEmail("mk@wp.pl")
                        .selectExperience(3)
                        .selectManualTester()
                        .selectContinent("europe")
                        .selectSeleniumCommands("switch-commands")
                        .uploadFile(file)
                        .sendFormButton()
                        .getValidatorMessage(), "Form send with success");
    }
}