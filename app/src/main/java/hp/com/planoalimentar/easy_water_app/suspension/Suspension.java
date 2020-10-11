package hp.com.planoalimentar.easy_water_app.suspension;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import static hp.com.planoalimentar.easy_water_app.R.layout.activity_option;
import hp.com.planoalimentar.easy_water_app.R;


public class Suspension extends Fragment {

    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;
    private EditText data_actual;
    private Spinner opt_situacao;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this
        View view = inflater.inflate(R.layout.fragment_corte, container, false);

        data_actual = view.findViewById(R.id.et_corte_data);
        opt_situacao = view.findViewById(R.id.opt_corte_situacao);

        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = dateFormat.format(calendar.getTime());
        data_actual.setText(date);

        String[]situacao = new String[]{"Corte fornecimento","Suspensao fornecimento"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), activity_option,situacao);
        adapter.setDropDownViewResource(activity_option);
        opt_situacao.setAdapter(adapter);

        return view;
    }
}