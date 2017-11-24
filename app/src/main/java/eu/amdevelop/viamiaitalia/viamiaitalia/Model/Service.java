package eu.amdevelop.viamiaitalia.viamiaitalia.Model;

import android.util.Log;

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
    private String imageURL;

    public Service(JSONObject obj) {
        try {
            Log.d("Service class", obj.toString());
            this.id = obj.getInt(Keywords.ServiceKeywords.id.name());
            this.minPirce = obj.getDouble(Keywords.ServiceKeywords.minimal_price.name());
            if (obj.has(Keywords.ServiceKeywords.service_c_s.name())) {
                this.name = obj.getJSONObject(Keywords.ServiceKeywords.service_c_s.name()).getString(Keywords.ServiceKeywords.name.name());
                this.description = obj.getJSONObject(Keywords.ServiceKeywords.service_c_s.name()).getString(Keywords.ServiceKeywords.description.name());
                this.descriptionLong = obj.getJSONObject(Keywords.ServiceKeywords.service_c_s.name()).getString(Keywords.ServiceKeywords.descriptionLong.name());
            } else {
                this.name = obj.getJSONObject(Keywords.ServiceKeywords.service_e_n.name()).getString(Keywords.ServiceKeywords.name.name());
                this.description = obj.getJSONObject(Keywords.ServiceKeywords.service_e_n.name()).getString(Keywords.ServiceKeywords.description.name());
                this.descriptionLong = obj.getJSONObject(Keywords.ServiceKeywords.service_e_n.name()).getString(Keywords.ServiceKeywords.descriptionLong.name());
            }
            Log.d("Service class min price", minPirce + "EUR");
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
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
