/* in scan num lieber eine neue methode, die überprüft ob s[0] zwischen '1' und '9' ist
    Aufgabe 4) "Guessing Game" und Verwendung von Methoden
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Aufgabe4 {

    static Scanner myScanner = new Scanner(System.in);
    static int score = 0;

    public static int randomNum(){
        return (int) (Math.random()*201);
    }

    public static boolean isInt(String s){
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                counter++;
            }
        }
        if(counter==s.length()) return true;
        else return false;
    }

    public static void print(int num, int input){
        if(input==num) System.out.println("Congrats! You guessed: "+ num + " correctly! Your score: " + score);
        else System.out.println("You failed! The correct Number is " + num);
    }

    public static int scanNum(){
        System.out.println("Guess the correct number between 0 and 200!");
        String in = myScanner.nextLine();
        if(in.equals("q")) {
            System.exit(0);
        }
        int n = -1;
        if(isInt(in)) {
            n = Integer.parseInt(in);
            if(!(n >= 0 && n <= 200)) {
                scanNum();
            }
        } else scanNum();

        return n;
    }

    public static void guessTheNum(int input, int num){
        int tries = 7 - score;
        if (input > num){
            System.out.println("The Number is lower, you have " + tries + " tries left!");
        }
        else System.out.println("The Number is higher, you have " + tries + " tries left!");
        score++;
    }

    public static void main(String[] args) {
        while(true) {
            int input = 0;
            int num = randomNum();
            while (num != input && score < 8) {
                input = scanNum();
                guessTheNum(input, num);
            }
            print(num, input);
            num = -1;
            score = 0;
        }
    }
}
