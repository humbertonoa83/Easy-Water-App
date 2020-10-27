package hp.com.planoalimentar.easy_water_app.client;

import java.io.Serializable;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 17/10/2020.
 */
public class ClientBean implements Serializable {

    private String id;
    private String name;
    private String email;
    private String surname;
    private String telephone;
    private String gender;
    private String nationality;


    public ClientBean(){}

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

    public String getSurname () {

        return surname;
    }

    public void setSurname (String surname) {

        this.surname = surname;
    }

    public String getEmail () {

        return email;
    }

    public void setEmail (String email) {

        this.email = email;
    }

    public String getTelephone () {

        return telephone;
    }

    public void setTelephone (String telephone) {

        this.telephone = telephone;
    }

    public String getGender () {

        return gender;
    }

    public void setGender (String gender) {

        this.gender = gender;
    }

    public String getNationality () {

        return nationality;
    }

    public void setNationality (String nationality) {

        this.nationality = nationality;
    }

    @Override
    public String toString () {

        return "ClientBean{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", email='" + email + '\'' + ", surname='" + surname + '\'' + ", telephone='" + telephone + '\'' + ", gender='" + gender + '\'' + ", nationality='" + nationality + '\'' + '}';
    }
}
