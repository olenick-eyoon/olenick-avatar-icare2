package com.olenick.avatar.icare2.web.containers;

import javax.validation.constraints.NotNull;

import com.olenick.avatar.icare2.properties.ICare2Props;
import org.openqa.selenium.By;

import com.olenick.avatar.icare2.model.ResponseFilter;
import com.olenick.selenium.containers.WebContainer;
import com.olenick.selenium.drivers.ExtendedRemoteWebDriver;
import com.olenick.selenium.elements.ExtendedSelectWebElement;
import com.olenick.selenium.elements.ExtendedWebElement;

/**
 * "Filter by Response" panel inside "REPORT FILTERS".
 */
public class FilterByResponsePanel extends WebContainer<FilterByResponsePanel> {
    private static ICare2Props appProps = ICare2Props.getInstance();

    private PatientExperienceIFrame parent;

    private ExtendedWebElement addButton, applyButton, closeButton,
            removeButton;
    private ExtendedSelectWebElement availableList, compositeSelect,
            itemSelect, patientTypeSelect, selectedList, surveyTypeSelect;

    public FilterByResponsePanel(@NotNull ExtendedRemoteWebDriver driver,
            PatientExperienceIFrame parent) {
        super(driver);

        this.parent = parent;

        this.closeButton = new ExtendedWebElement(this);

        this.surveyTypeSelect = new ExtendedSelectWebElement(this);
        this.patientTypeSelect = new ExtendedSelectWebElement(this);
        this.compositeSelect = new ExtendedSelectWebElement(this);

        this.itemSelect = new ExtendedSelectWebElement(this);

        this.availableList = new ExtendedSelectWebElement(this);
        this.addButton = new ExtendedWebElement(this);
        this.removeButton = new ExtendedWebElement(this);
        this.selectedList = new ExtendedSelectWebElement(this);

        this.applyButton = new ExtendedWebElement(this);
    }

    public PatientExperienceIFrame close() {
        this.closeButton.click();
        return this.parent;
    }

    public PatientExperienceIFrame configureFilters(
            ResponseFilter responseFilter) {
        if (responseFilter != null) {
            this.surveyTypeSelect.selectByValue(responseFilter.getSurveyType());
            this.patientTypeSelect.selectByValue(responseFilter
                    .getPatientType());
            this.compositeSelect.selectByValue(responseFilter.getComposite());

            this.itemSelect.selectByValue(responseFilter.getItem());

            this.availableList.selectByValue(responseFilter.getResponses());
            this.addButton.click();
        }
        return this.parent;
    }

    @Override
    public FilterByResponsePanel waitForElementsToLoad() {
        this.closeButton.setUnderlyingWebElement(this.driver.findElement(By
                .id(appProps.getRF_ELEMENT_ID_CLOSE_BUTTON())));

        this.surveyTypeSelect.setUnderlyingWebElement(this.driver
                .findElement(By.id(appProps.getRF_ELEMENT_ID_SURVEY_TYPE_SELECT())));
        this.patientTypeSelect.setUnderlyingWebElement(this.driver
                .findElement(By.id(appProps.getRF_ELEMENT_ID_PATIENT_TYPE_SELECT())));
        this.compositeSelect.setUnderlyingWebElement(this.driver.findElement(By
                .id(appProps.getRF_ELEMENT_ID_COMPOSITE_SELECT())));

        this.itemSelect.setUnderlyingWebElement(this.driver.findElement(By
                .id(appProps.getRF_ELEMENT_ID_ITEM_SELECT())));

        this.availableList.setUnderlyingWebElement(this.driver.findElement(By
                .id(appProps.getRF_ELEMENT_ID_AVAILABLE_LIST())));
        this.addButton.setUnderlyingWebElement(this.driver.findElement(By
                .id(appProps.getRF_ELEMENT_ID_ADD_BUTTON())));
        this.removeButton.setUnderlyingWebElement(this.driver.findElement(By
                .id(appProps.getRF_ELEMENT_ID_REMOVE_BUTTON())));
        this.selectedList.setUnderlyingWebElement(this.driver.findElement(By
                .id(appProps.getRF_ELEMENT_ID_SELECTED_LIST())));

        this.applyButton.setUnderlyingWebElement(this.driver.findElement(By
                .id(appProps.getRF_ELEMENT_ID_APPLY_BUTTON())));

        return this;
    }
}
