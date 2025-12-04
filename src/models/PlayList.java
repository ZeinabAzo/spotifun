package models;

import containers.Queue;

public class PlayList {
    private Queue<Song> songQueue;
    private String name;
    private int id;

    public PlayList(String name, int id) {
        this.songQueue = new Queue<>(1000);
        this.name = name;
        this.id = id;
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

    public Queue getSongQueue() {
        return songQueue;
    }

    public void setSongQueue(Queue songQueue) {
        this.songQueue = songQueue;
    }

    public void addMusic(Song song) {
        songQueue.enqueue(song);
    }
}
