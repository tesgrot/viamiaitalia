package eu.amdevelop.viamiaitalia.viamiaitalia.Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by terezamadova on 10/11/2017.
 */

public class Order {

    int id, noOfPeople, noOfChildren;
    String name, mail, phone;
    Date checkIn, checkOut; // asi nepridu dates ale Stringy??

    public Order(JSONObject obj) {
        try {
            this.id = obj.getInt(Keywords.OrderKeywords.id.name());
            this.noOfPeople = obj.getInt(Keywords.ServiceElementKeywords.duration.name());
            this.noOfChildren = obj.getInt(Keywords.ServiceElementKeywords.duration.name());
//            TODO dokoncit
            this.name = obj.getString(Keywords.OrderKeywords.name.name());
            this.mail = obj.getString(Keywords.OrderKeywords.mail.name());
            this.phone = obj.getString(Keywords.OrderKeywords.phone.name());
            ;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
