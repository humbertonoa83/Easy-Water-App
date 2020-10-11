package hp.com.planoalimentar.easy_water_app.init;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

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

import hp.com.planoalimentar.easy_water_app.R;
import hp.com.planoalimentar.easy_water_app.billing.Billing;
import hp.com.planoalimentar.easy_water_app.billing.View_Billing;
import hp.com.planoalimentar.easy_water_app.breakdown.BreakdownFragment;
import hp.com.planoalimentar.easy_water_app.client.Client;
import hp.com.planoalimentar.easy_water_app.client.View_Client;
import hp.com.planoalimentar.easy_water_app.client.datas.ClientDataFragment;
import hp.com.planoalimentar.easy_water_app.employee.Employee;
import hp.com.planoalimentar.easy_water_app.employee.View_Employee;
import hp.com.planoalimentar.easy_water_app.info.About;
import hp.com.planoalimentar.easy_water_app.payments.Payments;
import hp.com.planoalimentar.easy_water_app.payments.View_Payments;
import hp.com.planoalimentar.easy_water_app.profile.ProfileFragment;
import hp.com.planoalimentar.easy_water_app.recharger.BuyRecharger;
import hp.com.planoalimentar.easy_water_app.suspension.Suspension;

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
                fragmentClass = Client.class;
                break;
            case R.id.add_employee:
                fragmentClass = Employee.class;
            break;

            case R.id.add_billing:
                fragmentClass = Billing.class;
                break;
            case R.id.add_Payments:
                fragmentClass = Payments.class;
                break;
            case R.id.add_suspension:
                fragmentClass = Suspension.class;
                break;
            case R.id.view_client:
                fragmentClass = View_Client.class;
                break;
            case R.id.view_employee:
                fragmentClass = View_Employee.class;
                break;
            case R.id.view_billing:
                fragmentClass = View_Billing.class;
                break;

            case R.id.view_Payments:
                fragmentClass = View_Payments.class;
                break;

            case R.id.info_about:
                fragmentClass = About.class;
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
