package hp.com.planoalimentar.easy_water_app.user.roles;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 26/10/2020.
 */
public enum Roles implements RoleInterface{

    CLIENT{
        @Override
        public String getName () {

            return "client";
        }
    },
    ADMIN {
        @Override
        public String getName () {

            return "admin";
        }
    },
    OPERATOR {
        @Override
        public String getName () {

            return "operator";
        }
    },
    SUPERADMIN {
        @Override
        public String getName () {

            return "super-admin";
        }
    }
}
