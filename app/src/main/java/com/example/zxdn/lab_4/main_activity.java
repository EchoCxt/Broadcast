package com.example.zxdn.lab_4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by zxdn on 2016/10/20.
 */
public class main_activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        final Button Static=(Button)findViewById(R.id.static_log);
        final Button Dynamic=(Button)findViewById(R.id.dynamic_log);

        Static.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setClass(main_activity.this, fruit_activity.class);
                startActivity(intent);
            }
        });

        Dynamic.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent intent= new Intent();
                        intent.setClass(main_activity.this, dynamic.class);
                        startActivity(intent);
                    }
                });
    }
}
