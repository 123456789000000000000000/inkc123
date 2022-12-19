package com.example.indiannationalkennelclub.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.indiannationalkennelclub.Profile0FragmentActivity;
import com.example.indiannationalkennelclub.R;
import com.example.indiannationalkennelclub.ResponseModel.ResponseModelNonInkcRegistreDog;
import com.squareup.picasso.Picasso;

import java.util.Base64;
import java.util.List;

public class AdapterClassNonInkcRegisterDog extends RecyclerView.Adapter<AdapterClassNonInkcRegisterDog.MyViewHolder> {

    private AdapterClassNonInkcRegisterDog.RecycleViewClickListener listener;
    List<ResponseModelNonInkcRegistreDog> data;
    Context context;

    public AdapterClassNonInkcRegisterDog(RecycleViewClickListener listener, List<ResponseModelNonInkcRegistreDog> data, Context context) {
        this.listener = listener;
        this.data = data;
        this.context = context;
    }

    //    public AdapterClassNonInkcRegisterDog(Context context) {
//        this.context = context;
//    }
//
//    public AdapterClassNonInkcRegisterDog(RecycleViewClickListener listener, List<ResponseModelNonInkcRegistreDog> data) {
//        this.listener = listener;
//        this.data = data;
//    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_non_inkc_register_dog,parent,false);
        return new MyViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.puppyname.setText(data.get(position).getPet_name());
        holder.ownpuppy.setText(data.get(position).getSub_category_name());
        holder.registrationnumber.setText(data.get(position).getPet_registration_number());

//        Picasso.with(context).load(images).placeholder(R.drawable.ic_launcher_background)
//                .fit()
//                .into(holder.images);
        if(data.get(position).getPet_image().equals("")){

            Glide.with(context).load(R.drawable.user).into(holder.images);

        }
        else {
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
        LinearLayout linear6;
        ImageView images;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            puppyname = itemView.findViewById(R.id.puppyname);
            ownpuppy = itemView.findViewById(R.id.ownpuppy);
            registrationnumber = itemView.findViewById(R.id.registrationnumber);
            linear6 = itemView.findViewById(R.id.linear6);
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
