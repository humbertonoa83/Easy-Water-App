package hp.com.planoalimentar.easy_water_app.profile;

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
 * Created by humbertonoa83@gmail.com on 13/10/2020.
 */
public class ClientContactFragment extends Fragment {

    private Button btnNext;

    private Button btnPrevious;

    private FragmentTransaction fragmentTransaction;

    public ClientContactFragment () {
        // Required empty public constructor
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_client_contact, container, false);

        btnNext = view.findViewById(R.id.btn_next);
        btnPrevious = view.findViewById(R.id.btn_previous);

        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {

                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.in_from_left, R.anim.out_to_right);
                fragmentTransaction.replace(R.id.frame_layout, new ClientDocumentFragment());
                fragmentTransaction.commit();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.in_from_right, R.anim.out_to_left);
                fragmentTransaction.replace(R.id.frame_layout, new ClientInformationFragment());
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}