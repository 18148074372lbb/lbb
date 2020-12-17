package com.lbb.xiyu.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lbb.xiyu.db.DBOpenHelper;
import com.lbb.xiyu.model.Student;

public class StudentDao {
    private DBOpenHelper dbOpenHelper;
    private SQLiteDatabase db;
    public StudentDao(Context context){//context=LoginActivity
        dbOpenHelper=new DBOpenHelper(context);//实例化一个对象
    }
    public boolean login(String s_id,String password){
//        boolean loginflag=false;
        db=dbOpenHelper.getReadableDatabase();//初始化SQLiteDatabase//getWritableDatabase
        Cursor cursor = db.rawQuery("select * from student where s_id='" + s_id + "' and s_password='" + password + "'", null);
        if (cursor.moveToNext()){
            cursor.close();
            db.close();
            return  true;
        }
        cursor.close();
        db.close();
        return  false;
    }

    public Student findUserById(String id ) {
        Student student=new Student();
        db=dbOpenHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from student where s_id='" + id +"'",null);

        if(cursor.moveToNext()){
            student.setS_id(cursor.getString(cursor.getColumnIndex("s_id")));
            student.setPassword(cursor.getString(cursor.getColumnIndex("s_password")));
            student.setS_name(cursor.getString(cursor.getColumnIndex("s_name")));
            student.setS_grade(cursor.getString(cursor.getColumnIndex("s_grade")));
            student.setS_class(cursor.getString(cursor.getColumnIndex("s_class")));
            student.setS_spec(cursor.getString(cursor.getColumnIndex("s_spec")));
            student.setSex(cursor.getString(cursor.getColumnIndex("s_sex")));
            student.setS_picture(cursor.getString(cursor.getColumnIndex("s_picture")));
            return student;
        }
        return null;
    }
}
