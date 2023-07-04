package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {


        // 1.1 Mouse Hover on “Electronics”Tab
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"), By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        // 1.2 Mouse Hover on “Cell phones” and click
        clickOnElement(By.xpath("//h1[normalize-space()='Cell phones']"));

        // 1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualTextElement = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("message not displayed", expectedText, actualTextElement);
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        //2.1Mouse Hover on “Electronics” Tab
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"), By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //2.2 Mouse Hover on “Cell phones” and click
        clickOnElement(By.xpath("//h1[normalize-space()='Cell phones']"));

        //2.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualTextElement = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("message not displayed", expectedText, actualTextElement);

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(1000);
        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));

        //2.6 Verify the text “Nokia Lumia 1020”
        String expectedText1 = "Nokia Lumia 1020";
        String actualTextElement1 = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("message not displayed", expectedText1, actualTextElement1);

        //2.7 Verify the price “$349.00”
        String expectedText2 = "$349.00";
        String actualTextElement2 = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals("message not displayed", expectedText2, actualTextElement2);

        //2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");
        Thread.sleep(1000);
        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedText3 = "The product has been added to your shopping cart";
        String actualTextElement3 = getTextFromElement(By.xpath("//p[text()='The product has been added to your ']"));
        Assert.assertEquals("message not displayed", expectedText3, actualTextElement3);


        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"), By.xpath("//button[contains(text(),'Go to cart')]"));

       // clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));

        //2.12 Verify the message "Shopping cart"
        String expectedText4 = "Shopping cart";
        String actualTextElement4 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("message not displayed", expectedText4, actualTextElement4);
        Thread.sleep(1000);

        //2.13 Verify the quantity is 2
        String expectedText5 = "2";
        String actualTextElement5 = getTextFromElement(By.xpath("//input[@id='itemquantity11222']"));
        Assert.assertEquals("message not displayed", expectedText5, actualTextElement5);

        //2.14 Verify the Total $698.00
        String expectedText6 = "$698.00";
        String actualTextElement6 = getTextFromElement(By.xpath("//td[@class='subtotal']//span[text()='$698.00']"));
        Assert.assertEquals("message not displayed", expectedText6, actualTextElement6);

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));


        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedText7 = "Welcome, Please Sign In!";
        String actualTextElement7 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("message not displayed", expectedText7, actualTextElement7);

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.19 Verify the text “Register”
        String expectedText8 = "Register";
        String actualTextElement8 = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("message not displayed", expectedText8, actualTextElement8);


        //2.20 Fill the mandatory fields
        clickOnElement(By.xpath("//input[@id='gender-female']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Tina");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Pathak");
        sendTextToElement(By.xpath("//input[@id='Email']"),"tinaP31@yahoo.com");
        sendTextToElement(By.xpath("//input[@id='Password']"),"tina123");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"tina123");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        String expectedText9 = "Your registration completed";
        String actualTextElement9 = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("message not displayed", expectedText9, actualTextElement9);

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //2.24 Verify the text “Shopping card”
        String expectedText10 = "Shopping cart";
        String actualTextElement10 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("message not displayed", expectedText10, actualTextElement10);



    }



    @After
    public  void tearDown(){
        driver.quit();
    }
}