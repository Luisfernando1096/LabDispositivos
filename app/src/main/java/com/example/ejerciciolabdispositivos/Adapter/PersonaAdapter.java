package com.example.ejerciciolabdispositivos.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejerciciolabdispositivos.Entidades.Personas;
import com.example.ejerciciolabdispositivos.R;
import com.example.ejerciciolabdispositivos.ViewHolder.ViewHolderPersona;
import com.example.ejerciciolabdispositivos.ViewModel.PersonaViewModel;

import java.util.ArrayList;
import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<ViewHolderPersona> {
    private List<Personas> datos = new ArrayList<>(); // Inicializar la lista vacía

    private OnItemClickListener onItemClickListener;

    private OnItemLongClickListener onItemLongClickListener;
    public PersonaAdapter(OnItemClickListener itemClickListener, OnItemLongClickListener itemLongClickListener) {
        this.onItemClickListener = itemClickListener;
        this.onItemLongClickListener = itemLongClickListener;
        // No necesitas el ViewModel aquí
    }

    public void setDatos(List<Personas> nuevasPersonas) {
        datos = nuevasPersonas;
        notifyDataSetChanged(); // Notificar al adaptador que los datos han cambiado
    }

    @NonNull
    @Override
    public ViewHolderPersona onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_persona, parent, false);
        return new ViewHolderPersona(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPersona holder, int position) {
        final Personas persona = datos.get(position);
        holder.getIdPersona().setText(String.valueOf(datos.get(position).idPersona));
        holder.getNombrePersona().setText(datos.get(position).nombrePersona);
        holder.getApellidoPersona().setText(datos.get(position).apellidoPersona);
        holder.getEdadPersona().setText(String.valueOf(datos.get(position).edadPersona));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClick(persona);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(onItemLongClickListener != null){
                    onItemLongClickListener.onItemLongClick(persona);
                }
                return true;
            }
        });
    }

    public interface OnItemClickListener {
        void onItemClick(Personas persona);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(Personas persona);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}
