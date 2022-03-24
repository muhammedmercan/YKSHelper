package com.muhammedmercan.ykshelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowDetailOfDepartment extends AppCompatActivity {

    private TextView name, department, faculty, city, educationTime, typeOfUniversity, typeOfPoint, point2021,
            point2020, point2019, point2018,point2017,point2016,point2015, placementRanking2021,placementRanking2020,placementRanking2019,
            placementRanking2018,placementRanking2017,quota2021,placementRanking2016,placementRanking2015, quota2020, quota2019, quota2018,
            quota2017,quota2016,quota2015,winner2021, winner2020,winner2019,winner2018, additionalInfo;

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
        additionalInfo = findViewById(R.id.txtAdditionalInfo);
        city = findViewById(R.id.showDetailOfDepartment_txtCity);
        educationTime = findViewById(R.id.txtEducationTime);
        typeOfUniversity = findViewById(R.id.txtTypeOfUniversity);
        typeOfPoint = findViewById(R.id.txtTypeOfPoint);
        point2021 = findViewById(R.id.txtPoint2021);
        point2020 = findViewById(R.id.txtPoint2020);
        point2019 = findViewById(R.id.txtPoint2019);
        point2018 = findViewById(R.id.txtPoint2018);
        point2017 = findViewById(R.id.txtPoint2017);
        point2016 = findViewById(R.id.txtPoint2016);
        point2015 = findViewById(R.id.txtPoint2015);
        placementRanking2021 = findViewById(R.id.txtPlacementRanking2021);
        placementRanking2020 = findViewById(R.id.txtPlacementRanking2020);
        placementRanking2019 = findViewById(R.id.txtPlacementRanking2019);
        placementRanking2018 = findViewById(R.id.txtPlacementRanking2018);
        placementRanking2017 = findViewById(R.id.txtPlacementRanking2017);
        placementRanking2016 = findViewById(R.id.txtPlacementRanking2016);
        placementRanking2015 = findViewById(R.id.txtPlacementRanking2015);
        quota2021 = findViewById(R.id.txtQuota2021);
        quota2020 = findViewById(R.id.txtQuota2020);
        quota2019 = findViewById(R.id.txtQuota2019);
        quota2018 = findViewById(R.id.txtQuota2018);
        quota2017 = findViewById(R.id.txtQuota2017);
        quota2016 = findViewById(R.id.txtQuota2016);
        quota2015 = findViewById(R.id.txtQuota2015);
        winner2021 = findViewById(R.id.txtWinner2021);
        winner2020 = findViewById(R.id.txtWinner2020);
        winner2019 = findViewById(R.id.txtWinner2019);
        winner2018 = findViewById(R.id.txtWinner2018);


    }

    private void setData() {

        name.setText(data.get(0).getUniversity());
        department.setText(data.get(0).getDepartment());
        faculty.setText(data.get(0).getFaculty());
        additionalInfo.setText(data.get(0).getAdditionalInfo());
        city.setText(data.get(0).getCity());
        educationTime.setText(data.get(0).getEducationTime());
        typeOfUniversity.setText(data.get(0).getTypeOfUniversity());
        typeOfPoint.setText(data.get(0).getTypeOfPoint());
        point2021.setText(data.get(0).getPlacementPoint2021());
        point2020.setText(data.get(0).getPlacementPoint2020());
        point2019.setText(data.get(0).getPlacementPoint2019());
        point2018.setText(data.get(0).getPlacementPoint2018());
        point2017.setText(data.get(0).getPlacementPoint2017());
        point2016.setText(data.get(0).getPlacementPoint2016());
        point2015.setText(data.get(0).getPlacementPoint2015());
        placementRanking2021.setText(String.valueOf(data.get(0).getPlacementRanking2021()));
        placementRanking2020.setText(String.valueOf(data.get(0).getPlacementRanking2020()));
        placementRanking2019.setText(String.valueOf(data.get(0).getPlacementRanking2019()));
        placementRanking2018.setText(String.valueOf(data.get(0).getPlacementRanking2018()));
        placementRanking2017.setText(String.valueOf(data.get(0).getPlacementRanking2017()));
        placementRanking2016.setText(String.valueOf(data.get(0).getPlacementRanking2016()));
        placementRanking2015.setText(String.valueOf(data.get(0).getPlacementRanking2015()));
        quota2021.setText(data.get(0).getQuota2021());
        quota2020.setText(data.get(0).getQuota2020());
        quota2019.setText(data.get(0).getQuota2019());
        quota2018.setText(data.get(0).getQuota2018());
        quota2017.setText(data.get(0).getQuota2017());
        quota2016.setText(data.get(0).getQuota2016());
        quota2015.setText(data.get(0).getQuota2015());
        winner2021.setText(data.get(0).getWinner2021());
        winner2020.setText(data.get(0).getWinner2020());
        winner2019.setText(data.get(0).getWinner2019());
        winner2018.setText(data.get(0).getWinner2018());


    }
}