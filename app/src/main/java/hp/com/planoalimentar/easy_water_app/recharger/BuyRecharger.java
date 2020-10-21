package hp.com.planoalimentar.easy_water_app.recharger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import hp.com.planoalimentar.easy_water_app.R;
import hp.com.planoalimentar.easy_water_app.api.statics.ApiRequest;
import hp.com.planoalimentar.easy_water_app.api.statics.CallBack;
import hp.com.planoalimentar.easy_water_app.api.statics.Constants;
import hp.com.planoalimentar.easy_water_app.client.ClientBean;
import hp.com.planoalimentar.easy_water_app.init.MainActivity;
import hp.com.planoalimentar.easy_water_app.recharger.model.RechargerBean;
import hp.com.planoalimentar.easy_water_app.recharger.statics.RechargerConstants;
import hp.com.planoalimentar.easy_water_app.recharger.statics.routes.RechargerRoutes;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 27/09/2020.
 */

public class BuyRecharger extends Fragment {

    private View view;
    private TextInputEditText txtRechargerValue;
    private TextInputLayout layoutRechargerValue;
    private RadioGroup radioPayment;
    private TextInputLayout layoutAccountNumber;
    private TextInputEditText txtAccountNumber;
    private Button btnBuyRecharger;
    private RadioButton rdbtnMpesa;
    private RechargerBean rechargerBean;
    private ProgressDialog progressDialog;

    public BuyRecharger () {
        // Required empty public constructor
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_buy_recharger, container, false);

        init();

        btnBuyRecharger.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                if(isvalidated()){
                    try {
                        JSONObject parameters = new JSONObject();
                        parameters.put("value", txtRechargerValue.getText().toString());
                        if(rdbtnMpesa.isSelected()){
                            parameters.put("payment_type", "M-Pesa");
                        }
                        else{
                            parameters.put("payment_type", "Cartão de Crédito");
                        }
                        parameters.put("via", 1);
                        parameters.put("counter_id", 2);

                        ApiRequest.makePOSTRequest(getContext(), RechargerRoutes.buyRecharger(), parameters, new CallBack() {

                            @Override
                            public void responce (String responce) {
                                parseInformation(responce);
                            }
                        });
                    }catch (JSONException exception){
                        exception.printStackTrace();
                    }
                }
            }
        });

        return view;
    }

    private void parseInformation (String responce) {
        try {
            progressDialog.setMessage(getString(R.string.message_wait));
            progressDialog.setCancelable(false);
            progressDialog.show();
            JSONObject jsonObject = new JSONObject(responce);
            if(jsonObject.getBoolean(Constants.SUCCESS)){
                Gson gson = new GsonBuilder().create();
                rechargerBean = gson.fromJson((new JSONObject(responce)).getJSONObject("rechargerObject").toString(), RechargerBean.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("recharger", rechargerBean);
                Intent intent = new Intent(getContext(), RechargeReceiptActivity.class);
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
                progressDialog.dismiss();
            }
            else{
                progressDialog.dismiss();
                Toast.makeText(getContext(), getString(R.string.generic_server_down), Toast.LENGTH_LONG).show();
            }
        }catch (JSONException exception){
            exception.printStackTrace();
            progressDialog.dismiss();
            Toast.makeText(getContext(), getString(R.string.generic_server_down), Toast.LENGTH_LONG).show();
        }
    }

    private void init () {
        txtRechargerValue = view.findViewById(R.id.txt_recharger_value);
        txtAccountNumber = view.findViewById(R.id.txt_account_number);
        layoutRechargerValue = view.findViewById(R.id.water_counter);
        layoutAccountNumber = view.findViewById(R.id.account_number);
        btnBuyRecharger = view.findViewById(R.id.btn_buy);
        rdbtnMpesa = view.findViewById(R.id.rdbtn_Mpesa);
        radioPayment = view.findViewById(R.id.group_payment);
        progressDialog= new ProgressDialog(getContext());
    }

    private boolean isvalidated(){
        boolean filledValues = true;

        if(txtRechargerValue.getText().toString().isEmpty()) {
            layoutRechargerValue.setError(getString(R.string.required_field));
            filledValues = false;
        }if(filledValues){
            if(Integer.parseInt(txtRechargerValue.getText().toString()) < RechargerConstants.MINIMUM_RECHARGER_VALUE){
                layoutRechargerValue.setError(getString(R.string.invalid_value));
                filledValues = false;
            }
        }
        if(radioPayment.getCheckedRadioButtonId() == -1){
            filledValues = false;
        }if(txtAccountNumber.getText().toString().isEmpty()){
            layoutAccountNumber.setError(getString(R.string.required_field));
            filledValues = false;
        }

        return filledValues;
    }

}
