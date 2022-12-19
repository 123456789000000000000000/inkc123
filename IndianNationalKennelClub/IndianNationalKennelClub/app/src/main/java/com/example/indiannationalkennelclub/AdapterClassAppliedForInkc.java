package com.example.indiannationalkennelclub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.indiannationalkennelclub.Adapter.AdapterClassInkcRegisterDog;
import com.example.indiannationalkennelclub.ResponseModel.ResponseModelInkcRegisterDog;

import java.util.List;

public class AdapterClassAppliedForInkc extends RecyclerView.Adapter<AdapterClassAppliedForInkc.MyViewHolder>{

    private AdapterClassAppliedForInkc.RecycleViewClickListener listener;
    List<ResponseModelInkcRegisterDog> data;
    Context context;

    public AdapterClassAppliedForInkc(RecycleViewClickListener listener, List<ResponseModelInkcRegisterDog> data, Context context) {
        this.listener = listener;
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_inkc_register_dog,parent,false);
        return new MyViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.puppyname.setText(data.get(position).getPet_name());
        holder.ownpuppy.setText(data.get(position).getSub_category_name());
        holder.registrationnumber.setText(data.get(position).getPet_registration_number());
        if(data.get(position).getPet_image().equals(""))
        {
            Glide.with(context).load(R.drawable.user).into(holder.images);

        }else {
            Glide.with(context).load("https://test181120221003.inkc.in/" + data.get(position).getPet_image()).into(holder.images);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView puppyname,ownpuppy,registrationnumber;
        Button btn;
        ImageView images;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            puppyname = itemView.findViewById(R.id.puppyname);
            ownpuppy = itemView.findViewById(R.id.ownpuppy);
            registrationnumber = itemView.findViewById(R.id.registrationnumber);
            images = itemView.findViewById(R.id.images);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());

        }
    }

    public interface RecycleViewClickListener{
        void onClick(View v,int position);
    }
}
