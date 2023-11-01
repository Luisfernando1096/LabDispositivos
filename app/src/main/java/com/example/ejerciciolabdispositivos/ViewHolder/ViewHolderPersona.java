package com.example.ejerciciolabdispositivos.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ejerciciolabdispositivos.R;

public class ViewHolderPersona extends RecyclerView.ViewHolder {
    private TextView idPersona;
    private TextView nombrePersona;
    private TextView apellidoPersona;
    private TextView edadPersona;
    public ViewHolderPersona(@NonNull View itemView) {
        super(itemView);
        this.idPersona = itemView.findViewById(R.id.tvId);
        this.nombrePersona = itemView.findViewById(R.id.tvNombre);
        this.apellidoPersona = itemView.findViewById(R.id.tvApellido);
        this.edadPersona = itemView.findViewById(R.id.tvEdad);
    }

    public TextView getIdPersona() {
        return idPersona;
    }

    public TextView getNombrePersona() {
        return nombrePersona;
    }

    public TextView getApellidoPersona() {
        return apellidoPersona;
    }

    public TextView getEdadPersona() {
        return edadPersona;
    }
}
