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


    public Service() {

    }

    public Service(JSONObject obj) {
        Log.d("Service JSON OBJECT ", obj.toString() + "=======\n");
        try {
            this.id = obj.getInt("id");
            this.name = obj.getJSONObject("service_e_n").getString("name");
            this.description = obj.getJSONObject("service_e_n").getString("description");
            this.descriptionLong = obj.getJSONObject("service_e_n").getString("descriptionLong");
            this.minPirce = obj.getDouble("minimal_price");
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
