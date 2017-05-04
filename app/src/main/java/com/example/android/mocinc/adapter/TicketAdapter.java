package com.example.android.mocinc.adapter;

/**
 * Created by Khalil Qibran on 5/4/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

import com.example.android.mocinc.InformationTicket;
import com.example.android.mocinc.R;
import com.example.android.mocinc.model.Ticket;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {
    private List<Ticket> ticket;
    private int rowLayout;
    private Context context;
    Bundle b;

    public static class TicketViewHolder extends RecyclerView.ViewHolder {
        LinearLayout ticketLayout;

        TextView ticketNama;
        TextView ticketWaktu;
        TextView ticketLokasi;
        TextView ticketHarga;

        public TicketViewHolder(View v) {
            super(v);
            ticketLayout = (LinearLayout) v.findViewById(R.id.ticket_layout);
            ticketNama= (TextView) v.findViewById(R.id.nama);
            ticketWaktu= (TextView) v.findViewById(R.id.waktu);
            ticketLokasi= (TextView) v.findViewById(R.id.lokasi);
            ticketHarga= (TextView) v.findViewById(R.id.harga);

        }
    }
    public TicketAdapter(List<Ticket> ticket, int rowLayout, Context context) {
        this.ticket = ticket;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    // mulai
    @Override
    public TicketAdapter.TicketViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new TicketViewHolder(view);
    }


    @Override
    public void onBindViewHolder(TicketViewHolder holder, final int position) {

        holder.ticketHarga.setText(ticket.get(position).getHarga());
        holder.ticketNama.setText(ticket.get(position).getNama());
        holder.ticketLokasi.setText(ticket.get(position).getLokasi());
        holder.ticketWaktu.setText(ticket.get(position).getWaktu());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, berita.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent i;
                i = new Intent(context, InformationTicket.class);
                i.putExtra("id", ticket.get(position).getId());
                i.putExtra("harga", ticket.get(position).getHarga());
                i.putExtra("lang", ticket.get(position).getLang());
                i.putExtra("lat", ticket.get(position).getLat());
                i.putExtra("lokasi", ticket.get(position).getLokasi());
                i.putExtra("nama", ticket.get(position).getNama());
                i.putExtra("waktu", ticket.get(position).getWaktu());
                i.putExtra("username", ticket.get(position).getWaktu());

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return ticket.size();
    }

}

