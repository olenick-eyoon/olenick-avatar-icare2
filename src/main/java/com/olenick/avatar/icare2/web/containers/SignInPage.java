package com.olenick.avatar.icare2.web.containers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by eyoon on 1/7/2016.
 */
public class SignInPage extends BasePageObject {
    //Locators

    //Username Text Input
    @FindBy(how = How.CSS, using = "input#SignonUserName.signin-custom-username-editbox-input")
    private WebElement input_username;

    //Password Text Input
    @FindBy(how = How.ID, using = "SignonPassName")
    private WebElement input_passname;

    //Sign In Button
    @FindBy(how = How.ID, using = "SignonbtnLogin")
    private WebElement button_sign_in;

    //Constructor
    public SignInPage(WebDriver driver, String urlRoot) {
        super(driver, urlRoot);

        //Initialise Elements
        PageFactory.initElements(this.driver, this);
    }

    //Page Actions
    public SignInPage pageLoad() {
        this.driver.get(this.urlRoot + appProps.getRELATIVE_URL());

        return this;
    }

    public SignInPage pageSign_in(String username, String password) {
        this.setInput_username(username);
        this.setInput_passname(password);
        this.clickButton_sign_in();

        return this;
    }

    public SignInPage setInput_username(String username) {
        return (SignInPage) this.setInput_value(this.input_username, username);
    }

    public SignInPage setInput_passname(String password) {
        return (SignInPage) this.setInput_value(this.input_passname, password);
    }

    public SignInPage clickButton_sign_in() {
        return (SignInPage) this.clickButton(this.button_sign_in);
    }
}
