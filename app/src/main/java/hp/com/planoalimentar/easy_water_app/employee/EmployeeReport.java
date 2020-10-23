package hp.com.planoalimentar.easy_water_app.employee;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import hp.com.planoalimentar.easy_water_app.R;


public class EmployeeReport extends Fragment {
    private Spinner spinner_status;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_employee_report, container, false);
        spinner_status = view.findViewById(R.id.spinner_report_status);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.status, android.R.layout.simple_spinner_dropdown_item);
        spinner_status.setAdapter(adapter);

        return view;
    }
}