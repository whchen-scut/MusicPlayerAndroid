package com.william.RDC.musicplayer.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final String CREATE_SONGS =
            "create table SONGS ("
            + "id integer primary key autoincrement, "
            + "title text, "//歌名
            + "artist text, "//歌手
            + "duration integer,"//时长
            + "dataPath text, "//文件路径
            + "listId integer,"//在DisplayActivity 的listView中的位置
            + "isLove text)";//是否是喜爱的歌曲
    private Context mContext;
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SONGS);//建表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


}
