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
    String name, description, descriptionLong, reccommend1, reccommend2, reccommend3, note, address;
    double latitude, longitude;
    String check_in, check_out; // TODO overit aky typ to je
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
            //TODO CHECKIN CHECKOUT
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionLong() {
        return descriptionLong;
    }

    public void setDescriptionLong(String descriptionLong) {
        this.descriptionLong = descriptionLong;
    }

    public String getReccommend1() {
        return reccommend1;
    }

    public void setReccommend1(String reccommend1) {
        this.reccommend1 = reccommend1;
    }

    public String getReccommend2() {
        return reccommend2;
    }

    public void setReccommend2(String reccommend2) {
        this.reccommend2 = reccommend2;
    }

    public String getReccommend3() {
        return reccommend3;
    }

    public void setReccommend3(String reccommend3) {
        this.reccommend3 = reccommend3;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }


    public int getNoBed() {
        return noBed;
    }

    public void setNoBed(int noBed) {
        this.noBed = noBed;
    }

    public int getNoBath() {
        return noBath;
    }

    public void setNoBath(int noBath) {
        this.noBath = noBath;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", descriptionLong='" + descriptionLong + '\'' +
                ", reccommend1='" + reccommend1 + '\'' +
                ", reccommend2='" + reccommend2 + '\'' +
                ", reccommend3='" + reccommend3 + '\'' +
                ", note='" + note + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", check_in='" + check_in + '\'' +
                ", check_out='" + check_out + '\'' +
                ", cities=" + cities +
                '}';
    }

    public class City {

        int id;
        String cityEN, cityCS;
        int distance;

        public City(int id, String cityEN, String cityCS, int distance) {
            this.id = id;
            this.cityEN = cityEN;
            this.cityCS = cityCS;
            this.distance = distance;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCityEN() {
            return cityEN;
        }

        public void setCityEN(String cityEN) {
            this.cityEN = cityEN;
        }

        public String getCityCS() {
            return cityCS;
        }

        public void setCityCS(String cityCS) {
            this.cityCS = cityCS;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "City{" +
                    "id=" + id +
                    ", cityEN='" + cityEN + '\'' +
                    ", cityCS='" + cityCS + '\'' +
                    ", distance=" + distance +
                    '}';
        }
    }

}
