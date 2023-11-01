package com.example.ejerciciolabdispositivos.DAO;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ejerciciolabdispositivos.Entidades.Personas;
import java.util.List;
@Dao
public interface PersonaDAO {
    @Insert
    void Insert(Personas personaEntity);
    @Delete
    void Delete(Personas personaEntity);
    @Update
    void Update(Personas personaEntity);
    @Query("SELECT * FROM PERSONAS")
    LiveData<List<Personas>> obtenerTodasLasPersonas();
}