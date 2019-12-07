package com.example.chousnthere_it;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_other(View view){
        Intent intent =new Intent(this, other.class);
        startActivity(intent);
    }

    public void onClick_classroom(View view){
        Intent intent=new Intent(this, Classroom.class);
        startActivity(intent);
    }

    public void onClick_univ(View view) {
        Intent intent=new Intent(this, UnivListActivity.class);
        startActivity(intent);
    }

    public void onClick_prof(View view) {
        Intent intent=new Intent(this, ProfActivity.class);
        startActivity(intent);
    }

    public void onClick_map(View view) {
        Intent intent=new Intent(this, UnivMapActivity.class);
        startActivity(intent);
    }
    public static String getSigneture(Context context){
        PackageManager pm = context.getPackageManager();
        try{
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);

            for(int i = 0; i < packageInfo.signatures.length; i++){
                Signature signature = packageInfo.signatures[i];
                try {
                    MessageDigest md = MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
                    return Base64.encodeToString(md.digest(), Base64.NO_WRAP);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }

            }

        }catch(PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

}
