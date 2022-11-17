package com.example.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.ViewHolder>{


    ArrayList<modelClass> dataHolder;

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image,image2;
        TextView  header,desc;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            image = itemView.findViewById(R.id.imagesample);
            header = itemView.findViewById(R.id.header);
            desc = itemView.findViewById(R.id.desc);
            image2= itemView.findViewById(R.id.delete);
            image2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    dataHolder.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                }
            });
        }
    }

    public myadapter(FragmentActivity activity, ArrayList<modelClass> dataholder) {
        this.dataHolder = dataholder;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.image.setImageResource(dataHolder.get(position).getImage());
    holder.header.setText(dataHolder.get(position).getHeader());
    holder.desc.setText(dataHolder.get(position).getDesc());
    }
    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

}
