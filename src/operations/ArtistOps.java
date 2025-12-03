package operations;

import containers.SparseSet;
import models.Artist;

import java.util.Arrays;

public class ArtistOps {
    SparseSet<Artist> artists;

    public ArtistOps(){
        artists = new SparseSet<Artist>(100, 100) {
            @Override
            protected int getId(Artist element) {
                return element.getId();
            }
        };
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

    public void findMusic(String musicName) {
        //TODO: please do it in a O(log n) way
    }

    public void addMusic(int artistId, String musicName, int year, int rating, String result) {
        find(artistId).getSongList().addSong(musicName, year, rating, result);
    }

    public boolean searchWord(int artistId, int musicId, String word) {
        return find(artistId).getSongList().contains(musicId, word);
    }
}
