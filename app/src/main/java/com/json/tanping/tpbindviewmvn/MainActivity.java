package com.json.tanping.tpbindviewmvn;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DemoBean>  beans = new ArrayList<>();
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        //限制
        LinearLayoutManager manager = new LinearLayoutManager(this) ;
        recyclerView.setLayoutManager(manager);
        testData();
        DemoAdapter adapter = new DemoAdapter(beans);


        recyclerView.setAdapter(adapter);

    }
    public void testData(){
        for (int i=0;i<30;i++){
            DemoBean bean = new DemoBean();
//            bean.type = i%3;
            bean.value = new OKBean();

//            if (i%2==0) bean.type =TYPE_ITEM;
            beans.add(bean);
        }
    }
}
