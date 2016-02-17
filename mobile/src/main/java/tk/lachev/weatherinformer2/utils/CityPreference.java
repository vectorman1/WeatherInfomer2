package tk.lachev.weatherinformer2.utils;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by Boris Lachev on 1/23/2016.
 */
public class CityPreference {
    SharedPreferences prefs;
    public CityPreference(Activity activity) {
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    public String getCity() {
        return prefs.getString("city", "Sofia");
    }
    public void setCity(String city) {
        prefs.edit().putString("city", city).commit();
    }
}
