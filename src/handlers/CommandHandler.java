package handlers;

import models.Song;
import operations.ArtistOps;
import operations.PlayListOps;
import operations.SongOps;

import java.util.*;

public class CommandHandler {
    private SongOps songOps;
    private ArtistOps artistOps;
    private PlayListOps playListOps;

    private  Scanner scanner;
    private Map<String, Command> commands = new HashMap<>();
    private ArtistCommand artistCommand;
    private PlayListCommand playListCommand;
    private HistoryCommand historyCommand;

    public CommandHandler(Scanner scanner, SongOps songOps, ArtistOps artistOps, PlayListOps playListOps) {
        this.artistOps = artistOps;
        this.scanner = scanner;
        this.songOps =songOps;
        this.playListOps = playListOps;
        createCommands(commands);
        artistCommand = new ArtistCommand(artistOps);
        playListCommand = new PlayListCommand(playListOps);
        historyCommand = new HistoryCommand(songOps);

    }

    private void createCommands(Map<String, Command> commands) {
        //_______ 1. ARTIST  ________\\
        commands.put("adds", this::addArtist);
        commands.put("dels", this::removeArtist);
        commands.put("finds", this::findArtist);
        commands.put("prints", this::printArtists);
        commands.put("cls", this::clearArtists);
        commands.put("findms", this::findMusic);
        commands.put("addms", this::addMusic);
        commands.put("delm", this::deleteSong);
        commands.put("searchw", this::searchWord);
        commands.put("countw", this::countWord);


        //__________ 2. PLAYLIST __________\\
        commands.put("addp", this::addPlaylist);
        commands.put("addms", this::addMusicPL);
        commands.put("searchp", this::searchPl);
        commands.put("searchmp", this::searchMP);
        commands.put("delmp", this::deleteMusic);
        commands.put("showp", this::showPlaylist);


        //_________ 3. HISTORY ______________\\
        commands.put("playm", this::playMusic);
        commands.put("undo_playm", this::undo);

        //__________ 4. MIN-MAX _______________\\
        commands.put("get_max_rated", this::getMax);
        commands.put("get_min_rated", this::getMin);
    }

    // _______________ Artist Ops _______________
    private void addArtist(String[] args) {
        artistCommand.add(args);
    }

    private void removeArtist(String[] args){
        artistCommand.remove(args);
    }

    private void findArtist(String[] args) {
        artistCommand.find(args);
    }

    private void printArtists(String[] args) {
        artistCommand.printAll(args);
    }

    private void clearArtists(String[] strings) {
        artistCommand.clear();
    }

    private void findMusic(String[] strings) {
        artistCommand.findMusic(strings);
    }

    private void addMusic(String[] strings) {
        artistCommand.addMusic(strings);
    }

    private void deleteSong(String[] strings) {
        artistCommand.deleteSong(strings);
        historyCommand.deleteSong(strings);
        playListCommand.deleteMusic(strings);
    }

    private void searchWord(String[] strings) {
        artistCommand.searchWord(strings);
    }

    private void countWord(String[] strings) {
        artistCommand.countWord(strings);
    }
    //______________________________________________

    //_______________PLAYLIST_______________________
    private void addPlaylist(String[] strings) {
        playListCommand.add(strings);
    }

    private void addMusicPL(String[] strings) {
        playListCommand.addMusic(strings);
    }

    private void searchPl(String[] strings) {
        playListCommand.searchPl(strings);
    }

    private void searchMP(String[] strings) {
        playListCommand.searchMP(strings);
    }

    private void deleteMusic(String[] strings) {
        playListCommand.deleteSong(strings);
    }

    private void showPlaylist(String[] strings) {
        playListCommand.showPlaylist(strings);
    }
    //________________________________________________

    //_______________History__________________________
    private void playMusic(String[] strings) {
        historyCommand.playMusic(strings);
    }

    private void undo(String[] strings) {
        historyCommand.undoPlay();
    }
    //____________________________________________

    private void getMin(String[] strings) {
        System.out.println(songOps.getMin().toString());
    }

    private void getMax(String[] strings) {
        System.out.println(songOps.getMax().toString());
    }



    public void start() {
        while (true) {
            String command = scanner.nextLine().trim();
            if (command.equals("stop")) break;

            handleCommand(command);
        }
    }

    private void handleCommand(String command) {
        String[] split = command.trim().split("\\s+");
        String name = split[0];
        String[] args = Arrays.copyOfRange(split, 1, split.length);

        Command c = commands.get(name);
        if (c != null) {
            c.execute(args);
        } else {
            System.out.println("Unknown command");
        }
    }
}
