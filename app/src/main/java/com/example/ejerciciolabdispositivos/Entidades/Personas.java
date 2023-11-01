package com.example.ejerciciolabdispositivos.Entidades;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Personas {
    @PrimaryKey(autoGenerate = true)
    public int idPersona;
    public String nombrePersona;
    public String apellidoPersona;
    public int edadPersona;
    @NonNull
    @Override
    public String toString() {
        return nombrePersona + " " + apellidoPersona + " " + edadPersona;
    }
}