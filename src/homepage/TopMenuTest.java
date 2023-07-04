package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    public void selectMenu(String menu){

        clickOnElement(By.linkText(menu));

    }
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public  void verifyPageNavigation(){

         selectMenu("Computers");
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile'] //a[text()='Computers ']"));
        String expectedText = "https://demo.nopcommerce.com/computers";
        String actualTextElement = driver.getCurrentUrl();
        Assert.assertEquals("message not displayed", expectedText, actualTextElement);



    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
