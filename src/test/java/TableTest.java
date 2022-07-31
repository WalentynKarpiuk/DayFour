import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class TableTest extends TestBase {

    @Test
    public void shouldPrintMountainsOver4000() {
        driver.get("https://seleniumui.moderntester.pl/table.php");
        List<WebElement> allRows = driver.findElements(By.cssSelector("tbody tr"));
        Assert.assertTrue(allRows.size() >0);

        for(WebElement row : allRows) {
            WebElement nameHight = row.findElements(By.cssSelector("td")).get(3);
            int height = Integer.parseInt(nameHight.getText());
            if(height>4000){
                WebElement name = row.findElements(By.cssSelector("td")).get(0);
                System.out.println(name.getText());
            }


        }



    }

    /*
1. Otwórz stronę https://seleniumui.moderntester.pl/table.php
2. Stwórz test, który wypisze do konsoli – przy pomocy System.out.println()
   - informacje o szczytach (nazwa, pasmo górskie, państwo, wysokość)
   ale tylko tych których wysokość jest większa niż 4000m
3. Do rozwiązania zadania użyj pętli for-each w celu przeiterowania po wszystkich wierszach w tabeli
     */
}
