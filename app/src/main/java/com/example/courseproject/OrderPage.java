package com.example.courseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.courseproject.model.Course;
import com.example.courseproject.model.CourseApi;
import com.example.courseproject.model.Order;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OrderPage extends AppCompatActivity {
    List<String> coursesTitle = new ArrayList<>();;

    ArrayAdapter<String> adapter;
    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://c6a8e086333c6b13.mokky.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    static CourseApi courseApi = retrofit.create(CourseApi.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ListView orders_list = findViewById(R.id.orders_list);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle);


        orders_list.setAdapter(adapter);
        getOrders();


    }

    public void getOrders() {

        for(String l : coursesTitle) {
            Log.d("AmirbekOrder", l.toString());
        }
        Call<List<Course>> call = courseApi.getOrderCourses();
        call.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                if(response.isSuccessful() && response.body() != null) {
                    List<Course> courses = response.body();
                    for(Course c : courses) {
                        Log.d("AmirbekTit",c.getTitle());
                        coursesTitle.add(c.getTitle().toString());
                    }
                    runOnUiThread(() -> adapter.notifyDataSetChanged());

                } else {
                    Log.e("AmirbekL", "Response not successful or body is null");
                }
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {
                Log.e("AmirbekL", "Network request failed", t);
            }
        });



    }
}
