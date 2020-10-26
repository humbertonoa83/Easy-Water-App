package hp.com.planoalimentar.easy_water_app.client.datas.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import hp.com.planoalimentar.easy_water_app.R;
import hp.com.planoalimentar.easy_water_app.client.ClientBean;
import hp.com.planoalimentar.easy_water_app.client.adress.ClientAddress;
import hp.com.planoalimentar.easy_water_app.client.document.ClientDocumentBean;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 13/10/2020.
 */
public class ClientInformationFragment extends Fragment {

    private Button btnNext;
    private TextView txtClientName;
    private TextView txtClientSurname;
    private TextView txtGender;
    private TextView txt_client_nacionality;
    private ClientDocumentBean clientdocument;
    private View view;
    private Bundle bundle;
    private ClientBean clientBean;

    private FragmentTransaction fragmentTransaction;

    public ClientInformationFragment () {
        // Required empty public constructor
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_client_information, container, false);

        init();

        Class fragmentClass = ClientContactFragment.class;
        Fragment fragment = null;

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }

        fragment.setArguments(bundle);


        btnNext = view.findViewById(R.id.btn_next);
        final Fragment finalFragment = fragment;
        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                finalFragment.setArguments(bundle);
                fragmentTransaction.setCustomAnimations(R.anim.in_from_right, R.anim.out_to_left);
                fragmentTransaction.replace(R.id.frame_layout, finalFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    private void init () {

        bundle = this.getArguments();
        clientBean = (ClientBean) bundle.getSerializable("client");

        txtClientName = view.findViewById(R.id.txt_client_name);
        txtGender = view.findViewById(R.id.txt_client_gender);
        txt_client_nacionality = view.findViewById(R.id.txt_client_nacionality);

        txtGender.setText(clientBean.getGender());
        txtClientName.setText(clientBean.getName());
        txt_client_nacionality.setText(clientBean.getNationality());

        txtClientSurname = view.findViewById(R.id.txt_client_surname);
        txtClientSurname.setText(clientBean.getSurname());
    }
}