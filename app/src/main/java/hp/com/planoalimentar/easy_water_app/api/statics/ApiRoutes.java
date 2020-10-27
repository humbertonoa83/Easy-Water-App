package hp.com.planoalimentar.easy_water_app.api.statics;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 10/10/2020.
 */
public enum ApiRoutes implements ApiRoutesInterface{

    CLIENTS{
        @Override
        public String path () {

            return Path.getAddress()+"clients/";
        }
    },
    BREAKDOWN {
        @Override
        public String path () {

            return Path.getAddress()+"breakdowns/";
        }
    },
    CLIENTTYPE {
        @Override
        public String path () {

            return Path.getAddress()+"client-types/";
        }
    },RECHARGER {
        @Override
        public String path () {

            return Path.getAddress()+"rechargers/";
        }
    },
    LOGIN{
        @Override
        public String path () {

            return Path.getAddress()+"login/";
        }
    },
    LOGOUT{
        @Override
        public String path () {

            return Path.getAddress()+"logout/";
        }
    },
    EMPLOYEE {
        @Override
        public String path () {

            return Path.getAddress()+"employees/";
        }
    };



}
