package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


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
        waitt(2000);
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

        waitt(2000);
        generatorIt.close();
    }

    @When("user is on page with - Help in programming issues - caption")
    public void userIsOnPageWithHelpInProgrammingIssuesCaption() {
        String actual = driver.findElement(By.className("main-page-top__header")).getText();

        assertEquals("Pomoc w problemach programistycznych", actual);
    }

    @And("user clicks on - Need Help - button")
    public void userClicksOnNeedHelpButton() {
        driver.findElement(By.className("select-text-desktop")).click();
    }

    @And("user selects subject to be discusses with the Mentor")
    public void userSelectsSubjectToBeDiscussesWithTheMentor() {
        driver.findElements(By.xpath("//div[@class='main-page-top__select-container']//ul//li")).get(7).click();
    }

    @And("user clicks - Find Mentor - button")
    public void userClicksFindMentorButton() {
        driver.findElement(By.className("main-page-top__select-btn")).click();
    }

    @When("user is on the page with a chosen subject")
    public void userIsOnPageWithAChosenSubject() {

        String filter = driver.findElement(By.xpath("//p[text()='Filtruj: ']")).getText();

        assertTrue(filter.contains("Filtruj: "));
    }


    @And("user reserves Mentor")
    public void userReservesMentor() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//button[text() = 'Rezerwuj']"), 0));

        driver.findElements(By.xpath("//button[text() = 'Rezerwuj']")).get(0).click();
    }

    @And("user describes the issue")
    public void userDescribesTheIssue() {

        WebElement txt = driver.findElement(By.className("reservation__modal-textarea"));

        waitt(3000);
        txt.sendKeys("I have the following question...");
    }

    @And("user chooses date of consultation")
    public void userChoosesDateOfConsultation() {
        driver.findElements(By.xpath("//div[@id='dateSelect']//ul//li")).get(0).click();

    }

    @And("user chooses time of consultation")
    public void userChoosesTimeOfConsultation() {
        driver.findElements(By.xpath("//div[@id='hourSelect']//ul//li")).get(0).click();
    }

    @And("user acknowledges the order")
    public void userAcknowledgesTheOrder() {
        driver.findElement(By.className("reservation-modal__summary-button")).click();
    }

    @When("user is on payment page")
    public void userIsOnPaymentPage() {

        waitt(3000);
        String currentUrl = driver.getCurrentUrl();

        assertTrue(currentUrl.contains("secure.payu.com"));
    }

    @Then("web browser is automatically closed")
    public void webBrowserIsAutomaticallyClosed() {
        driver.close();
    }
}
