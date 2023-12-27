package StepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends env_target {
    @Given("Open website saucedemo")
    public void openWebsiteSaucedemo() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @And("^Input valid (.*) and (.*)$")
    public void inputValidUsernameAndPassword(String username, String password) {
        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
    }

    @When("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("Should success login and redirect to homepage")
    public void shouldSuccessLoginAndRedirectToHomepage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header_container']/div[2]/span"))
        );

        driver.close();
        driver.quit();
    }

    //invalid credentials
    @And("^Input invalid (.*) and (.*)$")
    public void inputInvalidUsernameAndPassword(String username, String password) {
        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
    }

    @Then("Failed login and showing error message")
    public void failedLoginAndShowingErrorMessage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3/button"))
        );

        driver.close();
        driver.quit();
    }

    //without input credentials
    @And("^Without input (.*) and (.*)$")
    public void withoutInputUsernameAndPassword(String username, String password) {
        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
    }

    @Then("Failed login and showing error message Epic sadface: Username is required")
    public void failedLoginAndShowingErrorMessageEpicSadfaceUsernameIsRequired() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3/button"))
        );

        driver.close();
        driver.quit();
    }
}
