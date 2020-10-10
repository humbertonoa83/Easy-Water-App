package hp.com.planoalimentar.easy_water_app.api.statics;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 10/10/2020.
 */
enum ApiRoutes implements ApiRoutesInterface{
    CLIENTS{
        @Override
        public String path () {

            return "api/clients/";
        }
    },
    BREAKDOWN {
        @Override
        public String path () {

            return "api/breakdowns/";
        }
    },
    CLIENTTYPE {
        @Override
        public String path () {

            return "api/client-types/";
        }
    }
}
