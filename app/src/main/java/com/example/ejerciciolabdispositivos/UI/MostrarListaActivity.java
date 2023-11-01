package com.example.ejerciciolabdispositivos.UI;


import static com.example.ejerciciolabdispositivos.UI.MainActivity.personaViewModel;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejerciciolabdispositivos.Adapter.PersonaAdapter;
import com.example.ejerciciolabdispositivos.Entidades.Personas;
import com.example.ejerciciolabdispositivos.databinding.ActivityMostrarListaBinding;

import java.util.List;

public class MostrarListaActivity extends AppCompatActivity implements  PersonaAdapter.OnItemClickListener, PersonaAdapter.OnItemLongClickListener{
    public static PersonaAdapter personaAdapter;
    private RecyclerView recyclerView;
    private ActivityMostrarListaBinding binding;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMostrarListaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Inicializa el adaptador con datos del ViewModel
        personaAdapter = new PersonaAdapter(MostrarListaActivity.this, MostrarListaActivity.this);
        layoutManager = new LinearLayoutManager(this);
        binding.rcvPersonas.setAdapter(personaAdapter);
        binding.rcvPersonas.setLayoutManager(layoutManager);
        binding.rcvPersonas.setHasFixedSize(true);

        LiveData<List<Personas>> liveDataPersonas = personaViewModel.getListaDePersonas();
        liveDataPersonas.observe(MostrarListaActivity.this, personas -> {
            List<Personas> lstPersonas = personas;
            personaAdapter.setDatos(lstPersonas);
        });
    }

    @Override
    public void onItemClick(Personas persona) {
        Intent intent = new Intent(MostrarListaActivity.this, AgregarPersonaActivity.class);
        intent.putExtra("id", persona.idPersona);
        intent.putExtra("nombre", persona.nombrePersona);
        intent.putExtra("apellido", persona.apellidoPersona);
        intent.putExtra("edad", persona.edadPersona);
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(Personas persona) {
        mostrarAlertDialog(persona);
    }

    private void mostrarAlertDialog(Personas persona) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Eliminacion");
        builder.setMessage("Esta seguro que desea eliminar?");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                personaViewModel.deletePersona(persona);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
