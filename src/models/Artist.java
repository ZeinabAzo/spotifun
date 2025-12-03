package models;

import holders.SongList;

public class Artist {
    private int id;
    private String name;
    private SongList songList;

    public Artist(String name, int id){
        this.name = name;
        this.id = id;
        songList = new SongList();
    }

    public SongList getSongList() {
        return songList;
    }

    public void setSongList(SongList songList) {
        this.songList = songList;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        var songs = songList.getAllSongs();
        if (songs.isEmpty()) {
            sb.append("No songs");
        } else {
            for (Song s : songs) {
                sb.append(s.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }

        return "Artist{id=" + id +
                ", name='" + name + '\'' +
                ", songs=[" + sb + "]}";
    }

}
