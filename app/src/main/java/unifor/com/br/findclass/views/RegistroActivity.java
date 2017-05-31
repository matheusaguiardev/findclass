package unifor.com.br.findclass.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import unifor.com.br.findclass.R;
import unifor.com.br.findclass.model.Sala;

/**
 * Created by thiago on 26/03/17.
 */

public class RegistroActivity extends  GenericActivity implements  View.OnClickListener{

    private TextView txtNomeSala;
    private EditText edtData;
    private EditText edtHora;
    private Button btnRegistrar;
    private Button btnCancelar;
    private Sala sala;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();

            this.sala = (Sala) bundle.get("sala");

        }


        txtNomeSala = (TextView) findViewById(R.id.txt_nome_sala);
        edtData = (EditText) findViewById(R.id.edt_data);
        edtHora = (EditText) findViewById(R.id.adt_hora);
        btnRegistrar = (Button) findViewById(R.id.btn_registrar);
        btnCancelar = (Button) findViewById(R.id.btn_cancelar);


        if (!sala.getLaboratorio()) {
            txtNomeSala.setText(sala.getNome() + " - Sala " + sala.getNumero());
        } else {
            txtNomeSala.setText(sala.getNome() + " - Sala " + sala.getNumero() + " Lab");
        }

        edtData.setOnClickListener(this);
        edtHora.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.edt_data:
                //Escolher data
                break;
            case R.id.adt_hora:
                //Escolher hora
                break;
            case R.id.btn_registrar:
                //Registrar Sala
                Toast.makeText(this, "Registra Data e Hora", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_cancelar:
                //Retornar para Tela anterior
                break;
            default:
        }


    }
}
