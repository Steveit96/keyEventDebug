package com.steve.keycode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    TextView mtext_view,analog_val,txt_log;
    public static final int REQUEST_WRITE_STORAGE_REQUEST_CODE = 1000;
    Boolean write_successful = false;
    File root=null;
    ScrollView scroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtext_view=(TextView) findViewById(R.id.text_view);
        analog_val=(TextView) findViewById(R.id.analog_val);
        scroll=(ScrollView) findViewById(R.id.scroll);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        scroll.fullScroll(0);
        try {
            if(mtext_view.getText().equals("Press Any Keys")) {
                mtext_view.setText( "KeyCode : " + event.getKeyCode() + "   Scan Code :" + event.getScanCode()+"\n");
            }else
            {
                mtext_view.setText(mtext_view.getText() + "\n" + "KeyCode : " + event.getKeyCode() + "   Scan Code :" + event.getScanCode()+"\n");
            }
        }catch(Exception e)
        {
            Log.e("ERROR",e.getMessage());

        }
        Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                mtext_view.setText("");
            }
        };
        handler.postDelayed(r, 2500);
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public void onBackPressed() {

    }
    public String getMills()
    {
        long val=System.currentTimeMillis()/1000;
        String date = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date (val*1000));
        return date;
    }
}
