package hp.com.planoalimentar.easy_water_app.store.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import hp.com.planoalimentar.easy_water_app.user.UserBean;

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

    //User attributes
    private final static String USER_ID = "user_id";
    private final static String USER_AVATAR = "user_avatar";
    private final static String USER_NAME = "user_name";
    private final static String USER_EMAIL = "user_email";

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
        editor.putString(TOKEN, token);
        editor.commit();
        editor.apply();
    }

    /**
     * Get the User whose Logged in
     *
     * @return UserBean
     * */
    public UserBean getUser(){
        UserBean user = new UserBean();

        user.setId(sharedPreferences.getString(USER_ID, ""));
        user.setName(sharedPreferences.getString(USER_NAME, ""));
        user.setEmail(sharedPreferences.getString(USER_EMAIL, ""));
        user.setAvatar(sharedPreferences.getString(USER_AVATAR, ""));
        return user;
    }

    /**
     * Store the Login Token
     * @param user
     * @return void
     * */
    public void storeUser(UserBean user){
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putString(USER_ID, "");
        editor.putString(USER_NAME, "");
        editor.putString(USER_EMAIL, "");
        editor.putString(USER_AVATAR, "");
        editor.commit();
        editor.apply();
    }

    /**
     * Get the User Token
     * @return String
     * */
    public String getToken(){
        return sharedPreferences.getString(TOKEN, "");
    }

    /**
     * Get the User Token
     * @return String
     * */
    public String getUsername(){
        return sharedPreferences.getString(USER_NAME, "");
    }

}
