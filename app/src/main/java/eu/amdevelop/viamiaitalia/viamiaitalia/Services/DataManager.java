package eu.amdevelop.viamiaitalia.viamiaitalia.Services;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Accommodation;
import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Apartment;
import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Contact;
import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Order;
import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Service;
import eu.amdevelop.viamiaitalia.viamiaitalia.Model.ServiceElement;
import io.paperdb.Paper;

/**
 * Created by terezamadova on 15/11/2017.
 */

public class DataManager {

    public static final String IP_ADDRESS = "http://viamiaitalia.com/api/";
    private static final DataManager ourInstance = new DataManager();
    private DataService dataService;
    private ConnectionCheck connectionCheck;

    private DataManager() {
        dataService = new DataService();
        connectionCheck = new ConnectionCheck();
    }

    public static DataManager getInstance() {
        return ourInstance;
    }

    public ArrayList<Service> getServices() {
        destroyInstance();
        ArrayList<Service> posts = new ArrayList<>();
        try {
            Boolean connectionIsOn = connectionCheck.execute().get();
            if (connectionIsOn.booleanValue()) {

                JSONArray jsonPosts = dataService.execute(IP_ADDRESS + "services").get();

                for (int i = 0; i < jsonPosts.length(); i++) {
                    JSONObject serviceObject = jsonPosts.getJSONObject(i);
                    Service service = new Service(serviceObject);
                    posts.add(service);
                }

                Paper.book().delete("Services");
                Paper.book().write("Services", posts);
                return posts;
            } else {
                posts = Paper.book().read("Services");
                return posts;
            }

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
            Boolean connectionIsOn = connectionCheck.execute().get();
            if (connectionIsOn.booleanValue()) {
                JSONArray jsonPosts = dataService.execute(IP_ADDRESS + "serviceElements/" + id).get();

                for (int i = 0; i < jsonPosts.length(); i++) {
                    JSONObject serviceObject = jsonPosts.getJSONObject(i);
                    ServiceElement element = new ServiceElement(serviceObject);
                    elements.add(element);
                }

                Paper.book().delete("ServiceElements_" + id);
                Paper.book().write("ServiceElements_" + id, elements);
                return elements;
            } else {
                elements = Paper.book().read("ServiceElements_" + id);
                return elements;
            }

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
            Boolean connectionIsOn = connectionCheck.execute().get();
            if (connectionIsOn.booleanValue()) {
                JSONArray jsonOrders = dataService.execute(IP_ADDRESS + "me").get();
                JSONObject jsonObject = jsonOrders.getJSONObject(0);
                Order order = new Order(jsonObject);
                Paper.book().delete("Order");
                Paper.book().write("Order", order);
                return order;
            } else {
                Order order = Paper.book().read("Order");
                return order;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Accommodation getAccommodation(int id) {
        destroyInstance();

        try {
            Boolean connectionIsOn = connectionCheck.execute().get();
            if (connectionIsOn.booleanValue()) {
                JSONObject jsonObject = dataService.execute(IP_ADDRESS + "accommodation/" + id).get().getJSONObject(0);
                Accommodation accommodation = new Accommodation(jsonObject);
                Paper.book().delete("Accommodation");
                Paper.book().write("Accommodation", accommodation);
                return accommodation;
            } else {
                Accommodation accommodation = Paper.book().read("Accommodation");
                return accommodation;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Apartment> getApartments(int id) {
        destroyInstance();

        ArrayList<Apartment> apartments = new ArrayList<>();
        try {
            JSONArray jsonArray = dataService.execute(IP_ADDRESS + "accommodation/" + id + "/apartments").get();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                Apartment apartment = new Apartment(jsonObj);
                apartments.add(apartment);
            }
            return apartments;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return apartments;
    }


    public Contact getContact() {
        destroyInstance();

        try {
            Boolean connectionIsOn = connectionCheck.execute().get();
            if (connectionIsOn.booleanValue()) {
                JSONArray jsonContacts = dataService.execute(IP_ADDRESS + "contact").get();
                JSONObject jsonObject = jsonContacts.getJSONObject(0);
                Contact contact = new Contact(jsonObject);
                Paper.book().delete("Contact");
                Paper.book().write("Contact", contact);
                return contact;
            } else {
                Contact contact = Paper.book().read("Contact");
                return contact;
            }
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
            test = dataService.execute(IP_ADDRESS + "me").get();
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
        connectionCheck = null;
        connectionCheck = new ConnectionCheck();
    }

}
