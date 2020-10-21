package hp.com.planoalimentar.easy_water_app.recharger;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import hp.com.planoalimentar.easy_water_app.R;
import hp.com.planoalimentar.easy_water_app.recharger.model.RechargerBean;

public class RechargeReceiptActivity extends AppCompatActivity {

    private ImageView goback;
    private TextView txtReference;
    private TextView txtRechargerValue;
    private TextView txtPaymentMethod;
    private TextView txtRechargerCode;
    private TextView txtHour;
    private RechargerBean rechargerBean;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge_receipt);
        init();

        goback.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                finish();
            }
        });

    }

    private void init () {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int largura = displayMetrics.widthPixels;
        int altura = displayMetrics.heightPixels;
        getWindow().setLayout( (int) (largura *.8), (int) (altura *.8));

        getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));

        rechargerBean = (RechargerBean) getIntent().getSerializableExtra("recharger");

        goback= findViewById(R.id.Goback);
        txtReference = findViewById(R.id.txt_reference);
        txtRechargerValue= findViewById(R.id.txt_recharger_value);
        txtPaymentMethod = findViewById(R.id.txt_payment_method);
        txtRechargerCode = findViewById(R.id.txt_recharger_code);
        txtHour = findViewById(R.id.txt_hour);

        txtReference.setText(rechargerBean.getReference());
        txtRechargerValue.setText(rechargerBean.getValue());
        txtPaymentMethod.setText(rechargerBean.getPaymentMethod());
        txtRechargerCode.setText(rechargerBean.getRecharger());
        txtHour.setText(rechargerBean.getBothAt());
    }
}