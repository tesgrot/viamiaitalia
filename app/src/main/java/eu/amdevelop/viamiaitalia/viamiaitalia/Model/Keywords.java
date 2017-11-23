package eu.amdevelop.viamiaitalia.viamiaitalia.Model;

/**
 * Created by terezamadova on 15/11/2017.
 */

public class Keywords {

    public enum ContactKeywords {
        address, house_number, city, state, number, email, facebook_u_r_l, twitter_u_r_l, instagram_u_r_l, contact_person, note
    }

    public enum ServiceKeywords {
        id, minimal_price, service_e_n, service_c_s, name, description, descriptionLong

    }

    public enum ServiceElementKeywords {
        id, service_element_c_s, service_element_e_n, description_long, duration, duration_units, price_person
    }

    public enum OrderKeywords {
        id, name, mail, phone
//            TODO dokoncit
    }

    public enum AccommodationKeywords {
        id, name, description, descriptionLong
//            TODO dokoncit
    }

}
