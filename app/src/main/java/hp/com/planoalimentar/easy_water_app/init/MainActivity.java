package hp.com.planoalimentar.easy_water_app.init;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import hp.com.planoalimentar.easy_water_app.R;
import hp.com.planoalimentar.easy_water_app.auth.LoginActivity;
import hp.com.planoalimentar.easy_water_app.billing.billing;
import hp.com.planoalimentar.easy_water_app.billing.view_billing;
import hp.com.planoalimentar.easy_water_app.client.client;
import hp.com.planoalimentar.easy_water_app.client.view_client;
import hp.com.planoalimentar.easy_water_app.employee.employee;
import hp.com.planoalimentar.easy_water_app.employee.view_employee;
import hp.com.planoalimentar.easy_water_app.info.about;
import hp.com.planoalimentar.easy_water_app.info.exit;
import hp.com.planoalimentar.easy_water_app.payments.payments;
import hp.com.planoalimentar.easy_water_app.payments.view_payments;
import hp.com.planoalimentar.easy_water_app.profile.ProfileFragment;
import hp.com.planoalimentar.easy_water_app.recharger.BuyRecharger;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 21/09/2020.
 */


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_splash);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_header_container);
        toolbar = findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
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

            case R.id.add_client:
                fragmentClass = client.class;
                break;
            case R.id.add_employee:
                fragmentClass = employee.class;
            break;

            case R.id.add_billing:
                fragmentClass = billing.class;
                break;
            case R.id.add_Payments:
                fragmentClass = payments.class;
                break;

            case R.id.view_client:
                fragmentClass = view_client.class;
                break;
            case R.id.view_employee:
                fragmentClass = view_employee.class;
                break;
            case R.id.view_billing:
                fragmentClass = view_billing.class;
                break;

            case R.id.view_Payments:
                fragmentClass = view_payments.class;
                break;

            case R.id.info_about:
                fragmentClass = about.class;
                break;
            case R.id.info_exit:
               // android.os.Process.killProcess(android.os.Process.myPid());
                //System.exit(1);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.app_name);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("Tem a certeza que deseja sair??")
                        .setCancelable(false)
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        })
                        .setNegativeButton("Nao", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
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

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        drawerLayout.closeDrawers();
    }

}
