package com.olenick.avatar.icare2.web.containers;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.olenick.avatar.icare2.properties.ICare2Props;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.olenick.avatar.icare2.model.report_values.HCAHPSNationalValue;
import com.olenick.avatar.icare2.model.report_values.ReportValues;
import com.olenick.selenium.drivers.ExtendedRemoteWebDriver;

/**
 * Report Overview tab.
 */
public class HCAHPSNationalTabIFrame extends
        ReportGraphsTabIFrame<HCAHPSNationalTabIFrame> {
    private static ICare2Props appProps = ICare2Props.getInstance();

    private PatientExperienceIFrame parent;

    public HCAHPSNationalTabIFrame(@NotNull ExtendedRemoteWebDriver driver,
            PatientExperienceIFrame parent) {
        super(driver);
        this.parent = parent;
    }

    public HCAHPSNationalTabIFrame accessGraphsFrame() {
        this.accessResultsFrame();
        this.switchToFrame(appProps.getHCSHPS_ELEMENT_ID_GRAPHS_FRAME());
        return this;
    }

    public HCAHPSNationalTabIFrame accessResultsFrame() {
        this.parent.accessPanelFrame();
        this.switchToFrame(appProps.getHCSHPS_ELEMENT_ID_RESULTS_FRAME());
        return this;
    }

    @Override
    public HCAHPSNationalTabIFrame waitForElementsToLoad() {
        this.accessGraphsFrame().waitForResults();
        return this;
    }

    @Override
    public HCAHPSNationalTabIFrame exportToPDF() {
        throw new RuntimeException("Not implemented yet");
    }

    public ReportValues getValues() {
        ReportValues result = new ReportValues();
        if (this.dataAvailable) {
            for (WebElement row : this.getRows()) {
                String itemName = row
                        .findElement(By.xpath(appProps.getHCSHPS_XPATH_RELATIVE_ITEM_NAME()))
                        .getText().trim();
                float adjustedScore = Float.valueOf(row
                        .findElement(By.xpath(appProps.getHCSHPS_XPATH_RELATIVE_ADJUSTED_SCORE()))
                        .getText().trim());
                result.set(itemName, new HCAHPSNationalValue(adjustedScore));
            }
        } else {
            result.setDataAvailable(false);
        }
        return result;
    }

    private List<WebElement> getRows() {
        List<WebElement> rows = this.getDriver().findElements(
                By.xpath(appProps.getHCSHPS_XPATH_ROWS()), appProps.getHCSHPS_TIMEOUT_SECS_GET_ROWS());
        return rows;
    }
}
