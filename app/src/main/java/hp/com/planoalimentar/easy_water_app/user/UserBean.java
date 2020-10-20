package hp.com.planoalimentar.easy_water_app.user;

import java.io.Serializable;

import hp.com.planoalimentar.easy_water_app.api.statics.ApiRoutes;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 18/10/2020.
 */
public class UserBean implements Serializable {

    private String id;
    private String name;
    private String email;
    private String avatar;

    public UserBean(){}

    public String getId () {

        return id;
    }

    public void setId (String id) {

        this.id = id;
    }

    public String getName () {

        return name;
    }

    public void setName (String name) {

        this.name = name;
    }

    public String getEmail () {

        return email;
    }

    public void setEmail (String email) {

        this.email = email;
    }

    public String getAvatar () {

        return avatar;
    }

    public void setAvatar (String avatar) {

        this.avatar = avatar;
    }
}
