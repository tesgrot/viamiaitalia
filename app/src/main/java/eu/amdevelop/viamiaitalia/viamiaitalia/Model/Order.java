package eu.amdevelop.viamiaitalia.viamiaitalia.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by terezamadova on 10/11/2017.
 */

public class Order {

    int id, noOfPeople, noOfChildren;
    String name, mail, phone;
    String checkIn, checkOut; // asi nepridu dates ale Stringy??

    public Order() {
        this.id = 1;
        this.noOfChildren = 1;
        this.noOfPeople = 3;
        this.name = "tereza";
        this.mail = "mail@mail.com";
        this.phone = "0928394";
        this.checkIn = "29/09/2018";
        this.checkOut = "12/10/2018";
    }

    public Order(JSONObject obj) {
        try {
            this.id = obj.getInt(Keywords.OrderKeywords.id.name());
            this.noOfPeople = obj.getInt("no_of_people");
            this.noOfChildren = obj.getInt("no_of_children");
//            TODO dokoncit
            this.name = obj.getString(Keywords.OrderKeywords.name.name());
            this.mail = obj.getString(Keywords.OrderKeywords.mail.name());
            this.phone = obj.getString(Keywords.OrderKeywords.phone.name());
            ;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(int noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public int getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(int noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
}
