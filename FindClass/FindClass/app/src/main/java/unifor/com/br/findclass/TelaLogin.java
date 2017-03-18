package unifor.com.br.findclass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class TelaLogin extends AppCompatActivity implements View.OnClickListener {

    private EditText campoSenha;
    private EditText campoMatricula;
    private TextView txtRecuperarSenha;
    private Button btnEntrar;
    private ImageView imgUniforLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        imgUniforLogin = (ImageView) findViewById(R.id.imgTelaLogin);

        campoMatricula = (EditText) findViewById(R.id.cmp_matricula);
        campoSenha = (EditText) findViewById(R.id.cmp_senha);

        txtRecuperarSenha = (TextView) findViewById(R.id.txt_rec_senha);
        txtRecuperarSenha.setOnClickListener(this);

        btnEntrar = (Button) findViewById(R.id.btn_entrar);
        btnEntrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.txt_rec_senha: // ID do recuperar senha

                //        Envia para tela de recuperar senha
                //               Intent it1 = new Intent(this,RecuperarSenhaActivity.class);
                //               startActivity(it1);
                //               break;
            case R.id.btn_entrar:

                String strMatricula = campoMatricula.getText().toString();
                String strSenha = campoSenha.getText().toString();

                Boolean valido = true;

//                // Verifica Matricula
                if (strMatricula.isEmpty()) {
                    campoMatricula.setError("Matricula obrigatória");
                    valido = false;
                }
//                // Verifica Senha
                if (strSenha.isEmpty()) {
                    campoSenha.setError("Senha obrigatória");
                    valido = false;
                }

                // Implementar Verificação com o banco

                if (valido) {
//               TELA PRINCIPAL
                    Intent it = new Intent(this, MainActivity.class);
                    startActivity(it);
                }

                break;
        }
    }
}
