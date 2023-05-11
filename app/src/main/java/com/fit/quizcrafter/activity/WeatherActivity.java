package com.fit.quizcrafter.activity;

import static com.fit.quizcrafter.api.RetrofitClient.access_key;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fit.quizcrafter.api.RetrofitClient;
import com.fit.quizcrafter.api.RetrofitWeather;
import com.fit.quizcrafter.databinding.ActivityWeatherBinding;
import com.fit.quizcrafter.domain.Question;
import com.fit.quizcrafter.domain.Quiz;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {

    private ActivityWeatherBinding binding;
    private String location;
    private RetrofitWeather retrofitWeather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeatherBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        retrofitWeather = RetrofitClient.getRetrofitService();

        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location=binding.editText.getText().toString();
                Call<ResponseBody> callAsync =
                        retrofitWeather.getWeatherbyLocation(access_key,"melbourne");
                System.out.println(callAsync.toString());
                //makes an async request & invokes callback methods when the response returns
                callAsync.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call,
                                           Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            System.out.println(response);
                        }
                        else {
                            Log.i("Error ","Response failed");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        System.out.println("error");

                    }
                });



            }
        });
    }
}