package operations;

import models.Artist;
import models.Song;

import java.util.HashMap;
import java.util.Map;

public class SongOps {
    //This is a class to keep all song together
    private Map<Song, Artist> songArtistMap = new HashMap<>();
    private Map<String, Song> songNameMap = new HashMap<>();
    private Map<Integer, Song> songIdMap = new HashMap<>();



    public Map<Song, Artist> getSongArtistMap() {
        return songArtistMap;
    }

    public Map<String, Song> getSongNameMap() {
        return songNameMap;
    }

    public void addSong(Song song, Artist artist){
        if(!songArtistMap.containsKey(song)) {
            songArtistMap.put(song, artist);
            songNameMap.put(song.getName(), song);
            songIdMap.put(song.getId(), song);
        }
    }

    public Song getSong(int id){
        return songIdMap.get(id);
    }

    public Song findMusic(String name){
        return songNameMap.get(name);
    }

    public void removeSong(Song song) {
        if(songArtistMap.containsKey(song)) {
            songArtistMap.remove(song);
            songNameMap.remove(song.getName());
            songIdMap.remove(song.getId());
        }
    }
}
