import handlers.CommandHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        CommandHandler commandHandler = new CommandHandler(scanner);
        commandHandler.start();
        scanner.close();
    }
}
