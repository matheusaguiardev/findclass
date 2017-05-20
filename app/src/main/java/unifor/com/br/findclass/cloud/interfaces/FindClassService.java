package unifor.com.br.findclass.cloud.interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import unifor.com.br.findclass.model.Aluno;
import unifor.com.br.findclass.model.Sala;

/**
 * Created by aguiar on 12/05/17.
 */

public interface FindClassService {

    @GET("alunos")
    Call<List<Aluno>> listAlunos();

    @GET("salas")
    Call<List<Sala>> listSalas();

}
