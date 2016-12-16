package com.example.kl529.calendar;

import java.text.SimpleDateFormat;
import java.util.*;
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
    private Calendar mCal;
    
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
        
        mCal.set(Integer.parseInt(nowYear.format(date), Integer.parseInt(nowMonth.format(date)) -1, Integer.parseInt(nowDay.format(date)));
                 
        int dayNum = mCal.get(Calendar.DAY_OF_WEEK);
                 
        for (int i = 1; i <dayNum; i++)
                 {
                     dayList.add("");
                 }
        
        setCalendarDate(mCal.get(Calendar.MONTH) + 1);
                 
        gridAdapter = new GridAdapter(getApplicationContext(), dayList);
                 
           
        gridView.setAdapter(gridAdapter);
               
    }//-change first-I make new branch,and I change return.
                 
                 
    private void setCalendarDate(int month)
    {
        int i;
        mCal.set(Calendar.MONTH, month-1);
       
        for (i=0; i<mCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++)
        {
            dayList.add("" + (i+1));
        }
        //------------------------
        Date date = new Date();
        date.setYear(year);
        date.setMonth(month);
        date.setDate(1);
        firstDay = date.getDay();
        
        toDays = 31;
        for (int i = 29; i<=32; i++)
        {    
            date.setDate(i);
            if (date.getDate() == 1)
            {
                totDays = i -1;
                break;
            }
        }
        
    }
    
    private class GridAdapter extends BaseAdapter {
        
        private final List<String> list;
        
        private final LayoutInflater inflater;
        
        public GridAdapter (Context context, List<String> list)
        {    
            this.list = list;
            
            this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }     
        
        @Override
        public int getCount(){
            return list.size();
        }
             
        @Override
        public void setCount(int c){
            this.count = c;
        }
        
        @Override
        public String getItem(int position){
            return list.get(position);
        }
            
        @Override
        public long getItemId(int position){
            return position;
        }
            
        @Override
            public View getView(int position, View convertView, ViewGroup parent){//getview
                ViewHolder holder = null; //create ViewHolder
                if (convertView == null){              
                    convertView = inflater.inflate(R.layout.activity_main, parent, false);
                    holder = new ViewHolder();
                   
                    holder.tvItemGridView = (TextView)convertView.findViewById(R.id.tv_date);
                    
                    convertView.setTag(holder);
                }
                else {
                    holder = (ViewHolder)convertView.getTag();
                }
                
                holder.tvItemGridView.setText("" + getItem(position));
                mCal = Calendar.getInstance();
                Integer today = mCal.get(Caledanr.DAY_OF_MONTH);
                String sToday = String.valueOf(today);
                
                if(sToday.equals(getItem(position))){
                    holder.tvItemGridView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                }
                
                return convertView;
            }
        }
        private class ViewHolder{
            TextView tvItemGridView;
        }
                
//debugging..
}
