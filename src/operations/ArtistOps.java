package operations;

import containers.SparseSet;
import models.Artist;
import models.Song;

import java.util.Arrays;

public class ArtistOps {
    SparseSet<Artist> artists;
    SongOps songOps;

    public ArtistOps(SongOps songOps){
        artists = new SparseSet<Artist>(100, 100) {
            @Override
            protected int getId(Artist element) {
                return element.getId();
            }
        };
        this.songOps = songOps;
    }

    public void add(Artist artist){
        artists.add(artist);
    }

    public void delete(int id){
        artists.remove(id);
    }

    public Artist find(int id){
        return artists.get(id);
    }

    public void printAll(){
        System.out.println(Arrays.toString(artists.all()));
    }

    public void clear(){
        artists = new SparseSet<Artist>(100, 100) {
            @Override
            protected int getId(Artist element) {
                return element.getId();
            }
        };
    }

    public Song findMusic(String musicName) {
        return songOps.findMusic(musicName);
    }

    public void addMusic(int artistId, String musicName, int year, int rating, String result) {
        Song song = find(artistId).getSongList().addSong(musicName, year, rating, result);
        songOps.addSong(song, find(artistId));
    }

    public boolean searchWord(int artistId, int musicId, String word) {
        return find(artistId).getSongList().contains(musicId, word);
    }

    public int countWord(int artistId, int musicId, String word) {
        return find(artistId).getSongList().countWord(musicId, word);
    }

    public void deleteSong(int musicId, int artistId) {
        Song song = songOps.getSong(musicId);
        songOps.removeSong(song);
        artists.get(artistId).getSongList().deleteSong(musicId);
    }
}
