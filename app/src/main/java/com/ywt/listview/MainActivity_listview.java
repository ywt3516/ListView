package com.ywt.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ywt on 2018/5/25.
 */

public class MainActivity_listview extends AppCompatActivity {
    private List<Item> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initList();

        ItemAdapter itemAdapter = new ItemAdapter(MainActivity_listview.this, R.layout.listview, list);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(itemAdapter);

        // 短暂点击
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = list.get(position);
                Toast.makeText(MainActivity_listview.this, "click " + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        // 长按点击
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = list.get(position);
                Toast.makeText(MainActivity_listview.this, "long click " + item.getName(), Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }

    private void initList() {
        for (int i = 0; i < 100; i++) {
            Item item = new Item("Item " + i, R.mipmap.ic_launcher);
            list.add(item);
        }
    }

}
