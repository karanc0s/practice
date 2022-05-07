package com.weather.recyclerview_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RV_Adapter.ClickListener {

    private RecyclerView mRecyclerView;
    private RV_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView_main);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);


        adapter = new RV_Adapter(getNUM(),this);

        mRecyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClick(int index) {
        Toast.makeText(this, "Item Clicked "+index, Toast.LENGTH_LONG).show();
    }
    ArrayList<String> getNUM() {
        ArrayList<String> num = new ArrayList<>();
        for(int i=0; i<50; i++){
            String str = "........."+i+"."+"  ->"+i+"";
            num.add(str);
        }
      return num;
    }
}