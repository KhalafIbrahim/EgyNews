package com.example.egynews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView=findViewById(R.id.splash_image);




        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("NewsData");
//myRef.setValue("new set1");


        OneNew objc=new OneNew();

        objc.setTitle("الخبر الاول ");
        objc.setContent("هذا الخبر لافتتاح قاعدة البيانات");
        objc.setPhotoPath("https://www.bing.com/images/search?view=detailV2&ccid=UsoY%2f41B&id=473EA8AAEB803233964BAD61A216FF0CCDDB1C72&thid=OIP.UsoY_41BZtTqw-FMGd5uogHaFj&mediaurl=https%3a%2f%2ft1.daumcdn.net%2fcfile%2ftistory%2f270EC75054D6D8D60E&exph=562&expw=750&q=image+progrmming&simid=607996776630977578&selectedIndex=201");
        objc.setType(StaticKyes.International+"");
        objc.setTime(Calendar.getInstance().getTimeInMillis());
        myRef.push().setValue(objc);



        objc.setTitle("الخبر الثانى ");
        objc.setContent("هذا الخبرمحلى");
        objc.setPhotoPath("https://steemit.com/technology/@twiningenious/the-programing-is-the-future-and-128644");
        objc.setType(StaticKyes.localNews+"");
        objc.setTime(Calendar.getInstance().getTimeInMillis());
        myRef.push().setValue(objc);











        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animshape);
        imageView.startAnimation(animation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        },3000);
    }
}



