package com.example.egynews.intarNational;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.example.egynews.OneNew;
import com.example.egynews.StaticKyes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class IntraViewModel extends AndroidViewModel {



    private MediatorLiveData<List<OneNew>> getData=new MediatorLiveData<>();



    public IntraViewModel(@NonNull Application application) {
        super(application);
    }












    private List<OneNew> list=new ArrayList<>();



    public void setData(int type){
        FirebaseDatabase database=FirebaseDatabase.getInstance();

        DatabaseReference reference=database.getReference("NewsData");
        Query query = reference.orderByChild(StaticKyes.Type).equalTo(type);
        query.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    for (DataSnapshot data : dataSnapshot.getChildren()) {

                        OneNew oneNew = data.getValue(OneNew.class);

                        assert oneNew != null;
                        Log.e("Data", oneNew.getTitle() + "");

                        list.add(oneNew);

                    }
                    getData.postValue(list);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {




            }
        });


    }

    public void setDataList(List<OneNew> list){

    }

    public LiveData<List<OneNew>> getData(){

        return getData;

    }










}
