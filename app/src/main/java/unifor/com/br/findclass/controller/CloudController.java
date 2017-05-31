package unifor.com.br.findclass.controller;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import unifor.com.br.findclass.cloud.helper.ServiceHelper;
import unifor.com.br.findclass.model.Aluno;
import unifor.com.br.findclass.model.Reserva;
import unifor.com.br.findclass.model.Sala;

/**
 * Created by aguiar on 26/05/17.
 */

public class CloudController {

    private ServiceHelper serviceHelper;

    private List<Aluno> alunos = new ArrayList<>();
    private List<Sala> salas = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public CloudController() {
        this.serviceHelper = new ServiceHelper();
    }

    public List<Aluno> getAllStudents() {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                setAlunos(serviceHelper.getAlunos());
            }
        });
        return getAlunos();
    }

    public List<Sala> getAllRooms() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                setSalas(serviceHelper.getSalas());
            }
        });
        return getSalas();
    }

    public List<Reserva> getAllReservas() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                setReservas(serviceHelper.getReservas());
            }
        });
        return getReservas();

    }


    private List<Aluno> getAlunos() {
        return alunos;
    }

    private void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    private List<Sala> getSalas() {
        return salas;
    }

    private void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    private List<Reserva> getReservas() {
        return reservas;
    }

    private void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
