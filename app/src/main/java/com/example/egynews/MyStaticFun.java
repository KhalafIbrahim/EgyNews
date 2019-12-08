package com.example.egynews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

class MyStaticFun {
    private static   MyStaticFun ourInstance ;

    static MyStaticFun getInstance() {

        if (ourInstance== null){


            ourInstance= new MyStaticFun();


        }
        return ourInstance;
    }

    private MyStaticFun() {
    }




private Fragment fragment;
    public Fragment getFragment(){

        return fragment ;
    }

    public void setFragment(Fragment fragment){

this.fragment=fragment;
    }




   public void attachFragmnt(AppCompatActivity activity, Fragment fragment) {


        if (fragment!= null) {

            FragmentManager manager = activity.getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.frag_container, fragment);
            transaction.commit();

        }
    }



}
