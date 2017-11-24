package eu.amdevelop.viamiaitalia.viamiaitalia.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by terezamadova on 10/11/2017.
 */

public class Service {

    private int id;
    private String name, description, descriptionLong, imageURL;
    private double minPirce;

    public Service(JSONObject obj) {
        try {
            this.id = obj.getInt(Keywords.ServiceKeywords.id.name());
            this.minPirce = obj.getDouble(Keywords.ServiceKeywords.minimal_price.name());
            if (obj.has(Keywords.ServiceKeywords.service_c_s.name())) {
                this.name = obj.getJSONObject(Keywords.ServiceKeywords.service_c_s.name()).getString(Keywords.ServiceKeywords.name.name());
                this.description = obj.getJSONObject(Keywords.ServiceKeywords.service_c_s.name()).getString(Keywords.ServiceKeywords.description.name());
                this.descriptionLong = obj.getJSONObject(Keywords.ServiceKeywords.service_c_s.name()).getString(Keywords.ServiceKeywords.description_long.name());
            } else {
                this.name = obj.getJSONObject(Keywords.ServiceKeywords.service_e_n.name()).getString(Keywords.ServiceKeywords.name.name());
                this.description = obj.getJSONObject(Keywords.ServiceKeywords.service_e_n.name()).getString(Keywords.ServiceKeywords.description.name());
                this.descriptionLong = obj.getJSONObject(Keywords.ServiceKeywords.service_e_n.name()).getString(Keywords.ServiceKeywords.description_long.name());
            }
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

    public String getDescription() {
        return description;
    }

    public String getDescriptionLong() {
        return descriptionLong;
    }

    public String getImageURL() {
        return imageURL;
    }

    public double getMinPirce() {
        return minPirce;
    }
}
