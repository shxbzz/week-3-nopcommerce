package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class ElectronicsTest extends Utility {


    String baseUrl = "https://demo.nopcommerce.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void textVerified() {
        //  1.1 Mouse Hover on “Electronics” Tab
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));

        //  1.2 Mouse Hover on “Cell phones” and click
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));

        //  1.3 Verify the text “Cell phones”
        assertVerifyText(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        //  2.1 Mouse Hover on “Electronics” Tab
        Thread.sleep(2000);
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));

        //  2.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(2000);
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));

        //  2.3 Verify the text “Cell phones”
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");

        // 	2.4 Click on List View Tab
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //	2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@class='details']//a[contains(text(),'Nokia Lumia 1020')]"));

        //	2.6 Verify the text “Nokia Lumia 1020”
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"), "Nokia Lumia 1020");

        //	2.7 Verify the price “$349.00”
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//span[@id='price-value-20']"), "$349.00");

        //  2.8 Change quantity to 2
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys(Keys.CONTROL + "a");

        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

        //	2.9 Click on “ADD TO CART” tab
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //	2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        //  After that close the bar clicking on the cross button.
        assertVerifyText(By.xpath("//div[@id='bar-notification']/div/p"), "The product has been added to your shopping cart");
        Thread.sleep(1000);
        clickOnElement(By.cssSelector("span.close"));

        //	2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElement(By.xpath("//li[@id='topcartlink']/a/span[1]"));
        Thread.sleep(2000);
        clickOnMouseHoverOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //	2.12 Verify the message "Shopping cart"
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        //	2.13 Verify the quantity is 2
        // mouseHoverOnElement(By.xpath("//li[@id='topcartlink']/a/span[1]"));
        // assertVerifyText(By.xpath("//span[@class='cart-qty']"), "(2)");
        Thread.sleep(2000);
        WebElement xyz = driver.findElement(By.xpath("//input[@class=\"qty-input\"]"));
        // Get value attribute with getAttribute()
        String qty = xyz.getAttribute("value");
        // Verify the quantity
        Assert.assertEquals("Error> Quanti mismatch:", "2", qty);

        //  2.14 Verify the Total $698.00
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//span//strong[contains(text(),'$698.00')]"), "$698.00");

        //  2.15 click on checkbox “I agree with the terms of service”
        Thread.sleep(2000);
        clickOnElement(By.id("termsofservice"));

        //  2.16 Click on checkout
        Thread.sleep(2000);
        clickOnElement(By.id("checkout"));

        //  2.17 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");

        // 	2.18 Click on “REGISTER” tab
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@onclick='location.href=\"https://demo.nopcommerce.com/register?returnUrl=%2Fcart\"']"));

        //	2.19 Verify the text “Register”
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//h1[contains(text(),'Register')]"), "Register");

        //	2.20 Fill the mandatory fields
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='gender-male']"));
        sendTextToElement(By.id("FirstName"), "abc");
        sendTextToElement(By.id("LastName"), "abc123");

        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"), "11");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"), "September");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"), "1998");

        sendTextToElement(By.id("Email"), "abcs@gmail.com");
        sendTextToElement(By.id("Password"), "12345678");
        sendTextToElement(By.id("ConfirmPassword"), "12345678");

        //	2.21 Click on “REGISTER” Button
        Thread.sleep(2000);
        clickOnElement(By.id("register-button"));

        //	2.22 Verify the message “Your registration completed”
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//div[contains(text(),'Your registration completed')]"), "Your registration completed");

        //	2.23 Click on “CONTINUE” tab
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //	2.24 Verify the text “Shopping cart”
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        //	2.25 click on checkbox “I agree with the terms of service”
        Thread.sleep(2000);
        clickOnElement(By.id("termsofservice"));

        //	2.26 Click on “CHECKOUT”
        Thread.sleep(2000);
        clickOnElement(By.id("checkout"));

        //	2.27 Fill the Mandatory fields
        Thread.sleep(2000);
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "abc");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "xyz");
        clickOnElement(By.id("BillingNewAddress_CountryId"));
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        clickOnElement(By.id("BillingNewAddress_StateProvinceId"));
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_StateProvinceId"), "Other");
        sendTextToElement(By.id("BillingNewAddress_City"), "london");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "101 street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "RT4 R74");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "758541258724");

        //	2.28 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[text() = 'Continue']"));

        //	2.29 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(2000);
        clickOnElement(By.id("shippingoption_2"));

        //  2.30 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));

        //  2.31 Select Radio Button “Credit Card”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']")); //credit card
        clickOnElement(By.xpath("//div[@id='checkout-step-payment-method']/div/button"));//continue

        //  2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Visa");

        //  2.33 Fill all the details
        Thread.sleep(2000);
        sendTextToElement(By.id("CardholderName"), "abc");
        sendTextToElement(By.id("CardNumber"), "5232 1478 4876 3353");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "02");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2024");
        sendTextToElement(By.id("CardCode"), "000");

        //  2.34 Click on “CONTINUE”CHECKOUT”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));

        //  2.35 Verify “Payment Method” is “Credit Card”
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//li[@class='payment-method']/span[2]"), "Credit Card");

        //  2.36 Verify “Shipping Method” is “2nd Day Air”
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//li[@class='shipping-method']/span[2]"), "2nd Day Air");

        //	2.37 Verify Total is “$698.00”
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//td[@class='subtotal']/span"), "$698.00");

        //	2.38 Click on “CONFIRM”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[text()='Confirm']"));

        //	2.39 Verify the Text “Thank You”
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");

        //	2.40 Verify the message “Your order has been successfully processed!”
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//div[@class='section order-completed']//strong"), "Your order has been successfully processed!");

        //	2.41 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //  2.42 Verify the text “Welcome to our store”
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");

        //  2.43 Click on “Logout” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //  2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://demo.nopcommerce.com/", url);
    }

    @After
    public void teardown() {
        closeBrowser();
    }
}