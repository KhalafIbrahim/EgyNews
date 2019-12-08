package com.example.egynews.favor;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.egynews.MainActivity;
import com.example.egynews.MoveObjct;
import com.example.egynews.OneNew;
import com.example.egynews.R;
import com.example.egynews.Recycler_View.MyAdpter;
import com.example.egynews.ShowOneArticls;
import com.example.egynews.my_Database.MyDatabaseConn;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class OffLineFragment extends Fragment {


    public OffLineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_off_line, container, false);

        RecyclerView offline=view.findViewById(R.id.offLine);
        offline.setLayoutManager(new GridLayoutManager(getContext(),2));
        MyAdpter adpter =new MyAdpter();
        adpter.setmLayout(R.layout.row_grid);
        adpter.setOffLineList(MyDatabaseConn.getInstance().connect(getContext()).getAllOffLineNews());
        offline.setAdapter(adpter);

adpter.setOnItemClick(new MyAdpter.OnItemClick() {
    @Override
    public void onClick(OneNew oneNew) {



        String date=""+android.text.format.DateFormat.format("yyyy-MM-dd hh:mm:ss a",new Date(oneNew.getTime()) );
        MoveObjct.getInstance().
                Start(getContext()).
                setDATAtoMove(oneNew.getPhotoPath(),"Intra", date ,oneNew.getTitle(),oneNew.getContent() );
        MainActivity.attachFrag(new ShowOneArticls());



    }
});


        return view;

    }

}
