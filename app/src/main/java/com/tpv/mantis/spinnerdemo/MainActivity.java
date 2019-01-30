package com.tpv.mantis.spinnerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String APP_LOGO = "appLogo";
    private static final String APP_NAME = "appName";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
         * SimpleAdapter是一个简单的适配器，映射静态的XML格式的布局文件到视图中。可以指定一个List<Map<P,T>>格式的数据，
         * List中的每一条数据对应一行，而Map中的每一条数据对应数据行的一列。这个数据用来映射到XML定义的布局控件中，对应关系
         * 通过构造函数的另外两个参数来指定，现在来介绍一下SimpleAdapter的构造函数。
         *
         * 　　SimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to)
         *
         *     context：上下文对象，没什么好说的，一般就是当前的Activity。
         *     data：上面介绍的List<Map<S,T>>类型的数据。
         *     resource：XML资源的Id，通过R对象选中。
         *     from：一个String类型数组，每条数据对应data数据中，Map结构定义的Key。
         *     to：一个int类型数组，对应XML资源中控件的ID，注意顺序必须与from中指定数据的顺序一致。
         */
        Spinner mSpinner = findViewById(R.id.mantisSpinner);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, getData(), R.layout.items,
                new String[]{APP_LOGO, APP_NAME}, new int[]{R.id.imageView, R.id.textView});

        mSpinner.setAdapter(simpleAdapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Map<String, Object> map = (Map<String, Object>) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, map.get(APP_NAME).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> contentList = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put(APP_LOGO, R.drawable.browser);
        map1.put(APP_NAME, "Browser");
        contentList.add(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put(APP_LOGO, R.drawable.downloads);
        map2.put(APP_NAME, "Downloads");
        contentList.add(map2);
        Map<String, Object> map3 = new HashMap<>();
        map3.put(APP_LOGO, R.drawable.gallery);
        map3.put(APP_NAME, "Gallery");
        contentList.add(map3);
        Map<String, Object> map4 = new HashMap<>();
        map4.put(APP_LOGO, R.drawable.messages);
        map4.put(APP_NAME, "Messages");
        contentList.add(map4);
        Map<String, Object> map5 = new HashMap<>();
        map5.put(APP_LOGO, R.drawable.phone);
        map5.put(APP_NAME, "Phone");
        contentList.add(map5);
        Map<String, Object> map6 = new HashMap<>();
        map6.put(APP_LOGO, R.drawable.radio);
        map6.put(APP_NAME, "Radio");
        contentList.add(map6);
        Map<String, Object> map7 = new HashMap<>();
        map7.put(APP_LOGO, R.drawable.recorder);
        map7.put(APP_NAME, "Recorder");
        contentList.add(map7);
        return contentList;
    }
}
