package com.olenick.avatar.icare2.web.containers;

import javax.validation.constraints.NotNull;

import com.olenick.avatar.icare2.properties.ICare2Props;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.olenick.avatar.icare2.exceptions.NotImplementedException;
import com.olenick.avatar.icare2.model.report_values.ReportValues;
import com.olenick.selenium.drivers.ExtendedRemoteWebDriver;

/**
 * Report composite tab.
 */
public class DemographicsTabIFrame extends
        ReportGraphsTabIFrame<DemographicsTabIFrame> {
    private static ICare2Props appProps = ICare2Props.getInstance();
    private static final Logger log = LoggerFactory
            .getLogger(DemographicsTabIFrame.class);

    private PatientExperienceIFrame parent;

    public DemographicsTabIFrame(@NotNull ExtendedRemoteWebDriver driver,
            PatientExperienceIFrame parent) {
        super(driver);
        this.parent = parent;
    }

    public DemographicsTabIFrame accessBarGraphFrame() {
        return this.accessFrame(appProps.getD_ELEMENT_ID_BAR_GRAPH_FRAME());
    }

    public DemographicsTabIFrame accessGridFrame() {
        return this.accessFrame(appProps.getD_ELEMENT_ID_GRID_FRAME());
    }

    public DemographicsTabIFrame accessLineGraphFrame() {
        return this.accessFrame(appProps.getD_ELEMENT_ID_LINE_GRAPH_FRAME());
    }

    public DemographicsTabIFrame accessResultsFrame() {
        this.parent.accessPanelFrame();
        this.switchToFrame(appProps.getD_ELEMENT_ID_RESULTS_FRAME());
        return this;
    }

    @Override
    public DemographicsTabIFrame waitForElementsToLoad() {
        this.accessBarGraphFrame().waitForResults();
        this.accessLineGraphFrame().waitForResults();
        this.accessGridFrame().waitForResults();
        return this;
    }

    private DemographicsTabIFrame accessFrame(String frameId) {
        this.accessResultsFrame();
        this.switchToFrame(frameId);
        return this;
    }

    @Override
    public DemographicsTabIFrame exportToPDF() {
        this.accessResultsFrame();
        this.driver.findElement(By.id(appProps.getD_ELEMENT_ID_EXPORT_ALL_TO_PDF_LINK()))
                .click();
        this.handlePDFNewWindow();
        return this;
    }

    @Override
    public ReportValues getValues() {
        throw new NotImplementedException();
    }
}
