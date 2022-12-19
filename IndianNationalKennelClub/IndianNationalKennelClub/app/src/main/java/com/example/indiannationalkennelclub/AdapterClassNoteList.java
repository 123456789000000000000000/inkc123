package com.example.indiannationalkennelclub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class AdapterClassNoteList extends RecyclerView.Adapter<AdapterClassNoteList.MyViewHolder> {

    private  AdapterClassNoteList.RecycleViewClickListener listener;
    List<ResponseModelNote> data;

    public AdapterClassNoteList(RecycleViewClickListener listener, List<ResponseModelNote> data) {
        this.listener = listener;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_note_details,parent,false);
        return new MyViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.sn.setText(data.get(position).getSn());
        holder.note.setText(data.get(position).getNote_message());
//        holder.notedate.setText(data.get(position).getNote_created_on());

        if(data.get(position).getMonth().equals("01"))
            holder.notedate.setText(data.get(position).day+" - JAN - "+data.get(position).year);
        else if(data.get(position).getMonth().equals("02"))
            holder.notedate.setText(data.get(position).day+" - FEB - "+data.get(position).year);
        else if(data.get(position).getMonth().equals("03"))
            holder.notedate.setText(data.get(position).day+" - MAR - "+data.get(position).year);
        else if(data.get(position).getMonth().equals("04"))
            holder.notedate.setText(data.get(position).day+" - APR - "+data.get(position).year);
        else if(data.get(position).getMonth().equals("05"))
            holder.notedate.setText(data.get(position).day+" - MAY - "+data.get(position).year);
        else if(data.get(position).getMonth().equals("06"))
            holder.notedate.setText(data.get(position).day+" - JUN - "+data.get(position).year);
        else if(data.get(position).getMonth().equals("07"))
            holder.notedate.setText(data.get(position).day+" - JUL - "+data.get(position).year);
        else if(data.get(position).getMonth().equals("08"))
            holder.notedate.setText(data.get(position).day+" - AUG - "+data.get(position).year);
        else if(data.get(position).getMonth().equals("09"))
            holder.notedate.setText(data.get(position).day+" - SEP - "+data.get(position).year);
        else if(data.get(position).getMonth().equals("10"))
            holder.notedate.setText(data.get(position).day+" - OCT - "+data.get(position).year);
        else if(data.get(position).getMonth().equals("11"))
            holder.notedate.setText(data.get(position).day+" - NOV - "+data.get(position).year);
        else
            holder.notedate.setText(data.get(position).day+" - DEC - "+data.get(position).year);

        holder.btn.setText("Remove");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView sn,note,notedate,id;
        Button btn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sn = itemView.findViewById(R.id.sn);
            note = itemView.findViewById(R.id.note);
            notedate = itemView.findViewById(R.id.notedate);
            btn = itemView.findViewById(R.id.id);
            btn.setOnClickListener(this);

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
