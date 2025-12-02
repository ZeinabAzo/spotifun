package handlers;

import java.util.Scanner;

public class CommandHandler {
    Scanner scanner;

    public CommandHandler(Scanner scanner) {
        this.scanner = scanner;
        createCommands(commands);
    }

    private void createCommands(Map<String, Command> commands) {
        commands.put("adds", this::addArtist);
    }


    public void start() {
        String command = scanner.nextLine();
        while (!command.equals("stop")){
            command = scanner.nextLine();
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
