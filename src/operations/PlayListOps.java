package operations;

import models.Artist;
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
        PlayList playList = playlists.get(playlistId);
        if(playList != null) {
            return playList.findSong(song);
        }else{
            return null;
        }
    }

    public void deleteSong(int playlistId, int musicId) {
        Song song = songOps.getSong(musicId);
        PlayList playList = playlists.get(playlistId);
        if (playList!= null){
            playList.deleteSong(song);
        }
    }

    public String showPlaylist(int playlistId) {
        return playlists.get(playlistId).toString();

    }

    public void deleteMusic(int artistId, int musicId) {
        Song song = songOps.getSong(musicId);
        Artist artist = songOps.getSongArtistMap().get(song);
        if(artist == null ||
                artist.getId() != artistId ){
            return;
        }
        for (PlayList playList: playlists.values()){
            playList.deleteSong(song);
        }

    }
}
