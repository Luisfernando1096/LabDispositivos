package com.example.ejerciciolabdispositivos.ViewModel;
import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ejerciciolabdispositivos.DAO.PersonaDAO;
import com.example.ejerciciolabdispositivos.Database.PersonasDatabase;
import com.example.ejerciciolabdispositivos.Entidades.Personas;

import java.util.List;
public class PersonaViewModel extends AndroidViewModel {
    private PersonaDAO personaDAO;
    private LiveData<List<Personas>> listaDePersonas;
    public PersonaViewModel(Application application) {
        super(application);
        PersonasDatabase database = PersonasDatabase.getInstance(application);
        personaDAO = database.personaDAO();
        listaDePersonas = personaDAO.obtenerTodasLasPersonas();
    }
    public LiveData<List<Personas>> getListaDePersonas() {
        return listaDePersonas;
    }
    public void insertPersona(Personas persona) {
        // Insertar la persona en un hilo en segundo plano
        new Thread(new Runnable() {
            @Override
            public void run() {
                personaDAO.Insert(persona);
            }
        }).start();
    }
    public void deletePersona(Personas persona) {
        // Insertar la persona en un hilo en segundo plano
        new Thread(new Runnable() {
            @Override
            public void run() {
                personaDAO.Delete(persona);
            }
        }).start();
    }

    public void updatePersona(Personas persona) {
        // Insertar la persona en un hilo en segundo plano
        new Thread(new Runnable() {
            @Override
            public void run() {
                personaDAO.Update(persona);
            }
        }).start();
    }
}
