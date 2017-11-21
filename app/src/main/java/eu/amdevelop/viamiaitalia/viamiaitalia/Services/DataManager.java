package eu.amdevelop.viamiaitalia.viamiaitalia.Services;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Contact;
import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Order;
import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Service;

/**
 * Created by terezamadova on 15/11/2017.
 */

public class DataManager {

    public static final String IP_ADDRESS = "http://10.0.2.2:8000/api/";
    //    public static final String IP_ADDRESS = "http://10.152.192.115:8000/api/";
    private static final DataManager ourInstance = new DataManager();
    private DataService dataService;

    private DataManager() {
        dataService = new DataService();
    }

    public static DataManager getInstance() {
        return ourInstance;
    }

    public ArrayList<Service> getServices() {
        destroyInstance();
        ArrayList<Service> posts = new ArrayList<>();

        try {
            JSONArray jsonPosts = dataService.execute(IP_ADDRESS + "services").get();
            // JSONArray jsonPosts = dataService.execute("http://192.168.87.102:8000/api/services").get();

            for (int i = 0; i < jsonPosts.length(); i++) {
                JSONObject serviceObject = jsonPosts.getJSONObject(i);
                Log.d("hfsdjkhfksj", serviceObject.toString());
                Service service = new Service(serviceObject);
                Log.d("!!!!getnutyService", service.toString());
                posts.add(service);
            }

            return posts;
        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return posts;
    }

    public Order getOrder() {
        destroyInstance();

        try {
            JSONArray jsonOrders = dataService.execute(IP_ADDRESS + "order").get();
            JSONObject jsonObject = jsonOrders.getJSONObject(0);
            Order order = new Order(jsonObject);

            return order;
        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Contact getContact() {
        destroyInstance();

        try {
            //    JSONArray jsonContacts = dataService.execute("http://192.168.87.102:8000/api/contact").get();
            JSONArray jsonContacts = dataService.execute(IP_ADDRESS + "contact").get();
            JSONObject jsonObject = jsonContacts.getJSONObject(0);
            Contact contact = new Contact(jsonObject);

            return contact;
        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean verifyCode(String code) {
        destroyInstance();
        //TODO
        return false;
    }

    private void destroyInstance() {
        dataService = null;
        dataService = new DataService();
    }

}
