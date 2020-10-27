package hp.com.planoalimentar.easy_water_app.store.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import hp.com.planoalimentar.easy_water_app.client.ClientBean;
import hp.com.planoalimentar.easy_water_app.client.adress.ClientAddress;
import hp.com.planoalimentar.easy_water_app.client.document.ClientDocumentBean;
import hp.com.planoalimentar.easy_water_app.employee.EmployeeBean;
import hp.com.planoalimentar.easy_water_app.user.UserBean;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 21/09/2020.
 */

public class StorePreferences {

    //The SharedPreferences
    private  static SharedPreferences sharedPreferences;

    //The Application Context
    private static Context context;

    //The Preference name
    private final static String PREF_NAME = "EASY_WATER";

    //Check if the the user is Logged In
    private final static  String LOGED = "isLogedIn";

    //Token
    private final static  String TOKEN = "token";

    //User attributes
    private final static String USER_ID = "user_id";
    private final static String USER_AVATAR = "user_avatar";
    private final static String USER_NAME = "user_name";
    private final static String USER_EMAIL = "user_email";
    private final static String ROLE = "role";

    //Client Logged Attributes
    private final static String CLIENTID = "clientid";
    private final static String CLIENTNAME= "clientname";
    private final static String CLIENTEMAIL= "clientemail";
    private final static String CLIENTSURNAME= "clientsurname";
    private final static String CLIENTTELEPHONE= "clienttelephone";
    private final static String CLIENTGENDER= "clientgender";
    private final static String CLIENTNATIONALITY= "clientnationality";

    //Employee Logged Attributes
    private final static String EMPLOYEEID = "employeeid";
    private final static String EMPLOYEENAME = "employeename";
    private final static String EMPLOYEESURNAME = "employeesurname";
    private final static String EMPLOYEEDOCUMENTYPE = "employeedocument_type";
    private final static String EMPLOYEEDOCUMENTNAME = "employeedocument_name";
    private final static String EMPLOYEETELEFONE = "employeeemailtelefone";
    private final static String EMPLOYEEGENDER = "employeegender";
    private final static String EMPLOYEENATIONALITY = "employeenationality";
    private final static String EMPLOYEETYPEMAME = "employeetypeName";
    private final static String EMPLOYEECOUNTRY = "employeecountry";
    private final static String EMPLOYEEEMAIL = "employeeemail";

    //Document Logged Person Information
    private final static String DOCUMENTNUMBER = "documentnumber";
    private final static String DOCUMENTYPE = "documentype";
    private final static String DOCUMENTEXPIRATIONDATE = "documentexpirationdate";
    private final static String DOCUMENTISSUEDATE = "documentissuedate";
    private final static String DOCUMENTISSUEPLACE = "documentissueplace";

    //Address Logged Person Information
    private final static String ADDRESSCOUNTRY= "addresscountry";
    private final static String ADDRESSPROVINCE = "addressprovince";
    private final static String ADDRESSDISTRICT = "addressdistrict";
    private final static String ADDRESSNEIGHBORHOOD = "addressneighborhood";
    private final static String ADDRESSTREET = "addressstreet";
    private final static String ADDRESSAVENUE = "addressavenue";
    private final static String ADDRESSBLOCK = "addressblock";
    private final static String ADDRESSPLACENUMBER =  "addressplace_number";

    public StorePreferences(Context context){

        this.context = context;

        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Check if the user are Logged in
     *
     * @return boolean
     * */
    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(LOGED, false);
    }

    /**
     * Force Loggout
     *
     * */
    public void forceLoggout(){
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putBoolean(LOGED, false);
        editor.commit();
        editor.apply();
    }

    public void setLoggedIn(){
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putBoolean(LOGED, true);
        editor.commit();
        editor.apply();

    }

    /**
     * Store the Login Token
     * @param token
     * @return void
     * */
    public void storeToken(String token){
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putString(TOKEN, token);
        editor.commit();
        editor.apply();
    }

