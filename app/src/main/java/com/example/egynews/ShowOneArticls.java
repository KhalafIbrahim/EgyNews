package com.example.egynews;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Objects;


public class ShowOneArticls extends Fragment {


    public ShowOneArticls() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_show_one_articls, container, false);
        TextView title = v.findViewById(R.id.title);
        TextView content = v.findViewById(R.id.content);
        TextView date = v.findViewById(R.id.date);
        TextView type = v.findViewById(R.id.tupe);
        ImageView photo = v.findViewById(R.id.articlPhoto);
        MoveObjct data = MoveObjct.getInstance().Start(Objects.requireNonNull(getContext()));

       final String sTitle = data.getTitle();
       final String sContent = data.getContent();
        String sDate = data.getDate();
        String sType = data.getType();

        Picasso.get().load(data.getPhoto()).centerCrop().fit().into(photo);

title.setText(sTitle);
content.setText(sContent);
date.setText(sDate);
type.setText(sType);


v.findViewById(R.id.btn_share).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
share(sTitle+"\n"+sContent);
    }
});




        return v;
    }
    private void  share(String msg){

msg+="\n تمت المشاركة بواسطة تطبيق اخبارى";
msg+="https://play.google.com/store/apps/details?id="+getActivity().getPackageName()+"";

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        //sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, msg);
        startActivity(Intent.createChooser(sharingIntent, "share with..."));



    }

}
