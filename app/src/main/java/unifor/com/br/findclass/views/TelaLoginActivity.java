package unifor.com.br.findclass.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import unifor.com.br.findclass.R;

public class TelaLoginActivity extends GenericActivity implements View.OnClickListener {


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
        btnEntrar = (Button) findViewById(R.id.btn_entrar);

        txtRecuperarSenha.setOnClickListener(this);
        btnEntrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.txt_rec_senha:
                break;
            case R.id.btn_entrar:
                validateUser();
                break;
            default:
        }
    }

    private void validateUser() {
        String strMatricula = campoMatricula.getText().toString();
        String strSenha = campoSenha.getText().toString();

        if (!strMatricula.isEmpty() && !strSenha.isEmpty()) {
            loginSharedPreference(strMatricula, strSenha);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("user", strMatricula);
            intent.putExtra("password", strSenha);
            startActivity(intent);
            finish();
        } else if (strMatricula.isEmpty()) {
            campoMatricula.setError("Matricula obrigatória");
        } else {
            campoSenha.setError("Senha obrigatória");
        }
    }
}
