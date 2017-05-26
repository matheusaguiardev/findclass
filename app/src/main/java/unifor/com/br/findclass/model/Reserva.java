package unifor.com.br.findclass.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

/**
 * Created by aguiar on 26/05/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reserva {

    @JsonProperty("matricula")
    private String matricula;

    @JsonProperty("data")
    private Date data;

    @JsonProperty("sala")
    private Integer sala;

    @JsonProperty("bloco")
    private String bloco;

    @JsonProperty("laboratorio")
    private Boolean laboratorio;

    public Reserva() {
    }

    public Reserva(String matricula, Date data, Integer sala, String bloco, Boolean laboratorio) {
        this.matricula = matricula;
        this.data = data;
        this.sala = sala;
        this.bloco = bloco;
        this.laboratorio = laboratorio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getSala() {
        return sala;
    }

    public void setSala(Integer sala) {
        this.sala = sala;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public Boolean getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Boolean laboratorio) {
        this.laboratorio = laboratorio;
    }
}
