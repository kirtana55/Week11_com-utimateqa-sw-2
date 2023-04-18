package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        //Verify the text ‘Welcome Back!’
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        String expectedText = "Welcome Back!";
        Assert.assertEquals("Message not displayed successfully", expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessage() {
        //click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        //Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("kirtana@com");
        driver.findElement(By.name("user[password]")).sendKeys("kirtana21");
        //click on Login button
        driver.findElement(By.xpath("//button[@class= 'button button-primary g-recaptcha']")).click();
        //Verify the error message ‘Invalid email or password.’
        String actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        String expectedText = "Invalid email or password.";
        Assert.assertEquals("Message displayed correctly", expectedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}