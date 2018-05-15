package planner.venue.venue;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    //Developed by Charlie Wall

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users.db";
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_USERID = "userid";
    private static final String COLUMN_FIRSTNAME = "firstname";
    private static final String COLUMN_LASTNAME = "lastname";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    SQLiteDatabase database;

    private static final String TABLE_CREATE = String.format("create table users (userid integer primary key not null, firstname text not null, lastname text not null, username text not null, password text not null);");

    public Database(Context Contxt){
        super(Contxt, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.database = db;
    }

    public void insertContact(UserDetails uDetails){
        database = this.getWritableDatabase();

        ContentValues val = new ContentValues();

        String quer = "select * from users";
        Cursor cursr = database.rawQuery(quer, null);
        int count = cursr.getCount();

        val.put(COLUMN_USERID, count);
        val.put(COLUMN_FIRSTNAME, uDetails.getfName());
        val.put(COLUMN_LASTNAME, uDetails.getlName());
        val.put(COLUMN_USERNAME, uDetails.getusrName());
        val.put(COLUMN_PASSWORD, uDetails.getPswrd());

        database.insert(TABLE_NAME, null, val);
        database.close();
    }

    public String searchPass(String uName){
        database = this.getReadableDatabase();
        String Q = "select username, password from " + TABLE_NAME;
        Cursor Curs = database.rawQuery(Q, null);

        String uN;
        String pW;

        pW = "Not found";

        if(Curs.moveToFirst()){
            do {
                uN = Curs.getString(0);


                if(uN.equals(uName)){
                    pW = Curs.getString(1);
                    break;
                }
            }
            while(Curs.moveToNext());

        }

        return pW;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String Query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        database.execSQL(Query);
        this.onCreate(database);
    }
}
