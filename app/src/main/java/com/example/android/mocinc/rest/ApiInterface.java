package com.example.android.mocinc.rest;


import com.example.android.mocinc.response.TicketResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    /*
    @FormUrlEncoded
    @POST("pertanyaan/list_jawaban")
    Call<JawabanResponse> jawabanList(@Field("id_pertanyaan") String id_pertanyaan);

    @GET("pertanyaan/list_kategori")
    Call<PkategoriResponse> pkategoriList();
   */
    @GET("ticket/list")
    Call<TicketResponse> ticketList();

}
