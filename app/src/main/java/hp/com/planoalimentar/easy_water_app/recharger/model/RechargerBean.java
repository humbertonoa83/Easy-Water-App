package hp.com.planoalimentar.easy_water_app.recharger.model;

import java.io.Serializable;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 21/10/2020.
 */
public class RechargerBean implements Serializable {

    private String reference;
    private String value;
    private String paymentMethod;
    private String recharger;
    private String bothAt;

    public String getReference () {

        return reference;
    }

    public String getValue () {

        return value;
    }

    public String getPaymentMethod () {

        return paymentMethod;
    }

    public String getRecharger () {

        return recharger;
    }

    public String getBothAt () {

        return bothAt;
    }

    public void setReference (String reference) {

        this.reference = reference;
    }

    public void setValue (String value) {

        this.value = value;
    }

    public void setPaymentMethod (String paymentMethod) {

        this.paymentMethod = paymentMethod;
    }

    public void setRecharger (String recharger) {

        this.recharger = recharger;
    }

    public void setBothAt (String bothAt) {

        this.bothAt = bothAt;
    }
}
