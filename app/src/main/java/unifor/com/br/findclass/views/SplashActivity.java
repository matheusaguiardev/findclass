package unifor.com.br.findclass.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import unifor.com.br.findclass.R;

public class SplashActivity extends GenericActivity {

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.imageView = (ImageView) findViewById(R.id.splash_image_view);


        sleepSplash();
    }

    private void sleepSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                irPara();
            }
        }, 1500);

    }

    private void irPara() {
        if (usuarioLogado() != null) {
            irParaMainActivity(usuarioLogado()[0], usuarioLogado()[1]);
        } else {
            irParaLogin();
        }
    }

    private void irParaLogin() {
        Intent intent = new Intent(this, TelaLoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void irParaMainActivity(String usuario, String senha) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("user", usuario);
        intent.putExtra("password", senha);
        startActivity(intent);
        finish();
    }

}
