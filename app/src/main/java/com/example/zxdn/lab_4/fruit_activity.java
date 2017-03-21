package com.example.zxdn.lab_4;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zxdn on 2016/10/20.
 */
public class fruit_activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruit);
        final List<Map<String,Object>> data= new ArrayList<>();
        final String[] name=new String[]{"Apple", "Banana", "Cherry", "Coco", "Kiwi", "Orange",
                "Pear", "Strawberry", "Watermelon"};
        final int[] photo=new int[] {R.mipmap.apple, R.mipmap.banana, R.mipmap.cherry,
                R.mipmap.coco, R.mipmap.kiwi, R.mipmap.orange, R.mipmap.pear,
                R.mipmap.strawberry, R.mipmap.watermelon };
        for (int i= 0; i< 9; i++ ) {
            Map<String, Object> temp= new LinkedHashMap<>();
            temp.put("photo", photo[i]);
            temp.put("name", name[i]);
            data.add(temp);
        }
        ListView listview = (ListView) findViewById(R.id.fruit_list);
        final SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.first_item,
                new String[]{"photo", "name"}, new int[] {R.id.photo, R.id.name});
        listview.setAdapter(simpleAdapter);

        //静态注册事件
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent("Static");
                Bundle stabun= new Bundle();
                stabun.putString("name",data.get(i).get("name").toString());
                stabun.putInt("photo", data.get(i).get("photo").hashCode());
                intent.putExtras(stabun);
                sendBroadcast(intent);

            }
        });
    }
}
