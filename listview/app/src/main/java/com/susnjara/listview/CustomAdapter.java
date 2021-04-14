package com.susnjara.listview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.jar.Attributes;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.NameViewHolder> {

    private static final String TAG = "CustomAdapter";
    private NameClickListener nameClickListener;

    private List<String> dataList;

    public CustomAdapter(List<String> dataList, NameClickListener nameClickListener){
        this.dataList = dataList;
        this.nameClickListener = nameClickListener;
    }


    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new NameViewHolder(listItemView, nameClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        holder.setName(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class NameViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;

        public NameViewHolder(@NonNull View itemView, NameClickListener nameClickListener) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Log.d(TAG,"NameViewHolder Click");
                    nameClickListener.onNameClick(getAdapterPosition());
                }
            });
        }

        public void setName(String name){
            textView.setText(name);
        }
    }
}
