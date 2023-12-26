/*
    Aufgabe 3) Rekursion
*/
public class Aufgabe3 {

    private static void printEvenNumbersAscending(int start, int end) {
        if(start<=end){
            if (start%2==0) System.out.print(start + " ");
            start++;
            printEvenNumbersAscending(start,end);
        }
    }

    private static void printOddNumbersDescending(int start, int end) {
        if (end>=start){
            if (end%2==1) System.out.print(end + " ");
            end--;
            printOddNumbersDescending(start,end);
        }
    }

    private static int sumSquaredDigits(int number) {
        int n = 0;
        if(number>0){
            n = (int) Math.pow(number % 10, 2);
            number = number / 10;
            n = n + sumSquaredDigits(number);
        }
        return n;
    }

    private static String removeSpaces(String text) {
        if(text == null) return null;
        else if(text.contains(" ")){
                text = text.replaceFirst(" ", "");
                text = removeSpaces(text);
            }
        return text;
    }

    public static void main(String[] args) {
        printEvenNumbersAscending(10, 20);
        System.out.println();
        printOddNumbersDescending(5, 15);
        System.out.println();

        System.out.println(sumSquaredDigits(1));
        System.out.println(sumSquaredDigits(102));
        System.out.println(sumSquaredDigits(1234));
        System.out.println(sumSquaredDigits(10000));
        System.out.println(sumSquaredDigits(93842));
        System.out.println(sumSquaredDigits(875943789));
        assert (sumSquaredDigits(1) == 1);
        assert (sumSquaredDigits(102) == 5);
        assert (sumSquaredDigits(1234) == 30);
        assert (sumSquaredDigits(10000) == 1);
        assert (sumSquaredDigits(93842) == 174);
        assert (sumSquaredDigits(875943789) == 438);
        System.out.println();

        System.out.println(removeSpaces(" "));
        System.out.println(removeSpaces("+ +"));
        System.out.println(removeSpaces(" 12 3 45 "));
        System.out.println(removeSpaces("a  b   c    d"));
        assert (removeSpaces(" ").equals(""));
        assert (removeSpaces("+ +").equals("++"));
        assert (removeSpaces(" 12 3 45 ").equals("12345"));
        assert (removeSpaces("a  b   c    d").equals("abcd"));
    }
}

