package unifor.com.br.findclass.views;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import unifor.com.br.findclass.adapter.PagerAdapter;

/**
 * Created by matheusaguiar on 22/03/17.
 */

public class GenericActivity extends AppCompatActivity {

    final String SHARED_KEY = "br.com.unifor.findclass";
    final String USER = "Usuario";
    final String PASSWORD = "Senha";


    private PagerAdapter pagerAdapter;

    protected TabLayout configTablayout(TabLayout tabLayout) {
        tabLayout.addTab(tabLayout.newTab().setText("Perfil"));
        tabLayout.addTab(tabLayout.newTab().setText("Buscar"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        return tabLayout;
    }

    protected ViewPager configViewPager(TabLayout tabLayout, ViewPager viewPager) {
        this.pagerAdapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(this.pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        return viewPager;
    }

    public void loginSharedPreference(String login, String password) {
        SharedPreferences preferences = getShareObject();
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(USER, login);
        editor.putString(PASSWORD, password);
        editor.apply();

    }

    public String[] usuarioLogado() {
        String[] usuario = new String[2];
        SharedPreferences preferences = getShareObject();

        String login = preferences.getString(USER, ""); // retorna "" se o valor ñ for encontrado.
        String senha = preferences.getString(PASSWORD, "");

        if (!login.isEmpty() && !senha.isEmpty()) {
            usuario[0] = login;
            usuario[1] = senha;
            return usuario;
        } else {
            return null;

        }
    }

    private SharedPreferences getShareObject() {
        return PreferenceManager.getDefaultSharedPreferences(this);
    }

}
