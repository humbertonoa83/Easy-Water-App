package hp.com.planoalimentar.easy_water_app.invoice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import hp.com.planoalimentar.easy_water_app.R;
public class InvoiceView extends Fragment {

    private FragmentTransaction fragmentTransaction;
    private Button button_submit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_invoice_view, container, false);

        button_submit = view.findViewById(R.id.btn_billing_submit);
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.framelayout, new InvoicePayment());
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}