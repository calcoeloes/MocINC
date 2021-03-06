package com.example.android.mocinc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.mocinc.adapter.TicketAdapter;
import com.example.android.mocinc.model.Ticket;
import com.example.android.mocinc.response.TicketResponse;
import com.example.android.mocinc.rest.ApiClient;
import com.example.android.mocinc.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class listTicket extends Activity {
    List<Ticket> ticket ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ticket);

        Button button = (Button) findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent i = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(i);

            }
        });

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
