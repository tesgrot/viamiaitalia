package eu.amdevelop.viamiaitalia.viamiaitalia.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Libcoo on 24.11.2017.
 */

public class Apartment {
    private int id, noOfPersons, noOfSingleB, noOfDoubleB;
    private String description, note, name;
    private boolean connection, ownBathroom;

    public Apartment(JSONObject obj) {
        try {
            this.id = obj.getInt(Keywords.AppartmentKeywords.id.name());
            if (obj.has(Keywords.AppartmentKeywords.appartment_c_s.name())) {
                this.name = obj.getJSONObject(Keywords.AppartmentKeywords.appartment_c_s.name()).getString(Keywords.AppartmentKeywords.name.name());
                this.description = obj.getJSONObject(Keywords.AppartmentKeywords.appartment_c_s.name()).getString(Keywords.AppartmentKeywords.description.name());
                this.note = obj.getJSONObject(Keywords.AppartmentKeywords.appartment_c_s.name()).getString(Keywords.AppartmentKeywords.note.name());
            } else {
                this.name = obj.getJSONObject(Keywords.AppartmentKeywords.appartment_e_n.name()).getString(Keywords.AppartmentKeywords.name.name());
                this.description = obj.getJSONObject(Keywords.AppartmentKeywords.appartment_e_n.name()).getString(Keywords.AppartmentKeywords.description.name());
                this.note = obj.getJSONObject(Keywords.AppartmentKeywords.appartment_e_n.name()).getString(Keywords.AppartmentKeywords.note.name());

            }
            this.noOfDoubleB = obj.getInt(Keywords.AppartmentKeywords.no_of_double_beds.name());
            this.noOfSingleB = obj.getInt(Keywords.AppartmentKeywords.no_of_single_beds.name());
            this.noOfPersons = obj.getInt(Keywords.AppartmentKeywords.no_of_persons.name());
            this.ownBathroom = obj.getBoolean(Keywords.AppartmentKeywords.has_own_bathroom.name());
            this.connection = obj.getBoolean(Keywords.AppartmentKeywords.has_internet_connection.name());
            //TODO CHECKIN CHECKOUT
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
