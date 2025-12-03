package handlers;

import java.util.*;

public class CommandHandler {

    Scanner scanner;
    Map<String, Command> commands = new HashMap<>();
    ArtistCommand artistCommand = new ArtistCommand();

    public CommandHandler(Scanner scanner) {
        this.scanner = scanner;
        createCommands(commands);
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

    //______________________________________________

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
