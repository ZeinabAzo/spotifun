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

    public Song findSong(Song target) {
        if (songQueue.isEmpty()) return null;

        Queue<Song> newQueue = new Queue<>(songQueue.getCapacity()); // same size
        Song found = null;

        while (!songQueue.isEmpty()) {
            Song current = songQueue.dequeue();

            if (current.equals(target)) {
                found = current; // song found
            } else {
                newQueue.enqueue(current); // keep the song
            }
        }

        // replace old queue with filtered one
        songQueue = newQueue;

        return found;
    }


    @Override
    public String toString(){
        return "Playlist id: " + this.id + "\n" +
                "PlayList name: " + this.name + "\n" +
                this.songQueue.toString();
    }
}
