package com.olenick.avatar.icare2.web.containers;

import java.util.EnumMap;

import javax.validation.constraints.NotNull;

import com.olenick.avatar.icare2.properties.ICare2Props;
import org.openqa.selenium.By;

import com.olenick.avatar.icare2.model.ProviderFilter;
import com.olenick.avatar.icare2.model.ProviderGrouping;
import com.olenick.selenium.containers.WebContainer;
import com.olenick.selenium.drivers.ExtendedRemoteWebDriver;
import com.olenick.selenium.elements.ExclusiveGroup;
import com.olenick.selenium.elements.ExtendedSelectWebElement;
import com.olenick.selenium.elements.ExtendedWebElement;

/**
 * "Filter by Provider" panel inside "REPORT FILTERS".
 */
public class FilterByProviderPanel extends WebContainer<FilterByProviderPanel> {
    private static ICare2Props appProps = ICare2Props.getInstance();

    private PatientExperienceIFrame parent;

    private ExtendedWebElement applyButton, closeButton, customGroupingRadio,
            departmentDivisionRadio, primarySpecialtyRadio;
    private ExclusiveGroup<ProviderGrouping> providerGroupingGroup;
    private ExtendedSelectWebElement customGroupingList,
            departmentDivisionList, primarySpecialtyList, providersList;
    private EnumMap<ProviderGrouping, ExtendedSelectWebElement> lists;

    public FilterByProviderPanel(@NotNull ExtendedRemoteWebDriver driver,
            PatientExperienceIFrame parent) {
        super(driver);

        this.parent = parent;

        this.closeButton = new ExtendedWebElement(this);

        this.departmentDivisionRadio = new ExtendedWebElement(this);
        this.primarySpecialtyRadio = new ExtendedWebElement(this);
        this.customGroupingRadio = new ExtendedWebElement(this);
        this.providerGroupingGroup = new ExclusiveGroup<>(
                ProviderGrouping.class);
        this.providerGroupingGroup
                .add(ProviderGrouping.PRIMARY_SPECIALTY,
                        this.primarySpecialtyRadio)
                .add(ProviderGrouping.DEPARTMENT_DIVISION,
                        this.departmentDivisionRadio)
                .add(ProviderGrouping.CUSTOM, this.customGroupingRadio);

        this.customGroupingList = new ExtendedSelectWebElement(this);
        this.departmentDivisionList = new ExtendedSelectWebElement(this);
        this.primarySpecialtyList = new ExtendedSelectWebElement(this);
        this.lists = new EnumMap<>(ProviderGrouping.class);
        this.lists.put(ProviderGrouping.CUSTOM, this.customGroupingList);
        this.lists.put(ProviderGrouping.DEPARTMENT_DIVISION,
                this.departmentDivisionList);
        this.lists.put(ProviderGrouping.PRIMARY_SPECIALTY,
                this.primarySpecialtyList);
        this.providersList = new ExtendedSelectWebElement(this);

        this.applyButton = new ExtendedWebElement(this);
    }

    public PatientExperienceIFrame close() {
        this.closeButton.click();
        return this.parent;
    }

    public PatientExperienceIFrame configureFilters(
            ProviderFilter providerFilter) {
        if (providerFilter != null) {
            ProviderGrouping grouping = providerFilter.getGrouping();
            this.providerGroupingGroup.safeSelect(grouping);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {
            }
            this.lists.get(grouping).selectByValue(
                    providerFilter.getGroupingElements());
            this.providersList.selectByValue(providerFilter.getProviders());
        }
        return this.parent;
    }

    @Override
    public FilterByProviderPanel waitForElementsToLoad() {
        this.closeButton.setUnderlyingWebElement(this.driver.findElement(By
                .id(appProps.getPF_ELEMENT_ID_CLOSE_BUTTON())));

        this.departmentDivisionRadio.setUnderlyingWebElement(this.driver
                .findElement(By.id(appProps.getPF_ELEMENT_ID_DEPARTMENT_DIVISION_RADIO())));
        this.primarySpecialtyRadio.setUnderlyingWebElement(this.driver
                .findElement(By.id(appProps.getPF_ELEMENT_ID_PRIMARY_SPECIALTY_RADIO())));
        this.customGroupingRadio.setUnderlyingWebElement(this.driver
                .findElement(By.id(appProps.getPF_ELEMENT_ID_CUSTOM_GROUPING_RADIO())));

        this.customGroupingList.setUnderlyingWebElement(this.driver
                .findElement(By.id(appProps.getPF_ELEMENT_ID_CUSTOM_GROUPING_LIST())));
        this.departmentDivisionList.setUnderlyingWebElement(this.driver
                .findElement(By.id(appProps.getPF_ELEMENT_ID_DEPARTMENT_DIVISION_LIST())));
        this.primarySpecialtyList.setUnderlyingWebElement(this.driver
                .findElement(By.id(appProps.getPF_ELEMENT_ID_PRIMARY_SPECIALTY_LIST())));

        this.providersList.setUnderlyingWebElement(this.driver.findElement(By
                .id(appProps.getPF_ELEMENT_ID_PROVIDERS_LIST())));

        this.applyButton.setUnderlyingWebElement(this.driver.findElement(By
                .id(appProps.getPF_ELEMENT_ID_APPLY_BUTTON())));

        return this;
    }
}
