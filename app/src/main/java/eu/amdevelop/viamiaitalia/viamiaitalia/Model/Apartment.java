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
            this.id = obj.getInt(Keywords.ApartmentKeywords.id.name());
            if (obj.has(Keywords.ApartmentKeywords.apartment_c_s.name())) {
                this.name = obj.getJSONObject(Keywords.ApartmentKeywords.apartment_c_s.name()).getString(Keywords.ApartmentKeywords.name.name());
                this.description = obj.getJSONObject(Keywords.ApartmentKeywords.apartment_c_s.name()).getString(Keywords.ApartmentKeywords.description.name());
                this.note = obj.getJSONObject(Keywords.ApartmentKeywords.apartment_c_s.name()).getString(Keywords.ApartmentKeywords.note.name());
            } else {
                this.name = obj.getJSONObject(Keywords.ApartmentKeywords.apartment_e_n.name()).getString(Keywords.ApartmentKeywords.name.name());
                this.description = obj.getJSONObject(Keywords.ApartmentKeywords.apartment_e_n.name()).getString(Keywords.ApartmentKeywords.description.name());
                this.note = obj.getJSONObject(Keywords.ApartmentKeywords.apartment_e_n.name()).getString(Keywords.ApartmentKeywords.note.name());
            }
            this.noOfDoubleB = obj.getInt(Keywords.ApartmentKeywords.no_of_double_beds.name());
            this.noOfSingleB = obj.getInt(Keywords.ApartmentKeywords.no_of_single_beds.name());
            this.noOfPersons = obj.getInt(Keywords.ApartmentKeywords.no_of_persons.name());
            this.ownBathroom = obj.getBoolean(Keywords.ApartmentKeywords.own_bathroom.name());
            this.connection = obj.getBoolean(Keywords.ApartmentKeywords.internet_connection.name());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public int getNoOfPersons() {
        return noOfPersons;
    }

    public int getNoOfSingleB() {
        return noOfSingleB;
    }

    public int getNoOfDoubleB() {
        return noOfDoubleB;
    }

    public String getDescription() {
        return description;
    }

    public String getNote() {
        return note;
    }

    public String getName() {
        return name;
    }

    public boolean isConnection() {
        return connection;
    }

    public boolean isOwnBathroom() {
        return ownBathroom;
    }
}
