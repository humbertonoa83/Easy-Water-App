package hp.com.planoalimentar.easy_water_app.client.adress;

import java.io.Serializable;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 26/10/2020.
 */
public class ClientAddress implements Serializable {

    private String country;
    private String province;
    private String district;
    private String neighborhood;
    private String street;
    private String avenue;
    private String block;
    private String place_number;

    public ClientAddress () { }

    public String getCountry () {

        return country;
    }

    public void setCountry (String country) {

        this.country = country;
    }

    public String getProvince () {

        return province;
    }

    public void setProvince (String province) {

        this.province = province;
    }

    public String getDistrict () {

        return district;
    }

    public void setDistrict (String district) {

        this.district = district;
    }

    public String getNeighborhood () {

        return neighborhood;
    }

    public void setNeighborhood (String neighborhood) {

        this.neighborhood = neighborhood;
    }

    public String getStreet () {

        return street;
    }

    public void setStreet (String street) {

        this.street = street;
    }

    public String getAvenue () {

        return avenue;
    }

    public void setAvenue (String avenue) {

        this.avenue = avenue;
    }

    public String getBlock () {

        return block;
    }

    public void setBlock (String block) {

        this.block = block;
    }

    public String getPlace_number () {

        return place_number;
    }

    public void setPlace_number (String place_number) {

        this.place_number = place_number;
    }
}
