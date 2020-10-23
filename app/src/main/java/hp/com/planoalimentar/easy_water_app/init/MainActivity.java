package hp.com.planoalimentar.easy_water_app.init;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
import hp.com.planoalimentar.easy_water_app.client.datas.ClientDataFragment;
import hp.com.planoalimentar.easy_water_app.client.routes.ClientRoutes;
import hp.com.planoalimentar.easy_water_app.employee.EmployeeReport;
import hp.com.planoalimentar.easy_water_app.info.About;
import hp.com.planoalimentar.easy_water_app.invoice.InvoiceView;
import hp.com.planoalimentar.easy_water_app.payments.Payments;
import hp.com.planoalimentar.easy_water_app.client.datas.profile.ProfileFragment;
import hp.com.planoalimentar.easy_water_app.recharger.BuyRecharger;
import hp.com.planoalimentar.easy_water_app.store.preferences.StorePreferences;
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
    private TextView txtUsername;
    private String token;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_splash);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        ApiRequest.makeGETRequest(getApplicationContext(), ClientRoutes.getClientInformation("1"), jsonObject, new CallBack() {

            @Override
            public void responce (String responce) {
                parseInformation(responce);
            }
        });


    }

    private void parseInformation (String responce) {
        try {

            Gson gson = new GsonBuilder().create();
            client = gson.fromJson((new JSONObject(responce)).getJSONObject("client").toString(), ClientBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
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
        bundle.putSerializable("client", client);
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

    }

}
