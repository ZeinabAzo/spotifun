import handlers.CommandHandler;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            CommandHandler commandHandler = new CommandHandler(scanner);
            commandHandler.start();
        }
        System.out.println("Exiting command prompt. Bye!");
    }
}

