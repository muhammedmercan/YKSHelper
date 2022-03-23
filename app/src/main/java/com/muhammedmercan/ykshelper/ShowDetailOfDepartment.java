package com.muhammedmercan.ykshelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowDetailOfDepartment extends AppCompatActivity {

    private TextView name, department, faculty, language, typeOfDepartment, typeOfDepartment2, city, educationTime, typeOfUniversity, typeOfPoint, point2021,
            point2020, point2019, point2018, placementRanking2021,placementRanking2020,placementRanking2019,placementRanking2018,quota2021,
            quota2020, quota2019, quota2018, winner2021, winner2020,winner2019,winner2018;

    private ArrayList<Department> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail_of_department);

        initView();

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);

        Database vt = new Database(this);
        data = vt.GetAllData("SELECT * FROM departments WHERE id == " + id);
        setData();
    }


    private void initView() {
        name = findViewById(R.id.showDetailOfDepartment_txtName);
        department = findViewById(R.id.showDetailOfDepartment_txtDepartment);
        faculty = findViewById(R.id.txtFaculty);
        language = findViewById(R.id.showDetailOfDepartment_txtLanguage);
        typeOfDepartment = findViewById(R.id.showDetailOfDepartment_txtTypeOfDepartment);
        typeOfDepartment2 = findViewById(R.id.showDetailOfDepartment_txtTypeOfDepartment2);
        city = findViewById(R.id.showDetailOfDepartment_txtCity);
        educationTime = findViewById(R.id.txtEducationTime);
        typeOfUniversity = findViewById(R.id.txtTypeOfUniversity);
        typeOfPoint = findViewById(R.id.txtTypeOfPoint);
        point2021 = findViewById(R.id.txtPoint2021);
        point2020 = findViewById(R.id.txtPoint2020);
        point2019 = findViewById(R.id.txtPoint2019);
        point2018 = findViewById(R.id.txtPoint2018);
        placementRanking2021 = findViewById(R.id.txtPlacementRanking2021);
        placementRanking2020 = findViewById(R.id.txtPlacementRanking2020);
        placementRanking2019 = findViewById(R.id.txtPlacementRanking2019);
        placementRanking2018 = findViewById(R.id.txtPlacementRanking2018);
        quota2021 = findViewById(R.id.txtQuota2021);
        quota2020 = findViewById(R.id.txtQuota2020);
        quota2019 = findViewById(R.id.txtQuota2019);
        quota2018 = findViewById(R.id.txtQuota2018);
        winner2021 = findViewById(R.id.txtWinner2021);
        winner2020 = findViewById(R.id.txtWinner2020);
        winner2019 = findViewById(R.id.txtWinner2019);
        winner2018 = findViewById(R.id.txtWinner2018);


    }

    private void setData() {

        name.setText(data.get(0).getUniversity());
        department.setText(data.get(0).getDepartment());
        faculty.setText(data.get(0).getFaculty());
        city.setText(data.get(0).getCity());
        educationTime.setText(data.get(0).getEducationTime());
        typeOfUniversity.setText(data.get(0).getTypeOfUniversity());
        typeOfPoint.setText(data.get(0).getTypeOfPoint());
        point2021.setText(data.get(0).getPlacementPoint2021());
        point2020.setText(data.get(0).getPlacementPoint2020());
        point2019.setText(data.get(0).getPlacementPoint2019());
        point2018.setText(data.get(0).getPlacementPoint2018());
        placementRanking2021.setText(String.valueOf(data.get(0).getPlacementRanking2021()));
        placementRanking2020.setText(String.valueOf(data.get(0).getPlacementRanking2020()));
        placementRanking2019.setText(String.valueOf(data.get(0).getPlacementRanking2019()));
        placementRanking2018.setText(String.valueOf(data.get(0).getPlacementRanking2018()));
        quota2021.setText(data.get(0).getQuota2021());
        quota2020.setText(data.get(0).getQuota2020());
        quota2019.setText(data.get(0).getQuota2019());
        quota2018.setText(data.get(0).getQuota2018());
        winner2021.setText(data.get(0).getWinner2021());
        winner2020.setText(data.get(0).getWinner2020());
        winner2019.setText(data.get(0).getWinner2019());
        winner2018.setText(data.get(0).getWinner2018());


    }
}