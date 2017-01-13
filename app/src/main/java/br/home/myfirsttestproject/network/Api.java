package br.home.myfirsttestproject.network;

import br.home.myfirsttestproject.network.model.Page;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ronan.lima on 13/01/17.
 */

public interface Api {

    @GET("/")
    Call<Page> getUsers(@Query("page") int page, @Query("results") int results);
}
