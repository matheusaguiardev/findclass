package unifor.com.br.findclass.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import unifor.com.br.findclass.R;
import unifor.com.br.findclass.adapter.BuscaListViewAdapter;
import unifor.com.br.findclass.views.MainActivity;

public class BuscaFragment extends Fragment implements View.OnClickListener {

    BuscaListViewAdapter adapter;

    ListView listView;

    CheckBox salaLivreCheckBox;
    CheckBox laboratorioCheckBox;

    EditText blocoEditText;
    EditText salaEditText;

    Button buscar;

    MainActivity myActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_busca, container, false);

        myActivity = (MainActivity) getActivity();

        listView = (ListView) view.findViewById(R.id.salas_list_view);
        salaLivreCheckBox = (CheckBox) view.findViewById(R.id.sala_livre_radio_button);
        laboratorioCheckBox = (CheckBox) view.findViewById(R.id.laboratorios_radio_button);
        blocoEditText = (EditText) view.findViewById(R.id.bloco_edit_text);
        salaEditText = (EditText) view.findViewById(R.id.sala_edit_text);
        buscar = (Button) view.findViewById(R.id.buscar_button);

        adapter = new BuscaListViewAdapter();

        salaLivreCheckBox.setOnClickListener(this);
        laboratorioCheckBox.setOnClickListener(this);
        buscar.setOnClickListener(this);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        adapter.setSalaArrayList(myActivity.criarSala());
        adapter.setContext(myActivity);
        listView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sala_livre_radio_button:
                if (salaLivreCheckBox.isChecked()) {
                    Toast.makeText(myActivity, "Sala selecionada", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.laboratorios_radio_button:
                if (laboratorioCheckBox.isChecked()) {
                    Toast.makeText(myActivity, "Laboratorios selecionado", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buscar_button:
                Toast.makeText(myActivity, "Ação de buscar !", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
