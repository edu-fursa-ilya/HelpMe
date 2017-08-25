package dev.android.fursa.helpme.com.fursa.dev.rest;


import dev.android.fursa.helpme.com.fursa.dev.rest.response.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlaceRequest {

    @GET("/maps/api/place/textsearch/json?")
    Call<Response> getPlace(
            @Query("query") String query,
            @Query("key") String apiKey,
            @Query("language") String lang);
}
