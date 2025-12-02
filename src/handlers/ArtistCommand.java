package handlers;

import models.Artist;
import operations.ArtistOps;

public class ArtistCommand {
    private ArtistOps artistOps = new ArtistOps();

    public void add(String[] args) {
        String name = args[0];
        int id = Integer.parseInt(args[1]);
        Artist artist = new Artist(name, id);
        artistOps.add(artist);
    }

    public void remove(String[] args) {
        int id = Integer.parseInt(args[0]);
        artistOps.delete(id);
    }
}
