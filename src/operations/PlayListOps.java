package operations;

import models.PlayList;

import java.util.HashMap;
import java.util.Map;

public class PlayListOps {
    private SongOps songOps;
    private Map<Integer, PlayList> playlists;

    public PlayListOps(SongOps songOps) {
        this.songOps = songOps;
        playlists = new HashMap<>();
    }

    public void add(int id, String name) {
        PlayList playList = new PlayList(name, id);
        playlists.put(id, playList);
    }
}
