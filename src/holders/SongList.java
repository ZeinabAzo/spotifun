package holders;

import containers.AVLTree;
import models.Song;

import java.util.ArrayList;
import java.util.List;

public class SongList {
    AVLTree<Integer, Song> songsById;
    AVLTree<String, Song> songsByName;


    public SongList(){
        songsById = new AVLTree<>();
        songsByName = new AVLTree<>();
    }

    public AVLTree<Integer, Song> getSongsById() {
        return songsById;
    }

    public void setSongsById(AVLTree<Integer, Song> songsById) {
        this.songsById = songsById;
    }

    public AVLTree<String, Song> getSongsByName() {
        return songsByName;
    }

    public void setSongsByName(AVLTree<String, Song> songsByName) {
        this.songsByName = songsByName;
    }

    public Song findByName(String name){
        return songsByName.get(name);
    }

    public Song findById(int id){
        return songsById.get(id);
    }

    public void addSong(Song song){
        songsById.put(song.getId(), song);
        songsByName.put(song.getName(), song);
    }

    public void deleteSong(int id){
        Song song = findById(id);
        songsByName.remove(song.getName());
        songsById.remove(id);
    }

    public boolean contains(int id, String word){
        Song song = songsById.get(id);
        return song.getLyrics().contains(word);
    }

    public int countWord(int id, String word) {
        String lyrics = songsById.get(id).getLyrics();
        String target = word.toLowerCase();
        String text = lyrics.toLowerCase();

        int count = 0;
        int index = 0;

        while ((index = text.indexOf(target, index)) != -1) {
            count++;
            index++; // move only 1 step for overlapping matches
        }

        return count;
    }

    public List<Song> getAllSongs() {
        return songsByName.toListInOrder();
    }


}
