package handlers;

import models.History;
import models.Song;
import operations.SongOps;

public class HistoryCommand {
    private SongOps songOps;
    private History history;
    
    public HistoryCommand(SongOps songOps){
        this.songOps = songOps;
        history = new History();
    }

    public void playMusic(String[] strings) {
        int musicId = Integer.parseInt(strings[1]);
        Song song = songOps.getSong(musicId);
        history.getHistory().push(song);
    }

    public void undoPlay() {
        Song song = history.getHistory().pop();
        System.out.println("This song was popped -> "+song.toString());
    }
}
