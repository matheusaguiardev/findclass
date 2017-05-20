package unifor.com.br.findclass.model;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Created by aguiar on 12/05/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Aluno implements Serializable {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("matricula")
    private String matricula;

    @JsonProperty("senha")
    private String senha;

    public Aluno(Integer id, String nome, String matricula, String senha) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
    }

    public Aluno() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
