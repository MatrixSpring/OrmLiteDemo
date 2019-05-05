package com.dawn.applicationdb;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dawn.applicationdb.bean.Student;
import com.dawn.applicationdb.dbioc.DaoSupportFactory;
import com.dawn.applicationdb.dbioc.IDaoSupport;
import com.dawn.applicationdb.permission.PermissionListener;
import com.dawn.applicationdb.permission.PermissionUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv_onclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_onclick = findViewById(R.id.tv_onclick);
        tv_onclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testDB();
                Toast.makeText(MainActivity.this,  "点击数据库！", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void testDB(){
        PermissionUtil permissionUtil = new PermissionUtil(MainActivity.this);
        permissionUtil.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, new PermissionListener() {
            @Override
            public void onGranted() {
                testDBUtils();
            }

            @Override
            public void onDenied(List<String> deniedPermission) {

            }

            @Override
            public void onShouldShowRationale(List<String> deniedPermission) {

            }
        });
    }

    public void testDBUtils(){
        IDaoSupport<Student> dao = DaoSupportFactory.getInstance(MainActivity.this).getDao(Student.class);
        List<Student> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            persons.add(new Student("在线", 18 + i));
        }
        dao.insert(persons);
        List<Student> list = dao.querySupport().queryAll();
        Toast.makeText(MainActivity.this, list.size() + "", Toast.LENGTH_SHORT).show();
    }
}
