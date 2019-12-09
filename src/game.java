import java.util.InputMismatchException;
import java.util.Scanner;

public class game {
    private player[] players;
    private int numOfPlayers;

    public game(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of players:" );
        try{
            numOfPlayers = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Invalid Number: " + e.getMessage());
            return;
        }
        players = new player[numOfPlayers];
        setAllPlayerNames(scanner);
        play(scanner);
    }

    private void play(Scanner scanner){
        int currentPlayer = 0;
        frame currentFrame = players[0].getNextFrame();
        do{
            if(currentFrame == null) return;

            boolean isFinished = false;
            while(!isFinished){
                System.out.println("Enter the next score for player " + players[currentPlayer].getName() + " : ");
                isFinished = currentFrame.throwResult(inputNextScore(scanner));
            }
            currentPlayer++;
            if(currentPlayer >= numOfPlayers) currentPlayer = 0;
            currentFrame = players[currentPlayer].getNextFrame();
            printScoreBoard();
        } while(currentFrame != null);
    }

    private void setAllPlayerNames(Scanner scanner){
        for(int i = 0; i < players.length; i++){
            players[i] = new player();
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
        } while(input == -1);
        return input;
    }

    private void printScoreBoard(){
        for(int i = 0; i < players.length; i++){
            System.out.println(players[i].getScoreString());
        }
    }
}
