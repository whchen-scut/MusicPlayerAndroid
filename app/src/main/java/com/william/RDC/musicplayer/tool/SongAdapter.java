package com.william.RDC.musicplayer.tool;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import com.william.RDC.musicplayer.R;
import com.william.RDC.musicplayer.model.Song;

public class SongAdapter extends ArrayAdapter<Song> {
    private int resourceId;//用来放置布局文件的id

    //适配器的构造函数
    public SongAdapter(Context context, int textViewResourceId, List<Song> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    static class ViewHolder {

        ImageView songImage;

        TextView songName;

        TextView songAuthor;

    }

    //这个方法在每个子项被滚动到屏幕内的时候会被调用
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Song song = getItem(position); // 获取当前项的Song实例
        View view;//子项布局对象
        ViewHolder viewHolder;//内部类对象
        if (convertView == null) {//如果是第一次加载
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);//布局对象化
            viewHolder = new ViewHolder();

            //把布局文件里面的三个对象加载出来
            viewHolder.songImage = view.findViewById(R.id.song_image);
            viewHolder.songName = view.findViewById (R.id.title);
            viewHolder.songAuthor=view.findViewById(R.id.artist);
            view.setTag(viewHolder); // 将ViewHolder存储在View中
        } else {//不是第一次加载，即布局文件已经加载，可以利用
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }
        if(song!=null && viewHolder!=null){
            //传入具体信息
            viewHolder.songImage.setImageBitmap(song.getAlbum_icon());//列表每一项的图标
            viewHolder.songName.setText(song.getTitle());//歌名
            viewHolder.songAuthor.setText(song.getArtist());//歌手

            //设置两个文本的字体style
            viewHolder.songName.setTypeface(Typeface.DEFAULT_BOLD);
            viewHolder.songAuthor.setTypeface(Typeface.DEFAULT_BOLD);
        }
        return view;
    }
}
