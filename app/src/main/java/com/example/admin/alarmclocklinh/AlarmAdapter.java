package com.example.admin.alarmclocklinh;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import java.util.ArrayList;

/**
 * Created by Admin on 11/4/2016.
 */

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.TimePickerHolder> {
    private static String LOG_TAG = "AlarmAdapter";
    private ArrayList<TimePicker> mTimePickerList;
    private static ClickListener mClickListener;
    public static class TimePickerHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TimePicker timePicker;

        public TimePickerHolder(View itemView){
            super(itemView);
            timePicker =(TimePicker)itemView.findViewById(R.id.timePicker);
            Log.i(LOG_TAG,"Adding Listenner");
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v){
            mClickListener.onItemClick(getAdapterPosition(), v);
        }


    }

        public void setOnItemClickListener( ClickListener clickListener,){
            this.mClickListener = clickListener;
        }
        public void MyRecyclerViewAdapter(ArrayList<TimePicker> newAlarmList){
            mTimePickerList = newAlarmList;
        }
        @Override
        public TimePickerHolder onCreatViewHolder(ViewGroup parent,int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alarm_card,parent,false);
            TimePickerHolder timePickerHolder = new TimePickerHolder(view);
            return timePickerHolder;
        }
        @Override
        public void onBindViewHolder(TimePickerHolder tph, int position){
            TimePicker tempTimePicker;
            tempTimePicker.setHour(mTimePickerList.get(position).getHour());
            tempTimePicker.setMinute(mTimePickerList.get(position).getMinute());
            tph.timePicker.setHour(tempTimePicker.getHour());
            tph.timePicker.setMinute(tempTimePicker.getMinute());
        }

        public void addItem(TimePicker tp, int index){
            mTimePickerList.add(index,tp);
            notifyItemInserted(index);
        }
        public void deleteItem(int index){
            mTimePickerList.remove(index);
            notifyItemRemoved(index);
        }
        @Override
        public int getItemCount(){
            return mTimePickerList.size();
        }

        public interface ClickListener {
            public void onItemClick(int position, View v);
        }
}

