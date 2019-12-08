package com.example.egynews;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.egynews.intarNational.IntraFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    public HomeFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



              View view=  inflater.inflate(R.layout.fragment_home, container, false);

        TextView international=view.findViewById(R.id.internationalNews);
        TextView sport=view.findViewById(R.id.sportsNews);
        TextView search=view.findViewById(R.id.searchNews);
        TextView videos=view.findViewById(R.id.videoNews);
        TextView favor=view.findViewById(R.id.favoriteNews);

international.setOnClickListener(this);
        sport.setOnClickListener(this);
        search.setOnClickListener(this);
        videos.setOnClickListener(this);
        favor.setOnClickListener(this);







        return view;



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.internationalNews:
                Toast.makeText(getContext(), "اخر الاخبار العالمية", Toast.LENGTH_SHORT).show();
                MyStaticFun.getInstance().attachFragmnt((MainActivity)getActivity(),new IntraFragment());

                break;
        }
    }

    @Override
    public void onDestroyView() {


        super.onDestroyView();

        MyStaticFun.getInstance().setFragment(this);
    }

}
