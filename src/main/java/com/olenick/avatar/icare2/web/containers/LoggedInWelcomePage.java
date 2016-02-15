package com.olenick.avatar.icare2.web.containers;

import javax.validation.constraints.NotNull;

import com.olenick.avatar.icare2.properties.ICare2Props;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.olenick.selenium.containers.WebContainer;
import com.olenick.selenium.drivers.ExtendedRemoteWebDriver;
import com.olenick.selenium.elements.ExtendedWebElement;

/**
 * Improving Care Welcome page when logged in.
 */
public class LoggedInWelcomePage extends WebContainer<LoggedInWelcomePage> {
    private static ICare2Props appProps = ICare2Props.getInstance();

    private ExtendedWebElement homeTab, patientExperienceTab, controlCenterTab;
    private HomeIFrame homeFrame;
    private PatientExperienceIFrame patientExperienceFrame;
    private ControlCenterIFrame controlCenterFrame;

    public LoggedInWelcomePage(@NotNull ExtendedRemoteWebDriver driver) {
        super(driver);
        this.homeTab = new ExtendedWebElement(this);
        this.patientExperienceTab = new ExtendedWebElement(this);
        this.controlCenterTab = new ExtendedWebElement(this);
        this.homeFrame = new HomeIFrame(this.driver);
        this.patientExperienceFrame = new PatientExperienceIFrame(this.driver,
                this);
        this.controlCenterFrame = new ControlCenterIFrame(this.driver);
    }

    public HomeIFrame navigateToHomeTab() {
        //TODO: This is not working well
        //this.homeTab.click();
        this.homeTab.sendKeys(Keys.ENTER);
        return this.homeFrame;
    }

    public PatientExperienceIFrame navigateToPatientExperienceTab() {
        //TODO: This is not working well
        //this.patientExperienceTab.click();
        this.patientExperienceTab.sendKeys(Keys.ENTER);
        return this.patientExperienceFrame;
    }

    public ControlCenterIFrame navigateToControlCenterTab() {
        //TODO: This is not working well
        //this.controlCenterTab.click();
        this.controlCenterTab.sendKeys(Keys.ENTER);
        return this.controlCenterFrame;
    }

    public LoggedInWelcomePage switchToMainIFrame() {
        //TODO: Why is needed the following line?
        this.driver.switchTo().defaultContent();
        new WebDriverWait(this.driver, appProps.getTIMEOUT_SWITCH_TO_FRAME())
                .until(ExpectedConditions
                        .frameToBeAvailableAndSwitchToIt(By.name(appProps.getELEMENT_NAME_MAIN_IFRAME())));
        return this;
    }

    @Override
    public LoggedInWelcomePage waitForElementsToLoad() {
        this.switchToMainIFrame();
        this.homeTab.setUnderlyingWebElement(this.driver.findElement(ExpectedConditions.elementToBeClickable(By
                .xpath(appProps.getXPATH_HOME_TAB()))));
        this.patientExperienceTab.setUnderlyingWebElement(this.driver
                .findElement(ExpectedConditions.elementToBeClickable(By.xpath(appProps.getXPATH_PATIENT_EXPERIENCE_TAB()))));
        this.controlCenterTab.setUnderlyingWebElement(this.driver
                .findElement(ExpectedConditions.elementToBeClickable(By.xpath(appProps.getXPATH_CONTROL_CENTER_TAB()))));
        return this;
    }
}
