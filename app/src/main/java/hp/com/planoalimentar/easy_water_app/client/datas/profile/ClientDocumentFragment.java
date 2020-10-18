package hp.com.planoalimentar.easy_water_app.client.datas.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import hp.com.planoalimentar.easy_water_app.R;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 15/10/2020.
 */
public class ClientDocumentFragment extends Fragment {

    private Button btnPrevious;

    private FragmentTransaction fragmentTransaction;

    public ClientDocumentFragment () {
        // Required empty public constructor
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_client_document, container, false);

        btnPrevious = view.findViewById(R.id.btn_previous);
        btnPrevious.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.in_from_right, R.anim.out_to_left);
                fragmentTransaction.replace(R.id.frame_layout, new ClientContactFragment());
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}