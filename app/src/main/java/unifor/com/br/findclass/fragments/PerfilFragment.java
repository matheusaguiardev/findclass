package unifor.com.br.findclass.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import unifor.com.br.findclass.R;
import unifor.com.br.findclass.adapter.BuscaListViewAdapter;
import unifor.com.br.findclass.views.MainActivity;
import unifor.com.br.findclass.views.RegistroActivity;

public class PerfilFragment extends Fragment {

    private String provisorio = "Thiago Alonso";   // String usada como entrada do TextView da tela Perfil, enquanto não implementamos
                                                   // a logica de busca dos dados da aplicação
    private TextView nomeUsuario;
    private TextView matriculaUsuario;
    private BuscaListViewAdapter adapter;
    private ListView listaHistorico;

    MainActivity myActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        View visao = inflater.inflate(R.layout.fragment_perfil, container , false);
        myActivity = (MainActivity) getActivity();

        listaHistorico = (ListView) visao.findViewById(R.id.salas_his_list);
        nomeUsuario = (TextView) visao.findViewById(R.id.textView_nome1);
        matriculaUsuario = (TextView) visao.findViewById(R.id.textView_matricula1);

        matriculaUsuario.setText(myActivity.getUsuarioLogin());
        nomeUsuario.setText(provisorio);
        adapter = new BuscaListViewAdapter();


        listaHistorico.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(myActivity, RegistroActivity.class);
                startActivity(intent);
            }
        });

        return visao;
    }

    @Override
    public void onStart() {
        super.onStart();

        adapter.setSalaArrayList(myActivity.historicoSalas());
        adapter.setContext(myActivity);
        listaHistorico.setAdapter(adapter);

    }



}
