package com.muhammedmercan.ykshelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class showResultOfSearchActivity extends AppCompatActivity {

    private RecyclerView departmentRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result_of_search);

        departmentRecycler = findViewById(R.id.departmentRecycler);

        //TODO düzelt
        Database vt = new Database(this);

        Intent intent = getIntent();
        String queryString = intent.getStringExtra("queryString");

        ArrayList<Department> data = vt.GetAllData(queryString);

        DepartmentRecyclerAdapter adapter = new DepartmentRecyclerAdapter(data,this);
        adapter.setDepartments(data);

        departmentRecycler.setAdapter(adapter);
        departmentRecycler.setLayoutManager(new LinearLayoutManager(this));


    }
}