package hp.com.planoalimentar.easy_water_app.payments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hp.com.planoalimentar.easy_water_app.R;

public class Payments extends Fragment {
private RecyclerView.Adapter dados;


    public Payments(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payments, container, false);

        return view;
    }
}