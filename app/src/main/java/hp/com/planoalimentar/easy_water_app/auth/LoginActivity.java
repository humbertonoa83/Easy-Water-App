package hp.com.planoalimentar.easy_water_app.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import hp.com.planoalimentar.easy_water_app.R;
import hp.com.planoalimentar.easy_water_app.init.MainActivity;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 24/09/2020.
 */

public class LoginActivity extends AppCompatActivity {

    private Button btn_Login;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_Login = findViewById(R.id.btn_Login);

        final Intent intent = new Intent(LoginActivity.this, MainActivity.class);

        btn_Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                startActivity(intent);
            }
        });
    }
}
