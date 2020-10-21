package hp.com.planoalimentar.easy_water_app.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import hp.com.planoalimentar.easy_water_app.R;
import hp.com.planoalimentar.easy_water_app.api.statics.ApiRequest;
import hp.com.planoalimentar.easy_water_app.api.statics.CallBack;
import hp.com.planoalimentar.easy_water_app.api.statics.Constants;
import hp.com.planoalimentar.easy_water_app.client.routes.ClientRoutes;
import hp.com.planoalimentar.easy_water_app.init.MainActivity;
import hp.com.planoalimentar.easy_water_app.store.preferences.StorePreferences;
import hp.com.planoalimentar.easy_water_app.user.routes.UserLoginRoutes;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 24/09/2020.
 */

public class LoginActivity extends AppCompatActivity {

    private Button btn_Login;
    private TextInputEditText txtEmail;
    private TextInputLayout layoutEmail;
    private TextInputEditText txtPass;
    private TextInputLayout layoutPass;
    private ProgressDialog progressDialog;
    private StorePreferences storePreferences;
    private Intent intent;



    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        btn_Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                if(isValidCredentials()){
                    try {
                        login();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void login () throws JSONException {
        progressDialog.setMessage(getString(R.string.message_wait));
        progressDialog.show();
        JSONObject paremeters = new JSONObject();
        paremeters.put("email", txtEmail.getText().toString().trim());
        paremeters.put("password", txtPass.getText().toString());

        ApiRequest.makePOSTLogin(getApplicationContext(), UserLoginRoutes.makeLogin(), paremeters,new CallBack(){

            @Override
            public void responce (String responce) {
                parseData(responce);
            }
        });

    }

    private void parseData (String responce) {
        try {
            System.out.println("Response "+responce);
            JSONObject jsonObject = new JSONObject(responce);
            if(jsonObject.getBoolean(Constants.SUCCESS)){
                String token = jsonObject.getString(Constants.TOKEN);
                storePreferences.setLoggedIn();
                System.out.println("Token: "+token);
                storePreferences.storeToken(token);

                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                finish();
            }
            else{
                layoutEmail.setError(getString(R.string.invalid_credentials));
                layoutPass.setError(getString(R.string.invalid_credentials));
                progressDialog.dismiss();
            }
        }catch (JSONException exception){
            exception.printStackTrace();
            progressDialog.dismiss();
        }
    }

    private boolean isValidCredentials () {

        if(txtEmail.getText().toString().isEmpty()){
            layoutEmail.setErrorEnabled(true);
            layoutEmail.setError(getString(R.string.email_required));
            return false;
        }
        if(txtPass.getText().toString().isEmpty()){
            layoutPass.setErrorEnabled(true);
            layoutPass.setError(getString(R.string.password_required));
            return false;
        }
        if(txtPass.getText().toString().length() < 8){
            layoutPass.setErrorEnabled(true);
            layoutPass.setError(getString(R.string.minimal_password));
            return false;
        }

        return true;

    }

    private void init(){

        btn_Login = findViewById(R.id.btn_Login);
        txtEmail = findViewById(R.id.txt_email);
        layoutEmail = findViewById(R.id.layoutEmail);
        txtPass = findViewById(R.id.txtPass);
        layoutPass = findViewById(R.id.layoutPass);

        final Intent intent = new Intent(LoginActivity.this, MainActivity.class);

        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setCancelable(false);

        storePreferences = new StorePreferences(getApplicationContext());
    }
}
