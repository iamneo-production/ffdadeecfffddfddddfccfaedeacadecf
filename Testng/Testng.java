import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FacebookSignUpTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up Chrome driver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testSignUp() {
        // Step 1: Open a Chrome browser and navigate to fb.com
        driver.get("http://www.fb.com");

        // Step 2: Verify the page redirection
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "http://www.facebook.com", "Page redirection failed.");

        // Step 3: Verify "Create an account" section exists
        boolean createAccountExists = driver.findElement(By.id("createAccount")).isDisplayed();
        Assert.assertTrue(createAccountExists, "Create an account section not found.");

        // Step 4: Fill in the text boxes
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Doe");
        driver.findElement(By.name("reg_email__")).sendKeys("test@example.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("test@example.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("password");

        // Step 5: Update date of birth and select gender
        // Update the date of birth dropdown and select gender as per your scenario

        // Step 6: Click on "Create an account"
        driver.findElement(By.name("websubmit")).click();

        // Step 7: Verify successful account creation
        boolean successMessageExists = driver.findElement(By.id("successMessage")).isDisplayed();
        Assert.assertTrue(successMessageExists, "Account creation failed.");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after each test
        driver.quit();
    }
}
