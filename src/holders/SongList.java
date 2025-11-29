package holders;

import containers.AVLTree;
import models.Song;

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
}
