package org.example.PaymentFromTest;

import org.example.PaymentPage.PaymentPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import java.time.Duration;
import java.util.Arrays;

class PaymentFormTest {
    private static final int WAIT_DURATION = 5;
    private WebDriver driver;
    private PaymentPage paymentPage;
    private static final String PATH_TO_DRIVER = "c:\\Drivers\\chromedriver-win64\\chromedriver.exe";
    private static final String DRIVER = "webdriver.chrome.driver";
    private WebDriverWait wait;

    @BeforeAll
    static void setUpChromeDriver() {
        System.setProperty(DRIVER, PATH_TO_DRIVER );
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        paymentPage = new PaymentPage(driver);
        paymentPage.open();
        paymentPage.acceptCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Тест на соответствие названия блока «Онлайн пополнение без комиссии»")
    void OnlineReplenishmentWithoutCommissionHeaderTest() {
        WebElement header = paymentPage.getFormHeader();
        Assertions.assertEquals("Онлайн пополнение без комиссии", header.getText().replace("\n", " "));
    }

    @Test
    @DisplayName("Тест наличия логотипов платежных систем")
    void logoPaymentSystemPresenceTest() {
        Arrays.asList(paymentPage.visaLogo, paymentPage.verifiedByVisa,paymentPage.masterCard,
                paymentPage.masterCardSecureCode, paymentPage.belCard).forEach(
                locator -> {
                    boolean isLogoPresence = isLogoPresent(locator);
                    Assertions.assertAll(() ->
                            Assertions.assertTrue(isLogoPresence, String.format("Лого %s не появилось", locator)));
                });
    }

    @Test
    @DisplayName("Тест на проверку ссылки 'Подробнее о сервисе'")
    void hyperTextTest() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentPage.serviceDetailsHyperText)).click();
        String metaContent = driver.getTitle().trim();
        Assertions.assertEquals("Порядок оплаты и безопасность интернет платежей", metaContent);
    }

    @Test
    @DisplayName("Тест кнопки 'Continue'")
    void buttonContinueTest() {
        WebElement phoneNumberField = wait.until(ExpectedConditions.elementToBeClickable( paymentPage. phoneNumberInputField));
        phoneNumberField.click();
        phoneNumberField.sendKeys(PaymentPage.TEST_PHONE_NUMBER);
        WebElement moneySumField = wait.until(ExpectedConditions.elementToBeClickable(
               paymentPage. moneySumInputField));
        moneySumField.click();
        moneySumField.sendKeys(PaymentPage.TEST_SUM);
        wait.until(ExpectedConditions.elementToBeClickable( paymentPage.continuePayFormButton)).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentPage. iFrame));
        boolean isCardDataForm = wait.until(ExpectedConditions.visibilityOfElementLocated( paymentPage. creditCardDataForm)) != null;

        Assertions.assertTrue(isCardDataForm, "Переход на форму заполнения данных о карте не осуществлен");
    }


    @Test
    @DisplayName("Проверка формы оплаты 'Услуги связи'")
    void testServicePaymentForm() {
        paymentPage.fillPhoneNumber("297777777");
        paymentPage.fillAmount("10");
        Assertions.assertEquals( paymentPage.getPhoneNumber(),"(29)777-77-77");
        Assertions.assertEquals( paymentPage.getPaymentAmount(),"10");
    }

    private boolean isLogoPresent(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}

