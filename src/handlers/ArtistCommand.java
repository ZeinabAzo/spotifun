package handlers;

import models.Artist;
import operations.ArtistOps;

public class ArtistCommand {
    private ArtistOps artistOps = new ArtistOps();

    public void add(String[] args) {
        String name = args[0];
        int id = Integer.parseInt(args[1]);
        System.out.println("--"+ name +" - "+ id);
        Artist artist = new Artist(name, id);
        artistOps.add(artist);
    }
}
