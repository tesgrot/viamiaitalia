package eu.amdevelop.viamiaitalia.viamiaitalia.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by terezamadova on 08/11/2017.
 */

public class Contact {

    private String address;
    private int houseNo;
    private String city;
    private String state;

    private String phone;
    private String email;
    private String facebookUrl;
    private String twitterUrl;
    private String instagramUrl;
    private String contactPerson;
    private String note;

    public Contact(JSONObject obj) {
        try {
            this.address = obj.getString("address");
            this.houseNo = obj.getInt("house_number");
            this.city = obj.getString("city");
            this.state = obj.getString("state");
            this.phone = obj.getString("number");
            this.email = obj.getString("email");
            this.facebookUrl = obj.getString("facebook_u_r_l");
            this.twitterUrl = obj.getString("twitter_u_r_l");
            this.instagramUrl = obj.getString("instagram_u_r_l");
            this.contactPerson = obj.getString("contact_person");
            this.note = obj.getString("note");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
