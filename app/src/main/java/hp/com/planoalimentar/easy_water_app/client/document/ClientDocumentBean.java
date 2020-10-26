package hp.com.planoalimentar.easy_water_app.client.document;

import java.io.Serializable;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 26/10/2020.
 */
public class ClientDocumentBean implements Serializable {

    private String document_number;
    private String document_type;
    private String issue_date;

    public String getIssue_place () {

        return issue_place;
    }

    public void setIssue_place (String issue_place) {

        this.issue_place = issue_place;
    }

    private String issue_place;
    private String expiration_date;

    public ClientDocumentBean () {

    }

    public String getDocument_number () {

        return document_number;
    }

    public void setDocument_number (String document_number) {

        this.document_number = document_number;
    }

    public String getDocument_type () {

        return document_type;
    }

    public void setDocument_type (String document_type) {

        this.document_type = document_type;
    }

    public String getIssue_date () {

        return issue_date;
    }

    public void setIssue_date (String issue_date) {

        this.issue_date = issue_date;
    }

    public String getExpiration_date () {

        return expiration_date;
    }

    public void setExpiration_date (String expiration_date) {

        this.expiration_date = expiration_date;
    }
}
