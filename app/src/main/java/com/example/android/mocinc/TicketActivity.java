package com.example.android.mocinc;

/**
 * Created by Khalil Qibran on 5/4/2017.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.android.mocinc.adapter.TicketAdapter;
import com.example.android.mocinc.model.Ticket;

import java.util.List;

import com.example.android.mocinc.R;
import com.example.android.mocinc.response.TicketResponse;
import com.example.android.mocinc.rest.ApiClient;
import com.example.android.mocinc.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketActivity extends AppCompatActivity {
    List<Ticket> ticket ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ticket_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<TicketResponse> call = apiService.ticketList();

        call.enqueue(new Callback<TicketResponse>() {
            @Override
            public void onResponse(Call<TicketResponse> call, Response<TicketResponse> response) {
                int statusCode = response.code();
                ticket = response.body().getResults();
                recyclerView.setAdapter(new TicketAdapter(ticket, R.layout.list_item_ticket, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<TicketResponse> call, Throwable t) {
                // Log error here since request failed
                //Log.e(TAG, t.toString());
            }
        });


    }
}


