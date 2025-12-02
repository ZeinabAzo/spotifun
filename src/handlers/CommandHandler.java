package handlers;

import java.util.Scanner;

public class CommandHandler {
    Scanner scanner;
    Map<String, Command> commands = new HashMap<>();
    ArtistCommand artistCommand = new ArtistCommand();

    public CommandHandler(Scanner scanner) {
        this.scanner = scanner;
        createCommands(commands);
    }

    private void createCommands(Map<String, Command> commands) {
        commands.put("adds", this::addArtist);
    }

    // _______________ Artist Ops _______________
    private void addArtist(String[] args) {
        ArtistCommand.add(args);
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
