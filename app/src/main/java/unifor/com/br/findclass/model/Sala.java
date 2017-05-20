package unifor.com.br.findclass.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Created by matheusaguiar on 24/03/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sala implements Serializable {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("numero")
    private Integer numero;

    @JsonProperty("bloco")
    private String bloco;

    @JsonProperty("laboratorio")
    private Boolean laboratorio;

    @JsonProperty("oculpada")
    private Boolean oculpada;

    public Sala() {
    }

    public Sala(String nome, Integer numero, String bloco, Boolean laboratorio, Boolean oculpada) {
        this.nome = nome;
        this.numero = numero;
        this.bloco = bloco;
        this.laboratorio = laboratorio;
        this.oculpada = oculpada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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

    public Boolean getOculpada() {
        return oculpada;
    }

    public void setOculpada(Boolean oculpada) {
        this.oculpada = oculpada;
    }
}
