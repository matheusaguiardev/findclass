package unifor.com.br.findclass.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import unifor.com.br.findclass.R;

/**
 * Created by thiago on 28/03/17.
 */

public class InformacoesActivity extends GenericActivity implements View.OnClickListener {

    private TextView txtNomeSalaInf;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);

        txtNomeSalaInf = (TextView) findViewById(R.id.txt_nome_sala_inf);
        btnCancelar = (Button) findViewById(R.id.btn_desmarcar);

        btnCancelar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_cancelar:
                //Retirar a sala da lista de salas registradas (caso a sala nao tenha sido utilizada ainda) e voltar para tela anterior
                break;
            default:
        }


    }

}
