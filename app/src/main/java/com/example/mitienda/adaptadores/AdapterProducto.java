package com.example.mitienda.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mitienda.Entidades.Producto;
import com.example.mitienda.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.viewHolder> implements View.OnClickListener {
    LayoutInflater inflater;
    ArrayList<Producto> model;

    private View.OnClickListener listener;

    public AdapterProducto(Context context, ArrayList<Producto> model){
        this.inflater = LayoutInflater.from(context);
        this.model = model;

    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_productos, parent, false);
        view.setOnClickListener(this);

        return new viewHolder(view);
    }

    public  void setOnClickLister(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        String nombre = model.get(position).getNombre();
        String description = model.get(position).getDescripcion();
        int imagen = model.get(position).getImagenId();
        holder.nombre.setText(nombre);
        holder.descriptcion.setText(description);
        holder.imagen.setImageResource(imagen);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }

    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView nombre, descriptcion;
        ImageView imagen;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre_producto);
            descriptcion = itemView.findViewById(R.id.producto_descripcion);
            imagen = itemView.findViewById(R.id.imagenProducto);
        }
    }
}

