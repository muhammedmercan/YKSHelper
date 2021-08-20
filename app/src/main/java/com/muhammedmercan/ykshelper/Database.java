package com.muhammedmercan.ykshelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "universities";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_DEPARTMENTS = "departments";
    private static final String ROW_ID = "id";
    private static final String ROW_UNIVERSITY = "university";
    private static final String ROW_FACULTY = "faculty";
    private static final String ROW_DEPARTMENT = "department";
    private static final String ROW_LANGUAGE = "language";
    private static final String ROW_ADDITIONALINFO = "additional_info";
    private static final String ROW_EDUCATİONTİME = "education_time";
    private static final String ROW_CITY = "city";
    private static final String ROW_TYPEOFPOINT = "type_of_point";
    private static final String ROW_TYPEOFUNIVERSTY = "type_of_university";
    private static final String ROW_TYPEOFDEPARTMENT = "type_of_department";
    private static final String ROW_TYPEOFDEPARTMENT2 = "type_of_department2";
    private static final String ROW_QUOTA2018 = "quota2018";
    private static final String ROW_QUOTA2019 = "quota2019";
    private static final String ROW_QUOTA2020 = "quota2020";
    private static final String ROW_QUOTA2021 = "quota2021";
    private static final String ROW_STATUS = "status";
    private static final String ROW_WINNER2018 = "winner2018";
    private static final String ROW_WINNER2019 = "winner2019";
    private static final String ROW_WINNER2020 = "winner2020";
    private static final String ROW_WINNER2021 = "winner2021";
    private static final String ROW_PLACEMENTRANKING2018 = "placement_ranking2018";
    private static final String ROW_PLACEMENTRANKING2019 = "placement_ranking2019";
    private static final String ROW_PLACEMENTRANKING2020 = "placement_ranking2020";
    private static final String ROW_PLACEMENTRANKING2021 = "placement_ranking2021";
    private static final String ROW_PLACEMENTPOINT2018 = "placement_point2018";
    private static final String ROW_PLACEMENTPOINT2019 = "placement_point2019";
    private static final String ROW_PLACEMENTPOINT2020 = "placement_point2020";
    private static final String ROW_PLACEMENTPOINT2021 = "placement_point2021";

    private static final String TABLE_RANKINGS = "rankings";
    private static final String ROW_TYPEOFRANKINGS = "type_of_rankings";
    private static final String ROW_POINT = "point";
    private static final String ROW_TYT = "tyt";
    private static final String ROW_SAYİSAL = "sayisal";
    private static final String ROW_ESİTAGİRLİK = "esit_agirlik";
    private static final String ROW_SOZEL = "sozel";
    private static final String ROW_DIL = "dil";

    private String nameOfTable;









    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String table = ("CREATE TABLE " + TABLE_DEPARTMENTS + "("
                + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_UNIVERSITY + " TEXT NOT NULL, "
                + ROW_FACULTY + " TEXT NOT NULL, "
                + ROW_DEPARTMENT + " TEXT NOT NULL, "
                + ROW_LANGUAGE + " TEXT NOT NULL, "
                + ROW_TYPEOFPOINT + " TEXT NOT NULL, "
                + ROW_ADDITIONALINFO + " TEXT DEFAULT '', "
                + ROW_EDUCATİONTİME + " TEXT DEFAULT '', "
                + ROW_CITY + " TEXT NOT NULL, "
                + ROW_TYPEOFUNIVERSTY + " TEXT NOT NULL, "
                + ROW_TYPEOFDEPARTMENT + " TEXT NOT NULL, "
                + ROW_TYPEOFDEPARTMENT2 + " TEXT NOT NULL, "
                + ROW_QUOTA2021 + " TEXT NOT NULL, "
                + ROW_QUOTA2020 + " TEXT NOT NULL, "
                + ROW_QUOTA2019 + " TEXT NOT NULL, "
                + ROW_QUOTA2018 + " TEXT NOT NULL, "
                + ROW_STATUS + " TEXT NOT NULL, "
                + ROW_WINNER2021 + " TEXT NOT NULL, "
                + ROW_WINNER2020 + " TEXT NOT NULL, "
                + ROW_WINNER2019 + " TEXT NOT NULL, "
                + ROW_WINNER2018 + " TEXT NOT NULL, "
                + ROW_PLACEMENTRANKING2021 + " INTEGER NOT NULL, "
                + ROW_PLACEMENTRANKING2020 + " INTEGER NOT NULL, "
                + ROW_PLACEMENTRANKING2019 + " INTEGER NOT NULL, "
                + ROW_PLACEMENTRANKING2018 + " INTEGER NOT NULL, "
                + ROW_PLACEMENTPOINT2021 + " TEXT NOT NULL, "
                + ROW_PLACEMENTPOINT2020 + " TEXT NOT NULL, "
                + ROW_PLACEMENTPOINT2019 + " TEXT NOT NULL, "
                + ROW_PLACEMENTPOINT2018 + " TEXT NOT NULL)");


            String table2 = ("CREATE TABLE " + TABLE_RANKINGS + "("
                    + ROW_TYPEOFRANKINGS + " TEXT NOT NULL, "
                    + ROW_POINT + " INTEGER NOT NULL, "
                    + ROW_TYT + " INTEGER NOT NULL, "
                    + ROW_SAYİSAL + " INTEGER NOT NULL, "
                    + ROW_ESİTAGİRLİK + " INTEGER NOT NULL, "
                    + ROW_SOZEL + " INTEGER NOT NULL, "
                    + ROW_DIL + " INTEGER NOT NULL)");

        db.execSQL(table);
        db.execSQL(table2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEPARTMENTS);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RANKINGS);
        onCreate(db);

    }

    public void AddDataToRankings(String typeOfRankings, int point, int tyt, int sayisal, int esitAgirlik, int sozel, int dil) {

        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_TYPEOFRANKINGS,typeOfRankings);
            cv.put(ROW_POINT,point);
            cv.put(ROW_TYT, tyt);
            cv.put(ROW_SAYİSAL, sayisal);
            cv.put(ROW_ESİTAGİRLİK, esitAgirlik);
            cv.put(ROW_SOZEL, sozel);
            cv.put(ROW_DIL, dil);

            db.insert(TABLE_RANKINGS, null,cv);
        }catch (Exception e){
        }
        db.close();

    }

    public String GetAllDataFromRankings(String queryString){
        SQLiteDatabase db = this.getReadableDatabase();


        //TODO SAYISAL, EŞİTAĞIRLIK gibi verileri çekmeyi ayarla

            Cursor cursor = db.rawQuery(queryString, null);
            cursor.moveToNext();
            String data = cursor.getString(2);

            db.close();

            return data;
    }

    public void AddData(String typeOfPoint, String university, String faculty, String department, String language, String additionalInfo, String educationTime, String city, String typeOfUniversity, String typeOfDepartment,
                        String typeOfDepartment2, String quota2020, String quota2019, String quota2018, String quota2017, String status, String winner2020,
                        String winner2019, String winner2018, String winner2017, int placementRanking2020, int placementRanking2019,
                        int placementRanking2018, int placementRanking2017, String placementPoint2020, String placementPoint2019,
                        String placementPoint2018, String placementPoint2017){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_TYPEOFPOINT,typeOfPoint);
            cv.put(ROW_UNIVERSITY, university);
            cv.put(ROW_FACULTY, faculty);
            cv.put(ROW_DEPARTMENT, department);
            cv.put(ROW_LANGUAGE, language);
            cv.put(ROW_ADDITIONALINFO, additionalInfo);
            cv.put(ROW_EDUCATİONTİME, educationTime);
            cv.put(ROW_CITY, city);
            cv.put(ROW_TYPEOFUNIVERSTY, typeOfUniversity);
            cv.put(ROW_TYPEOFDEPARTMENT, typeOfDepartment);
            cv.put(ROW_TYPEOFDEPARTMENT2, typeOfDepartment2);
            cv.put(ROW_QUOTA2018, quota2017);
            cv.put(ROW_QUOTA2019, quota2018);
            cv.put(ROW_QUOTA2020, quota2019);
            cv.put(ROW_QUOTA2021, quota2020);
            cv.put(ROW_STATUS, status);
            cv.put(ROW_WINNER2018, winner2017);
            cv.put(ROW_WINNER2019, winner2018);
            cv.put(ROW_WINNER2020, winner2019);
            cv.put(ROW_WINNER2021, winner2020);
            cv.put(ROW_PLACEMENTRANKING2018, placementRanking2017);
            cv.put(ROW_PLACEMENTRANKING2019, placementRanking2018);
            cv.put(ROW_PLACEMENTRANKING2020, placementRanking2019);
            cv.put(ROW_PLACEMENTRANKING2021, placementRanking2020);
            cv.put(ROW_PLACEMENTPOINT2018, placementPoint2017);
            cv.put(ROW_PLACEMENTPOINT2019, placementPoint2018);
            cv.put(ROW_PLACEMENTPOINT2020, placementPoint2019);
            cv.put(ROW_PLACEMENTPOINT2021, placementPoint2020);
            db.insert(TABLE_DEPARTMENTS, null,cv);
        }catch (Exception e){
        }
        db.close();
    }

    public void AddData(String typeOfPoint, String university, String faculty, String department, String language, String educationTime, String city, String typeOfUniversity, String typeOfDepartment,
                        String typeOfDepartment2, String quota2020, String quota2019, String quota2018, String quota2017, String status, String winner2020,
                        String winner2019, String winner2018, String winner2017, int placementRanking2020, int placementRanking2019,
                        int placementRanking2018, int placementRanking2017, String placementPoint2020, String placementPoint2019,
                        String placementPoint2018, String placementPoint2017){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_TYPEOFPOINT,typeOfPoint);
            cv.put(ROW_UNIVERSITY, university);
            cv.put(ROW_FACULTY, faculty);
            cv.put(ROW_DEPARTMENT, department);
            cv.put(ROW_LANGUAGE, language);
            cv.put(ROW_EDUCATİONTİME, educationTime);
            cv.put(ROW_CITY, city);
            cv.put(ROW_TYPEOFUNIVERSTY, typeOfUniversity);
            cv.put(ROW_TYPEOFDEPARTMENT, typeOfDepartment);
            cv.put(ROW_TYPEOFDEPARTMENT2, typeOfDepartment2);
            cv.put(ROW_QUOTA2018, quota2017);
            cv.put(ROW_QUOTA2019, quota2018);
            cv.put(ROW_QUOTA2020, quota2019);
            cv.put(ROW_QUOTA2021, quota2020);
            cv.put(ROW_STATUS, status);
            cv.put(ROW_WINNER2018, winner2017);
            cv.put(ROW_WINNER2019, winner2018);
            cv.put(ROW_WINNER2020, winner2019);
            cv.put(ROW_WINNER2021, winner2020);
            cv.put(ROW_PLACEMENTRANKING2018, placementRanking2017);
            cv.put(ROW_PLACEMENTRANKING2019, placementRanking2018);
            cv.put(ROW_PLACEMENTRANKING2020, placementRanking2019);
            cv.put(ROW_PLACEMENTRANKING2021, placementRanking2020);
            cv.put(ROW_PLACEMENTPOINT2018, placementPoint2017);
            cv.put(ROW_PLACEMENTPOINT2019, placementPoint2018);
            cv.put(ROW_PLACEMENTPOINT2020, placementPoint2019);
            cv.put(ROW_PLACEMENTPOINT2021, placementPoint2020);
            db.insert(TABLE_DEPARTMENTS, null,cv);
        }catch (Exception e){
        }
        db.close();
    }


    public ArrayList<Department> GetAllData(String queryString){
        ArrayList<Department> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            if (queryString.equals("SELECT * FROM Departments WHERE (")) {
                queryString = "SELECT * FROM Departments";
            }
            queryString = queryString + " ORDER BY placementranking2020";
            System.out.println(queryString);
            Cursor cursor = db.rawQuery(queryString,null);
            while (cursor.moveToNext()){

                data.add(new Department(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),
                        cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),
                        cursor.getString(11),cursor.getString(12),cursor.getString(13),cursor.getString(14),cursor.getString(15),cursor.getString(16),
                        cursor.getString(17),cursor.getString(18),cursor.getInt(19),cursor.getInt(20),cursor.getInt(21),cursor.getInt(22),
                        cursor.getString(23),cursor.getString(24),cursor.getString(25),cursor.getString(26)));
            }
        }catch (Exception e){
        }
        db.close();
        return data;
    }
}
