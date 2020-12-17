package com.lbb.xiyu.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {
    final static String DBNAME="express_db.db";
    final static int VERSION=1;
    public DBOpenHelper(@Nullable Context context) {//创建数据库，context=LoginActivity
        super(context, DBNAME,  null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建学生表
        db.execSQL("create table student(" +
                "'s_id' char(12) not null," +/*学生学号*/
                "'s_name' varchar(20),"+/*学生姓名*/
                "'s_password' varchar(20) not null," +/*学生密码*/
                "'s_grade' varchar(40)," +/*学生年级*/
                "'s_class' varchar(20),"+/*学生班级*/
                "'s_spec' varchar(20)," +/*学生专业*/
                "'s_sex' char(2)," +/*学生性别*/
                "'s_picture' varchar(200),"+/*学生头像*/
                "primary key('s_id'));");
//        预存三条数据
        db.execSQL("insert into student values('19302030219','隆彬彬','123456','2019级','安卓一班','软件技术','男','')");
        db.execSQL("insert into student values('19302030226','鲜子豪','123456','2019级','安卓一班','软件技术','男','')");
        db.execSQL("insert into student values('19302030230','雷坤','123456','2019级','安卓一班','软件技术','男','')");
        //创建洗澡间表
        db.execSQL("create table bathroom("+
                "'b_id' char(5) not null," +/*洗澡间号*/
                "'b_type' char (2) not null,"+/*洗澡间分类*/
                "'b_status' cahr(8) not null," +/*洗澡间状态*/
                "primary key('b_id'));");
//        预存两条数据
        db.execSQL("insert into bathroom values ('m001','男','空闲')");
        db.execSQL("insert into bathroom values ('w001','女','空闲')");

        //创建订单表
        db.execSQL("create table `order`(" +
                "'o_id' char(12) not null," +/*订单号*/
                "'s_id' char(12),"+/*学生学号*/
                "'b_id' char(5) not null," +/*洗澡间号*/
                "'o_starttime' datetime," +/*订单时间*/
                "'o_endtime' datetime,"+/*结算时间*/
                "'o_money' float," +/*订单金额*/
                "'o_status' char(8)," +/*订单状态*/
                "primary key('o_id'));");

        //创建消息表
        db.execSQL("create table inform(" +
                "'i_id' char(12) not null," +/*消息编号*/
                "'s_id' char(12),"+/*学生学号*/
                "'b_id' char(5) not null," +/*洗澡间号*/
                "'i_time' datetime," +/*时间*/
                "'i_text' text,"+/*消息内容*/
                "primary key('i_id'));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
