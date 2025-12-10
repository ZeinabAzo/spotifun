package holders;

import models.Song;

import java.util.*;

public class SongList {

    private HashMap<Integer, Song> songsById;
    private HashMap<String, Song> songsByName;

    public SongList() {
        songsById = new HashMap<>();
        songsByName = new HashMap<>();
    }

    public Song findByName(String name) {
        return songsByName.get(name);
    }

    public Song findById(int id) {
        return songsById.get(id);
    }

    public void addSong(Song song) {
        songsById.put(song.getId(), song);
        songsByName.put(song.getName(), song);
    }

    public void deleteSong(int id) {
        Song song = songsById.remove(id);
        if (song != null) {
            songsByName.remove(song.getName());
        }
    }

    public boolean contains(int id, String word) {
        Song song = songsById.get(id);
        return song != null && song.getLyrics().contains(word);
    }

    public int countWord(int id, String word) {
        Song song = songsById.get(id);
        if (song == null) return 0;

        String lyrics = song.getLyrics().toLowerCase();
        String target = word.toLowerCase();

        int count = 0;
        int index = lyrics.indexOf(target);

        while (index != -1) {
            count++;
            index = lyrics.indexOf(target, index + 1); // allow overlaps
        }

        return count;
    }

    public List<Song> getAllSongs() {
        // Sort alphabetically by name for consistent behavior
        List<Song> list = new ArrayList<>(songsByName.values());
        list.sort(Comparator.comparing(Song::getName));
        return list;
    }
}
