package eu.amdevelop.viamiaitalia.viamiaitalia.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by terezamadova on 21/11/2017.
 */

public class ServiceElement {
    private int pricePerson, duration, id;
    private String durationUnit, descriptionLong;

    public ServiceElement(JSONObject obj) {
        try {
            this.id = obj.getInt(Keywords.ServiceElementKeywords.id.name());
            if (obj.has(Keywords.ServiceElementKeywords.service_element_c_s.name())) {
                this.descriptionLong = obj.getJSONObject(Keywords.ServiceElementKeywords.service_element_c_s.name()).getString(Keywords.ServiceElementKeywords.description_long.name());
            } else {
                this.descriptionLong = obj.getJSONObject(Keywords.ServiceElementKeywords.service_element_e_n.name()).getString(Keywords.ServiceElementKeywords.description_long.name());
            }
            this.duration = obj.getInt(Keywords.ServiceElementKeywords.duration.name());
            this.durationUnit = obj.getString(Keywords.ServiceElementKeywords.duration_units.name());
            this.pricePerson = obj.getInt(Keywords.ServiceElementKeywords.price_person.name());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ServiceElement{" +
                "pricePerson=" + pricePerson +
                ", duration=" + duration +
                ", id=" + id +
                ", durationUnit='" + durationUnit + '\'' +
                ", descriptionLong='" + descriptionLong + '\'' +
                '}';
    }

    public int getPricePerson() {
        return pricePerson;
    }

    public void setPricePerson(int pricePerson) {
        this.pricePerson = pricePerson;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(String durationUnit) {
        this.durationUnit = durationUnit;
    }

    public String getDescriptionLong() {
        return descriptionLong;
    }

    public void setDescriptionLong(String descriptionLong) {
        this.descriptionLong = descriptionLong;
    }
}
