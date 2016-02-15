package com.olenick.avatar.icare2.web.containers;

import com.olenick.avatar.icare2.properties.ICare2Props;
import org.openqa.selenium.By;
import com.olenick.selenium.containers.WebContainer;
import com.olenick.selenium.drivers.ExtendedRemoteWebDriver;
import com.olenick.selenium.elements.ExtendedWebElement;

/**
 * ImprovingCare Login Page.
 * <p>
 * Not thread-safe.
 * </p>
 */
public class LoginPage extends WebContainer<LoginPage> {
    private static ICare2Props appProps = ICare2Props.getInstance();

    private ExtendedWebElement usernameInputField, passwordInputField, submitButton;
    private String urlRoot;

    public LoginPage(ExtendedRemoteWebDriver driver, String urlRoot) {
        super(driver);

        this.driver = driver;
        this.urlRoot = urlRoot;
        this.usernameInputField = new ExtendedWebElement(this);
        this.passwordInputField = new ExtendedWebElement(this);
        this.submitButton = new ExtendedWebElement(this);
    }

    public LoginPage open() {
        this.driver.get(this.urlRoot + appProps.getRELATIVE_URL());

        return this;
    }

    public LoginPage sendUsername(String username) {
        //TODO: There should be a better way of asserting the sendkeys
        do {
            this.usernameInputField.clear();
            this.usernameInputField.sendKeys(username);
        } while (this.usernameInputField.getAttribute("value").isEmpty());

        return this;
    }

    public LoginPage sendPassword(String password) {
        //TODO: There should be a better way of asserting the sendkeys
        do {
            this.passwordInputField.clear();
            this.passwordInputField.sendKeys(password);
        } while (this.passwordInputField.getAttribute("value").isEmpty());

        return this;
    }

    public LoginPage submit() {
        this.submitButton.click();

        return this;
    }

    public LoggedInWelcomePage login(String username, String password) {
        this.sendUsername(username);
        this.sendPassword(password);
        this.submit();

        return new LoggedInWelcomePage(this.driver);
    }

    public LoginPage loginFailure(String username, String password) {
        this.login(username, password);
        this.driver.findVisibleElement(By.id(appProps.getELEMENT_ID_INVALID_CREDENTIALS_ERROR_MESSAGE()));

        return this;
    }

    @Override
    public LoginPage waitForElementsToLoad() {
        this.usernameInputField.setUnderlyingWebElement(
                driver.findVisibleElement(By.id(appProps.getELEMENT_ID_USERNAME_INPUT())));
        this.passwordInputField.setUnderlyingWebElement(
                driver.findVisibleElement(By.id(appProps.getELEMENT_ID_PASSWORD_INPUT())));
        this.submitButton.setUnderlyingWebElement(
                driver.findVisibleElement(By.id(appProps.getELEMENT_ID_SUBMIT_BUTTON())));

        return this;
    }
}