package handlers;

import containers.Queue;
import containers.Stack;
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

    public void deleteSong(String[] strings) {
        Stack<Song> historyP = history.getHistory();
        Queue<Song> tempQueue = new Queue<>(historyP.getCapacity());
        int artistId = Integer.parseInt(strings[0]);
        int musicId = Integer.parseInt(strings[1]);
        while (!historyP.isEmpty()) {
            Song top = historyP.pop();
            if (top.getId() == musicId) {
                break; // delete it
            } else {
                tempQueue.enqueue(top);
            }
        }

        // Push elements back from queue to stack in correct order
        while (!tempQueue.isEmpty()) {
            historyP.push(tempQueue.dequeue());
        }
    }
}
