package hp.com.planoalimentar.easy_water_app.client.datas.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hp.com.planoalimentar.easy_water_app.R;

/**
 * This is a product created by AEISUTC Team on
 * Matyanga Project concurs
 * Created by humbertonoa83@gmail.com on 27/09/2020.
 */
public class ProfileFragment extends Fragment {

    private FragmentTransaction fragmentTransaction;

    private Bundle bundle;

    public ProfileFragment () {
        // Required empty public constructor
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        bundle = this.getArguments();

        Class fragmentClass =ClientInformationFragment.class;
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

        fragmentTransaction.add(R.id.frame_layout, fragment);
        fragmentTransaction.commit();

        return view;
    }
}
