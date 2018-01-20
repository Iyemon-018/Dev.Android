package com.example.iyemon018.listviewsample;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by iyemon018 on 2018/01/20.
 */
public final class DailyAdapter extends BaseAdapter {
    
    LinkedList<DataForHour> dailyDataList;
    
    LayoutInflater layoutInflater;
    
    final int color;
    
    final int warningForeground;
    
    final int errorForeground;
    
    static final SimpleDateFormat FORMATTER = new SimpleDateFormat("HH:mm");
    
    public DailyAdapter(Context context) {
        
        this.dailyDataList = new LinkedList<>();
        this.layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.color = ContextCompat.getColor(context, R.color.list_view_item_alternate);
        this.warningForeground = ContextCompat.getColor(context, R.color.value_warning);
        this.errorForeground = ContextCompat.getColor(context, R.color.value_error);
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
        
        DataForHour data   = this.dailyDataList.get(position);
        ViewHolder  holder = new ViewHolder(convertView);
        
        Date dateTime = data.getDateTime();
        Calendar c = Calendar.getInstance();
        c.setTime(dateTime);
        c.add(Calendar.HOUR, 1);
        c.add(Calendar.MINUTE, -1);
        holder.hourTextView.setText(FORMATTER.format(data.getDateTime()) + " ～ " + FORMATTER.format(c.getTime()));
        if (position % 2 == 1) {
            holder.layoutRoot.setBackgroundColor(this.color);
        }
    
        TextView valueTextView = holder.valueTextView;
        valueTextView.setText(Float.toString(data.getValue()));
        if (data.getValue() > 80f) {
            valueTextView.setTextColor(this.errorForeground);
        } else if (data.getValue() > 50f) {
            valueTextView.setTextColor(this.warningForeground);
        }
        
        return convertView;
    }
    
    static class ViewHolder {
        
        @BindView(R.id.hourTextView)
        TextView hourTextView;
        
        @BindView(R.id.valueTextView)
        TextView valueTextView;
    
        @BindView(R.id.layoutRoot)
        LinearLayout layoutRoot;
    
        ViewHolder(View view) {ButterKnife.bind(this, view);}
    }
}
