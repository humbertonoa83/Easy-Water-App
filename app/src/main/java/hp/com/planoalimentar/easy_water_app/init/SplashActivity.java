package hp.com.planoalimentar.easy_water_app.init;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;

import hp.com.planoalimentar.easy_water_app.R;
import hp.com.planoalimentar.easy_water_app.auth.LoginActivity;
import hp.com.planoalimentar.easy_water_app.store.preferences.StorePreferences;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 21/09/2020.
 */

public class SplashActivity extends AppCompatActivity {

    private CountDownTimer countDownTimer;
    private Intent intent;
    private StorePreferences storePreferences;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_splash);

        storePreferences = new StorePreferences(getApplicationContext());

        countDownTimer = new CountDownTimer(1500, 500){

            @Override
            public void onTick (long millisUntilFinished) {

            }

            @Override
            public void onFinish () {
                if(storePreferences.isLoggedIn()){
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                }else{
                    intent = new Intent(getApplicationContext(), LoginActivity.class);
                }
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                finish();
            }
        }.start();


    }
}
