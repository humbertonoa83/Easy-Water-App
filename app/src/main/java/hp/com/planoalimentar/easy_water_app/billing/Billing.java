package hp.com.planoalimentar.easy_water_app.billing;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import hp.com.planoalimentar.easy_water_app.R;

public class Billing extends Fragment {
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;
    private EditText data_actual;
    private EditText data_multa;
    private EditText nome;
    private Button btn_leitura;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_billing, container, false);
        nome=view.findViewById(R.id.et_factura_nome);
        data_actual = view.findViewById(R.id.et_factura_data_actual);
        data_multa=view.findViewById(R.id.et_factura_data_multa);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = dateFormat.format(calendar.getTime());
        data_actual.setText(date);
        String actual= date.toString();

        try {
            calendar.setTime(dateFormat.parse(actual)); // parsed date and setting to calendar
            calendar.add(Calendar.DATE, 10);  // number of days to add
            String destDate = dateFormat.format(calendar.getTime());  // End date
            data_multa.setText(destDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }



        return view;

    }
}