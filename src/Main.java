import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner= new Scanner(System.in);
    static int position;
    static String winner = null;
    static int firstPlayer = setPlayer();
    static int secondPlayer = (firstPlayer == 1 ? 2 : 1);
    static int[] playerList = new int[9];
    static int currentPlayer = firstPlayer;
    static int count = 0;

    public static void main(String[] args) {

        welcomeMessage();
//        setPlayer();
        askInputToPlayer();

//        Arrays.asList(playerList).forEach(System.out::println);
    }

    private static void toggleCurrentPlayer() {
        currentPlayer = (currentPlayer == 1 ? 2 : 1);
    }

    private static int setPlayer() {
        return (int) (Math.random()*2+1);
    }


    private static void askInputToPlayer() {

        while(!checkWinner() && count < 9) {
            System.out.println("Enter position [0-9] Player" + currentPlayer + ":");
            position = scanner.nextInt();
            setValueOnPosition();

            toggleCurrentPlayer();
            count ++;

        }
        if(checkWinner()){
            toggleCurrentPlayer();
            System.out.println("The winner is " + currentPlayer);
        }
        else if (count > 9) {
            System.out.println("The game end in Draw");

        }





    }


    private static boolean checkWinner() {
        if (playerList[0] == playerList[1] && playerList[2] == playerList[1] && playerList[0] != 0)
            return true;
        if (playerList[3] == playerList[4] && playerList[5] == playerList[4] && playerList[3] != 0)
            return true;
        if (playerList[6] == playerList[7] && playerList[8] == playerList[7] && playerList[6] != 0)
            return true;
        if (playerList[0] == playerList[3] && playerList[6] == playerList[0] && playerList[6] != 0)
            return true;
        if (playerList[1] ==playerList[4] && playerList[7] == playerList[4]  && playerList[7] != 0)
        return true;
        if (playerList[2] == playerList[5] && playerList[8] == playerList[5] && playerList[2] != 0)
            return true;
        if (playerList[0] == playerList[4] && playerList[8] == playerList[4] && playerList[4] != 0)
            return true;
        if (playerList[2] == playerList[4] && playerList[6] == playerList[4] && playerList[6] != 0)
            return true;
        else
            return false;

//        for (int a = 0; a < 9; a++) {
//            if (Arrays.asList(playerList).contains(String.valueOf(a + 1))) {
//                break;
//            } else if (a == 8)
//                return "draw";
//        }
//        return null;
    }







    private static void setValueOnPosition() {
        playerList[position-1] = currentPlayer;
    }

    private static void welcomeMessage() {
        System.out.println("Welcome to TicTacToe");
    }


}
