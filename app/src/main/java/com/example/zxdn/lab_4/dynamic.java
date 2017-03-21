package com.example.zxdn.lab_4;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by zxdn on 2016/10/20.
 */
public class dynamic extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic);

        final Button dy_log=(Button)findViewById(R.id.dy_log);
        final Button dy_send=(Button)findViewById(R.id.dy_send);
        final EditText edit= (EditText)findViewById(R.id.edit);
        dy_log.setOnClickListener(new View.OnClickListener(){
            private dynamicReceiver dynamic= null;
            @Override
            public void onClick(View view) {

                if (dy_log.getText().toString().equals("Register Broadcast")) {
                    if (dynamic == null) {
                        dynamic= new dynamicReceiver();
                        IntentFilter dynamic_filter = new IntentFilter();
                        dynamic_filter.addAction("TheDynamic");
                        registerReceiver(dynamic, dynamic_filter);
                    }
                    dy_log.setText("Unregister  Broadcast");
                } else {
                        unregisterReceiver(dynamic);
                        dynamic=null;
                        dy_log.setText("Register Broadcast");

                }
            }
        });

        dy_send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String msa= edit.getText().toString();
                Intent intent = new Intent("TheDynamic");
                Bundle bundle= new Bundle();
                bundle.putString("massage",msa);
                intent.putExtras(bundle);
                sendBroadcast(intent);
            }
        });



    }
}
