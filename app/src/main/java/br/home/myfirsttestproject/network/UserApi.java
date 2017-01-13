package br.home.myfirsttestproject.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.greenrobot.eventbus.EventBus;

import br.home.myfirsttestproject.BuildConfig;
import br.home.myfirsttestproject.network.model.ErrorVO;
import br.home.myfirsttestproject.network.model.Page;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ronan.lima on 13/01/17.
 */

public final class UserApi {
    public static final Gson GSON = new GsonBuilder()
            .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SS'Z'")
            .create();
    private static final int RESULTS = 20;
    private Api api;
    private static UserApi INSTANCE;

    public static UserApi getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserApi();
        }
        return INSTANCE;
    }

    public void getUsers(int page) {
        Call<Page> userResponsePage = api.getUsers(page, RESULTS);
        userResponsePage.enqueue(new Callback<Page>() {
            @Override
            public void onResponse(Call<Page> call, Response<Page> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    EventBus.getDefault().post(response.body());
                } else {
                    ErrorVO error = GSON.fromJson(response.errorBody().charStream(), ErrorVO.class);
                    EventBus.getDefault().post(error);
                }
            }

            @Override
            public void onFailure(Call<Page> call, Throwable t) {
                EventBus.getDefault().post(new ErrorVO());
            }
        });
    }

    private UserApi() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ?
                HttpLoggingInterceptor.Level.BODY :
                HttpLoggingInterceptor.Level.NONE);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        api = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GSON))
                .client(client)
                .build()
                .create(Api.class);
    }
}
