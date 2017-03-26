package unifor.com.br.findclass.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import unifor.com.br.findclass.R;

public class CadastroFragment extends Fragment {


    private TextView txtNomeSala;

    private EditText edtData;
    private EditText edtHora;

    private Button btnRegistrar;
    private Button btnCancelar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View visao = inflater.inflate(R.layout.fragment_cadastro, container , false);






        return visao;
    }

}
