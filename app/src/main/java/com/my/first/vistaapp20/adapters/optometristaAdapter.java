package com.my.first.vistaapp20.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.my.first.vistaapp20.R;
import com.my.first.vistaapp20.models.OptometristaModel;

import java.util.ArrayList;

public class optometristaAdapter extends RecyclerView.Adapter<optometristaAdapter.OptometristasViewHolder> {

    private ArrayList<OptometristaModel> optometristas;
    private OnOptometristasListener onOptometristasListener;

    public optometristaAdapter(OnOptometristasListener onOptometristasListener) {
        this.onOptometristasListener = onOptometristasListener;
        this.optometristas = new ArrayList<>();
    }

    public ArrayList<OptometristaModel> obtenerListado() {
        return this.optometristas;
    }

    public void cargarListado(ArrayList<OptometristaModel> optometristas) {
        this.optometristas = optometristas;
    }

    @NonNull
    @Override
    public optometristaAdapter.OptometristasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.optometrista_item, null, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        return new OptometristasViewHolder(view, onOptometristasListener);
    }

    @Override
    public void onBindViewHolder(@NonNull optometristaAdapter.OptometristasViewHolder holder, int position) {
        holder.jvpm.setText(optometristas.get(position).getJvpm());
        holder.nombre.setText(optometristas.get(position).getNombre());
        holder.imageView.setImageResource(optometristas.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return optometristas.size();
    }

    public class OptometristasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        OnOptometristasListener onOptometristasListener;
        LinearLayout linearLayout;
        ImageView imageView;
        TextView nombre, jvpm;

        public OptometristasViewHolder(@NonNull View itemView, OnOptometristasListener onOptometristasListener) {
            super(itemView);

            this.onOptometristasListener = onOptometristasListener;
            this.linearLayout = itemView.findViewById(R.id.lytopt);
            this.imageView = itemView.findViewById(R.id.imaiconopt);
            this.nombre = itemView.findViewById(R.id.txnombreopt);
            this.jvpm = itemView.findViewById(R.id.txjvpm);
            this.linearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onOptometristasListener.onClickListener(getAdapterPosition());
        }
    }

    public interface OnOptometristasListener {
        void onClickListener(int posicion);
    }
}
