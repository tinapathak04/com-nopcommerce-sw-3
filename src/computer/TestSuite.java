package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile'] //a[text()='Computers ']"));
        //1.2 Click on Desktop
        mouseHover(By.xpath("//ul[@class='top-menu notmobile'] //a[text()='Computers ']"),By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");

        //1.4 Verify the Product will arrange in Descending order.
        String expectedText = "Name: Z to A";
        String actualTextElement = getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        Assert.assertEquals("message not displayed", expectedText, actualTextElement);
    }

      @Test
        public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

          //2.1 Click on Computer Menu.
          clickOnElement(By.xpath("//ul[@class='top-menu notmobile'] //a[text()='Computers ']"));
          //2.2 Click on Desktop
          mouseHover(By.xpath("//ul[@class='top-menu notmobile'] //a[text()='Computers ']"),By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
          // 2.3 Select Sort By position "Name: A to Z"
          selectByIndex(By.xpath("//select[@id='products-orderby']"),1);
          Thread.sleep(1000);
          //2.4 Click on "Add To Cart"
          clickOnElement(By.xpath("//div[@class='buttons']//button[text()='Add to cart']"));
          Thread.sleep(Long.parseLong("1000"));

          //2.5 Verify the Text "Build your own computer"
          String expectedText = "Build your own computer";
          String actualTextElement = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
          Assert.assertEquals("message not displayed", expectedText, actualTextElement);
          Thread.sleep(1000);
          //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
          selectByValue(By.xpath("//select[@id='product_attribute_1']"), "1");;
          Thread.sleep(1000);
          //2.7.Select "8GB [+$60.00]" using Select class.
          selectByValue(By.xpath("//select[@id='product_attribute_2']"),"5");
          //2.8 Select HDD radio "400 GB [+$100.00]"
          clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
          //2.9 Select OS radio "Vista Premium [+$60.00]"
          clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
          //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
          clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
          clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
          Thread.sleep(1000);


          //2.11 Verify the price "$1,425.00"
          String expectedText1 = "$1,425.00";
          String actualTextElement1 = getTextFromElement(By.xpath("//span[@id='price-value-1']"));
          Assert.assertEquals("message not displayed", expectedText1, actualTextElement1);

          //2.12 Click on "ADD TO CARD" Button.
          clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
          Thread.sleep(1000);

          //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar

         String expectedMessage = "The product has been added to your shopping cart";
         String actualMesaage = getTextFromElement(By.xpath("//p[@class='content']"));
         Assert.assertEquals("Message is not displayed",expectedMessage,actualMesaage);

         clickOnElement(By.xpath("//span[@class='close']"));

          //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
//          mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"),By.xpath("//button[contains(text(),'Go to cart')]"));
         // mouseHover(By.linkText("Shopping cart"),By.linkText("Go to cart"));


          //2.15 Verify the message "Shopping cart"
         // String expectedText3 = "Shopping cart";
         // String actualTextElement3 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
         // Assert.assertEquals("message not displayed", expectedText3, actualTextElement3);

          //2.16 Change the Qty to "2" and Click on "Update shopping cart"
          driver.findElement(By.xpath("//input[@id='itemquantity11245']")).clear();
          sendTextToElement(By.xpath("//input[@id='itemquantity11245']"),"2");

//          WebElement quantity = driver.findElement(By.xpath("//input[contains(@class, 'qty-input')]"));
//          quantity.clear();
//          quantity.sendKeys("2");
//          clickOnElement(By.xpath("//button[@id='updatecart']"));

          Thread.sleep(1000);

          //2.17 Verify the Total"$2,950.00"
          String expectedText4 = "$2,950.00";
          String actualTextElement4 = getTextFromElement(By.xpath("//span[text()='$2,950.00']"));
          Assert.assertEquals("message not displayed", expectedText4, actualTextElement4);

          //2.18 click on checkbox “I agree with the terms of service”
          clickOnElement(By.xpath("//input[@id='termsofservice']"));
          //2.19 Click on “CHECKOUT”
          clickOnElement(By.xpath("//button[@id='checkout']"));
          Thread.sleep(1000);

          //2.20 Verify the Text “Welcome, Please Sign In!”
          String expectedText5 = "Welcome, Please Sign In!";
          String actualTextElement5 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
          Assert.assertEquals("message not displayed", expectedText5, actualTextElement5);

          //2.21Click on “CHECKOUT AS GUEST” Tab
          clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
           Thread.sleep(1000);


          //2.22 Fill the all mandatory field
          sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Tina");
          sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Pathak");
          sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"tinaP@yahoo.com");
          selectByValue(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United States");
          selectByValue(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"New York");
          sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"New York");
          sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"47 W 13th St, New York");
          sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"NY 10011");
          sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"2770000");

          //2.23 Click on “CONTINUE”
          clickOnElement(By.xpath("//div[@id='billing-buttons-container']//button[text()='Continue']"));
          //2.24 Click on Radio Button “Next Day Air($0.00)”
          clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
          //2.25 Click on “CONTINUE”
          clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']//button[text()='Continue']"));
          //2.26 Select Radio Button “Credit Card”
          clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
          //2.27 Select “Master card” From Select credit card dropdown
          selectByValue(By.xpath("//option[contains(text(),'Master card')]"),"MasterCard");
          //2.28 Fill all the details
          sendTextToElement(By.xpath("//input[@id='CardholderName']"),"T Pathak");
          sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5425233430109903");
          sendTextToElement(By.xpath("//select[@id='ExpireMonth']"),"12");
          sendTextToElement(By.xpath("//select[@id='ExpireYear']"),"2026");
          sendTextToElement(By.xpath("//input[@id='CardCode']"),"0136");
          //2.29 Click on “CONTINUE”
          clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']//button[text()='Continue']"));

          //2.30 Verify “Payment Method” is “Credit Card”
          String expectedText6 = "Payment Method: Credit Card";
          String actualTextElement6 = getTextFromElement(By.xpath("//span[contains(text(),'Payment Method:')]"));
          Assert.assertEquals("message not displayed", expectedText6, actualTextElement6);

          //2.32 Verify “Shipping Method” is “Next Day Air”
          String expectedText7 = "Shipping Method: Next Day Air";
          String actualTextElement7 = getTextFromElement(By.xpath("//span[contains(text(),'Shipping Method:')]"));
          Assert.assertEquals("message not displayed", expectedText7, actualTextElement7);

          //2.33 Verify Total is “$2,950.00”
          String expectedText8 = "$2,950.00";
          String actualTextElement8 = getTextFromElement(By.xpath("//td[@class='subtotal']//span[text()='$2,950.00']"));
          Assert.assertEquals("message not displayed", expectedText8, actualTextElement8);


          //2.34 Click on “CONFIRM”
          clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

          //2.35 Verify the Text “Thank You”
          String expectedText9 = "Thank you";
          String actualTextElement9 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
          Assert.assertEquals("message not displayed", expectedText9, actualTextElement9);


          //2.36 Verify the message “Your order has been successfully processed!”
          String expectedText10 = "Your order has been successfully processed!";
          String actualTextElement10 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
          Assert.assertEquals("message not displayed", expectedText10, actualTextElement10);


          //2.37 Click on “CONTINUE”
          clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

          //2.37 Verify the text “Welcome to our store”
          String expectedText11 = "Welcome to our store";
          String actualTextElement11 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
          Assert.assertEquals("message not displayed", expectedText11, actualTextElement11);

      }



    @After
    public void tearDown(){
        driver.quit();
    }
}
