package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "WIFI已断开", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Main2Activity.class);
                intent.putExtra("studentName", "王小明");
                intent.putExtra("age", "30");
                startActivity(intent);


            }
        });


        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult(intent2, 1);


            }
        });


        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog dialog;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("连接wifi");
                final EditText et = new EditText(MainActivity.this);
                et.setHint("请输入密码");
                et.setSingleLine(true);
                builder.setView(et);
                builder.setNegativeButton("取消", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String password = et.getText().toString();
                        if (password.equals("123456")) {
                            Toast.makeText(MainActivity.this, "连接成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }
        });

setFragmnet();
    }




    private void setFragmnet(){

        FragmentManager  fm2= getSupportFragmentManager();
        FragmentTransaction tx=fm2.beginTransaction();
        tx.add(R.id.fragmentceshi,new Fragmentceshi());
        tx.commit();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1&&resultCode == 2){
            String acquiredData= data.getStringExtra("data"); //获取回传的数据
            Toast.makeText(MainActivity.this,acquiredData,Toast.LENGTH_SHORT).show();
        }
    }

}


