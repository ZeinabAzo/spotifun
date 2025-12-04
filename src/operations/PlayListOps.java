package operations;

import models.PlayList;
import models.Song;

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

    public void addMusic(int musicId, int playlistId) {
        Song song = songOps.getSong(musicId);
        PlayList playList = playlists.get(playlistId);
        playList.addMusic(song);
    }

    public PlayList getP(int i) {
        return playlists.get(i);
    }

    public Song getSong(int playlistId, int musicId) {
        Song song = songOps.getSong(musicId);
        return playlists.get(playlistId).findSong(song);
    }

    public void deleteSong(int playlistId, int musicId) {
        Song song = songOps.getSong(musicId);
        PlayList playList = playlists.get(playlistId);
        playlists.get(playlistId).deleteSong(song);
    }

    public String showPlaylist(int playlistId) {
        return playlists.get(playlistId).toString();

    }
}
