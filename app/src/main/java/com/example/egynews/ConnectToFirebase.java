package com.example.egynews;

import android.util.Log;

import androidx.lifecycle.AndroidViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ConnectToFirebase {




    private AndroidViewModel vm;
    public void setVm(AndroidViewModel vm){

        this.vm= vm ;


    }


    private ConnectToFirebase() {
    }

    private final static ConnectToFirebase obj = new ConnectToFirebase();


    public static synchronized ConnectToFirebase getInstance() {


        return obj;

    }

}
