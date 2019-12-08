import java.util.InputMismatchException;
import java.util.Scanner;

public class game {
    private player[] players;

    public game(int numOfPlayers){
        Scanner scanner = new Scanner(System.in);
        players = new player[numOfPlayers];
        setAllPlayerNames(scanner);
        play(scanner);
    }

    private void play(Scanner scanner){
        int currentPlayer = 0;
        frame currentFrame;
        do{
            currentFrame = players[currentPlayer].getNextFrame();
            if(currentFrame == null) return;

            System.out.println("Enter the next score for player " + players[currentPlayer].getName() + " : ");
            currentFrame.throwResult(inputNextScore(scanner));
        } while()
    }

    public void setAllPlayerNames(Scanner scanner){
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

    private int inputNextScore(Scanner scanner){
        int input = -1;
        do{
            try{
                input = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Please enter a valid number between 0 and 10");
            }
        } while(input != -1);
        return input;
    }
}
