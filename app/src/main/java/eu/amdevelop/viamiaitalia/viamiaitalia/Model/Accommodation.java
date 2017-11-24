package eu.amdevelop.viamiaitalia.viamiaitalia.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by terezamadova on 23/11/2017.
 */

public class Accommodation {

    int id, noBed, noBath, minPrice;
    String name, description, descriptionLong, reccommend1, reccommend2, reccommend3, note, address, check_in, check_out;
    double latitude, longitude;
    ArrayList<City> cities;


    public Accommodation(JSONObject obj) {
        try {
            this.id = obj.getInt(Keywords.AccommodationKeywords.id.name());
            if (obj.has(Keywords.AccommodationKeywords.accommodation_c_s.name())) {
                this.name = obj.getJSONObject(Keywords.AccommodationKeywords.accommodation_c_s.name()).getString(Keywords.AccommodationKeywords.name.name());
                this.description = obj.getJSONObject(Keywords.AccommodationKeywords.accommodation_c_s.name()).getString(Keywords.AccommodationKeywords.description.name());
                this.descriptionLong = obj.getJSONObject(Keywords.AccommodationKeywords.accommodation_c_s.name()).getString(Keywords.AccommodationKeywords.description_long.name());
                this.reccommend1 = obj.getJSONObject(Keywords.AccommodationKeywords.accommodation_c_s.name()).getString(Keywords.AccommodationKeywords.recommended_for1.name());
                this.reccommend2 = obj.getJSONObject(Keywords.AccommodationKeywords.accommodation_c_s.name()).getString(Keywords.AccommodationKeywords.recommended_for2.name());
                this.reccommend3 = obj.getJSONObject(Keywords.AccommodationKeywords.accommodation_c_s.name()).getString(Keywords.AccommodationKeywords.recommended_for3.name());
                this.note = obj.getJSONObject(Keywords.AccommodationKeywords.accommodation_c_s.name()).getString(Keywords.AccommodationKeywords.note.name());
            } else {
                this.name = obj.getJSONObject(Keywords.AccommodationKeywords.accommodation_e_n.name()).getString(Keywords.AccommodationKeywords.name.name());
                this.description = obj.getJSONObject(Keywords.AccommodationKeywords.accommodation_e_n.name()).getString(Keywords.AccommodationKeywords.description.name());
                this.descriptionLong = obj.getJSONObject(Keywords.AccommodationKeywords.accommodation_e_n.name()).getString(Keywords.AccommodationKeywords.description_long.name());
                this.reccommend1 = obj.getJSONObject(Keywords.AccommodationKeywords.accommodation_e_n.name()).getString(Keywords.AccommodationKeywords.recommended_for1.name());
                this.reccommend2 = obj.getJSONObject(Keywords.AccommodationKeywords.accommodation_e_n.name()).getString(Keywords.AccommodationKeywords.recommended_for2.name());
                this.reccommend3 = obj.getJSONObject(Keywords.AccommodationKeywords.accommodation_e_n.name()).getString(Keywords.AccommodationKeywords.recommended_for3.name());
                this.note = obj.getJSONObject(Keywords.AccommodationKeywords.accommodation_e_n.name()).getString(Keywords.AccommodationKeywords.note.name());
            }
            this.cities = new ArrayList<>();
            JSONArray jsonCities = obj.getJSONArray(Keywords.AccommodationKeywords.close_cities.name());
            for (int i = 0; i < jsonCities.length(); i++) {
                int id = jsonCities.getJSONObject(i).getInt(Keywords.AccommodationKeywords.id.name());
                String cityEN = jsonCities.getJSONObject(i).getString(Keywords.AccommodationKeywords.city_e_n.name());
                String cityCS = jsonCities.getJSONObject(i).getString(Keywords.AccommodationKeywords.city_c_s.name());
                int cityDistance = jsonCities.getJSONObject(i).getInt(Keywords.AccommodationKeywords.distance.name());
                City city = new City(id, cityEN, cityCS, cityDistance);
                cities.add(city);
            }
            this.minPrice = obj.getInt(Keywords.AccommodationKeywords.minimal_price.name());
            this.address = obj.getString(Keywords.AccommodationKeywords.address.name());
            this.latitude = obj.getInt(Keywords.AccommodationKeywords.latitude.name());
            this.longitude = obj.getInt(Keywords.AccommodationKeywords.longitude.name());
            this.noBath = obj.getInt(Keywords.AccommodationKeywords.no_of_bathrooms.name());
            this.noBed = obj.getInt(Keywords.AccommodationKeywords.no_of_bedrooms.name());
            check_in = obj.getString(Keywords.AccommodationKeywords.check_in.name());
            check_out = obj.getString(Keywords.AccommodationKeywords.check_out.name());
            String chIn = "";
            for (int i = 11; i < 16; i++) {
                chIn += check_in.charAt(i);
            }
            String chOut = "";
            for (int i = 11; i < 16; i++) {
                chOut += check_out.charAt(i);
            }
            this.check_in = chIn;
            this.check_out = chOut;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public int getNoBed() {
        return noBed;
    }

    public int getNoBath() {
        return noBath;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionLong() {
        return descriptionLong;
    }

    public String getReccommend1() {
        return reccommend1;
    }

    public String getReccommend2() {
        return reccommend2;
    }

    public String getReccommend3() {
        return reccommend3;
    }

    public String getNote() {
        return note;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCheck_in() {
        return check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public class City {

        int id, distance;
        String cityEN, cityCS;

        public City(int id, String cityEN, String cityCS, int distance) {
            this.id = id;
            this.cityEN = cityEN;
            this.cityCS = cityCS;
            this.distance = distance;
        }

        public int getId() {
            return id;
        }

        public int getDistance() {
            return distance;
        }

        public String getCityEN() {
            return cityEN;
        }

        public String getCityCS() {
            return cityCS;
        }
    }
}
