package handlers;

import models.Artist;
import models.Song;
import operations.ArtistOps;
import operations.SongOps;

import java.util.Arrays;

public class ArtistCommand {
    private ArtistOps artistOps;

    public ArtistCommand(ArtistOps artistOps){
        this.artistOps = artistOps;
    }

    public void add(String[] args) {
        String name = args[1];
        int id = Integer.parseInt(args[0]);
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
        if(artist==null){
            System.out.println("Not found");
        }else {
            System.out.println(artist.toString());
        }
    }


    public void printAll(String[] args) {
        artistOps.printAll();
    }

    public void clear() {
        artistOps.clear();
    }

    public void findMusic(String[] strings) {
        String musicName = strings[0];
        Song song = artistOps.findMusic(musicName);
        System.out.println(song == null ? "Song not found." : song.toString());
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

    public void searchWord(String[] strings) {
        int artistId = Integer.parseInt(strings[0]);
        int musicId = Integer.parseInt(strings[1]);
        String word = strings[2];
        boolean result = artistOps.searchWord(artistId, musicId, word);
        if(result){
            System.out.println("This word -> " + word + " exists in this songs lyrics");
        }else{
            System.out.println("word not found :( ");
        }
    }

    public void countWord(String[] strings) {
        int artistId = Integer.parseInt(strings[0]);
        int musicId = Integer.parseInt(strings[1]);
        String word = strings[2];
        int count = artistOps.countWord(artistId, musicId, word);
        System.out.println("The word \"" + word + "\" appears " + count + " time" + (count != 1 ? "s" : "") + " in the lyrics.");}

    public void deleteSong(String[] strings) {
        artistOps.deleteSong(Integer.parseInt(strings[1]), Integer.parseInt(strings[0]));
    }
}
