package com.my.first.vistaapp20.adapters;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.my.first.vistaapp20.R;
import com.my.first.vistaapp20.models.AsesorModel;

import java.util.ArrayList;

public class asesoresAdapter extends RecyclerView.Adapter<asesoresAdapter.asesorviewholder> {
ArrayList<AsesorModel>_asesores;
private onAsesoresListener _asesoresListener;

    public asesoresAdapter(ArrayList<AsesorModel>asesores,onAsesoresListener asesoresListener) {
        this._asesores=asesores;
        this._asesoresListener=asesoresListener;

    }

    @NonNull
    @Override
    public asesoresAdapter.asesorviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.asesor_item,null,false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.WRAP_CONTENT));
        return new asesorviewholder(view, _asesoresListener);
    }

    @Override
    public void onBindViewHolder(@NonNull asesoresAdapter.asesorviewholder holder, int position) {
        holder.nombre.setText(_asesores.get(position).getNombre());
        holder.descripcion.setText(_asesores.get(position).getTelefono());
        holder.imageView.setImageResource(_asesores.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return _asesores.size();
    }

    public class asesorviewholder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener,View.OnClickListener {
        ImageView imageView;
        TextView nombre, descripcion;
        LinearLayout linearLayout;
        onAsesoresListener onAsesoresListener;

        public asesorviewholder(@NonNull View itemView,onAsesoresListener onAsesoresListener) {
            super(itemView);
            this.onAsesoresListener=onAsesoresListener;
            imageView=itemView.findViewById(R.id.imaicon);
            nombre=itemView.findViewById(R.id.txnombreopt);
            descripcion=itemView.findViewById(R.id.txjvpm);
            linearLayout=itemView.findViewById(R.id.lytasesor);
            linearLayout.setOnCreateContextMenuListener(this);
            linearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onAsesoresListener.onaseroresclick(getAdapterPosition());
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {

        }
    }
    public interface onAsesoresListener{
    void onaseroresclick(int posision);
    }
}
