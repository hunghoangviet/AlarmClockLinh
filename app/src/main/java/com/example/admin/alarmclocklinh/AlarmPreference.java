package com.example.admin.alarmclocklinh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class AlarmPreference extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    //private static String LOG_TAG = "CardViewActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_preference);

        mRecyclerView = (RecyclerView) findViewById(R.id.activity_alarm_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AlarmAdapter(getDataSet());//unwritten method
        mRecyclerView.setAdapter(mAdapter);
    }


}//end of Alarm Preference
