import handlers.CommandHandler;
import operations.ArtistOps;
import operations.PlayListOps;
import operations.SongOps;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        SongOps songOps = new SongOps();     // ONE shared instance

        ArtistOps artistOps = new ArtistOps(songOps);
        PlayListOps playListOps = new PlayListOps(songOps);
        try (Scanner scanner = new Scanner(System.in)) {
            CommandHandler commandHandler = new CommandHandler(scanner, songOps, artistOps, playListOps);
            commandHandler.start();
        }
        System.out.println("Exiting command prompt. Bye!");
    }
}

