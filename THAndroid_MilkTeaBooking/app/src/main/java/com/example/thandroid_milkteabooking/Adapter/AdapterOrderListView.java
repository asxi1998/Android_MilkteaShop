package com.example.thandroid_milkteabooking.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thandroid_milkteabooking.R;
import com.example.thandroid_milkteabooking.model.HomeListView;
import com.example.thandroid_milkteabooking.model.OrderListView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class AdapterOrderListView extends BaseAdapter {

    Context context;
    List<OrderListView> arrayList;
    int layoutResource;
    LayoutInflater inflater;
    public AdapterOrderListView(Context context, List<OrderListView> arrayList,int layoutResource) {
        this.context = context;
        this.arrayList = arrayList;
        this.layoutResource=layoutResource;
        inflater= LayoutInflater.from(context);
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
            convertView=inflater.inflate(R.layout.designorderlistview,null);

            viewHolder = new ViewHolder();
            viewHolder.imageView= convertView.findViewById(R.id.imageVieworder);
            viewHolder.title= convertView.findViewById(R.id.textViewTitleOrder);
            viewHolder.price= convertView.findViewById(R.id.textViewPrice);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        OrderListView orderListView= arrayList.get(position);

        viewHolder.imageView.setBackgroundResource(orderListView.getImageView());
        viewHolder.title.setText(orderListView.getTitle());
        viewHolder.price.setText(orderListView.getPrice());

        return convertView;
    }

    public class ViewHolder{
        ImageView imageView;
        TextView title;
        TextView price;
    }
}
