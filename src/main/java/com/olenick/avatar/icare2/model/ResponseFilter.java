package com.olenick.avatar.icare2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Response filter.
 */
public class ResponseFilter implements Cloneable {
    private String surveyType;
    private String patientType;
    private String composite;
    private String item;
    private List<String> responses;

    public String getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String getComposite() {
        return composite;
    }

    public void setComposite(String composite) {
        this.composite = composite;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public List<String> getResponses() {
        return responses;
    }

    public void setResponses(String... responses) {
        this.responses = Arrays.asList(responses);
    }

    public void setResponses(List<String> responses) {
        this.responses = responses;
    }

    @Override
    @SuppressWarnings("super")
    public ResponseFilter clone() {
        ResponseFilter clone = new ResponseFilter();
        clone.setSurveyType(this.surveyType);
        clone.setPatientType(this.patientType);
        clone.setComposite(this.composite);
        clone.setItem(this.item);
        if (this.responses != null) {
            clone.setResponses(new ArrayList<>(this.responses));
        }
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ResponseFilter that = (ResponseFilter) o;

        if (composite != null ? !composite.equals(that.composite)
                : that.composite != null)
            return false;
        if (item != null ? !item.equals(that.item) : that.item != null)
            return false;
        if (patientType != null ? !patientType.equals(that.patientType)
                : that.patientType != null)
            return false;
        if (responses != null ? !responses.equals(that.responses)
                : that.responses != null)
            return false;
        if (surveyType != null ? !surveyType.equals(that.surveyType)
                : that.surveyType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = surveyType != null ? surveyType.hashCode() : 0;
        result = 31 * result
                + (patientType != null ? patientType.hashCode() : 0);
        result = 31 * result + (composite != null ? composite.hashCode() : 0);
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (responses != null ? responses.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResponseFilter{");
        sb.append("surveyType='").append(surveyType).append('\'');
        sb.append(", patientType='").append(patientType).append('\'');
        sb.append(", composite='").append(composite).append('\'');
        sb.append(", item='").append(item).append('\'');
        sb.append(", responses=").append(responses);
        sb.append('}');
        return sb.toString();
    }
}
