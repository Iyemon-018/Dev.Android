package com.example.iyemon018.listviewsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.LinkedList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by iyemon018 on 2018/01/20.
 */
public final class DailyAdapter extends BaseAdapter {
    
    LinkedList<DataForHour> dailyDataList;
    
    LayoutInflater layoutInflater;
    
    static final SimpleDateFormat FORMATTER = new SimpleDateFormat("HH:mm:ss");
    
    public DailyAdapter(Context context) {
        
        this.dailyDataList = new LinkedList<>();
        this.layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }
    
    public void addData(DataForHour data) {
        
        this.dailyDataList.add(data);
    }
    
    public void addDataAll(Collection<DataForHour> dataList) {
        
        this.dailyDataList.addAll(dataList);
    }
    
    @Override
    public int getCount() {
        
        return this.dailyDataList.size();
    }
    
    @Override
    public Object getItem(int position) {
        
        return this.dailyDataList.get(position);
    }
    
    @Override
    public long getItemId(int position) {
        
        return position;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
        convertView = this.layoutInflater.inflate(R.layout.data_for_hour_item, parent, false);
        
        DataForHour data = this.dailyDataList.get(position);
        ViewHolder holder = new ViewHolder(convertView);
        
        holder.hourTextView.setText(FORMATTER.format(data.getDateTime()));
        holder.valueTextView.setText(Float.toString(data.getValue()));
        
        return convertView;
    }
    
    static class ViewHolder {
        
        @BindView(R.id.hourTextView)
        TextView hourTextView;
    
        @BindView(R.id.valueTextView)
        TextView valueTextView;
        
        ViewHolder(View view) {ButterKnife.bind(this, view);}
    }
}
