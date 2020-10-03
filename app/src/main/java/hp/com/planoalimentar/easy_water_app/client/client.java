package hp.com.planoalimentar.easy_water_app.client;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hp.com.planoalimentar.easy_water_app.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link client#newInstance} factory method to
 * create an instance of this fragment.
 */
public class client extends Fragment {

    public client() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cliente, container, false);

        return view;
    }


}