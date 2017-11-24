package eu.amdevelop.viamiaitalia.viamiaitalia.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by terezamadova on 08/11/2017.
 */

public class Contact implements java.io.Serializable {

    private String address, city, state, phone, email, facebookUrl, twitterUrl, instagramUrl, contactPerson, note;
    private int houseNo;

    public Contact(JSONObject obj) {
        try {
            this.address = obj.getString(Keywords.ContactKeywords.address.name());
            this.houseNo = obj.getInt(Keywords.ContactKeywords.house_number.name());
            this.city = obj.getString(Keywords.ContactKeywords.city.name());
            this.state = obj.getString(Keywords.ContactKeywords.state.name());
            this.phone = obj.getString(Keywords.ContactKeywords.number.name());
            this.email = obj.getString(Keywords.ContactKeywords.email.name());
            this.facebookUrl = obj.getString(Keywords.ContactKeywords.facebook_u_r_l.name());
            this.twitterUrl = obj.getString(Keywords.ContactKeywords.twitter_u_r_l.name());
            this.instagramUrl = obj.getString(Keywords.ContactKeywords.instagram_u_r_l.name());
            this.contactPerson = obj.getString(Keywords.ContactKeywords.contact_person.name());
            this.note = obj.getString(Keywords.ContactKeywords.note.name());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getNote() {
        return note;
    }

    public int getHouseNo() {
        return houseNo;
    }

}
