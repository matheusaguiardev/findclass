
package unifor.com.br.findclass.views;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import unifor.com.br.findclass.R;
import unifor.com.br.findclass.cloud.helper.ServiceHelper;
import unifor.com.br.findclass.controller.CloudController;
import unifor.com.br.findclass.model.Sala;

public class MainActivity extends GenericActivity implements TabLayout.OnTabSelectedListener {

    TabLayout tabLayout;
    ViewPager viewPager;

    String usuarioLogin;
    String usuarioSenha;

    ServiceHelper serviceHelper;

    ArrayList<Sala> salas = new ArrayList<>();
    ArrayList<Sala> salas_historico = new ArrayList<>();

    CloudController controller;


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

        serviceHelper = new ServiceHelper();

        controller = new CloudController(); // Objeto que vai ajudar fazer requisição no servidor.
    }


    @Override
    protected void onStart() {

         controller.getAllReservas(); // pega todas as RESERVAS que estão no json

        do {
            salas = new ArrayList<>(controller.getAllRooms()); // pega todas as SALAS que estão no json
        }while(salas.size() == 0);

        controller.getAllStudents(); // pega todas os ESTUDANTES que estão no json

        super.onStart();
    }


    public ArrayList<Sala> criarSala() {

        return salas;
    }

    public ArrayList<Sala> historicoSalas() {

        for(int i = 0; i<salas.size() ; i++){
            if (salas.get(i).getOculpada()){
                salas_historico.add(salas.get(i));
            }
        }

        return salas_historico;
    }

    //String nome, int numeroSala, String bloco, Boolean laboratorio, Boolean oculpada
    public void adicionarSala(String nomePredio, int num, String bloco, boolean lab, boolean ocupada) {
        this.salas.add(new Sala(nomePredio, num, bloco, lab, ocupada));
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

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

}