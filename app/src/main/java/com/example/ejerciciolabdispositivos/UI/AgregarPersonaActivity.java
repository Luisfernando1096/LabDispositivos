package com.example.ejerciciolabdispositivos.UI;

import static com.example.ejerciciolabdispositivos.UI.MainActivity.personaViewModel;
import static com.example.ejerciciolabdispositivos.UI.MostrarListaActivity.personaAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ejerciciolabdispositivos.Entidades.Personas;
import com.example.ejerciciolabdispositivos.R;
import com.example.ejerciciolabdispositivos.databinding.ActivityAgregarPersonaBinding;

import java.util.List;

public class AgregarPersonaActivity extends AppCompatActivity {
    private ActivityAgregarPersonaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);

        binding = ActivityAgregarPersonaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        if(getIntent().getExtras() != null){
            binding.edtId.setText(String.valueOf(getIntent().getIntExtra("id", 0)));
            binding.edtNombre.setText(getIntent().getStringExtra("nombre").toString());
            binding.edtApellido.setText(getIntent().getStringExtra("apellido").toString());
            binding.edtEdad.setText(String.valueOf(getIntent().getIntExtra("edad", 0)));
        }

        binding.btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Personas persona = new Personas();
                persona.nombrePersona = binding.edtNombre.getText().toString();
                persona.apellidoPersona = binding.edtApellido.getText().toString();
                persona.edadPersona = Integer.parseInt(binding.edtEdad.getText().toString());
                if(binding.edtId.getText().toString().equals("")){
                    personaViewModel.insertPersona(persona);
                }else{
                    persona.idPersona = Integer.parseInt(binding.edtId.getText().toString());
                    personaViewModel.updatePersona(persona);
                }
                finish();
            }
        });
    }
}