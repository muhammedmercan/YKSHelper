package com.muhammedmercan.ykshelper;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DB_PATH = "/data/data/com.muhammedmercan.ykshelper/databases/";
    private static final String DB_NAME = "universities2";
    private SQLiteDatabase sqLiteDatabase;
    private Context mContext;
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    /*
     * Eğer veritabanı yoksa kopyalayıp oluşturacak varsa hiçbir şey yapmayacak
     * metodumuz.
     */
    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();

        if (dbExist) {
            /*
             * Veritabanı daha önce mevcut o yüzden herhangi bir işlem yapmaya
             * gerek yok.
             */
        } else {
            /*
             * Veritabanı daha önce hiç oluşturulmamış o yüzden veritabanını
             * kopyala
             */
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {

                throw new Error("Veritabanı kopyalanamadı");

            }
        }

    }

    /*
     * Veritabanı daha önce oluşturulmuş mu oluşturulmamış mı bunu öğrenmek için
     * yazılan method.
     */
    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {

        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    /*
     * Veritabanını assets'ten alıp
     * "/data/data/com.gelecegiyazanlar.orneksozluk/databases/" altına
     * kopyalayacak metod
     */
    private void copyDataBase() throws IOException {
        InputStream myInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[102444];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }


            /*
     * Uygulama içinde kullanacağımız db örneği
     * */
    public SQLiteDatabase getDatabase(){
        return sqLiteDatabase;
    }

    /*
     * Veritabanını uygulamada kullanacağımız zaman açmak için gerekli
     * metod
     */
    public void openDataBase() throws SQLException {
        String myPath = DB_PATH + DB_NAME;
        sqLiteDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    /*
     * Veritabanını işimiz bittiğinde kapatmak için kullanacağımız metod
     */
    @Override
    public synchronized void close() {
        if (sqLiteDatabase != null)
            sqLiteDatabase.close();
        super.close();
    }

}