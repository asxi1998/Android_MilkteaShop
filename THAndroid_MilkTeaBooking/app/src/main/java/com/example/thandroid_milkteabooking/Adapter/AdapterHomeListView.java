package com.example.thandroid_milkteabooking.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.thandroid_milkteabooking.R;
import com.example.thandroid_milkteabooking.model.HomeListView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class AdapterHomeListView extends BaseAdapter {
    Context context;
    ArrayList<HomeListView> arrayList;
    int layoutResource;
    LayoutInflater inflater;
    public AdapterHomeListView(Context context, ArrayList<HomeListView> arrayList, int layoutResource) {
        this.context = context;
        this.arrayList = arrayList;
        this.layoutResource = layoutResource;
        inflater=LayoutInflater.from(context);
    }





    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return getItemId(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.designhomelistview,null);

            viewHolder = new ViewHolder();
            viewHolder.imageView= convertView.findViewById(R.id.imageViewdesignhome);
            viewHolder.Title= convertView.findViewById(R.id.textviewTille);
            viewHolder.Direction= convertView.findViewById(R.id.textviewDirection);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        HomeListView homeListView= arrayList.get(position);

        viewHolder.imageView.setBackgroundResource(homeListView.getImageHomeListView());
        viewHolder.Title.setText(homeListView.getTitle());
        viewHolder.Direction.setText(homeListView.getDirection());

        return convertView;
    }
    public class ViewHolder{
        ImageView imageView;
        TextView Title;
        TextView Direction;
    }


}
