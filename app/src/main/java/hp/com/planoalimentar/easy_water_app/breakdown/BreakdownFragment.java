package hp.com.planoalimentar.easy_water_app.breakdown;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import hp.com.planoalimentar.easy_water_app.R;
import hp.com.planoalimentar.easy_water_app.api.statics.ApiRequest;
import hp.com.planoalimentar.easy_water_app.api.statics.CallBack;
import hp.com.planoalimentar.easy_water_app.api.statics.Constants;
import hp.com.planoalimentar.easy_water_app.breakdown.routes.BreakdownRoutes;
import hp.com.planoalimentar.easy_water_app.store.preferences.StorePreferences;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 02/10/2020.
 */
public class BreakdownFragment extends Fragment {

    private TextInputEditText txt_breakdown_cause;
    private TextInputEditText txt_breakdown_description;
    private TextInputEditText txt_breakdown_occur_number;
    private TextInputLayout label_breakdown_cause;
    private TextInputLayout label_breakdown_description;
    private TextInputLayout label_breakdown_occur_number;
    private ProgressDialog progressDialog;
    private DatePicker picker;
    private Button btn_send;
    private View view;
    private StorePreferences storePreferences;

    public BreakdownFragment () {
        // Required empty public constructor
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_breakdown, container, false);
        init();

        btn_send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                progressDialog.setMessage(getString(R.string.message_wait));
                progressDialog.setCancelable(false);
                progressDialog.show();
                if(verifyFields()){
                    try {
                        JSONObject parameters = new JSONObject();
                        parameters.put("reason", txt_breakdown_cause.getText().toString());
                        parameters.put("occurrences_number", txt_breakdown_occur_number.getText().toString());
                        parameters.put("client_id", storePreferences.getClientId());
                        parameters.put("last_occurrences_date",picker.getYear()+ "-"+(picker.getMonth() + 1)+"-"+picker.getDayOfMonth()+" 12:00:00");
                        parameters.put("breakdown_types_id",1);
                        ApiRequest.makePOSTRequest(getContext(), BreakdownRoutes.reportBreakdown(), parameters, new CallBack() {

                            @Override
                            public void responce (String responce) {
                                try {
                                    JSONObject response = new JSONObject(responce);
                                    if(response.getBoolean(Constants.SUCCESS)){
                                        txt_breakdown_cause.setText("");
                                        txt_breakdown_description.setText("");
                                        txt_breakdown_occur_number.setText("");
                                        Toast.makeText(getContext(), getString(R.string.operation_success), Toast.LENGTH_LONG).show();
                                    }else{
                                        Toast.makeText(getContext(), getString(R.string.generic_server_down), Toast.LENGTH_LONG).show();
                                    }
                                    progressDialog.dismiss();

                                }catch (JSONException exception){
                                    progressDialog.dismiss();
                                    exception.printStackTrace();
                                }
                            }
                        });
                    }catch (JSONException exception){
                        progressDialog.dismiss();
                        exception.printStackTrace();
                    }
                }

                progressDialog.dismiss();
            }
        });
        return view;
    }

    private void init(){
        txt_breakdown_cause = view.findViewById(R.id.txt_breakdown_cause);
        txt_breakdown_description = view.findViewById(R.id.txt_breakdown_description);
        txt_breakdown_occur_number = view.findViewById(R.id.txt_breakdown_occur_number);

        label_breakdown_cause = view.findViewById(R.id.breakdown_cause);
        label_breakdown_description = view.findViewById(R.id.breakdown_description);
        label_breakdown_occur_number = view.findViewById(R.id.breakdown_occur_number);

        btn_send = view.findViewById(R.id.btn_send);

        progressDialog = new ProgressDialog(getContext());

        picker= view.findViewById(R.id.breakdown_date);

        storePreferences = new StorePreferences(getContext());
    }

    private boolean verifyFields(){

        boolean isSomethingEmpty = true;

        if(txt_breakdown_cause.getText().toString().isEmpty()){
            label_breakdown_cause.setError(getString(R.string.required_field));
            isSomethingEmpty =false;
        }
        if(txt_breakdown_description.getText().toString().isEmpty()){
            label_breakdown_description.setError(getString(R.string.required_field));
            isSomethingEmpty =false;
        }
        if(txt_breakdown_occur_number.getText().toString().isEmpty()){
            label_breakdown_occur_number.setError(getString(R.string.required_field));
            isSomethingEmpty =false;
        }

        return isSomethingEmpty;
    }
}