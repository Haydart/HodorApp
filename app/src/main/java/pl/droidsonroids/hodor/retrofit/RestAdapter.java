package pl.droidsonroids.hodor.retrofit;

<<<<<<< HEAD
import pl.droidsonroids.hodor.HodorApplication;
=======
>>>>>>> origin/master
import pl.droidsonroids.hodor.model.FCMMessage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class RestAdapter {

    public static final String BASE_URL = "https://fcm.googleapis.com/fcm/";
    private final RestApi mApiManager;

    public RestAdapter() {
        mApiManager = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RestApi.class);
    }

<<<<<<< HEAD
    public void sendPush(String to) {
        mApiManager.sendPush(new FCMMessage(to, HodorApplication.getInstance().getPreferences().getUsername())).enqueue(new Callback<Void>() {
=======
    public void sendPush(String to, String from) {
        mApiManager.sendPush(new FCMMessage(to, from)).enqueue(new Callback<Void>() {
>>>>>>> origin/master
            @Override
            public void onResponse(final Call<Void> call, final Response<Void> response) {
                //no-op
            }

            @Override
            public void onFailure(final Call<Void> call, final Throwable t) {
                //no-op
            }
        });
    }

    public interface RestApi {
<<<<<<< HEAD
        @Headers("Authorization: key=AIzaSyDfxP0GzJCYZHet1tIifkpacUeZvi72I2g")
        @POST("send")
        Call<Void> sendPush(@Body FCMMessage message);
    }
}
=======
        @Headers("Authorization: key=AIzaSyCUvwOCIClx7GsDPTfDBiCgSXmHz6BDslc")
        @POST("send")
        Call<Void> sendPush(@Body FCMMessage message);
    }
}
>>>>>>> origin/master