    /**
     * Get the User whose Logged in
     *
     * @return UserBean
     * */
    public UserBean getUser(){
        UserBean user = new UserBean();

        user.setId(sharedPreferences.getString(USER_ID, ""));
        user.setName(sharedPreferences.getString(USER_NAME, ""));
        user.setEmail(sharedPreferences.getString(USER_EMAIL, ""));
        user.setAvatar(sharedPreferences.getString(USER_AVATAR, ""));
        return user;
    }

    /**
     * Store the Login Token
     * @param user
     * @return void
     * */
    public void storeUser(UserBean user){
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putString(USER_ID, user.getId());
        editor.putString(USER_NAME, user.getName());
        editor.putString(USER_EMAIL, user.getEmail());
        editor.putString(USER_AVATAR, user.getAvatar());
        editor.commit();
        editor.apply();
    }

    /**
     * Get the User Token
     * @return String
     * */
    public String getToken(){
        return sharedPreferences.getString(TOKEN, "");
    }

    /**
     * Get the User Token
     * @return String
     * */
    public String getUsername(){
        return sharedPreferences.getString(USER_NAME, "");
    }

    /**
     * Store the User Role
     * @param role
     * */
    public void storeRole (String role) {
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putString(ROLE, role);
        editor.commit();
        editor.apply();
    }

    /**
     * Store the Client Data
     * that is Logged In
     *
     * @param clientBean
     * */

    public void storeClientData (ClientBean clientBean) {
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putString(CLIENTID, clientBean.getId());
        editor.putString(CLIENTNAME, clientBean.getName());
        editor.putString(CLIENTSURNAME, clientBean.getSurname());
        editor.putString(CLIENTEMAIL, clientBean.getEmail());
        editor.putString(CLIENTGENDER, clientBean.getGender());
        editor.putString(CLIENTNATIONALITY, clientBean.getNationality());
        editor.putString(CLIENTTELEPHONE, clientBean.getTelephone());

        editor.commit();
        editor.apply();
    }

    /**
     * Get the Client Data
     * that is Logged In
     *
     * @return ClientBean
     * */

    public ClientBean getClientData () {
        ClientBean client = new ClientBean();
        client.setId(sharedPreferences.getString(CLIENTID, ""));
        client.setName(sharedPreferences.getString(CLIENTNAME, ""));
        client.setSurname(sharedPreferences.getString(CLIENTSURNAME, ""));
        client.setEmail(sharedPreferences.getString(CLIENTEMAIL, ""));
        client.setGender(sharedPreferences.getString(CLIENTGENDER, ""));
        client.setNationality(sharedPreferences.getString(CLIENTNATIONALITY, ""));
        client.setTelephone(sharedPreferences.getString(CLIENTTELEPHONE, ""));

        return client;
    }

    /**
     * Store the Employee Data
     * that is Logged In
     *
     * @param employee
     * */
    public void storeEmployee (EmployeeBean employee) {
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putString(EMPLOYEECOUNTRY, employee.getCountry());
        editor.putString(EMPLOYEEDOCUMENTNAME, employee.getDocument_name());
        editor.putString(EMPLOYEEDOCUMENTYPE, employee.getDocument_type());
        editor.putString(EMPLOYEEGENDER, employee.getGender());
        editor.putString(EMPLOYEEID, employee.getId());
        editor.putString(EMPLOYEENAME, employee.getName());
        editor.putString(EMPLOYEENATIONALITY, employee.getNationality());
        editor.putString(EMPLOYEESURNAME, employee.getSurname());
        editor.putString(EMPLOYEETYPEMAME, employee.getEmployeeTypeName());
        editor.putString(EMPLOYEETELEFONE, employee.getTelefone());
        editor.putString(EMPLOYEEEMAIL, employee.getEmail());

        editor.commit();
        editor.apply();
    }

