package com.example.egynews.intarNational;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.egynews.ConnectToFirebase;
import com.example.egynews.MainActivity;
import com.example.egynews.MoveObjct;
import com.example.egynews.OneNew;
import com.example.egynews.R;
import com.example.egynews.Recycler_View.MyAdpter;
import com.example.egynews.ShowOneArticls;
import com.example.egynews.StaticKyes;

import java.util.Calendar;
import java.util.Date;
import java.util.List;





public class IntraFragment extends Fragment {

    private IntraViewModel mViewModel;


    LinearLayout noDataCont;
    RecyclerView recyclerView;
    MyAdpter adpter;
    boolean isGrid = false;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.intra_fragment, container, false);

        Context context = getContext();
        noDataCont = root.findViewById(R.id.noDataCount);
        recyclerView = root.findViewById(R.id.international_recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adpter = new MyAdpter();
        recyclerView.setAdapter(adpter);
        ImageButton imageButton = root.findViewById(R.id.convert);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 if (isGrid) {


                    imageButton.setImageResource(R.drawable.ic_grid);
                     adpter.setmLayout(R.layout.articals_row);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                     recyclerView.setAdapter(adpter);
                    isGrid = false;


                } else {

                    isGrid = true;
                     imageButton.setImageResource(R.drawable.ic_list);
                    adpter.setmLayout(R.layout.row_grid);
                     recyclerView.setAdapter(adpter);
                    recyclerView.setLayoutManager(new GridLayoutManager(context, 2));

                }
            }
        });
adpter.setOnItemClick(new MyAdpter.OnItemClick() {
    @Override
    public void onClick(OneNew oneNew) {



        String date=""+android.text.format.DateFormat.format("yyyy-MM-dd hh:mm:ss a",new Date(oneNew.getTime()) );
        MoveObjct.getInstance().
                Start(getContext()).
                setDATAtoMove(oneNew.getPhotoPath(),"Intra", date ,oneNew.getTitle(),oneNew.getContent() );
       MainActivity.attachFrag(new  ShowOneArticls());


     }
});
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(IntraViewModel.class);

        ConnectToFirebase.getInstance().setVm(mViewModel);
        mViewModel.setData(StaticKyes.International);
        mViewModel.getData().observe(this, new Observer<List<OneNew>>() {
            @Override
            public void onChanged(List<OneNew> newList) {
                Log.e("data size", newList.size() + "");

                if (newList.size() > 0) {
                    noDataCont.setVisibility(View.GONE);
                    adpter.setDataList(newList);
                }


            }
        });
    }

}
