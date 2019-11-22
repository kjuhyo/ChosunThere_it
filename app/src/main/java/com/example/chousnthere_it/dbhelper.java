package com.example.chousnthere_it;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class dbhelper extends SQLiteOpenHelper {

    String TAG="dbhelper"; //Logcat에 출력할 태그 이름

    //assets 폴더 안에 생성된 db파일
    String DB_PATH=""; //assets폴더에 db파일 생성할 것이므로 빈칸으로 둔다("")
    String DB_NAME="syjh.db";

    SQLiteDatabase mDataBase;
    Context mcontext;

    public dbhelper(Context context){
        super(context, "SYJHdb.db", null, 1);
        if(Build.VERSION.SDK_INT>=17){
            DB_PATH=context.getApplicationInfo().dataDir+"/databases/";
        }
        else{
            DB_PATH="/data/data/"+context.getPackageName()+"/databases/";
        }
        this.mcontext=context;
    }

    public void createDataBase() throws IOException{

        //asset폴더에서 복사해온다
        boolean mDataBaseExist=checkDataBase();
        if(!mDataBaseExist){
            this.getReadableDatabase();
            this.close();
            try{
                copyDataBase();
                Log.e(TAG, "assetsDB database created");
            }
            catch (IOException mIOException){
                throw new Error("ErrorCopyingDB");
            }
        }
    }

    //경로에 db존재하는지 확인하는 메소드
    boolean checkDataBase(){
        File dbFile=new File(DB_PATH+DB_NAME);
        return dbFile.exists();
    }

    //assets 폴더에서 데이터베이스를 복사
    private void copyDataBase() throws IOException{
        InputStream mInput=mcontext.getAssets().open(DB_NAME);
        String outFileName=DB_PATH+DB_NAME;
        OutputStream mOutput=new FileOutputStream(outFileName);
        byte[] mBuffer=new byte[1024];
        int mLength;
        while ((mLength=mInput.read(mBuffer))>0){
            mOutput.write(mBuffer,0,mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    //db열어서 쿼리를 쓸수있게 하는 메소드
    boolean openDataBase() throws SQLException{
        String mPath=DB_PATH+DB_NAME;
        mDataBase=SQLiteDatabase.openDatabase(mPath,null,SQLiteDatabase.CREATE_IF_NECESSARY);
        return mDataBase!=null;
    }

    @Override
    public synchronized void close(){
        if(mDataBase!=null){
            mDataBase.close();
        }
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db){

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){

    }
}
