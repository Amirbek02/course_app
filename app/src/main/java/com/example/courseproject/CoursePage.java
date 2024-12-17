package com.example.courseproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.courseproject.model.Course;
import com.example.courseproject.model.CourseApi;
import com.example.courseproject.model.Order;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoursePage extends AppCompatActivity {

    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://c6a8e086333c6b13.mokky.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    static CourseApi courseApi = retrofit.create(CourseApi.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        ConstraintLayout courseBg = findViewById(R.id.coursePageBg);
        ImageView courseImage = findViewById(R.id.coursePageImg);
        TextView courseTitle = findViewById(R.id.coursePageTitle);
        TextView courseLevel = findViewById(R.id.coursePageLevel);
        TextView courseDate = findViewById(R.id.coursePageDate);
        TextView courseText = findViewById(R.id.coursePageText);

        courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg", 0));
        courseImage.setImageResource(getIntent().getIntExtra("courseImg", 0));

        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseDate.setText(getIntent().getStringExtra("courseDate"));
        courseLevel.setText(getIntent().getStringExtra("courseLevel"));
        courseText.setText(getIntent().getStringExtra("courseText"));
    }

    public void addToCard(View view) {
        int item_id = getIntent().getIntExtra("courseId", 0);
        String courseImage = getIntent().getStringExtra("courseImg");
        String courseTitle = getIntent().getStringExtra("courseTitle");
        String courseBg = getIntent().getStringExtra("courseBg");
        String courseLevel = getIntent().getStringExtra("courseLevel");
        String courseDate = getIntent().getStringExtra("courseDate");
        String courseText = getIntent().getStringExtra("courseText");

        if (Order.items_id.contains(item_id)) {
            Toast.makeText(this, "Курс уже добавлен!", Toast.LENGTH_SHORT).show();
            Log.d("Amirbek", "Course already added: " + item_id);
            return;
        }

        Call<Course> checkCall = courseApi.getOrdersById(item_id);
        checkCall.enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(CoursePage.this, "Курс уже добавлен!", Toast.LENGTH_SHORT).show();
                    Log.d("Amirbek", "Course already exists on server: " + item_id);
                } else {
                    Order.items_id.add(item_id);
                    Course addPostCourse = new Course(item_id, courseImage, courseTitle, courseDate, courseLevel, courseBg, courseText, 2);

                    Call<Void> postCall = courseApi.postCourse(addPostCourse);
                    postCall.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if (response.isSuccessful()) {
                                Log.d("Amirbek", "Post request successful");
                            } else {
                                Log.e("Error", "Request failed: " + response.code() + " - " + response.message());
                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Log.e("Error", "Request failed: " + t.getMessage());
                        }
                    });
                    Toast.makeText(CoursePage.this, "Добавлено! :)", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {
                Log.e("Error", "Check course request failed: " + t.getMessage());
            }
        });
    }
}