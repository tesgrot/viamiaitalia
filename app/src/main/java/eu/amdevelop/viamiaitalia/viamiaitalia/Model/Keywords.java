package eu.amdevelop.viamiaitalia.viamiaitalia.Model;

/**
 * Created by terezamadova on 15/11/2017.
 */

public class Keywords {

    public enum ContactKeywords {
        address, house_number, city, state, number, email, facebook_u_r_l, twitter_u_r_l,
        instagram_u_r_l, contact_person, note
    }

    public enum ServiceKeywords {
        id, minimal_price, service_e_n, service_c_s, name, description, description_long

    }

    public enum ServiceElementKeywords {
        id, service_element_c_s, service_element_e_n, description_long, duration, duration_units,
        price_person
    }

    public enum OrderKeywords {
        id, name, mail, phone
//            TODO dokoncit
    }

    public enum AccommodationKeywords {
        id, accommodation_e_n, accommodation_c_s, name, description, description_long,
        recommended_for1, recommended_for2, recommended_for3, note, close_cities, city_e_n,
        city_c_s, distance, minimal_price, address, latitude, longitude, check_in, check_out,
        no_of_bathrooms, no_of_bedrooms
    }

    public enum ApartmentKeywords {
        id, apartment_e_n, apartment_c_s, name, description, note, no_of_single_beds, no_of_double_beds,
        no_of_persons, internet_connection, own_bathroom
    }

}
