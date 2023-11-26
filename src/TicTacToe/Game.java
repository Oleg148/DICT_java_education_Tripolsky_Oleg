package TicTacToe;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private final char[][] array = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private int idLain;
    private int idColumn;
    private char newSymbol = 'O';
    private int move = 0;

    private void print_array(){
        System.out.println("---------");
        for (char[] chars : array) {
            System.out.print("| ");
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println('|');
        }
        System.out.println("---------");
    }

    private void new_array(){
        newSymbol = newSymbol == 'X' ? 'O' : 'X';
        array[idLain - 1][idColumn - 1] = newSymbol;
        print_array();
    }

    public void tictactoe(){
        Random rand = new Random();
        print_array();
        while (true){
            if (newSymbol == 'O') {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter the coordinates: ");

                try {
                    idLain = in.nextByte();
                    idColumn = in.nextByte();

                } catch (InputMismatchException e) {
                    System.out.println("You should enter numbers!");
                    continue;
                }
            }
            else {
                idLain = rand.nextInt(1, 4);
                idColumn = rand.nextInt(1, 4);

             }

            if (idLain > 3 || idColumn > 3 || idLain < 1 || idColumn < 1){
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            else if (array[idLain - 1][idColumn - 1] != ' ' && newSymbol == 'X'){
                continue;
            }

            else if (array[idLain - 1][idColumn - 1] != ' '){
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            if (newSymbol == 'X') {
                System.out.println("Enter the coordinates: " + idLain + ' ' + idColumn);
            }

            new_array();

            move = move + 1;

            if (array[0][0] == array[0][1] && array[0][0] == array[0][2] && array[0][0] != ' ') {
                System.out.println(newSymbol + " win");
                break;
            }
            else if (array[1][0] == array[1][1] && array[1][0] == array[1][2] && array[1][0] != ' ') {
                System.out.println(newSymbol + " win");
                break;
            }
            else if (array[2][0] == array[2][1] && array[2][0] == array[2][2] && array[2][0] != ' ') {
                System.out.println(newSymbol + " win");
                break;
            }
            else if (array[0][0] == array[1][0] && array[0][0] == array[2][0] && array[0][0] != ' ') {
                System.out.println(newSymbol + " win");
                break;
            }
            else if (array[0][1] == array[1][1] && array[0][1] == array[2][1] && array[0][1] != ' ') {
                System.out.println(newSymbol + " win");
                break;
            }
            else if (array[0][2] == array[1][2] && array[0][2] == array[2][2] && array[0][2] != ' ') {
                System.out.println(newSymbol + " win");
                break;
            }
            else if (array[0][0] == array[1][1] && array[0][0] == array[2][2] && array[0][0] != ' ') {
                System.out.println(newSymbol + " win");
                break;
            }
            else if (array[0][2] == array[1][1] && array[0][2] == array[2][0] && array[0][2] != ' ') {
                System.out.println(newSymbol + " win");
                break;
            }
            else if (move > 8) {
                System.out.println("Draw");
                break;
            }
        }
    }
}
