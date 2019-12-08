package com.example.egynews.Recycler_View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.egynews.OneNew;
import com.example.egynews.R;
import com.example.egynews.favor.OffLineFragment;
import com.example.egynews.my_Database.MyDatabaseConn;
import com.example.egynews.my_Database.OffLineOneNew;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdpter extends RecyclerView.Adapter<MyAdpter.MyViewHolder>{

private boolean isSaved ;

    List<?> dataList = new ArrayList<>();

    int mLayout =R.layout.articals_row;

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }



    public void setDataList(List<OneNew> dataList) {
        this.dataList = dataList;

        notifyDataSetChanged();
    }

    public void setOffLineList(List<OffLineOneNew> dataList) {
        this.dataList = dataList;


        isSaved =true;

        notifyDataSetChanged();
    }

    public void setmLayout(int mLayout) {
        this.mLayout = mLayout;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(mLayout,parent,false);

        return  new MyViewHolder(view);
    }



    MyDatabaseConn dp=MyDatabaseConn.getInstance();

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

         OneNew data= (OneNew) dataList.get(position);


if (dataList instanceof OffLineOneNew) {


    data = (OffLineOneNew) dataList.get(position);
    holder.save.setVisibility(View.GONE);

//}
//else if (dataList instanceof OffLineFragment){
//    data=(OffLineOneNew) dataList.get(position);
}


if (isSaved){

    holder.save.setVisibility(View.GONE);
}

holder.title.setText(data.getTitle());
holder.content.setText(data.getContent());

        Picasso.get().load(data.getPhotoPath()).fit().centerCrop().into(holder.imageView);

dp.connect(holder.itemView.getContext());


holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        onItemClick.onClick((OneNew) dataList.get(holder.getAdapterPosition()));


    }
});

final OneNew finalData =data;
holder.save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        OffLineOneNew n= new OffLineOneNew();
        n.setPhotoPath(finalData.getPhotoPath());
        n.setTitle(finalData.getTitle());
        n.setTime(finalData.getTime());
        n.setContent(finalData.getContent());
        n.setType(finalData.getType());



       if (dp.insertToDatabase(n)){

           Toast.makeText(holder.itemView.getContext(), "Done", Toast.LENGTH_SHORT).show();
       }

    }
});

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

TextView title,content,save;
ImageView imageView;

        public MyViewHolder(@NonNull View  view) {
            super(view);
title=view.findViewById(R.id.row_title);
content=view.findViewById(R.id.row_content);
imageView=view.findViewById(R.id.row_image_grid);
save=view.findViewById(R.id.save_to_read);


        }
    }

    public interface OnItemClick{

        void onClick(OneNew oneNew);



    }


}
