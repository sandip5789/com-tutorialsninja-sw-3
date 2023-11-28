package myaccounts;
/**
 * 1. Create the class MyAccountsTest
 */

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.Random;

public class MyAccountsTest extends Utility {
    static String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
    public void selectMyAccountOptions(String option) {
        // 1.2 This method should click on the options whatever name is passed as parameter.
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='" + option + "']"));
    }

    // 1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        // 1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        // 1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        Thread.sleep(200);
        selectMyAccountOptions("Register");
        // 1.3 Verify the text “Register Account”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Register Account']"), "Register Account");
    }
    // 2. Test name verifyUserShouldNavigateToLoginPageSuccessfully
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        // 2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        // 2.2 Call the method “selectMyAccountOptions” method and pass the parameter ““Login””
        Thread.sleep(200);
        selectMyAccountOptions("Login");
        // 2.3 Verify the text “Returning Customer”
        verifyTheStringMessage(By.xpath("//h2[normalize-space()='Returning Customer']"), "Returning Customer");
    }
   // 3. Test name verifyThatUserRegisterAccountSuccessfully
   @Test
   public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
       // 3.1 Click on My Account Link.
       clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
       // 3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
       Thread.sleep(200);
       selectMyAccountOptions("Register");
       // 3.3 Enter First Name
       sendTextToElement(By.name("firstname"), "Abcd");
       // 3.4 Enter Last Name
       sendTextToElement(By.name("lastname"), "Xyz");
       // 3.5 Enter Email
       Random random = new Random();
       sendTextToElement(By.id("input-email"), "abcd"+random.nextInt()+"@gmail.com");
       // 3.6 Enter Telephone
       sendTextToElement(By.name("telephone"), "0789655254");
       // 3.7 Enter Password
       sendTextToElement(By.xpath("//input[@id='input-password']"), "abcd123");
       // 3.8 Enter Password Confirm
       sendTextToElement(By.xpath("//input[@id='input-confirm']"), "abcd123");
       // 3.9 Select Subscribe Yes radio button
       clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
       // 3.10 Click on Privacy Policy check box
       clickOnElement(By.xpath("//input[@name='agree']"));
       // 3.11 Click on Continue button
       clickOnElement(By.xpath("//input[@value='Continue']"));
       // 3.12 Verify the message “Your Account Has Been Created!”
       verifyTheStringMessage(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"), "Your Account Has Been Created!");
       // 3.13 Click on Continue button
       clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
       // 3.14 Click on My Account Link.
       clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
       // 3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
       selectMyAccountOptions("Logout");
       // 3.16 Verify the text “Account Logout”
       verifyTheStringMessage(By.xpath("//h1[normalize-space()='Account Logout']"), "Account Logout");
       // 3.17 Click on Continue button
       clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
   }
   // 4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully
   @Test
   public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
      // 4.1 Click on My Account Link.
       clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
      // 4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
       Thread.sleep(200);
       selectMyAccountOptions("Login");
      // 4.3 Enter Email address
       sendTextToElement(By.xpath("//input[@id='input-email']"), "abcdxyz123@gmail.com");
      // 4.4 Enter Last Name ----> Option not available in form
      // 4.5 Enter Password
       sendTextToElement(By.xpath("//input[@id='input-password']"), "abcd@123");
      // 4.6 Click on Login button
       clickOnElement(By.xpath("//input[@value='Login']"));
      // 4.7 Verify text “My Account”
       verifyTheStringMessage(By.xpath("//h2[normalize-space()='My Account']"), "My Account");
      // 4.8 Click on My Account Link.
       clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
      // 4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
       Thread.sleep(200);
       selectMyAccountOptions("Logout");
      // 4.10 Verify the text “Account Logout”
       verifyTheStringMessage(By.xpath("//h1[normalize-space()='Account Logout']"), "Account Logout");
      // 4.11 Click on Continue button
       clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
   }
}

