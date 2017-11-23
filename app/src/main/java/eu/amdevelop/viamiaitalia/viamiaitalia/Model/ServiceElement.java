package eu.amdevelop.viamiaitalia.viamiaitalia.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by terezamadova on 21/11/2017.
 */

public class ServiceElement {
    private int pricePerson, duration, id;
    private String durationUnit, descriptionLong;

    public ServiceElement(int pricePerson, int duration, int id, String durationUnit, String descriptionLong) {
        this.pricePerson = pricePerson;
        this.duration = duration;
        this.id = id;
        this.durationUnit = durationUnit;
        this.descriptionLong = descriptionLong;
    }

    public ServiceElement(JSONObject obj) {
        try {
            this.id = obj.getInt("id");
            this.descriptionLong = obj.getJSONObject("service_element_c_s").getString("description_long");
            this.duration = obj.getInt("duration");
            this.durationUnit = obj.getString("duration_units");
            this.pricePerson = obj.getInt("price_person");
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
