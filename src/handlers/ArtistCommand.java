package handlers;

import models.Artist;
import models.Song;
import operations.ArtistOps;

import java.util.Arrays;

public class ArtistCommand {
    private ArtistOps artistOps = new ArtistOps();

    public void add(String[] args) {
        String name = args[0];
        int id = Integer.parseInt(args[1]);
        Artist artist = new Artist(name, id);
        artistOps.add(artist);
        System.out.println("Artist: " + name + " with id: " + id + " has been successfully added.");
    }

    public void remove(String[] args) {
        int id = Integer.parseInt(args[0]);
        String name = artistOps.find(id).getName();
        artistOps.delete(id);
        System.out.println("Artist: " + name + " with id: " + id + " has been successfully removed.");
    }

    public void find(String[] args) {
        Artist artist = artistOps.find(Integer.parseInt(args[0]));
        System.out.println(artist.toString());
    }


    public void printAll(String[] args) {
        artistOps.printAll();
    }

    public void clear() {
        artistOps.clear();
    }

    public void findMusic(String[] strings) {
        String musicName = strings[0];
        artistOps.findMusic(musicName);
    }

    public void addMusic(String[] strings) {
        String musicName = strings[0];
        int artistId = Integer.parseInt(strings[1]);
        int year = Integer.parseInt(strings[2]);
        int rating = Integer.parseInt(strings[3]);
        String[] lyrics = Arrays.copyOfRange(strings, 4, strings.length - 1);
        String result = String.join(" ", lyrics);
        artistOps.addMusic(artistId, musicName, year, rating, result);
        System.out.println("Done ;) ");
    }
}
