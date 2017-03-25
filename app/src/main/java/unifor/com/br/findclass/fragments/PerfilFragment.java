package unifor.com.br.findclass.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import unifor.com.br.findclass.R;
import unifor.com.br.findclass.views.MainActivity;

public class PerfilFragment extends Fragment {

    private TextView nomeUsuario;
    private TextView matriculaUsuario;

    MainActivity myActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        View visao = inflater.inflate(R.layout.fragment_perfil, container , false);
        myActivity = (MainActivity) getActivity();

        nomeUsuario = (TextView) visao.findViewById(R.id.textView_nome1);
        matriculaUsuario = (TextView) visao.findViewById(R.id.textView_matricula1);


        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }
}
