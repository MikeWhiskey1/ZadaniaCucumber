package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.Assert.assertEquals;


public class MyStepdefs {

    private WebDriver driver;
    private WebDriver generatorIt;

    // my function which includes delays after steps
    void waitt(int timee) {
        try {Thread.sleep(timee);}
        catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    }

    @Given("there is open browser with Coders Guru {string} page")
    public void thereIsOpenBrowserWithCodersGuruPage(String url) {
        System.setProperty("webdriver.chrome.driver", "/home/miki/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("user click on registration button")
    public void userClickOnRegistrationButton() {
        driver.findElement(By.xpath("//input[@class='link main-page-top__email-input-sent']")).click();
    }

    @Then("user is on registration page with Private option active")
    public void userIsOnRegistrationPageWithOptionActive() {

        String txt = driver.findElement(By.className("registration__header")).getText();
        assertEquals(txt, "Zarejestruj się");
    }

    @When("user fills email (.*)")
    public void userFillsEmail(String parameter) {
        driver.findElement(By.id("fos_user_registration_form_email")).sendKeys(parameter);
    }

    @And("user fills first Name (.*)")
    public void userFillsFirstNameFirstName(String parameter) {
        driver.findElement(By.id("fos_user_registration_form_name")).sendKeys(parameter);
    }

    @And("user fills second Name (.*)")
    public void userFillsSecondNameSecondName(String parameter) {
        driver.findElement(By.id("fos_user_registration_form_lastname")).sendKeys(parameter);
    }

    @And("user fills password (.*)")
    public void userFillsPasswordPassword(String parameter) {
        driver.findElement((By.id("fos_user_registration_form_plainPassword_first"))).sendKeys(parameter);
    }

    @And("user again fills password (.*)")
    public void userAgainFillsPasswordPasswordRepeat(String parameter) {
        driver.findElement(By.id("fos_user_registration_form_plainPassword_second")).sendKeys(parameter);
    }

    @And("user fills city (.*)")
    public void userFillsCityCity(String parameter) {
        driver.findElement(By.id("form_city")).sendKeys(parameter);
    }

    @And("user fills zip Code (.*)")
    public void userFillsZipCodeZipCode(String parameter) {
        driver.findElement(By.id("form_postal_code")).sendKeys(parameter);
    }

    @And("user fills street (.*)")
    public void userFillsStreetStreet(String parameter) {
        driver.findElement(By.id("form_street")).sendKeys(parameter);
    }

    @And("user fills home Number (.*)")
    public void userFillsHomeNumberHomeNumber(String parameter) {
        driver.findElement(By.id("form_number")).sendKeys(parameter);
    }

    @And("user acknowledges rules")
    public void userAcknowledgesRules() {
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
    }

    @And("user confirms registration")
    public void userConfirmsRegistration() {

//        MyClass MyClass = new MyClass();
//        MyClass.waitt(5000);

        waitt(3000);
        driver.findElement(By.id("register-submit-btn")).click();

    }


    @And("user closes browser")
    public void userClosesBrowser() {
        driver.close();
    }

    @Then("user is on registration page")
    public void userIsOnRegistrationPage() {
        String txt = driver.findElement(By.className("registration__header")).getText();
        assertEquals(txt, "Zarejestruj się");
    }

    @And("user selects Company")
    public void userSelectsCompany() {
        driver.findElement(By.id("company")).click();
    }

    @And("user fills company name (.*)")
    public void userFillsCompanyNameCompanyName(String parameter) {
        driver.findElement (By.id("fos_user_registration_form_company_name")).sendKeys(parameter);
    }


    @And("user fills NIP")
    public void userFillsNIPNip() {

        System.setProperty("webdriver.chrome.driver", "/home/miki/chromedriver_linux64/chromedriver");
        generatorIt = new ChromeDriver();
        generatorIt.manage().window().maximize();
        generatorIt.get("http://generatory.it/");
        generatorIt.findElements(By.xpath("//a[@class='btn-large btn-flat orange white-text waves-effect waves-light']")).get(1).click();

        String nip = generatorIt.findElement(By.id("nipBox")).getText();

        driver.findElement(By.id("fos_user_registration_form_nip")).sendKeys(nip);

        waitt(3000);
        generatorIt.close();
    }
}
