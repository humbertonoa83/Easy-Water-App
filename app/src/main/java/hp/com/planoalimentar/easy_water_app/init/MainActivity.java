package hp.com.planoalimentar.easy_water_app.init;

import android.app.role.RoleManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import hp.com.planoalimentar.easy_water_app.R;
import hp.com.planoalimentar.easy_water_app.api.statics.ApiRequest;
import hp.com.planoalimentar.easy_water_app.api.statics.CallBack;
import hp.com.planoalimentar.easy_water_app.api.statics.Constants;
import hp.com.planoalimentar.easy_water_app.auth.LoginActivity;
import hp.com.planoalimentar.easy_water_app.breakdown.BreakdownFragment;
import hp.com.planoalimentar.easy_water_app.client.ClientBean;
import hp.com.planoalimentar.easy_water_app.client.adress.ClientAddress;
import hp.com.planoalimentar.easy_water_app.client.datas.ClientDataFragment;
import hp.com.planoalimentar.easy_water_app.client.document.ClientDocumentBean;
import hp.com.planoalimentar.easy_water_app.client.routes.ClientRoutes;
import hp.com.planoalimentar.easy_water_app.employee.EmployeeBean;
import hp.com.planoalimentar.easy_water_app.employee.EmployeeInvoice;
import hp.com.planoalimentar.easy_water_app.employee.EmployeeReport;
import hp.com.planoalimentar.easy_water_app.info.About;
import hp.com.planoalimentar.easy_water_app.invoice.InvoicePayment;
import hp.com.planoalimentar.easy_water_app.invoice.InvoiceView;
import hp.com.planoalimentar.easy_water_app.payments.Payments;
import hp.com.planoalimentar.easy_water_app.client.datas.profile.ProfileFragment;
import hp.com.planoalimentar.easy_water_app.recharger.BuyRecharger;
import hp.com.planoalimentar.easy_water_app.store.preferences.StorePreferences;
import hp.com.planoalimentar.easy_water_app.user.roles.Roles;
import hp.com.planoalimentar.easy_water_app.user.routes.UserLoginRoutes;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 21/09/2020.
 */


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private JSONObject jsonObject;
    private StorePreferences storePreferences;
    private ClientBean client;
    private ClientDocumentBean clientDocument;
    private ClientAddress clientAddress;
    private TextView txtUsername;
    private String token;
    private static boolean HIDE_MENU = false;
    private EmployeeBean employee;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_splash);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        if(storePreferences.getRole().equals(Roles.CLIENT.getName())) {
            ApiRequest.makeGETRequest(getApplicationContext(), ClientRoutes.getClientInformation(storePreferences.getClientId()), jsonObject, new CallBack() {

                @Override
                public void responce (String responce) {

                    parseInformation(responce);
                }
            });
        }else{
            ApiRequest.makeGETRequest(getApplicationContext(), ClientRoutes.getClientInformation(storePreferences.getClientId()), jsonObject, new CallBack() {

                @Override
                public void responce (String responce) {

                    parseInformationEmployee(responce);
                }
            });
        }

    }

    private void hideMenus (Menu menu) {
        if(storePreferences.getRole().equals(Roles.CLIENT.getName())){
            MenuItem employee_report = menu.findItem(R.id.employee_report);
            employee_report.setVisible(false);
            MenuItem employee_invoice = menu.findItem(R.id.employee_invoice);
            employee_invoice.setVisible(false);
            MenuItem employee = menu.findItem(R.id.employee);
            employee.setVisible(false);
            MenuItem notification = menu.findItem(R.id.notification);
            notification.setVisible(false);
        }else{
            MenuItem mydatas = menu.findItem(R.id.mydatas);
            mydatas.setVisible(false);
            MenuItem breakdown = menu.findItem(R.id.breakdown);
            breakdown.setVisible(false);
            MenuItem create_recharger = menu.findItem(R.id.create_recharger);
            create_recharger.setVisible(false);
            MenuItem second_copy = menu.findItem(R.id.second_copy);
            second_copy.setVisible(false);
            MenuItem add = menu.findItem(R.id.add);
            add.setVisible(false);
        }

    }

    private void parseInformation (String responce) {
        try {
            JSONObject jsonObject = new JSONObject(responce);
            if(jsonObject.getJSONObject("client") != null) {
                Gson gson = new GsonBuilder().create();
                client = gson.fromJson((new JSONObject(responce)).getJSONObject("client").toString(), ClientBean.class);
                clientDocument = gson.fromJson((new JSONObject(responce)).getJSONObject("clientdocument").toString(), ClientDocumentBean.class);
                clientAddress = gson.fromJson((new JSONObject(responce)).getJSONObject("clientadress").toString(), ClientAddress.class);
                storePreferences.storeClientData(client);
                storePreferences.storeDocument(clientDocument);
                storePreferences.storeAddress(clientAddress);

            }else{
                client = storePreferences.getClientData();
                clientDocument = storePreferences.getDocument();
                clientAddress = storePreferences.getAddress();

            }


        } catch (JSONException e) {
            client = storePreferences.getClientData();
            clientDocument = storePreferences.getDocument();
            clientAddress = storePreferences.getAddress();
        }

    }

    private void parseInformationEmployee (String responce) {
        try {
            JSONObject jsonObject = new JSONObject(responce);
            if(jsonObject.getJSONObject("employee") != null) {
                Gson gson = new GsonBuilder().create();
                employee = gson.fromJson((new JSONObject(responce)).getJSONObject("employee").toString(), EmployeeBean.class);
                clientDocument = gson.fromJson((new JSONObject(responce)).getJSONObject("employeedocument").toString(), ClientDocumentBean.class);
                clientAddress = gson.fromJson((new JSONObject(responce)).getJSONObject("employeeaddress").toString(), ClientAddress.class);
                storePreferences.storeClientData(client);
                storePreferences.storeDocument(clientDocument);
                storePreferences.storeAddress(clientAddress);

            }else{
                employee = storePreferences.getEmployee();
                clientDocument = storePreferences.getDocument();
                clientAddress = storePreferences.getAddress();

            }


        } catch (JSONException e) {
            employee = storePreferences.getEmployee();
            clientDocument = storePreferences.getDocument();
            clientAddress = storePreferences.getAddress();
        }

    }

    @Override
    public void onBackPressed () {

        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected (@NonNull MenuItem item) {
        selectDrawerItem(item);
        return true;
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass = null;
        switch(menuItem.getItemId()) {
            case R.id.create_recharger:
                fragmentClass = BuyRecharger.class;
                break;
            case R.id.profile:
                fragmentClass = ProfileFragment.class;
                break;
            case R.id.add_Payments:
                fragmentClass = Payments.class;
                break;

            case R.id.add_billing:
                fragmentClass = InvoiceView.class;
                break;
            case R.id.employee_invoice:
                fragmentClass = EmployeeInvoice.class;
                break;
            case R.id.employee_report:
                fragmentClass = EmployeeReport.class;
                break;
            case R.id.info_about:
                fragmentClass = About.class;
                break;
            case R.id.info_exit:

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.app_name);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage(getString(R.string.label_confirm_logout))
                        .setCancelable(false)
                        .setPositiveButton(getString(R.string.label_yes), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                logout();

                                dialog.cancel();
                            }
                        })
                        .setNegativeButton(getString(R.string.label_no), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                break;

            case R.id.breakdown:
                fragmentClass = BreakdownFragment.class;
                break;

            case R.id.mydatas:
                fragmentClass = ClientDataFragment.class;
                break;
            default:;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(fragment == null){
            drawerLayout.closeDrawers();
            return;

        }

        Bundle bundle = new Bundle();
        if(storePreferences.getRole() == Roles.CLIENT.getName()){
            bundle.putSerializable("client", client);
        }else{
            bundle.putSerializable("employee", employee);
        }

        bundle.putSerializable("document", clientDocument);
        bundle.putSerializable("address", clientAddress);

        fragment.setArguments(bundle);

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.framelayout, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        drawerLayout.closeDrawers();
    }

    private void logout () {
        storePreferences.forceLoggout();
        JSONObject paremeters = new JSONObject();

        ApiRequest.makePOSTRequest(getApplicationContext(), UserLoginRoutes.makeLogout(), paremeters,new CallBack(){

            @Override
            public void responce (String responce) {
                try {
                    JSONObject jsonObject = new JSONObject(responce);
                    if(jsonObject.getBoolean(Constants.SUCCESS)){
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), getString(R.string.logout_error), Toast.LENGTH_LONG).show();
                    }
                }catch (JSONException exception){
                    exception.printStackTrace();
                }


            }
        });

    }

    private void init(){

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_header_container);
        toolbar = findViewById(R.id.toolbar);
        jsonObject = new JSONObject();

        storePreferences = new StorePreferences(getApplicationContext());
        token = storePreferences.getToken();
        //txtUsername = findViewById(R.id.username);
        //txtUsername.setText(storePreferences.getUsername());

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        Menu menu = navigationView.getMenu();
        hideMenus(menu);

    }

}
