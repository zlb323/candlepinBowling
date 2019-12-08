import java.util.Scanner;

public class game {
    private player[] players;

    public game(int numOfPlayers){
        players = new player[numOfPlayers];
    }

    public void setAllPlayerNames(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < players.length; i++){
            setPlayerName(i, scanner);
        }
    }

    //This function allows for a change in name at a later time if needed
    public void setPlayerName(int playerIndex, Scanner scanner){
        System.out.print("Enter your name: ");

        String name = scanner.next();
        players[playerIndex].setName(name);
    }
}
