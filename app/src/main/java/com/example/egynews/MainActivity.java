package com.example.egynews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
   static FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager=getSupportFragmentManager();



        attachFrag(new HomeFragment());
    }

    public static void attachFrag(Fragment frag) {


        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.frag_container,frag);
        transaction.commit();


    }

    @Override
    public void onBackPressed() {




        attachFrag(MyStaticFun.getInstance().getFragment());
    }
}
