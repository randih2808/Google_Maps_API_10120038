package com.tugas_memanfaatkan_sensor_di_perangkat_android.Google_Maps_API_10120038;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;
import android.view.Window;

public class Splashscreen extends AppCompatActivity {
    //Nim   : 10120038
    //Nama  : Randi Hardiansyah
    //Kelas : IF-1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Reques window feature
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();




        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke Viewpager2 activity
                Intent Viewpager=new Intent(Splashscreen.this, Viewpager2.class);
                startActivity(Viewpager);
                finish();

            }
        },3000);
    }
}