package hp.com.planoalimentar.easy_water_app.store.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 21/09/2020.
 */

public class StorePreferences {

    //The SharedPreferences
    private  static SharedPreferences sharedPreferences;

    //The Application Context
    private static Context context;

    //The Preference name
    private final static String PREF_NAME = "EASY_WATER";

    public StorePreferences(Context context){

        this.context = context;

        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

}
