package unifor.com.br.findclass.model;

import java.io.Serializable;

/**
 * Created by matheusaguiar on 24/03/17.
 */

public class Sala implements Serializable {

    private String nome;

    private int numero;

    private Boolean laboratorio;

    public Sala(String nome, int numero, Boolean laboratorio) {
        this.nome = nome;
        this.numero = numero;
        this.laboratorio = laboratorio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Boolean getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Boolean laboratorio) {
        this.laboratorio = laboratorio;
    }
}
