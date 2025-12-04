package handlers;

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

    public CommandHandler(Scanner scanner, SongOps songOps, ArtistOps artistOps, PlayListOps playListOps) {
        this.artistOps = artistOps;
        this.scanner = scanner;
        this.songOps =songOps;
        this.playListOps = playListOps;
        createCommands(commands);
        artistCommand = new ArtistCommand(artistOps);
        playListCommand = new PlayListCommand(playListOps);

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
        commands.put("searchw", this::searchWord);
        commands.put("countw", this::countWord);


        //__________ 2. PLAYLIST __________\\
        commands.put("addp", this::addPlaylist);
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
