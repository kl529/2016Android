package com.example.kl529.calendar;

import java.text.SimpleDateFormat;

    import java.util.ArrayList;
    import java.util.Calendar;
    import java.util.Date;
    import java.util.List;
    import java.util.Locale;

    import android.app.Activity;
    import android.content.Context;
    import android.os.Bundle;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.view.ViewGroup;
    import android.widget.BaseAdapter;
    import android.widget.GridView;
    import android.widget.TextView;


public class MainActivity extends Activity {

    private TextView tvDate;
    //    연,월 레이아웃 텍스트 뷰
    private TextView tvDate;
    // GridView Adapter
    private GridAdapter gridAdapter;
    // Save List
    private ArrayList<String> dayList;
    //GridView
    private GridView gridView;
    //Calender variable
    private Calender mCal;
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.activity_main);

        tvDate = (TextView)findViewById(android.R.id.tv_date);
        gridView = (GridView)findViewById(R.id.gridview);
        //Set today's month and days.
        long now = System.currentTimeMillis();
        
        final Date date = new Date(now);
        //Each save year,month,days
        final SimpleDateFormat nowYear = new SimpleDateFormat("yyyy",Locale.KOREA);
        final SimpleDateFormat nowMonth = new SimpleDateFormat("MM",Locale.KOREA);
        final SimpleDateFormat nowDay = new SimpleDateFormat("DD",Locale.KOREA);
        
        tvDate.setText(nowYear.format(date) + "." + nowMonth.format(date));
        //gridview what day?
        dayList = new ArrayList<String>();
        dayList.add("SUN");
        dayList.add("MON");
        dayList.add("TUE");
        dayList.add("WED");
        dayList.add("THU");
        dayList.add("FRI");
        dayList.add("SAT");
        mCal = Calendar.getInstance();
    }

}
