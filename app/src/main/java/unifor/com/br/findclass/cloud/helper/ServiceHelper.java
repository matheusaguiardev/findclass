package unifor.com.br.findclass.cloud.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import unifor.com.br.findclass.cloud.interfaces.FindClassService;
import unifor.com.br.findclass.model.Aluno;
import unifor.com.br.findclass.model.Sala;
import unifor.com.br.findclass.util.Utils;

/**
 * Created by aguiar on 12/05/17.
 */

public class ServiceHelper {

    public List<Aluno> getAlunos() {
        OkHttpClient okHttpClient = getHttpClient();
        Retrofit retrofit = getRetrofitObject(Utils.baseURL, okHttpClient);
        FindClassService service = retrofit.create(FindClassService.class);
        Call<List<Aluno>> alunosService = service.listAlunos();

        try {
            // Vai retornar a lista de alunos que esta no Servidor (mockable.io).
            List<Aluno> alunos = new ArrayList<>();
            if (!alunosService.isExecuted()) {
                alunos = alunosService.execute().body();
            }
            return alunos;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Sala> getSalas() {
        OkHttpClient okHttpClient = getHttpClient();

        Retrofit retrofit = getRetrofitObject(Utils.baseURL, okHttpClient);

        FindClassService service = retrofit.create(FindClassService.class);

        Call<List<Sala>> salasService = service.listSalas();
        try {
            // Vai retornar a lista de salas que esta no servidor (mockable.io).
            List<Sala> salas = new ArrayList<>();
            if (!salasService.isExecuted()) {
                salas = salasService.execute().body();
            }
            return salas;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private Retrofit getRetrofitObject(String url, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    private OkHttpClient getHttpClient() {
        return new OkHttpClient().newBuilder()
                .build();
    }

}
