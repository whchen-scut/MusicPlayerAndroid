package com.william.RDC.musicplayer.model;

import java.util.ArrayList;
import java.util.List;

public class PlayHistory {
    private static List<Song> songs = new ArrayList<>();
    public static void addSong(Song song) {
        songs.remove(song);
        songs.add(song);
    }
    private static void removeSong(Song song) {
        songs.remove(song);
    }

    public static List<Song> getSongs() {
        return songs;
    }

    public static void removeAll() {
        for (Song song : songs) {
          removeSong(song);
        }
    }
}
