package org.example.PaymentPage;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PaymentPage {
    public static final String URL = "https://www.mts.by/";
    public static final int TIMEOUT = 5;
    public static final String MTS_URL = "https://www.mts.by/";
    public static final int WAIT_DURATION = 5;
    public static final String TEST_PHONE_NUMBER = "297777777";
    public static final String TEST_SUM = "10";

    public final By cookieAgreeButton = By.id("cookie-agree");
    public final By phoneNumberInputField = By.id("connection-phone");
    public final By moneySumInputField = By.id("connection-sum");
    public final By continuePayFormButton = By.xpath("//form[@id='pay-connection']//button[@type='submit']");
    public final By iFrame = By.className("bepaid-iframe");
    public final By creditCardDataForm = By.xpath("//div[contains(@class,'card ng-tns')]");
    public final By formHeader = By.xpath("//h2[normalize-space(.)='Онлайн пополнение без комиссии']");
    public final List<By> paymentIcons = Arrays.asList(
            By.xpath("//img[@alt='Visa']"),
            By.xpath("//img[@alt='Verified By Visa']"),
            By.xpath("//div[@class='pay__partners']//img[@alt='MasterCard']"),
            By.xpath("//img[@alt='MasterCard Secure Code']"),
            By.xpath("//div[@class='pay__partners']//img[@alt='Белкарт']")
    );
    private WebDriver driver;
    private WebDriverWait wait;
    public final By visaLogo = By.xpath("//img[@alt='Visa']");
    public final By verifiedByVisa = By.xpath("//img[@alt='Verified By Visa']");
    public final By masterCard = By.xpath("//div[@class='pay__partners']//img[@alt='MasterCard']");
    public final By masterCardSecureCode = By.xpath("//img[@alt='MasterCard Secure Code']");
    public final By belCard = By.xpath("//div[@class='pay__partners']//img[@alt='Белкарт']");
    public final By payFormWrapper = By.className("pay__wrapper");
    public final By serviceDetailsHyperText = By.xpath("//a[contains(text(),'Подробнее о сервисе')]");


    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public void open() {
        driver.get(URL);
    }

    public void acceptCookies() {
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(cookieAgreeButton));
            cookieButton.click();
        } catch (Exception e) {
            System.out.println("Cookie banner did not appear.");
        }
    }

    public void fillPhoneNumber(String phoneNumber) {
        WebElement phoneField = wait.until(ExpectedConditions.elementToBeClickable(phoneNumberInputField));
        phoneField.click();
        phoneField.clear();
        phoneField.sendKeys(phoneNumber);
    }

    public void fillAmount(String amount) {
        WebElement amountField = wait.until(ExpectedConditions.elementToBeClickable(moneySumInputField));
        amountField.click();
        amountField.clear();
        amountField.sendKeys(amount);
    }

    public void submitForm() {
        wait.until(ExpectedConditions.elementToBeClickable(continuePayFormButton)).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
    }

    public String getPhoneNumber() {
        return driver.findElement(phoneNumberInputField).getAttribute("value");
    }

    public String getPaymentAmount() {
        return driver.findElement(moneySumInputField).getAttribute("value");
    }

    public boolean areCardFieldsEmpty() {
        return driver.findElements(creditCardDataForm).isEmpty();
    }

    public boolean arePaymentIconsPresent() {
        return paymentIcons.stream().allMatch(icon -> !driver.findElements(icon).isEmpty());
    }

    public WebElement getFormHeader() {
        return driver.findElement(formHeader);
    }

    public Function<WebDriver, WebElement> getMoneySumInputField(){
        return ExpectedConditions.elementToBeClickable(
                moneySumInputField);
    }
}


