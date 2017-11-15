package eu.amdevelop.viamiaitalia.viamiaitalia.Services;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by terezamadova on 10/11/2017.
 */

class LocalDataManager extends Activity {
    private static final String PREFS_NAME = "ViaMiaItalia";
    SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();


    public void saveUser(String accessCode) {
        editor.putString("accessCode", accessCode);
        editor.commit();
    }

    public String getAccessCode() {
        return preferences.getString("accessCode", null);
    }

    public void deleteAll() {
        editor.clear();
        editor.commit();
    }
}
