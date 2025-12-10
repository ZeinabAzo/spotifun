package handlers;

import models.PlayList;
import models.Song;
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
        int musicName = Integer.parseInt(strings[0]);
        int playlistId = Integer.parseInt(strings[1]);
        playListOps.addMusic(musicName, playlistId);
        System.out.println("Added");
    }

    public void searchPl(String[] strings) {
        PlayList playList = playListOps.getP(Integer.parseInt(strings[0]));
        System.out.println(playList == null ? "Playlist not found." : playList.toString());    }

    public void searchMP(String[] strings) {
        int musicId = Integer.parseInt(strings[1]);
        int playlistId = Integer.parseInt(strings[0]);
        Song song = playListOps.getSong(playlistId, musicId);
        System.out.println(song == null ? "Song not found." : song.toString());
    }

    public void deleteSong(String[] strings) {
        int musicId = Integer.parseInt(strings[1]);
        int playlistId = Integer.parseInt(strings[0]);
        playListOps.deleteSong(playlistId, musicId);
    }

    public void showPlaylist(String[] strings) {
        int playlistId = Integer.parseInt(strings[0]);
        String string = playListOps.showPlaylist(playlistId);
        System.out.println(string);
    }

    public void deleteMusic(String[] strings) {
        int artistId = Integer.parseInt(strings[0]);
        int musicId = Integer.parseInt(strings[1]);
        playListOps.deleteMusic(artistId, musicId);
    }
}
