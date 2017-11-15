package eu.amdevelop.viamiaitalia.viamiaitalia.Services;

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
            JSONArray jsonPosts = dataService.execute("https://jsonplaceholder.typicode.com/posts").get();

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
        }

        return posts;
    }

    public Order getOrder() {
        destroyInstance();

        try {
            JSONArray jsonOrders = dataService.execute("https://jsonplaceholder.typicode.com/users").get();
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
            JSONArray jsonContacts = dataService.execute("https://jsonplaceholder.typicode.com/photos").get();
            JSONObject jsonObject = jsonContacts.getJSONObject(0);
            Contact contact = new Contact(jsonObject);

            return contact;
        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }

    private void destroyInstance() {
        dataService = null;
        dataService = new DataService();
    }

}
