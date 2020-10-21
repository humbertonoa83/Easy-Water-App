package hp.com.planoalimentar.easy_water_app.breakdown.routes;

import hp.com.planoalimentar.easy_water_app.api.statics.ApiRoutes;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 21/10/2020.
 */
public class BreakdownRoutes {

    /**
     * Get the url to get the
     * Store the Breakdown
     * @return url
     * */
    public static String reportBreakdown(){
        return ApiRoutes.BREAKDOWN.path();
    }

}
