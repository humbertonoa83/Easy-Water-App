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

    //Check if the the user is Logged In
    private final static  String LOGED = "isLogedIn";

    //Token
    private final static  String TOKEN = "token";

    public StorePreferences(Context context){

        this.context = context;

        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Check if the user are Logged in
     *
     * @return boolean
     * */
    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(LOGED, false);
    }

    public void setLoggedIn(){
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putBoolean(LOGED, true);
        editor.commit();
        editor.apply();

    }

    /**
     * Store the Login Token
     * @param token
     * @return void
     * */
    public void storeToken(String token){
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putString(TOKEN, "");
        editor.commit();
        editor.apply();
    }



}
