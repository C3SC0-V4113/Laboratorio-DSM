package com.udb.edu.guia6.retrofit_vc190544.interfaces;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servicio {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2/APIUDB/producto/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static APIService service =
            retrofit.create(APIService.class);
}
