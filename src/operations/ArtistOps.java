package operations;

import containers.SparseSet;
import models.Artist;

import java.util.Arrays;

public class ArtistOps {
    SparseSet<Artist> artists;

    public ArtistOps(){
        artists = new SparseSet<>(100, 100); //based on my project document.
    }

    public void add(Artist artist) throws Exception {
        artists.add(artist);
    }

    public void delete(int id) throws Exception {
        artists.remove(id);
    }

    public Artist find(int id){
        return artists.get(id);
    }

    public void printAll(){
        System.out.println(Arrays.toString(artists.all()));
    }

    public void clear(){
        artists = new SparseSet<>(100, 100);
    }
}
