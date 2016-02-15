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
public class CompositeTabIFrame extends
        ReportGraphsTabIFrame<CompositeTabIFrame> {
    private static ICare2Props appProps = ICare2Props.getInstance();
    private static final Logger log = LoggerFactory
            .getLogger(CompositeTabIFrame.class);

    private PatientExperienceIFrame parent;

    public CompositeTabIFrame(@NotNull ExtendedRemoteWebDriver driver,
            PatientExperienceIFrame parent) {
        super(driver);
        this.parent = parent;
    }

    public CompositeTabIFrame accessGridFrame() {
        return this.accessFrame(appProps.getC_ELEMENT_ID_GRID_FRAME());
    }

    public CompositeTabIFrame accessCompositeBarGraphFrame() {
        return this.accessFrame(appProps.getC_ELEMENT_ID_COMPOSITE_BAR_GRAPH_FRAME());
    }

    public CompositeTabIFrame accessItemBarGraphFrame() {
        return this.accessFrame(appProps.getC_ELEMENT_ID_ITEM_BAR_GRAPH_FRAME());
    }

    public CompositeTabIFrame accessLineGraphFrame() {
        return this.accessFrame(appProps.getC_ELEMENT_ID_LINE_GRAPH_FRAME());
    }

    public CompositeTabIFrame accessResultsFrame() {
        this.parent.accessPanelFrame();
        this.switchToFrame(appProps.getC_ELEMENT_ID_RESULTS_FRAME());
        return this;
    }

    @Override
    public CompositeTabIFrame waitForElementsToLoad() {
        this.accessCompositeBarGraphFrame().waitForResults();
        this.accessItemBarGraphFrame().waitForResults();
        this.accessLineGraphFrame().waitForResults();
        this.accessGridFrame().waitForResults();
        return this;
    }

    private CompositeTabIFrame accessFrame(String frameId) {
        this.accessResultsFrame();
        this.switchToFrame(frameId);
        return this;
    }

    @Override
    public CompositeTabIFrame exportToPDF() {
        this.accessResultsFrame();
        this.driver.findElement(By.id(appProps.getC_ELEMENT_ID_EXPORT_ALL_TO_PDF_LINK()))
                .click();
        this.handlePDFNewWindow();
        return this;
    }

    @Override
    public ReportValues getValues() {
        throw new NotImplementedException();
    }
}
