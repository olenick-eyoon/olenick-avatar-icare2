package com.olenick.avatar.icare2.web.containers;

import java.time.Month;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.constraints.NotNull;

import com.olenick.avatar.icare2.properties.ICare2Props;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.olenick.avatar.icare2.model.MonthSpec;
import com.olenick.selenium.containers.WebContainer;
import com.olenick.selenium.drivers.ExtendedRemoteWebDriver;
import com.olenick.selenium.elements.ExtendedWebElement;

/**
 * Date Picker panel.
 */
public class DatePickerPanel extends WebContainer<DatePickerPanel> {
    private static ICare2Props appProps = ICare2Props.getInstance();

    private static final Pattern YEAR_BUTTON_CLASS_PATTERN = Pattern
            .compile("^.*" + appProps.getELEMENT_CLASS_PREFIX_YEAR() + "([0-9]{4}).*$");

    private PatientExperienceIFrame parent;

    private EnumMap<Month, ExtendedWebElement> monthElements;
    private Map<String, ExtendedWebElement> yearElements;

    private ExtendedWebElement cancelButton, okButton;

    public DatePickerPanel(@NotNull final ExtendedRemoteWebDriver driver,
            PatientExperienceIFrame parent) {
        super(driver);

        this.parent = parent;

        this.monthElements = new EnumMap<>(Month.class);
        for (int monthIndex = 1; monthIndex <= 12; ++monthIndex) {
            this.monthElements.put(Month.of(monthIndex),
                    new ExtendedWebElement(this));
        }
        this.yearElements = new HashMap<>();

        this.okButton = new ExtendedWebElement(this);
        this.cancelButton = new ExtendedWebElement(this);
    }

    public PatientExperienceIFrame pick(final MonthSpec monthSpec) {
        this.yearElements.get(monthSpec.getYear()).click();
        this.monthElements.get(monthSpec.getMonth()).click();
        this.okButton.click();
        return this.parent;
    }

    public PatientExperienceIFrame safePick(final MonthSpec monthSpec) {
        if (monthSpec == null) {
            return this.cancel();
        } else {
            return this.pick(monthSpec);
        }
    }

    public PatientExperienceIFrame cancel() {
        this.cancelButton.click();
        return this.parent;
    }

    @Override
    public DatePickerPanel waitForElementsToLoad() {
        for (Map.Entry<Month, ExtendedWebElement> entry : this.monthElements
                .entrySet()) {
            entry.getValue().setUnderlyingWebElement(
                    this.driver.findElement(By
                            .className(appProps.getELEMENT_CLASS_PREFIX_MONTH()
                                    + (entry.getKey().getValue() - 1))));
        }
        List<WebElement> yearButtons = this.getDriver()
                .findElementsByClassName(appProps.getELEMENT_CLASS_YEAR_BUTTON());
        for (WebElement yearButton : yearButtons) {
            Matcher yearButtonMatcher = YEAR_BUTTON_CLASS_PATTERN
                    .matcher(yearButton.getAttribute(appProps.getATTRIBUTE_NAME_CLASS()));
            this.yearElements.put(yearButtonMatcher.replaceFirst("$1"),
                    new ExtendedWebElement(this, yearButton));
        }

        this.okButton.setUnderlyingWebElement(this.driver.findElement(By
                .className(appProps.getELEMENT_ID_OK_BUTTON())));
        this.cancelButton.setUnderlyingWebElement(this.driver.findElement(By
                .className(appProps.getELEMENT_ID_CANCEL_BUTTON())));

        return this;
    }
}
