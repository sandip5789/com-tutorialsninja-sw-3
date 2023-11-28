package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Create the package utilities and create the class with the name ‘Utility’ inside the ‘utilities’
 * package. And write the all the utility methods in it’
 */

public class Utility extends BaseTest {
    //************************************ Click and SendText Method *****************************************

    /**
     * This method  will click on elements
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();

    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will send text on element String Text
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will send text to element CharSequence
     */
    public void sendKeysToElement(By by, CharSequence keys) {
        driver.findElement(by).sendKeys(keys);

    }
    // ****************************** Select Method **********************************************************

    /**
     * This method will select class from drop down
     */
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        // Create the object of select class
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    /**
     * This method will select the element from drop-down by VISIBLE TEXT
     */
    public void selectByVisibleTextFromDropDown(By by, String value) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    }

    /**
     * This method will select the element from drop-down by INDEX
     */
    public void selectByIndexFromDropDown(By by, int index) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    // ***************************** Sorting Ascending and Descending method ***********************************

    /**
     * This method will sort List in descending order
     */
    public boolean verifyTheListIsDecendingOrder(By by) {
        List<WebElement> list = driver.findElements(by);

        boolean isDecending = false;

        for (int i = 0; i < list.size() - 1; i++) {
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().compareTo(list.get(i + 1).getText()) < 0) {
                isDecending = true;
            }
        }
        return isDecending;
    }
    /**
     * This method will verify whether the elements are in ASCENDING ORDER or not
     */
    public boolean verifyTheListIsAscendingOrder(By by) {
        List<WebElement> list = driver.findElements(by);

        boolean isAsceding = false;

        for (int i = 0; i < list.size()-1; i++) {
            // System.out.println(list.get(i).getText());
            if (list.get(i).getText().compareTo(list.get(i + 1).getText()) > 0) {
                isAsceding=true;
            }
        }
        return isAsceding;
    }
    //******************************** DropDown Menu Without Select and Verify ********************************************//
    /**
     * This method will select from drop down by without select and verify
     */
    public void sortByPosition(By by, String value) {
        List<WebElement> soryByList = driver.findElements(by);
        for (WebElement element : soryByList) {
            if (element.getText().equalsIgnoreCase(value)) {
                element.click();
                break;
            }

        }
    }
    //************************ Verify the Message or Title **********************************//

    /**
     * This method will verify the two text from the elements
     */
    public void verifyTheStringMessage(By by, String actualMessage) {
        String expectedString = getTextFromElement(by).substring(0, actualMessage.length());
        Assert.assertEquals(expectedString, actualMessage);
    }

    /**
     * This message will verify text displayed on web page
     */
    public void verifyText(String expectedMessage, By by, String displayMessage) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }

    /**
     * This method will count products
     */
    public void countProduct(By by) {
        List<WebElement> linksElements = driver.findElements(by);
        System.out.println("Total number of products = " + linksElements.size());
    }

    /**
     * This method will verify count on web page
     */
    public void verifyCount(By by, int count) {
        List<WebElement> linksElements = driver.findElements(by);
        linksElements.size();
        int productCount = driver.findElements(by).size();
        Assert.assertEquals(productCount, count);
    }


    //*************************** Action Methods ***************************************//

    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        WebElement mouseHoover = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(mouseHoover).build().perform();

    }

    /**
     * This method will use to hover mouse on element and click
     */
    public void mouseHoverToElementAndClick(By by) {
        WebElement mouseHoover = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(mouseHoover).click().build().perform();
    }
    //********************************* Relative Locator *************************************//

    /**
     * This method will find the ABOVE element with reference to the given locator
     */
    public void findToAboveOfElement(By exactLocation, By referenceLocation){
        driver.findElement(RelativeLocator.with(exactLocation).above(referenceLocation));
    }

    /**
     * This method will find the BELOW element with reference to the given locator
     */
    public void findToBelowOfElement(By exactLocation, By referenceLocation){
        driver.findElement(RelativeLocator.with(exactLocation).below(referenceLocation));
    }

    /**
     * This method will find the NEAR element with reference to the given locator
     */
    public void findToNearOfElement(By exactLocation, By referenceLocation){
        driver.findElement(RelativeLocator.with(exactLocation).near(referenceLocation));
    }

    /**
     * This method will find the RIGHT SIDE element with reference to the given locator
     */
    public void findToRightOfElement(By exactLocation, By referenceLocation){
        driver.findElement(RelativeLocator.with(exactLocation).toRightOf(referenceLocation));
    }

    /**
     * This method will find the LEFT SIDE element with reference to the given locator
     */
    public void findToLeftOfElement(By exactLocation, By referenceLocation){
        driver.findElement(RelativeLocator.with(exactLocation).toLeftOf(referenceLocation));
    }


    // ***************************** Other Method **********************************************************

    /**
     * This method will clear text from the field
     */
    public void clearTextFromField(By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL + "a");
        driver.findElement(by).sendKeys(Keys.DELETE);

    }
    /**
     * This method is for Select my account
     */
    public void selectMyAccountOptions(String option){
        driver.findElement(By.linkText(option)).click();
    }

}

