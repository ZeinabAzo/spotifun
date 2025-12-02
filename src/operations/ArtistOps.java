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
        artists = new SparseSet<>(100, 100);
    }
}
