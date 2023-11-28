package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;
import java.util.Objects;

public class TopMenuTest extends Utility {
    static String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    // 1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu) {
        // 1.2 This method should click on the menu whatever name is passed as parameter
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']"));
        for (WebElement element : topMenuList) {
            if (Objects.equals(element.getText(), menu)) {
                clickOnElement(By.xpath("//div[@class = 'dropdown-menu']//a[normalize-space()='" + menu + "']"));
                break;
            }

        }
    }

    // 1. verifyUserShouldNavigateToDesktopsPageSuccessfully
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        // 1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Desktops']"));
        // 1.2 call selectMenu method and pass the menu = “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        // 1.3 Verify the text ‘Desktops’
        verifyTheStringMessage(By.tagName("h2"), "Desktops");

    }

    // 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
        Thread.sleep(200);
        // 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Components']"));
        // 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[normalize-space()='Show AllComponents']"));
        // 2.3 Verify the text ‘Laptops & Notebooks’
        verifyTheStringMessage(By.tagName("h2"), "Components");

    }

    // 3. verifyUserShouldNavigateToComponentsPageSuccessfully
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        //  3.1 Mouse hover on “Components” Tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Components']"));
        //  3.2 call selectMenu method and pass the menu = “Show All Components”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllComponents']"));
        //  3.3 Verify the text ‘Components’
        verifyTheStringMessage(By.tagName("h2"), "Components");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}