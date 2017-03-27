package unifor.com.br.findclass.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import unifor.com.br.findclass.R;

/**
 * Created by thiago on 26/03/17.
 */

public class RegistroActivity extends  GenericActivity implements  View.OnClickListener{

    private TextView txtNomeSala;
    private EditText edtData;
    private EditText edtHora;
    private Button btnRegistrar;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtNomeSala = (TextView) findViewById(R.id.txt_nome_sala);
        edtData = (EditText) findViewById(R.id.edt_data);
        edtHora = (EditText) findViewById(R.id.adt_hora);
        btnRegistrar = (Button) findViewById(R.id.btn_registrar);
        btnCancelar = (Button) findViewById(R.id.btn_cancelar);

        btnRegistrar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_cancelar:
                //Retornar para Tela anterior
                break;
            case R.id.btn_registrar:
                //Registrar Sala
                break;
            default:
        }


    }
}
