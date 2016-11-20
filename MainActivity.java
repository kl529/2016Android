package com.example.kl529.calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import android.*;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    private TextView tvDate;
//    연,월 레이아웃 텍스트 뷰


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.activity_main);

        tvDate = (TextView)findViewById(android.R.id.tv_date);

        long now = System.currentTimeMillis();

        final Date date = new Date(now);

        final SimpleDateFormat nowYear = new SimpleDateFormat("yyyy",Locale.KOREA);
        final SimpleDateFormat nowMonth = new SimpleDateFormat("MM",Locale.KOREA);
        final SimpleDateFormat nowDay = new SimpleDateFormat("dd",Locale.KOREA);

        tvDate.setText(nowYear.format(date) + "/" + nowMonth.format(date));

    }

}
