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
    private String document_type;
    private String document_name;
    private String telefone;
    private String gender;
    private String adress;
    private String nationality;
    private String country;
    private String counter;
    private String client_type;
    private String counter_id;


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

    public String getDocument_type () {

        return document_type;
    }

    public void setDocument_type (String document_type) {

        this.document_type = document_type;
    }

    public String getDocument_name () {

        return document_name;
    }

    public void setDocument_name (String document_name) {

        this.document_name = document_name;
    }

    public String getEmail () {

        return email;
    }

    public void setEmail (String email) {

        this.email = email;
    }

    public String getTelefone () {

        return telefone;
    }

    public void setTelefone (String telefone) {

        this.telefone = telefone;
    }

    public String getGender () {

        return gender;
    }

    public void setGender (String gender) {

        this.gender = gender;
    }

    public String getAdress () {

        return adress;
    }

    public void setAdress (String adress) {

        this.adress = adress;
    }

    public String getNationality () {

        return nationality;
    }

    public void setNationality (String nationality) {

        this.nationality = nationality;
    }

    public String getCountry () {

        return country;
    }

    public void setCountry (String country) {

        this.country = country;
    }

    public String getCounter () {

        return counter;
    }

    public void setCounter (String counter) {

        this.counter = counter;
    }

    public String getClient_type () {

        return client_type;
    }

    public void setClient_type (String client_type) {

        this.client_type = client_type;
    }

    public String getCounter_id () {

        return counter_id;
    }

    public void setCounter_id (String counter_id) {

        this.counter_id = counter_id;
    }

    @Override
    public String toString () {

        return "ClientBean{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", email='" + email + '\'' + ", surname='" + surname + '\'' + ", document_type='" + document_type + '\'' + ", document_name='" + document_name + '\'' + ", telefone='" + telefone + '\'' + ", gender='" + gender + '\'' + ", adress='" + adress + '\'' + ", nationality='" + nationality + '\'' + ", country='" + country + '\'' + ", counter='" + counter + '\'' + ", client_type='" + client_type + '\'' + ", counter_id='" + counter_id + '\'' + '}';
    }
}
