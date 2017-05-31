package unifor.com.br.findclass.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import unifor.com.br.findclass.R;
import unifor.com.br.findclass.adapter.BuscaListViewAdapter;
import unifor.com.br.findclass.views.MainActivity;
import unifor.com.br.findclass.views.RegistroActivity;

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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(myActivity, RegistroActivity.class);
                intent.putExtra("sala", adapter.getSalaArrayList().get(position));

                startActivity(intent);
            }
        });

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
                String bloco = blocoEditText.getText().toString();
                String sala = salaEditText.getText().toString();
                if (bloco != null && !bloco.isEmpty() && !sala.isEmpty() && sala != null) {
                    Toast.makeText(myActivity, "Ação de buscar !", Toast.LENGTH_SHORT).show();
                } else if (bloco.isEmpty()) {
                    blocoEditText.setError("Campo vazio");
                } else if (sala.isEmpty()) {
                    salaEditText.setError("Campo vazio");
                } else {
                    Toast.makeText(myActivity, "Verifique os campos !", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}