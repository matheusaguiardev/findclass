package unifor.com.br.findclass.views;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import unifor.com.br.findclass.R;
import unifor.com.br.findclass.model.Sala;

public class MainActivity extends GenericActivity implements TabLayout.OnTabSelectedListener {

    TabLayout tabLayout;
    ViewPager viewPager;

    String usuarioLogin;
    String usuarioSenha;

    ArrayList<Sala> salas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();

        usuarioLogin = bundle.get("user").toString();
        usuarioSenha = bundle.get("password").toString();

        this.tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        this.viewPager = (ViewPager) findViewById(R.id.pager);

        tabLayout = configTablayout(this.tabLayout);
        viewPager = configViewPager(this.tabLayout, this.viewPager);

        tabLayout.addOnTabSelectedListener(this);


    }

    public ArrayList<Sala> criarSala() {
        ArrayList<Sala> salas = new ArrayList<>();

        salas.add(new Sala("Bloco A", 10, false));
        salas.add(new Sala("Bloco C", 5, false));
        salas.add(new Sala("Bloco F", 3, true));
        salas.add(new Sala("Bloco T", 1, false));
        salas.add(new Sala("Bloco J", 6, true));
        salas.add(new Sala("Bloco Q", 9, false));

        return salas;
    }

    public ArrayList<Sala> historicoSalas() {
        ArrayList<Sala> salas = new ArrayList<>();

        salas.add(new Sala("Bloco T", 5, true));
        salas.add(new Sala("Bloco D", 15, false));
        salas.add(new Sala("Bloco R", 17, true));

        return salas;
    }


    public void adicionarSala(String bloco, int num, boolean lab) {
        this.salas.add(new Sala("Bloco " + bloco, num, lab));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }

    public String getUsuarioLogin () { return usuarioLogin;}

}