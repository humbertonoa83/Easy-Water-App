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
 * Created by humbertonoa83@gmail.com on 15/10/2020.
 */
public class ClientDocumentFragment extends Fragment {

    private Button btnPrevious;
    private TextView txt_document;
    private TextView txt_issue_date;
    private TextView txt_valid_date;
    private TextView txt_issue_place;
    private TextView txt_address;
    private FragmentTransaction fragmentTransaction;
    private Bundle bundle;
    private ClientBean clientBean;
    private View view;

    public ClientDocumentFragment () {
        // Required empty public constructor
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_client_document, container, false);
        init();

        btnPrevious = view.findViewById(R.id.btn_previous);
        btnPrevious.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {

                final Class fragmentClass = ClientContactFragment.class;
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

        txt_document = view.findViewById(R.id.txt_document);
        txt_issue_date = view.findViewById(R.id.txt_issue_date);
        txt_valid_date = view.findViewById(R.id.txt_valid_date);
        txt_issue_place = view.findViewById(R.id.txt_issue_place);
        txt_address = view.findViewById(R.id.txt_address);

        txt_document.setText(clientBean.getDocument_type());
        txt_address.setText(clientBean.getAdress());
        //txt_issue_date.setText(clientBean.get); Não implementado
    }
}