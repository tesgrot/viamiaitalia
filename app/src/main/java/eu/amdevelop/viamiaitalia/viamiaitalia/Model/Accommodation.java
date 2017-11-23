package eu.amdevelop.viamiaitalia.viamiaitalia.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by terezamadova on 23/11/2017.
 */

public class Accommodation {

    int id;

    public Accommodation(JSONObject obj) {
        try {
            this.id = obj.getInt(Keywords.AccommodationKeywords.id.name());
//            TODO dokoncit
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
