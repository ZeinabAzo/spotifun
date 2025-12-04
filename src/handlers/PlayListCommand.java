package handlers;

import operations.PlayListOps;

public class PlayListCommand {
    private PlayListOps playListOps;

    public PlayListCommand(PlayListOps playListOps) {
        this.playListOps = playListOps;
    }

    public void add(String[] strings) {
        int id = Integer.parseInt(strings[0]);
        String name = strings[1];
        playListOps.add(id, name);
    }

    public void addMusic(String[] strings) {
        int musicId = Integer.parseInt(strings[0]);
        int playlistId = Integer.parseInt(strings[1]);
        playListOps.addMusic(musicId, playlistId);
        System.out.println("Added");
    }
}
