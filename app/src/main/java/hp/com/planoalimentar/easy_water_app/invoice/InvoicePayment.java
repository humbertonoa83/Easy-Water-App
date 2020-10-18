package hp.com.planoalimentar.easy_water_app.invoice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import hp.com.planoalimentar.easy_water_app.R;

public class InvoicePayment extends Fragment {

    private FragmentTransaction fragmentTransaction;
    private Button button_voltar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_invoice_payment, container, false);

        button_voltar = view.findViewById(R.id.btn_invoice_back);
        button_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.framelayout, new InvoiceView());
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}