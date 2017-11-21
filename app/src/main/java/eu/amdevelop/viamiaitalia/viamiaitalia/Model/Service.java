package eu.amdevelop.viamiaitalia.viamiaitalia.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by terezamadova on 10/11/2017.
 */

public class Service {

    private int id;
    private String name;
    private String description;
    private String descriptionLong;
    private double minPirce;
    private int duration;
    private String durationUnit;
    private String imageURL;


    public Service(JSONObject obj) {
        try {
            this.id = obj.getInt("id");
            this.name = obj.getString("name");
            this.description = obj.getString("description");
            this.descriptionLong = obj.getString("descriptionLong");
            this.minPirce = obj.getInt("minPrice");
            this.duration = obj.getInt("duration");
            this.durationUnit = obj.getString("durationUnit");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionLong() {
        return descriptionLong;
    }

    public void setDescriptionLong(String descriptionLong) {
        this.descriptionLong = descriptionLong;
    }

    public double getMinPirce() {
        return minPirce;
    }

    public void setMinPirce(double minPirce) {
        this.minPirce = minPirce;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(String durationUnit) {
        this.durationUnit = durationUnit;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", descriptionLong='" + descriptionLong + '\'' +
                ", minPirce=" + minPirce +
                ", duration=" + duration +
                ", durationUnit='" + durationUnit + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
