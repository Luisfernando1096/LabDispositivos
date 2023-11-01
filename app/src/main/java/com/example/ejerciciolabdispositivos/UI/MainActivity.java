package com.example.ejerciciolabdispositivos.UI;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.ejerciciolabdispositivos.Entidades.Personas;
import com.example.ejerciciolabdispositivos.R;
import com.example.ejerciciolabdispositivos.ViewModel.PersonaViewModel;
import com.example.ejerciciolabdispositivos.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    public static PersonaViewModel personaViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa el PersonaViewModel aquí
        personaViewModel = new ViewModelProvider(this).get(PersonaViewModel.class);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AgregarPersonaActivity.class);
                startActivity(intent);
            }
        });

        binding.btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MostrarListaActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
