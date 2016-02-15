package com.olenick.avatar.icare2.web.containers;

import javax.validation.constraints.NotNull;

import com.olenick.avatar.icare2.properties.ICare2Props;
import org.openqa.selenium.By;

import com.olenick.avatar.icare2.model.PatientDemographics;
import com.olenick.avatar.icare2.web.elements.AvatarMultiselectWebElement;
import com.olenick.selenium.containers.WebContainer;
import com.olenick.selenium.drivers.ExtendedRemoteWebDriver;
import com.olenick.selenium.elements.ExtendedWebElement;

/**
 * "Filter by Demographics" panel inside "REPORT FILTERS".
 */
public class FilterByDemographicsPanel extends
        WebContainer<FilterByDemographicsPanel> {
    private static ICare2Props appProps = ICare2Props.getInstance();

    private PatientExperienceIFrame parent;

    private AvatarMultiselectWebElement admissionSourceSelect, ageSelect,
            dischargeStatusSelect, genderSelect, languageSelect,
            lengthOfStaySelect, raceSelect, serviceLineSelect;
    private ExtendedWebElement applyButton, closeButton;

    public FilterByDemographicsPanel(@NotNull ExtendedRemoteWebDriver driver,
            PatientExperienceIFrame parent) {
        super(driver);

        this.parent = parent;

        this.closeButton = new ExtendedWebElement(this);

        this.admissionSourceSelect = new AvatarMultiselectWebElement(this);
        this.ageSelect = new AvatarMultiselectWebElement(this);
        this.dischargeStatusSelect = new AvatarMultiselectWebElement(this);
        this.genderSelect = new AvatarMultiselectWebElement(this);

        this.languageSelect = new AvatarMultiselectWebElement(this);
        this.lengthOfStaySelect = new AvatarMultiselectWebElement(this);
        this.raceSelect = new AvatarMultiselectWebElement(this);
        this.serviceLineSelect = new AvatarMultiselectWebElement(this);

        this.applyButton = new ExtendedWebElement(this);
    }

    public PatientExperienceIFrame close() {
        this.closeButton.click();
        return this.parent;
    }

    public PatientExperienceIFrame configureFilters(
            PatientDemographics demographics) {
        if (demographics != null) {
            this.admissionSourceSelect.selectByValue(demographics
                    .getAdmissionSources());
            this.ageSelect.selectByValue(demographics.getAges());
            this.dischargeStatusSelect.selectByValue(demographics
                    .getDischargeStatuses());
            this.genderSelect.selectByValue(demographics.getGenders());

            this.languageSelect.selectByValue(demographics.getLanguages());
            this.lengthOfStaySelect.selectByValue(demographics
                    .getLengthsOfStay());
            this.raceSelect.selectByValue(demographics.getRaces());
            this.serviceLineSelect
                    .selectByValue(demographics.getServiceLines());

            this.applyButton.click();
        }
        return this.parent;
    }

    @Override
    public FilterByDemographicsPanel waitForElementsToLoad() {
        this.closeButton.setUnderlyingWebElement(this.driver
                .findVisibleElement(By.id(appProps.getDF_ELEMENT_ID_CLOSE_BUTTON())));

        this.admissionSourceSelect.setUnderlyingWebElement(this.driver
                .findVisibleElement(By.id(appProps.getDF_ELEMENT_ID_ADMISSION_SOURCE_SELECT())));
        this.ageSelect.setUnderlyingWebElement(this.driver
                .findVisibleElement(By.id(appProps.getDF_ELEMENT_ID_AGE_SELECT())));
        this.dischargeStatusSelect.setUnderlyingWebElement(this.driver
                .findVisibleElement(By.id(appProps.getDF_ELEMENT_ID_DISCHARGE_STATUS_SELECT())));
        this.genderSelect.setUnderlyingWebElement(this.driver
                .findVisibleElement(By.id(appProps.getDF_ELEMENT_ID_GENDER_SELECT())));

        this.languageSelect.setUnderlyingWebElement(this.driver
                .findVisibleElement(By.id(appProps.getDF_ELEMENT_ID_LANGUAGE_SELECT())));
        this.lengthOfStaySelect.setUnderlyingWebElement(this.driver
                .findVisibleElement(By.id(appProps.getDF_ELEMENT_ID_LENGTH_OF_STAY())));
        this.raceSelect.setUnderlyingWebElement(this.driver
                .findVisibleElement(By.id(appProps.getDF_ELEMENT_ID_RACE_SELECT())));
        this.serviceLineSelect.setUnderlyingWebElement(this.driver
                .findVisibleElement(By.id(appProps.getDF_ELEMENT_ID_SERVICE_LINE_SELECT())));

        this.applyButton.setUnderlyingWebElement(this.driver
                .findVisibleElement(By.id(appProps.getDF_ELEMENT_ID_APPLY_BUTTON())));

        return this;
    }
}
