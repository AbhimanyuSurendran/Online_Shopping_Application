package abhimanyu.online_shopping_application;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SQL_database extends SQLiteOpenHelper {
    private static final String TAG = "SQL_database";
    public SQL_database(@Nullable Context context) {
        super(context, "accounts", null, 21);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists account_information (name text,email text primary key, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists account_information");
        onCreate(db);
    }
    public void register(data data){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",data.getName());
        contentValues.put("email",data.getEmail());
        contentValues.put("password",data.getPassword());

        long account_information = sqLiteDatabase.insert("account_information",null,contentValues);
        Log.e(TAG, "register: "+account_information );
        if (account_information != -1){
            Log.e(TAG, "register: User Registered Successfully" );
        }else {
            Log.e(TAG, "register: Error in User Registeration" );
        }
    }
    public void login(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from account_information",null,null);
        while (cursor.moveToNext()){
            String email = cursor.getString(1);
            String password = cursor.getString(2);
            if (email.equals (data.getEmail()) && password.equals (data.getPassword())) {
                Log.e(TAG, "loginUser: User Login Successfully" );
                Intent intent = new Intent(login_Activity.this, products.class);
            }else {
                Log.e(TAG, "loginUser: error in login user");
            }
        }
    }
}
