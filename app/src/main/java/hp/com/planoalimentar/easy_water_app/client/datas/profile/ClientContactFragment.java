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

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 13/10/2020.
 */
public class ClientContactFragment extends Fragment {

    private Button btnNext;
    private Button btnPrevious;
    private FragmentTransaction fragmentTransaction;
    private TextView txtEmail;
    private TextView txtContact;
    private View view;
    private Bundle bundle;
    private ClientBean clientBean;

    public ClientContactFragment () {
        // Required empty public constructor
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_client_contact, container, false);
        init();

        btnNext = view.findViewById(R.id.btn_next);
        btnPrevious = view.findViewById(R.id.btn_previous);



        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                final Class fragmentClass = ClientDocumentFragment.class;
                Fragment fragment = null;
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (java.lang.InstantiationException e) {
                    e.printStackTrace();
                }

                fragment.setArguments(bundle);

                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.in_from_right, R.anim.out_to_left);
                fragmentTransaction.replace(R.id.frame_layout, fragment);
                fragmentTransaction.commit();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                final Class fragmentClass = ClientInformationFragment.class;
                Fragment fragment = null;
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (java.lang.InstantiationException e) {
                    e.printStackTrace();
                }

                fragment.setArguments(bundle);

                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.in_from_left, R.anim.out_to_right);
                fragmentTransaction.replace(R.id.frame_layout, fragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    private void init(){

        bundle = this.getArguments();
        clientBean = (ClientBean) bundle.getSerializable("client");

        txtEmail = view.findViewById(R.id.txt_email);
        txtContact = view.findViewById(R.id.txt_tel);

        txtEmail.setText(clientBean.getEmail());
        txtContact.setText(clientBean.getTelefone());

        System.out.println("Olaaaaa   "+clientBean.toString());
    }
}