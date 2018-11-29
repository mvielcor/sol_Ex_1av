package pmdm.manel.sol_ex_1av;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.os.Bundle;

public class ActivityPreferencies extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener{

    private SharedPreferences preferenciesDUsuari; //Objecte per llegir i manipular les preferencies


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencies);
        //Cal llegir les preferencies i actualitzar tots els valor de summaries
      actualitzaSummaries();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals("etp_nom")) {
            Preference pref = findPreference(key);
            pref.setSummary(sharedPreferences.getString(key, "Cap").toString());
        }
        if(key.equals("color_fragment")) {
            Preference pref = findPreference(key);
            pref.setSummary(sharedPreferences.getString(key, "Cap").toString());
        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }
    @Override
    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    public void actualitzaSummaries(){
        preferenciesDUsuari  = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Preference pref;
        //email
        pref = findPreference("etp_nom");
        pref.setSummary(preferenciesDUsuari.getString("etp_nom","Cap"));
        //color de fons
        pref = findPreference("color_fragment");
        pref.setSummary(preferenciesDUsuari.getString("color_fragment", "Cap").toString());


    }

}
