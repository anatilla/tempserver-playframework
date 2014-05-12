package utils;

import models.Measurement;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: alexander
 * Project: tempserver-playframework
 */
public class MeasurementJSONTemplate {
    private List<Measurement> temperature_record;

    public MeasurementJSONTemplate() {
        temperature_record = new ArrayList<>();
    }

    public List<Measurement> getTemperature_record() {
        return temperature_record;
    }

    public void setTemperature_record(List<Measurement> temperature_record) {
        this.temperature_record = temperature_record;
    }

    public void add(Measurement element) {
        temperature_record.add(element);
    }

    public void addAll(List<Measurement> list) {
        temperature_record.addAll(list);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MeasurementJSONTemplate{");
        sb.append("temperature_record=").append(temperature_record);
        sb.append('}');
        return sb.toString();
    }
}
