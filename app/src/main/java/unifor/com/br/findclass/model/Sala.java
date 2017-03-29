package unifor.com.br.findclass.model;

import java.io.Serializable;

/**
 * Created by matheusaguiar on 24/03/17.
 */

public class Sala implements Serializable {

    private String nome;

    private int numero;

    private Boolean laboratorio;

    private boolean oculpada;

    public Sala(String nome, int numero, Boolean laboratorio, boolean oculpada) {
        this.nome = nome;
        this.numero = numero;
        this.laboratorio = laboratorio;
        this.oculpada = oculpada;
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

    public boolean isOculpada() {
        return oculpada;
    }

    public void setOculpada(boolean oculpada) {
        this.oculpada = oculpada;
    }
}
