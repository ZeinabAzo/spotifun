package models;

import containers.SongList;

public class Artist {
    private int id;
    private String name;
    private SongList songList;

    public Artist(String name, int id){
        this.name = name;
        this.id = id;
        songList = new SongList();
    }
}
