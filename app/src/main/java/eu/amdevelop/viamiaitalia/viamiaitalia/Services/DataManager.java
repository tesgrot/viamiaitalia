package eu.amdevelop.viamiaitalia.viamiaitalia.Services;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Contact;
import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Order;
import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Service;
import eu.amdevelop.viamiaitalia.viamiaitalia.Model.ServiceElement;

/**
 * Created by terezamadova on 15/11/2017.
 */

public class DataManager {

    public static final String IP_ADDRESS = "http://viamiaitalia.com/api/";
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

            for (int i = 0; i < jsonPosts.length(); i++) {
                JSONObject serviceObject = jsonPosts.getJSONObject(i);
                Service service = new Service(serviceObject);
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

    public ArrayList<ServiceElement> getServiceElements(int id) {
        destroyInstance();
        ArrayList<ServiceElement> elements = new ArrayList<>();

        try {
            JSONArray jsonPosts = dataService.execute(IP_ADDRESS + "serviceElements/" + id).get();

            for (int i = 0; i < jsonPosts.length(); i++) {
                JSONObject serviceObject = jsonPosts.getJSONObject(i);
                ServiceElement element = new ServiceElement(serviceObject);
                elements.add(element);
            }

            return elements;
        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return elements;
    }

    public Order getOrder() {
        destroyInstance();

        try {
            JSONArray jsonOrders = dataService.execute(IP_ADDRESS + "me").get();
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

    public boolean verifyCode() {
        destroyInstance();
        JSONArray test;
        boolean success = true;
        try {
            test = dataService.execute(IP_ADDRESS + "services").get(); //TODO me
            if (test == null) success = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return success;
    }

    private void destroyInstance() {
        dataService = null;
        dataService = new DataService();
    }

}
