package models;

import holders.SongList;

public class PlayList {
    private SongList list;
    private String name;
    private int id;

    public PlayList(String name, int id) {
        this.list = new SongList();
        this.name = name;
        this.id = id;
    }

    public SongList getList() {
        return list;
    }

    public void setList(SongList list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
