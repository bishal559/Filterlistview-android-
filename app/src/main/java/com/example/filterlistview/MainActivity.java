package com.example.filterlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import com.example.filterlistview.ListAdapter.ListviewAdatper;
import com.example.filterlistview.Model.ListviewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText search;
    ListView listview;
    List<ListviewModel>models=new ArrayList<>();
    ListviewAdatper adatper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=(ListView)findViewById(R.id.listview);
        search=(EditText)findViewById(R.id.search);
        models.add(new ListviewModel(1,"test1","Chowmein","Vegetarian","C Momo  vert testy"));
        models.add(new ListviewModel(2,"test2","C MOMO","Buff","Chowmein  vert testy"));
        models.add(new ListviewModel(3,"test1","Chowmein","Vegetarian","C Momo  vert testy"));
        models.add(new ListviewModel(4,"test2","C MOMO","Buff","Chowmein  vert testy"));
        adatper=new ListviewAdatper(getApplicationContext(),models);
        listview.setAdapter(adatper);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adatper.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}