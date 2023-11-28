package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

public class DesktopsTest extends Utility {
    static String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    // 1.Test name verifyProductArrangeInAlphaBaticalOrder
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        Thread.sleep(200);
        // 1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Desktops']"));
        Thread.sleep(200);
        // 1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        // 1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        // 1.4 Verify the Product will arrange in Descending order.
        verifyTheListIsDecendingOrder(By.tagName("h4"));
    }
    // 2. Test name verifyProductAddedToShoppingCartSuccessFully
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // 2.1 Mouse hover on Currency Dropdown and click
        Thread.sleep(2000);
        mouseHoverToElementAndClick(By.xpath("//span[normalize-space()='Currency']"));
        // 2.2 Mouse hover on £Pound Sterling and click
        Thread.sleep(2000);
        mouseHoverToElementAndClick(By.xpath("//button[normalize-space()='£Pound Sterling']"));
        // 2.3 Mouse hover on Desktops Tab.
        mouseHoverToElement(By.xpath("//a[normalize-space()='Desktops']"));
        // 2.4 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        // 2.5 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
        // 2.6 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));
        // 2.7 Verify the Text "HP LP3065"
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='HP LP3065']"), "HP LP3065");
       // 2.8 Select Delivery Date "2023-11-27"
        datePicker("28", "Nov","2023");
        //2.9.Enter Qty "1” using Select class.
        String s = Keys.CONTROL + "a";
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), s);
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");
        //2.10 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        verifyTheStringMessage(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have added HP LP3065 to your shopping cart!");
        //2.12 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //2.13 Verify the text "Shopping Cart"
        verifyTheStringMessage(By.xpath("//h1[contains(text(),'Shopping Cart')]"), "Shopping Cart");
        //2.14 Verify the Product name "HP LP3065"
        verifyTheStringMessage(By.xpath("//table[@class = 'table table-bordered']/tbody[1]/tr[1]/td[2]/a[1]"),"HP LP3065");
        //2.15 Verify the Delivery Date "2023-11-27"
        verifyTheStringMessage(By.xpath("//table[@class = 'table table-bordered']//small[1]"), "Delivery Date:2023-11-28");
        //2.16 Verify the Model "Product21"
        verifyTheStringMessage(By.xpath("//td[normalize-space()='Product 21']"), "Product 21");
        //2.17 Verify the Totat "£74.73"
        verifyTheStringMessage(By.cssSelector("tbody tr td:nth-child(6)"), "£74.73");

    }
    public void datePicker(String day, String month, String year) throws InterruptedException {
        clickOnElement(By.xpath("//i[@class='fa fa-calendar']"));
        clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@colspan='5']"));

        while(true){
            String y = getTextFromElement(By.xpath("//div[@class='datepicker-months'] //th[@class='picker-switch']"));
            if(y.equalsIgnoreCase(year)){
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker-months']//th[@class='next'][contains(text(),'›')]"));
            }
        }
        clickOnElement(By.xpath("//span[normalize-space()='"+month+"']"));
        Thread.sleep(200);
        clickOnElement(By.xpath("//td[@class = 'day' and text() = '"+day+"']"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
