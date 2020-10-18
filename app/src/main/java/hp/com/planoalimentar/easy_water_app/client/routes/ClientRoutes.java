package hp.com.planoalimentar.easy_water_app.client.routes;

import hp.com.planoalimentar.easy_water_app.api.statics.ApiRoutes;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 17/10/2020.
 */
public class ClientRoutes {

    /**
     * Get the url to get the
     * Client Information
     * @param clientCode
     * @return url
     * */
    public static String getClientInformation(String clientCode){
        if(clientCode == null)
            throw new NullPointerException("Client code can't be null");
        return ApiRoutes.CLIENTS.path()+clientCode;
    }

}
