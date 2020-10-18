package hp.com.planoalimentar.easy_water_app.user.routes;

import hp.com.planoalimentar.easy_water_app.api.statics.ApiRoutes;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 18/10/2020.
 */
public class UserLoginRoutes {

    /**
     * Login
     * @return url
     * */
    public static String makeLogin(){
        return ApiRoutes.LOGIN.path();
    }

    /**
     * Login
     * @return url
     * */
    public static String makeLogout(){
        return ApiRoutes.LOGOUT.path();
    }

}
