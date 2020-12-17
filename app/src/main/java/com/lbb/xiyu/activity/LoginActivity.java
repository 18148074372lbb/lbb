package com.lbb.xiyu.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lbb.xiyu.R;
import com.lbb.xiyu.dao.StudentDao;
import com.lbb.xiyu.model.Student;

public class LoginActivity extends AppCompatActivity {
    private EditText id_et, password_et;
    Button login_bt;
    TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id_et = findViewById(R.id.id);
        password_et = findViewById(R.id.password);
        login_bt = findViewById(R.id.login);
        register = findViewById(R.id.register);

        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentDao studentdao = new StudentDao(LoginActivity.this);//实例化一个对象
                String id = id_et.getText().toString();
                String password = password_et.getText().toString();
                if (id == null || id.equals("")) {
                    Toast.makeText(LoginActivity.this, "登录用户名不能为空！", Toast.LENGTH_LONG).show();
                } else if (password == null || password.equals("")) {
                    Toast.makeText(LoginActivity.this, "登录密码不能为空！", Toast.LENGTH_LONG).show();
                }

                Student student = studentdao.findUserById(id);
                if (student == null) {
                    Toast.makeText(LoginActivity.this, "该用户不存在！", Toast.LENGTH_LONG).show();

                } else {
                    if (studentdao.login(id,password)){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                        builder.setTitle("登录提示信息");
                        builder.setMessage("密码错误，登录失败！");
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.show();
                        //Toast.makeText(LoginActivity.this, "密码错误，登陆失败！", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }
}