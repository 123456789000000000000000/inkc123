package com.example.indiannationalkennelclub.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indiannationalkennelclub.R;
import com.example.indiannationalkennelclub.ResponseModel.ResponseModelNotification;

import java.util.List;

public class AdapterClassNotification extends RecyclerView.Adapter<AdapterClassNotification.MyViewHolder> {

    private  AdapterClassNotification.RecycleViewClickListener listener;
    List<ResponseModelNotification> data;

    public AdapterClassNotification(RecycleViewClickListener listener, List<ResponseModelNotification> data) {
        this.listener = listener;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_notification,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.notidate.setText(data.get(position).getDay());
        if(data.get(position).getMonth().equals("01"))
            holder.notimonth.setText("JAN");
        else if(data.get(position).getMonth().equals("02"))
            holder.notimonth.setText("FEB");
        else if(data.get(position).getMonth().equals("03"))
            holder.notimonth.setText("MAR");
        else if(data.get(position).getMonth().equals("04"))
            holder.notimonth.setText("APR");
        else if(data.get(position).getMonth().equals("05"))
            holder.notimonth.setText("MAY");
        else if(data.get(position).getMonth().equals("06"))
            holder.notimonth.setText("JUN");
        else if(data.get(position).getMonth().equals("07"))
            holder.notimonth.setText("JUL");
        else if(data.get(position).getMonth().equals("08"))
            holder.notimonth.setText("AUG");
        else if(data.get(position).getMonth().equals("09"))
            holder.notimonth.setText("SEP");
        else if(data.get(position).getMonth().equals("10"))
            holder.notimonth.setText("OCT");
        else if(data.get(position).getMonth().equals("11"))
            holder.notimonth.setText("NOV");
        else
            holder.notimonth.setText("DEC");



        holder.notimessage.setText(data.get(position).getNoti_message());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView notidate,notimonth,notimessage;
        Button btn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            notidate = itemView.findViewById(R.id.notidate);
            notimonth = itemView.findViewById(R.id.notimonth);
            notimessage = itemView.findViewById(R.id.notimessage);
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
