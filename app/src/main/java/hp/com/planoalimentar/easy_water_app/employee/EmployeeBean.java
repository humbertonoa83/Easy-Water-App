package hp.com.planoalimentar.easy_water_app.employee;

import java.io.Serializable;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 26/10/2020.
 */
public class EmployeeBean implements Serializable {

    public String id;
    public String name;
    public String surname;
    public String document_type;
    public String document_name;
    public String email;
    public String telefone;
    public String gender;
    public String country;
    public String nationality;
    public String employeeTypeName;

    public EmployeeBean () { }

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

    public String getCountry () {

        return country;
    }

    public void setCountry (String country) {

        this.country = country;
    }

    public String getNationality () {

        return nationality;
    }

    public void setNationality (String nationality) {

        this.nationality = nationality;
    }

    public String getEmployeeTypeName () {

        return employeeTypeName;
    }

    public void setEmployeeTypeName (String employeeTypeName) {

        this.employeeTypeName = employeeTypeName;
    }

    @Override
    public String toString () {

        return "EmployeeBean{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", surname='" + surname + '\'' + ", document_type='" + document_type + '\'' + ", document_name='" + document_name + '\'' + ", email='" + email + '\'' + ", telefone='" + telefone + '\'' + ", gender='" + gender + '\'' + ", country='" + country + '\'' + ", nationality='" + nationality + '\'' + ", employeeTypeName='" + employeeTypeName + '\'' + '}';
    }
}
