import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import android.util.Log;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.view.ViewGroup.LayoutParams;




public class MainActivity extends ActionBarActivity {

    private TextView tvDate;
    // GridView Adapter
    private GridAdapter gridAdapter;
    // Save List
    private ArrayList<String> dayList;
    //GridView
    private GridView gridView;
    //Calender variable
    private Calendar mCal;
    private TextView tvDater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        startActivity(new Intent(this,LoadingActivity.class));

        setContentView(R.layout.activity_main);

        tvDater = (TextView)findViewById(R.id.tv_dater);
        gridView = (GridView)findViewById(R.id.gridview);
        //Set today's month and days.
        long now = System.currentTimeMillis();

        //지금 달 보여주는 달력 가져오기
        final Date date = new Date(now);
        //Each save year,month,days
        final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy",Locale.KOREA);
        final SimpleDateFormat curMonthFormat = new SimpleDateFormat("MM",Locale.KOREA);
        final SimpleDateFormat curDayFormat = new SimpleDateFormat("dd",Locale.KOREA);

        tvDater.setText("               "+curYearFormat.format(date) + "." + curMonthFormat.format(date) + "                 ");
        dayList = new ArrayList<String>();
        dayList.add("SUN");
        dayList.add("MON");
        dayList.add("TUE");
        dayList.add("WED");
        dayList.add("THU");
        dayList.add("FRI");
        dayList.add("SAT");


        mCal = Calendar.getInstance();

        mCal.set(Integer.parseInt(curYearFormat.format(date)), Integer.parseInt(curMonthFormat.format(date)) -1, Integer.parseInt(curDayFormat.format(date))-2);

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
        public int getCount() {
            return list.size();
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

            ViewHolder holder = null;

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

            Integer today = mCal.get(Calendar.DAY_OF_MONTH);

            String sToday = String.valueOf(today);

            if (sToday.equals(getItem(position))){

                holder.tvItemGridView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }

            return convertView;
        }
    }
    private class ViewHolder{
        TextView tvItemGridView;
    }

//Again.
