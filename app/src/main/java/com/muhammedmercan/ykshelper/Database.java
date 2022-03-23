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


    private static final String DATABASE_NAME = "universities2";
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


    private Context mContext;







    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String table = ("CREATE TABLE " + TABLE_DEPARTMENTS + "("
                + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_UNIVERSITY + " TEXT NOT NULL, "
                + ROW_FACULTY + " TEXT NOT NULL, "
                + ROW_DEPARTMENT + " TEXT NOT NULL, "
                + ROW_CITY + " TEXT  DEFAULT '---', "
                + ROW_LANGUAGE + " TEXT NOT NULL, "
                + ROW_TYPEOFPOINT + " TEXT NOT NULL, "
                + ROW_ADDITIONALINFO + " TEXT DEFAULT '---', "
                + ROW_EDUCATİONTİME + " TEXT DEFAULT '---', "
                + ROW_TYPEOFUNIVERSTY + " TEXT DEFAULT '---', "
                + ROW_TYPEOFDEPARTMENT + " TEXT DEFAULT '---', "
                + ROW_TYPEOFDEPARTMENT2 + " TEXT DEFAULT '---', "
                + ROW_QUOTA2021 + " TEXT DEFAULT '---', "
                + ROW_QUOTA2020 + " TEXT DEFAULT '---', "
                + ROW_QUOTA2019 + " TEXT DEFAULT '---', "
                + ROW_QUOTA2018 + " TEXT  DEFAULT '---',"
                + ROW_STATUS + " TEXT DEFAULT '', "
                + ROW_WINNER2021 + " TEXT DEFAULT '---', "
                + ROW_WINNER2020 + " TEXT DEFAULT '---', "
                + ROW_WINNER2019 + " TEXT DEFAULT '---' , "
                + ROW_WINNER2018 + " TEXT DEFAULT '---', "
                + ROW_PLACEMENTRANKING2021 + " INTEGER DEFAULT 0, "
                + ROW_PLACEMENTRANKING2020 + " INTEGER DEFAULT 0, "
                + ROW_PLACEMENTRANKING2019 + " INTEGER DEFAULT 0, "
                + ROW_PLACEMENTRANKING2018 + " INTEGER DEFAULT 0, "
                + ROW_PLACEMENTPOINT2021 + " TEXT DEFAULT '---', "
                + ROW_PLACEMENTPOINT2020 + " TEXT DEFAULT '---', "
                + ROW_PLACEMENTPOINT2019 + " TEXT DEFAULT '---', "
                + ROW_PLACEMENTPOINT2018 + " TEXT DEFAULT '---')");


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

    public String GetAllDataFromRankings(String queryString, String typeOfPoint){
        SQLiteDatabase db = this.getReadableDatabase();

        String data = "-- -- --";
        //TODO SAYISAL, EŞİTAĞIRLIK gibi verileri çekmeyi ayarla

        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {

            if (typeOfPoint.equals("tyt")) {

                data = cursor.getString(2);
            }
            else if (typeOfPoint.equals("sayisal")) {

                data = cursor.getString(3);
            }
            else if (typeOfPoint.equals("esit_agirlik")) {

                data = cursor.getString(4);
            }
            else if (typeOfPoint.equals("sozel")) {

                data = cursor.getString(5);
            }

            else if (typeOfPoint.equals("dil")) {

                data = cursor.getString(6);
            }

        }
        db.close();

        return data;
    }

    public void AddData(String typeOfPoint, String university, String faculty, String department, String language, String additionalInfo, String educationTime, String city, String typeOfUniversity, String typeOfDepartment,
                        String typeOfDepartment2, String quota2021, String quota2020, String quota2019, String quota2018, String status, String winner2021,
                        String winner2020, String winner2019, String winner2018, int placementRanking2021, int placementRanking2020,
                        int placementRanking2019, int placementRanking2018, String placementPoint2021, String placementPoint2020,
                        String placementPoint2019, String placementPoint2018){
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
            cv.put(ROW_QUOTA2018, quota2018);
            cv.put(ROW_QUOTA2019, quota2019);
            cv.put(ROW_QUOTA2020, quota2020);
            cv.put(ROW_QUOTA2021, quota2021);
            cv.put(ROW_STATUS, status);
            cv.put(ROW_WINNER2018, winner2018);
            cv.put(ROW_WINNER2019, winner2019);
            cv.put(ROW_WINNER2020, winner2020);
            cv.put(ROW_WINNER2021, winner2021);
            cv.put(ROW_PLACEMENTRANKING2018, placementRanking2018);
            cv.put(ROW_PLACEMENTRANKING2019, placementRanking2019);
            cv.put(ROW_PLACEMENTRANKING2020, placementRanking2020);
            cv.put(ROW_PLACEMENTRANKING2021, placementRanking2021);
            cv.put(ROW_PLACEMENTPOINT2018, placementPoint2018);
            cv.put(ROW_PLACEMENTPOINT2019, placementPoint2019);
            cv.put(ROW_PLACEMENTPOINT2020, placementPoint2020);
            cv.put(ROW_PLACEMENTPOINT2021, placementPoint2021);
            db.insert(TABLE_DEPARTMENTS, null,cv);
        }catch (Exception e){
        }
        db.close();
    }

    public void AddData(String typeOfPoint, String university, String faculty, String department, String language, String educationTime, String city, String typeOfUniversity, String typeOfDepartment,
                        String typeOfDepartment2, String quota2021, String quota2020, String quota2019, String quota2018, String status, String winner2021,
                        String winner2020, String winner2019, String winner2018, int placementRanking2021, int placementRanking2020,
                        int placementRanking2019, int placementRanking2018, String placementPoint2021, String placementPoint2020,
                        String placementPoint2019, String placementPoint2018){
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
            cv.put(ROW_QUOTA2018, quota2018);
            cv.put(ROW_QUOTA2019, quota2019);
            cv.put(ROW_QUOTA2020, quota2020);
            cv.put(ROW_QUOTA2021, quota2021);
            cv.put(ROW_STATUS, status);
            cv.put(ROW_WINNER2018, winner2018);
            cv.put(ROW_WINNER2019, winner2019);
            cv.put(ROW_WINNER2020, winner2020);
            cv.put(ROW_WINNER2021, winner2021);
            cv.put(ROW_PLACEMENTRANKING2018, placementRanking2018);
            cv.put(ROW_PLACEMENTRANKING2019, placementRanking2019);
            cv.put(ROW_PLACEMENTRANKING2020, placementRanking2020);
            cv.put(ROW_PLACEMENTRANKING2021, placementRanking2021);
            cv.put(ROW_PLACEMENTPOINT2018, placementPoint2018);
            cv.put(ROW_PLACEMENTPOINT2019, placementPoint2019);
            cv.put(ROW_PLACEMENTPOINT2020, placementPoint2020);
            cv.put(ROW_PLACEMENTPOINT2021, placementPoint2021);
            db.insert(TABLE_DEPARTMENTS, null,cv);
        }catch (Exception e){
        }
        db.close();
    }

    public void AddData(String typeOfPoint, String university, String faculty, String department, String language, String additionalInfo,  String educationTime, String city, String typeOfUniversity, String typeOfDepartment,
                        String typeOfDepartment2, String quota2021, String quota2020,  String winner2021,
                        String winner2020, String placementPoint2021, String placementPoint2020, int placementRanking2021, int placementRanking2020){
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
            cv.put(ROW_QUOTA2020, quota2020);
            cv.put(ROW_QUOTA2021, quota2021);
            cv.put(ROW_WINNER2020, winner2020);
            cv.put(ROW_WINNER2021, winner2021);
            cv.put(ROW_PLACEMENTRANKING2020, placementRanking2020);
            cv.put(ROW_PLACEMENTRANKING2021, placementRanking2021);
            cv.put(ROW_PLACEMENTPOINT2020, placementPoint2020);
            cv.put(ROW_PLACEMENTPOINT2021, placementPoint2021);
            db.insert(TABLE_DEPARTMENTS, null,cv);
        }catch (Exception e){
        }
        db.close();
    }

    public void AddData(String typeOfPoint, String university, String faculty, String department, String language, String educationTime, String city,
                        String typeOfUniversity, String typeOfDepartment, String typeOfDepartment2, String quota2021, String quota2020,
                        String winner2021, String winner2020, String placementPoint2021, String placementPoint2020, int placementRanking2021,
                        int placementRanking2020){
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
            cv.put(ROW_QUOTA2020, quota2020);
            cv.put(ROW_QUOTA2021, quota2021);
            cv.put(ROW_WINNER2020, winner2020);
            cv.put(ROW_WINNER2021, winner2021);
            cv.put(ROW_PLACEMENTRANKING2020, placementRanking2020);
            cv.put(ROW_PLACEMENTRANKING2021, placementRanking2021);
            cv.put(ROW_PLACEMENTPOINT2020, placementPoint2020);
            cv.put(ROW_PLACEMENTPOINT2021, placementPoint2021);
            db.insert(TABLE_DEPARTMENTS, null,cv);
        }catch (Exception e){
        }
        db.close();
    }



    public ArrayList<Department> GetAllData(String queryString){
        ArrayList<Department> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {


            System.out.println(queryString);
            Cursor cursor = db.rawQuery(queryString,null);
            while (cursor.moveToNext()){

                data.add(new Department(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4), cursor.getString(5),
                        cursor.getString(6), cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(11),
                        cursor.getString(12),cursor.getString(13),cursor.getString(14),cursor.getString(15),cursor.getString(16), cursor.getString(17),
                        cursor.getString(18),cursor.getString(19),cursor.getString(20),cursor.getString(21),cursor.getInt(22),
                        cursor.getInt(23),cursor.getInt(24),cursor.getInt(25),cursor.getInt(26),cursor.getInt(27),cursor.getInt(28),
                        cursor.getString(29),cursor.getString(30),cursor.getString(31),cursor.getString(32),cursor.getString(33),cursor.getString(34),
                        cursor.getString(35),cursor.getString(36),cursor.getString(37),cursor.getString(38),cursor.getString(39),cursor.getString(40),
                        cursor.getString(41),cursor.getString(42),cursor.getString(43),cursor.getString(44),cursor.getString(45),
                        cursor.getString(46),cursor.getString(47),cursor.getString(48),cursor.getString(49),cursor.getString(50),cursor.getString(51),
                        cursor.getString(52),cursor.getString(53),cursor.getString(54),cursor.getString(55),cursor.getString(56),cursor.getString(57),
                        cursor.getString(58),cursor.getString(59),cursor.getString(60),cursor.getString(61),cursor.getString(62),cursor.getString(63),
                        cursor.getString(64),cursor.getString(65),cursor.getString(66),cursor.getString(67),cursor.getString(68),cursor.getString(69),
                        cursor.getString(70),cursor.getString(71),cursor.getString(72),cursor.getString(73),cursor.getString(74),cursor.getString(75),
                        cursor.getString(76),cursor.getString(77),cursor.getString(78),cursor.getString(79),cursor.getString(80),cursor.getString(81),
                        cursor.getString(82),cursor.getString(83),cursor.getString(84),cursor.getString(85),cursor.getString(86),cursor.getString(87),
                        cursor.getString(88)));
            }
        }catch (Exception e){
        }
        db.close();
        return data;
    }
}