    /**
     * Get the Employee Data
     * that is Logged In
     *
     * @return  EmployeeBean
     * */
    public EmployeeBean getEmployee () {

        EmployeeBean employee = new EmployeeBean();

        employee.setId(sharedPreferences.getString(EMPLOYEEID, ""));
        employee.setName(sharedPreferences.getString(EMPLOYEENAME, ""));
        employee.setSurname(sharedPreferences.getString(EMPLOYEESURNAME, ""));
        employee.setDocument_name(sharedPreferences.getString(EMPLOYEEDOCUMENTNAME, ""));
        employee.setDocument_type(sharedPreferences.getString(EMPLOYEEDOCUMENTYPE, ""));
        employee.setEmail(sharedPreferences.getString(EMPLOYEEEMAIL, ""));
        employee.setTelefone(sharedPreferences.getString(EMPLOYEETELEFONE, ""));
        employee.setGender(sharedPreferences.getString(EMPLOYEEGENDER, ""));
        employee.setCountry(sharedPreferences.getString(EMPLOYEECOUNTRY, ""));
        employee.setNationality(sharedPreferences.getString(EMPLOYEENATIONALITY, ""));
        employee.setEmployeeTypeName(sharedPreferences.getString(EMPLOYEETYPEMAME, ""));


        return employee;
    }

    public String getRole(){
        return sharedPreferences.getString(ROLE, "");
    }

    public void storeClientId(String clientId){
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putString(CLIENTID, clientId);

        editor.commit();
        editor.apply();
    }

    public String getClientId(){
        return sharedPreferences.getString(CLIENTID, "");
    }

    public void storeEmployeeId(String employeeId){
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putString(EMPLOYEEID, employeeId);

        editor.commit();
        editor.apply();
    }

    public String getEmployeeid(){
        return sharedPreferences.getString(EMPLOYEEID, "");
    }

    public void storeDocument(ClientDocumentBean document){
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putString(DOCUMENTNUMBER, document.getDocument_number());
        editor.putString(DOCUMENTYPE, document.getDocument_type());
        editor.putString(DOCUMENTEXPIRATIONDATE, document.getExpiration_date());
        editor.putString(DOCUMENTISSUEDATE, document.getIssue_date());
        editor.putString(DOCUMENTISSUEPLACE, document.getIssue_place());

        editor.commit();
        editor.apply();
    }

    public ClientDocumentBean getDocument(){
        ClientDocumentBean document = new ClientDocumentBean();

        document.setDocument_number(sharedPreferences.getString(DOCUMENTNUMBER, ""));
        document.setDocument_type(sharedPreferences.getString(DOCUMENTYPE, ""));
        document.setExpiration_date(sharedPreferences.getString(DOCUMENTEXPIRATIONDATE, ""));
        document.setIssue_date(sharedPreferences.getString(DOCUMENTISSUEDATE, ""));
        document.setIssue_place(sharedPreferences.getString(DOCUMENTISSUEPLACE, ""));

        return document;
    }

    public void storeAddress(ClientAddress address){
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putString(ADDRESSAVENUE, address.getAvenue());
        editor.putString(ADDRESSBLOCK, address.getBlock());
        editor.putString(ADDRESSCOUNTRY, address.getCountry());
        editor.putString(ADDRESSDISTRICT, address.getDistrict());
        editor.putString(ADDRESSNEIGHBORHOOD, address.getNeighborhood());
        editor.putString(ADDRESSPLACENUMBER, address.getPlace_number());
        editor.putString(ADDRESSNEIGHBORHOOD, address.getNeighborhood());
        editor.putString(ADDRESSPROVINCE, address.getProvince());
        editor.putString(ADDRESSTREET, address.getStreet());

        editor.commit();
        editor.apply();
    }

    public ClientAddress getAddress(){
        ClientAddress address = new ClientAddress();

        address.setAvenue(sharedPreferences.getString(ADDRESSAVENUE, ""));
        address.setBlock(sharedPreferences.getString(ADDRESSBLOCK, ""));
        address.setCountry(sharedPreferences.getString(ADDRESSCOUNTRY, ""));
        address.setDistrict(sharedPreferences.getString(ADDRESSDISTRICT, ""));
        address.setNeighborhood(sharedPreferences.getString(ADDRESSNEIGHBORHOOD, ""));
        address.setPlace_number(sharedPreferences.getString(ADDRESSPLACENUMBER, ""));
        address.setProvince(sharedPreferences.getString(ADDRESSPROVINCE, ""));
        address.setStreet(sharedPreferences.getString(ADDRESSTREET, ""));

        return address;
    }

}
