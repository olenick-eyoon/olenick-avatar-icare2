package com.olenick.avatar.icare2.web.containers;

import com.olenick.avatar.icare2.properties.ICare2Props;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by eyoon on 1/8/2016.
 */
public abstract class BasePageObject {
    //Logger
    protected final static Logger log = LoggerFactory.getLogger(PatientExperienceIFrame.class);

    //ICare2 Properties
    protected final static ICare2Props appProps = ICare2Props.getInstance();

    //Webdriver
    protected WebDriver driver;

    //Page URL Root
    protected String urlRoot;

    BasePageObject(WebDriver driver, String urlRoot) {
        this.driver = driver;
        this.urlRoot = urlRoot;
    }

    public BasePageObject setInput_value(WebElement element, String value) {
        //The click does the magic to set focus
        element.click();
        element.clear();
        element.sendKeys(value);

        return this;
    }

    public BasePageObject clickButton(WebElement element) {
        element.click();

        return this;
    }
}
