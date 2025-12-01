package handlers;

import java.util.Scanner;

public class CommandHandler {
    Scanner scanner;

    public CommandHandler(Scanner scanner) {
        this.scanner = scanner;
    }


    public void start() {
        String command = scanner.nextLine();
        while (!command.equals("stop")){
            command = scanner.nextLine();
            handleCommand(command);
        }
    }

    private void handleCommand(String command) {
        //write commands one by one so you can check: DO NOT use a menu
    }
}
