import java.io.OutputStream;

/*
    Aufgabe 3) Verschachtelung von Schleifen und Methoden - Fröhliche Zahlen
*/
public class Aufgabe3 {

    private static boolean isHappyNumber(int number) {
        int happyNum = calcHappyNum(number);
        if(happyNum==1){
            return true;
        } else return false;
    }

    private static int calcHappyNum(int number){
        int temp = 1;
        while(number != 4 && number != 1){
            temp = number;
            number = 0;
            while(temp > 0){
                number += Math.pow((temp % 10),2);
                temp /= 10;
            }
        }
        return number;
    }

    private static int countHappyNumbers(int start, int end) {
        int out = 0;
        if(start > 0 && end > 0 && end >= start){
            for (int i = start; i <= end; i++){
                if(isHappyNumber(i)) out++;
            }
        }
        return out;
    }

    private static void printHappyNumbers(int start, int end) {
        if(start > 0 && end > 0 && end >= start){
            for (int i = start; i <= end; i++){
                if(isHappyNumber(i)) System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE isHappyNumber(...).
        System.out.println("23 --> " + isHappyNumber(23));
        assert (isHappyNumber(23));
        System.out.println("97 --> " + isHappyNumber(97));
        assert (isHappyNumber(97));
        System.out.println("7 --> " + isHappyNumber(7));
        assert (isHappyNumber(7));
        assert (isHappyNumber(1));
        System.out.println("58 --> " + isHappyNumber(58));
        assert (!isHappyNumber(58));
        System.out.println("40 --> " + isHappyNumber(40));
        assert (!isHappyNumber(40));
        System.out.println("5 --> " + isHappyNumber(5));
        assert (!isHappyNumber(5));
        assert (!isHappyNumber(4));
        System.out.println(countHappyNumbers(12,34));
        printHappyNumbers(12,34);
    }

}
