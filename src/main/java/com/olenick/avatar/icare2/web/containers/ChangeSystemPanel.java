package com.olenick.avatar.icare2.web.containers;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.olenick.avatar.icare2.properties.ICare2Props;
import com.olenick.selenium.drivers.ExtendedRemoteWebDriver;
import com.olenick.selenium.elements.ExtendedSelectWebElement;
import com.olenick.selenium.elements.ExtendedWebElement;

/**
 * "Change System" panel.
 */
public class ChangeSystemPanel extends WelcomePageIFrame<ChangeSystemPanel> {
    private static ICare2Props appProps = ICare2Props.getInstance();

    private final PatientExperienceIFrame parent;
    private ExtendedWebElement searchInput, searchButton, resetSearchButton;
    private ExtendedSelectWebElement systemSelect;
    private ExtendedWebElement applyButton, closeButton;

    public ChangeSystemPanel(@NotNull final ExtendedRemoteWebDriver driver,
            @NotNull final PatientExperienceIFrame parent) {
        super(driver);
        this.parent = parent;

        this.searchInput = new ExtendedWebElement(this);
        this.searchButton = new ExtendedWebElement(this);
        this.resetSearchButton = new ExtendedWebElement(this);
        this.systemSelect = new ExtendedSelectWebElement(this);
        this.applyButton = new ExtendedWebElement(this);
        this.closeButton = new ExtendedWebElement(this);
    }

    public LoggedInWelcomePage chooseSystem(@Null final String systemCode,
            @Null final String searchString, @Null final String systemName) {
        if (searchString != null) {
            this.searchInput.sendKeys(searchString);
            this.searchButton.click();
        }
        if (systemCode == null) {
            this.systemSelect.selectByVisibleText(systemName);
        } else {
            this.systemSelect.selectByValue(systemCode);
        }

        this.applyButton.click();

        // TODO: Investigate and remove.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }

        return new LoggedInWelcomePage(this.getDriver());
    }

    public PatientExperienceIFrame close() {
        this.accessPanelFrame();
        this.closeButton.click();
        return this.parent;
    }

    @Override
    public ChangeSystemPanel waitForElementsToLoad() {
        this.accessPanelFrame();
        this.setElements(this.closeButton).byId(appProps.getELEMENT_ID_CLOSE_BUTTON());

        this.accessChangeSysFrame();
        this.setElements(this.searchInput, this.searchButton,
                this.resetSearchButton, this.systemSelect, this.applyButton)
                .byId(true,
                        appProps.getELEMENT_ID_SEARCH_INPUT(),
                        appProps.getELEMENT_ID_SEARCH_BUTTON(),
                        appProps.getELEMENT_ID_RESET_SEARCH_BUTTON(),
                        appProps.getELEMENT_ID_SYSTEM_SELECT(),
                        appProps.getELEMENT_ID_APPLY_BUTTON());

        return this;
    }

    protected ChangeSystemPanel accessChangeSysFrame() {
        this.accessPanelFrame();
        this.switchToFrame(appProps.getELEMENT_ID_CHANGESYS_IFRAME());
        return this;
    }
}
