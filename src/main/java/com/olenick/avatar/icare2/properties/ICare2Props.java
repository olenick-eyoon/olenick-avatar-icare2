package com.olenick.avatar.icare2.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ICare2Props {
    private static final String PROPERTIES_FILE_NAME = "icare2.properties";
    private static ICare2Props props;
    private static Properties applicationProps;
    private static final Logger log = LoggerFactory.getLogger(ICare2Props.class);

    private ICare2Props() {
        // create and load default properties
        Properties defaultProps = new Properties();
        FileInputStream in;

        try {
            in = new FileInputStream(PROPERTIES_FILE_NAME);
            defaultProps.load(in);
            in.close();

            // create application properties with default
            applicationProps = new Properties(defaultProps);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // getters for LoginPage
    public static String getELEMENT_ID_INVALID_CREDENTIALS_ERROR_MESSAGE() { return applicationProps.getProperty("ELEMENT_ID_INVALID_CREDENTIALS_ERROR_MESSAGE"); }
    public static String getELEMENT_ID_PASSWORD_INPUT() { return applicationProps.getProperty("ELEMENT_ID_PASSWORD_INPUT"); }
    public static String getELEMENT_ID_SUBMIT_BUTTON() { return applicationProps.getProperty("ELEMENT_ID_SUBMIT_BUTTON"); }
    public String getELEMENT_ID_USERNAME_INPUT() { return applicationProps.getProperty("ELEMENT_ID_USERNAME_INPUT"); }
    public static String getRELATIVE_URL() { return applicationProps.getProperty("RELATIVE_URL"); }

    // LoggedInWelcomePage
    public static Long getTIMEOUT_SWITCH_TO_FRAME() { return Long.parseLong(applicationProps.getProperty("TIMEOUT_SWITCH_TO_FRAME")); }
    public static String getELEMENT_NAME_MAIN_IFRAME() { return applicationProps.getProperty("ELEMENT_NAME_MAIN_IFRAME"); }
    public static String getXPATH_MENU_BAR() { return applicationProps.getProperty("XPATH_MENU_BAR"); }
    public static String getXPATH_HOME_TAB() { return applicationProps.getProperty("XPATH_HOME_TAB"); }
    public static String getXPATH_PATIENT_EXPERIENCE_TAB() { return applicationProps.getProperty("XPATH_PATIENT_EXPERIENCE_TAB"); }
    public static String getXPATH_CONTROL_CENTER_TAB() { return applicationProps.getProperty("XPATH_CONTROL_CENTER_TAB"); }

    // ChangeSystemPanel
    public static String getELEMENT_ID_APPLY_BUTTON() { return applicationProps.getProperty("ELEMENT_ID_APPLY_BUTTON"); }
    public static String getELEMENT_ID_CHANGESYS_IFRAME() { return applicationProps.getProperty("ELEMENT_ID_CHANGESYS_IFRAME"); }
    public static String getELEMENT_ID_CLOSE_BUTTON() { return applicationProps.getProperty("ELEMENT_ID_CLOSE_BUTTON"); }
    public static String getELEMENT_ID_RESET_SEARCH_BUTTON() { return applicationProps.getProperty("ELEMENT_ID_RESET_SEARCH_BUTTON"); }
    public static String getELEMENT_ID_SEARCH_BUTTON() { return applicationProps.getProperty("ELEMENT_ID_SEARCH_BUTTON"); }
    public static String getELEMENT_ID_SEARCH_INPUT() { return applicationProps.getProperty("ELEMENT_ID_SEARCH_INPUT"); }
    public static String getELEMENT_ID_SYSTEM_SELECT() { return applicationProps.getProperty("ELEMENT_ID_SYSTEM_SELECT"); }

    // CompositeTabIframe
    public static String getC_ELEMENT_ID_COMPOSITE_BAR_GRAPH_FRAME() { return applicationProps.getProperty("C_ELEMENT_ID_COMPOSITE_BAR_GRAPH_FRAME"); }
    public static String getC_ELEMENT_ID_EXPORT_ALL_TO_PDF_LINK() { return applicationProps.getProperty("C_ELEMENT_ID_EXPORT_ALL_TO_PDF_LINK"); }
    public static String getC_ELEMENT_ID_GRID_FRAME() { return applicationProps.getProperty("C_ELEMENT_ID_GRID_FRAME"); }
    public static String getC_ELEMENT_ID_ITEM_BAR_GRAPH_FRAME() { return applicationProps.getProperty("C_ELEMENT_ID_ITEM_BAR_GRAPH_FRAME"); }
    public static String getC_ELEMENT_ID_LINE_GRAPH_FRAME() { return applicationProps.getProperty("C_ELEMENT_ID_LINE_GRAPH_FRAME"); }
    public static String getC_ELEMENT_ID_RESULTS_FRAME() { return applicationProps.getProperty("C_ELEMENT_ID_RESULTS_FRAME"); }

    // DatePickerPanel
    public static String getATTRIBUTE_NAME_CLASS() { return applicationProps.getProperty("ATTRIBUTE_NAME_CLASS"); }
    public static String getELEMENT_ID_OK_BUTTON() { return applicationProps.getProperty("ELEMENT_ID_OK_BUTTON"); }
    public static String getELEMENT_ID_CANCEL_BUTTON() { return applicationProps.getProperty("ELEMENT_ID_CANCEL_BUTTON"); }
    public static String getELEMENT_CLASS_PREFIX_MONTH() { return applicationProps.getProperty("ELEMENT_CLASS_PREFIX_MONTH"); }
    public static String getELEMENT_CLASS_PREFIX_YEAR() { return applicationProps.getProperty("ELEMENT_CLASS_PREFIX_YEAR"); }
    public static String getELEMENT_CLASS_YEAR_BUTTON() { return applicationProps.getProperty("ELEMENT_CLASS_YEAR_BUTTON"); }

    // DemographicsTabIFrame
    public static String getD_ELEMENT_ID_BAR_GRAPH_FRAME() { return applicationProps.getProperty("D_ELEMENT_ID_BAR_GRAPH_FRAME"); }
    public static String getD_ELEMENT_ID_EXPORT_ALL_TO_PDF_LINK() { return applicationProps.getProperty("D_ELEMENT_ID_EXPORT_ALL_TO_PDF_LINK"); }
    public static String getD_ELEMENT_ID_GRID_FRAME() { return applicationProps.getProperty("D_ELEMENT_ID_GRID_FRAME"); }
    public static String getD_ELEMENT_ID_LINE_GRAPH_FRAME() { return applicationProps.getProperty("D_ELEMENT_ID_LINE_GRAPH_FRAME"); }
    public static String getD_ELEMENT_ID_RESULTS_FRAME() { return applicationProps.getProperty("D_ELEMENT_ID_RESULTS_FRAME"); }

    // FilterByDemographicsPanel
    public static String getDF_ELEMENT_ID_ADMISSION_SOURCE_SELECT() { return applicationProps.getProperty("DF_ELEMENT_ID_ADMISSION_SOURCE_SELECT"); }
    public static String getDF_ELEMENT_ID_AGE_SELECT() { return applicationProps.getProperty("DF_ELEMENT_ID_AGE_SELECT"); }
    public static String getDF_ELEMENT_ID_APPLY_BUTTON() { return applicationProps.getProperty("DF_ELEMENT_ID_APPLY_BUTTON"); }
    public static String getDF_ELEMENT_ID_CLOSE_BUTTON() { return applicationProps.getProperty("DF_ELEMENT_ID_CLOSE_BUTTON"); }
    public static String getDF_ELEMENT_ID_DISCHARGE_STATUS_SELECT() { return applicationProps.getProperty("DF_ELEMENT_ID_DISCHARGE_STATUS_SELECT"); }
    public static String getDF_ELEMENT_ID_GENDER_SELECT() { return applicationProps.getProperty("DF_ELEMENT_ID_GENDER_SELECT"); }
    public static String getDF_ELEMENT_ID_LANGUAGE_SELECT() { return applicationProps.getProperty("DF_ELEMENT_ID_LANGUAGE_SELECT"); }
    public static String getDF_ELEMENT_ID_LENGTH_OF_STAY() { return applicationProps.getProperty("DF_ELEMENT_ID_LENGTH_OF_STAY"); }
    public static String getDF_ELEMENT_ID_RACE_SELECT() { return applicationProps.getProperty("DF_ELEMENT_ID_RACE_SELECT"); }
    public static String getDF_ELEMENT_ID_SERVICE_LINE_SELECT() { return applicationProps.getProperty("DF_ELEMENT_ID_SERVICE_LINE_SELECT"); }

    // FilterByProviderPanel
    public static String getPF_ELEMENT_ID_APPLY_BUTTON() { return applicationProps.getProperty("PF_ELEMENT_ID_APPLY_BUTTON"); }
    public static String getPF_ELEMENT_ID_CLOSE_BUTTON() { return applicationProps.getProperty("PF_ELEMENT_ID_CLOSE_BUTTON"); }
    public static String getPF_ELEMENT_ID_CUSTOM_GROUPING_LIST() { return applicationProps.getProperty("PF_ELEMENT_ID_CUSTOM_GROUPING_LIST"); }
    public static String getPF_ELEMENT_ID_CUSTOM_GROUPING_RADIO() { return applicationProps.getProperty("PF_ELEMENT_ID_CUSTOM_GROUPING_RADIO"); }
    public static String getPF_ELEMENT_ID_DEPARTMENT_DIVISION_LIST() { return applicationProps.getProperty("PF_ELEMENT_ID_DEPARTMENT_DIVISION_LIST"); }
    public static String getPF_ELEMENT_ID_DEPARTMENT_DIVISION_RADIO() { return applicationProps.getProperty("PF_ELEMENT_ID_DEPARTMENT_DIVISION_RADIO"); }
    public static String getPF_ELEMENT_ID_PRIMARY_SPECIALTY_LIST() { return applicationProps.getProperty("PF_ELEMENT_ID_PRIMARY_SPECIALTY_LIST"); }
    public static String getPF_ELEMENT_ID_PRIMARY_SPECIALTY_RADIO() { return applicationProps.getProperty("PF_ELEMENT_ID_PRIMARY_SPECIALTY_RADIO"); }
    public static String getPF_ELEMENT_ID_PROVIDERS_LIST() { return applicationProps.getProperty("PF_ELEMENT_ID_PROVIDERS_LIST"); }

    // FilterByResponsePanel
    public static String getRF_ELEMENT_ID_ADD_BUTTON() { return applicationProps.getProperty("RF_ELEMENT_ID_ADD_BUTTON"); }
    public static String getRF_ELEMENT_ID_APPLY_BUTTON() { return applicationProps.getProperty("RF_ELEMENT_ID_APPLY_BUTTON"); }
    public static String getRF_ELEMENT_ID_AVAILABLE_LIST() { return applicationProps.getProperty("RF_ELEMENT_ID_AVAILABLE_LIST"); }
    public static String getRF_ELEMENT_ID_CLOSE_BUTTON() { return applicationProps.getProperty("RF_ELEMENT_ID_CLOSE_BUTTON"); }
    public static String getRF_ELEMENT_ID_COMPOSITE_SELECT() { return applicationProps.getProperty("RF_ELEMENT_ID_COMPOSITE_SELECT"); }
    public static String getRF_ELEMENT_ID_ITEM_SELECT() { return applicationProps.getProperty("RF_ELEMENT_ID_ITEM_SELECT"); }
    public static String getRF_ELEMENT_ID_PATIENT_TYPE_SELECT() { return applicationProps.getProperty("RF_ELEMENT_ID_PATIENT_TYPE_SELECT"); }
    public static String getRF_ELEMENT_ID_REMOVE_BUTTON() { return applicationProps.getProperty("RF_ELEMENT_ID_REMOVE_BUTTON"); }
    public static String getRF_ELEMENT_ID_SELECTED_LIST() { return applicationProps.getProperty("RF_ELEMENT_ID_SELECTED_LIST"); }
    public static String getRF_ELEMENT_ID_SURVEY_TYPE_SELECT() { return applicationProps.getProperty("RF_ELEMENT_ID_SURVEY_TYPE_SELECT"); }

    // HCAHPSNationalTabIFrame
    public static Long getHCSHPS_TIMEOUT_SECS_GET_ROWS() { return Long.parseLong(applicationProps.getProperty("HCSHPS_TIMEOUT_SECS_GET_ROWS")); }
    public static String getHCSHPS_ELEMENT_ID_GRAPHS_FRAME() { return applicationProps.getProperty("HCSHPS_ELEMENT_ID_GRAPHS_FRAME"); }
    public static String getHCSHPS_ELEMENT_ID_RESULTS_FRAME() { return applicationProps.getProperty("HCSHPS_ELEMENT_ID_RESULTS_FRAME"); }
    public static String getHCSHPS_XPATH_ROWS() { return applicationProps.getProperty("HCSHPS_XPATH_ROWS"); }
    public static String getHCSHPS_XPATH_RELATIVE_ITEM_NAME() { return applicationProps.getProperty("HCSHPS_XPATH_RELATIVE_ITEM_NAME"); }
    public static String getHCSHPS_XPATH_RELATIVE_ADJUSTED_SCORE() { return applicationProps.getProperty("HCSHPS_XPATH_RELATIVE_ADJUSTED_SCORE"); }

    // OverviewTabIFrame
    public static long getO_TIMEOUT_SECS_GET_ROWS() { return Long.parseLong(applicationProps.getProperty("O_TIMEOUT_SECS_GET_ROWS")); }
    public static String getO_ELEMENT_ID_GRAPHS_FRAME() { return applicationProps.getProperty("O_ELEMENT_ID_GRAPHS_FRAME"); }
    public static String getO_ELEMENT_ID_RESULTS_FRAME() { return applicationProps.getProperty("O_ELEMENT_ID_RESULTS_FRAME"); }
    public static String getO_FINAL_ITEM_NAME() { return applicationProps.getProperty("O_FINAL_ITEM_NAME"); }
    public static String getO_XPATH_ROWS() { return applicationProps.getProperty("O_XPATH_ROWS"); }
    public static String getO_XPATH_RELATIVE_ITEM_NAME() { return applicationProps.getProperty("O_XPATH_RELATIVE_ITEM_NAME"); }
    public static String getO_XPATH_RELATIVE_TOP_BOX_PERCENTAGE() { return applicationProps.getProperty("O_XPATH_RELATIVE_TOP_BOX_PERCENTAGE"); }
    public static String getO_XPATH_RELATIVE_COUNT() { return applicationProps.getProperty("O_XPATH_RELATIVE_COUNT"); }

    // PatientExperienceIFrame
    public static String getPE_ATTRIBUTE_NAME_VALUE() { return applicationProps.getProperty("PE_ATTRIBUTE_NAME_VALUE"); }
    public static String getPE_ELEMENT_ID_APPLY_BUTTON() { return applicationProps.getProperty("PE_ELEMENT_ID_APPLY_BUTTON"); }
    public static String getPE_ELEMENT_ID_CALCULATION_MEAN_RADIO() { return applicationProps.getProperty("PE_ELEMENT_ID_CALCULATION_MEAN_RADIO"); }
    public static String getPE_ELEMENT_ID_CALCULATION_TOP_BOX_RADIO() { return applicationProps.getProperty("PE_ELEMENT_ID_CALCULATION_TOP_BOX_RADIO"); }
    public static String getPE_ELEMENT_ID_CANCEL_BUTTON() { return applicationProps.getProperty("PE_ELEMENT_ID_CANCEL_BUTTON"); }
    public static String getPE_ELEMENT_ID_CHANGE_SYSTEM_BUTTON() { return applicationProps.getProperty("PE_ELEMENT_ID_CHANGE_SYSTEM_BUTTON"); }
    public static String getPE_ELEMENT_ID_COMPOSITE_SELECT() { return applicationProps.getProperty("PE_ELEMENT_ID_COMPOSITE_SELECT"); }
    public static String getPE_ELEMENT_ID_COMPOSITE_TAB() { return applicationProps.getProperty("PE_ELEMENT_ID_COMPOSITE_TAB"); }
    public static String getPE_ELEMENT_ID_DATA_SET_ALL_RADIO() { return applicationProps.getProperty("PE_ELEMENT_ID_DATA_SET_ALL_RADIO"); }
    public static String getPE_ELEMENT_ID_DATA_SET_QUALIFIED_RADIO() { return applicationProps.getProperty("PE_ELEMENT_ID_DATA_SET_QUALIFIED_RADIO"); }
    public static String getPE_ELEMENT_ID_DATE_RANGE_DISCHARGE_VISIT_RADIO() { return applicationProps.getProperty("PE_ELEMENT_ID_DATE_RANGE_DISCHARGE_VISIT_RADIO"); }
    public static String getPE_ELEMENT_ID_DATE_RANGE_FROM_MONTH_SELECT() { return applicationProps.getProperty("PE_ELEMENT_ID_DATE_RANGE_FROM_MONTH_SELECT"); }
    public static String getPE_ELEMENT_ID_DATE_RANGE_FROM_SPAN() { return applicationProps.getProperty("PE_ELEMENT_ID_DATE_RANGE_FROM_SPAN"); }
    public static String getPE_ELEMENT_ID_DATE_RANGE_FROM_YEAR_SELECT() { return applicationProps.getProperty("PE_ELEMENT_ID_DATE_RANGE_FROM_YEAR_SELECT"); }
    public static String getPE_ELEMENT_ID_DATE_RANGE_SURVEY_RETURN_RADIO() { return applicationProps.getProperty("PE_ELEMENT_ID_DATE_RANGE_SURVEY_RETURN_RADIO"); }
    public static String getPE_ELEMENT_ID_DATE_RANGE_TO_MONTH_SELECT() { return applicationProps.getProperty("PE_ELEMENT_ID_DATE_RANGE_TO_MONTH_SELECT"); }
    public static String getPE_ELEMENT_ID_DATE_RANGE_TO_SPAN() { return applicationProps.getProperty("PE_ELEMENT_ID_DATE_RANGE_TO_SPAN"); }
    public static String getPE_ELEMENT_ID_DATE_RANGE_TO_YEAR_SELECT() { return applicationProps.getProperty("PE_ELEMENT_ID_DATE_RANGE_TO_YEAR_SELECT"); }
    public static String getPE_ELEMENT_ID_DEMOGRAPHICS_FILTER_LINK() { return applicationProps.getProperty("PE_ELEMENT_ID_DEMOGRAPHICS_FILTER_LINK"); }
    public static String getPE_ELEMENT_ID_DEMOGRAPHICS_TAB() { return applicationProps.getProperty("PE_ELEMENT_ID_DEMOGRAPHICS_TAB"); }
    public static String getPE_ELEMENT_ID_DEPARTMENT_SELECT() { return applicationProps.getProperty("PE_ELEMENT_ID_DEPARTMENT_SELECT"); }
    public static String getPE_ELEMENT_ID_GROUP_BY_SELECT() { return applicationProps.getProperty("PE_ELEMENT_ID_GROUP_BY_SELECT"); }
    public static String getPE_ELEMENT_ID_HCAHPS_NATIONAL_TAB() { return applicationProps.getProperty("PE_ELEMENT_ID_HCAHPS_NATIONAL_TAB"); }
    public static String getPE_ELEMENT_ID_ITEM_SELECT() { return applicationProps.getProperty("PE_ELEMENT_ID_ITEM_SELECT"); }
    public static String getPE_ELEMENT_ID_KEEP_VISIBLE_CHECKBOX() { return applicationProps.getProperty("PE_ELEMENT_ID_KEEP_VISIBLE_CHECKBOX"); }
    public static String getPE_ELEMENT_ID_LOCATION_SELECT() { return applicationProps.getProperty("PE_ELEMENT_ID_LOCATION_SELECT"); }
    public static String getPE_ELEMENT_ID_ORGANIZATION_SELECT() { return applicationProps.getProperty("PE_ELEMENT_ID_ORGANIZATION_SELECT"); }
    public static String getPE_ELEMENT_ID_OVERVIEW_TAB() { return applicationProps.getProperty("PE_ELEMENT_ID_OVERVIEW_TAB"); }
    public static String getPE_ELEMENT_ID_PATIENT_TYPE_SELECT() { return applicationProps.getProperty("PE_ELEMENT_ID_PATIENT_TYPE_SELECT"); }
    public static String getPE_ELEMENT_ID_PROVIDER_FILTER_LINK() { return applicationProps.getProperty("PE_ELEMENT_ID_PROVIDER_FILTER_LINK"); }
    public static String getPE_ELEMENT_ID_RESET_BUTTON() { return applicationProps.getProperty("PE_ELEMENT_ID_RESET_BUTTON"); }
    public static String getPE_ELEMENT_ID_RESPONSE_FILTER_LINK() { return applicationProps.getProperty("PE_ELEMENT_ID_RESPONSE_FILTER_LINK"); }
    public static String getPE_ELEMENT_ID_SAVE_SELECTIONS_BUTTON() { return applicationProps.getProperty("PE_ELEMENT_ID_SAVE_SELECTIONS_BUTTON"); }
    public static String getPE_ELEMENT_ID_SAVE_SELECTIONS_CHECKBOX() { return applicationProps.getProperty("PE_ELEMENT_ID_SAVE_SELECTIONS_CHECKBOX"); }
    public static String getPE_ELEMENT_ID_SELECTIONS_NAME_INPUT() { return applicationProps.getProperty("PE_ELEMENT_ID_SELECTIONS_NAME_INPUT"); }
    public static String getPE_ELEMENT_ID_SET_SELECTIONS_AS_DEFAULT_CHECKBOX() { return applicationProps.getProperty("PE_ELEMENT_ID_SET_SELECTIONS_AS_DEFAULT_CHECKBOX"); }
    public static String getPE_ELEMENT_ID_SHARE_SELECTIONS_CHECKBOX() { return applicationProps.getProperty("PE_ELEMENT_ID_SHARE_SELECTIONS_CHECKBOX"); }
    public static String getPE_ELEMENT_ID_SIDE_BY_SIDE_TAB() { return applicationProps.getProperty("PE_ELEMENT_ID_SIDE_BY_SIDE_TAB"); }
    public static String getPE_ELEMENT_ID_SURVEY_TYPE_SELECT() { return applicationProps.getProperty("PE_ELEMENT_ID_SURVEY_TYPE_SELECT"); }
    public static String getPE_ELEMENT_ID_SYSTEM_SELECT() { return applicationProps.getProperty("PE_ELEMENT_ID_SYSTEM_SELECT"); }
    public static String getPE_XPATH_RELATIVE_ALL_REPORT_TABS() { return applicationProps.getProperty("PE_XPATH_RELATIVE_ALL_REPORT_TABS"); }

    public static ICare2Props getInstance() {
        if (props == null) {
            props = new ICare2Props();
        }

        return props;
    }

    @Override
    public ICare2Props clone() {
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException ex) {
            log.error("Class ICare2Props can not be cloned cause is singleton.");
        }
        return null;
    }
}