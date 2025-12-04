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
            }
            newQueue.enqueue(current);
        }

        // replace old queue with filtered one
        songQueue = newQueue;

        return found;
    }

    public void deleteSong(Song target) {
        if(songQueue == null){
            return;
        }

        Queue<Song> newQueue = new Queue<>(songQueue.getCapacity());

        while (!songQueue.isEmpty()) {
            Song current = songQueue.dequeue();

            if (!current.equals(target)) {
                newQueue.enqueue(current);
            }
            newQueue.enqueue(current);
        }

        // replace old queue with filtered one
        songQueue = newQueue;

    }


    @Override
    public String toString(){
        return "Playlist id: " + this.id + "\n" +
                "PlayList name: " + this.name + "\n" +
                this.songQueue.toString();
    }
}
