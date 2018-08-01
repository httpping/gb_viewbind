package com.json.tanping.tpbindviewmvn;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tp.cache.CacheManager;

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


        CacheManager.init(this);
        String key = "xx";
        int value = 100;

        CacheManager.count();

        CacheManager.put(key,value,10);
        int a = 0;
        value = CacheManager.get(key,0);

        CacheManager.put("double",1.30d);
        double dd =  CacheManager.get("double");

         CacheManager.put("object",new OKBean());
        OKBean okBean =  CacheManager.get("object");

        CacheManager.put("list",beans);
        beans = CacheManager.get("list");
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
