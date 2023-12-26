import javax.lang.model.util.ElementScanner6;

/*
    Aufgabe 2) Erste Methoden
*/
public class Aufgabe2 {

    public static void main(String[] args) {
        printAlphabetPartsReverse('e');
        System.out.println();
        System.out.println((calcSum(10,356) == 63501));
        System.out.println(removeInString789("Telefonnummer 120, 178 oder 911?").equals("Telefonnummer 120, 1 oder 11?"));

        assert (calcSum(0,1) == 1);
        assert (calcSum(1,3) == 6);
        assert (calcSum(20,22) == 63);
        assert (calcSum(10,356) == 63501);

        assert (isAsciiValueInRange('B', 'A', 'G'));
        assert (!isAsciiValueInRange('!', '0', 'Z'));
        assert (isAsciiValueInRange('A','A', 'A'));
        assert (isAsciiValueInRange('B', 'A', 'C'));
        assert (isAsciiValueInRange(':', '8', 'D'));
        assert (!isAsciiValueInRange('+', '5', 'A'));

        assert (removeInString789("").equals(""));
        assert (removeInString789("7").equals(""));
        assert (removeInString789("67").equals("6"));
        assert (removeInString789("7493").equals("43"));
        assert (removeInString789("Hallo 0123456789:").equals("Hallo 0123456:"));
        assert (removeInString789("Telefonnummer 120, 178 oder 911?").equals("Telefonnummer 120, 1 oder 11?"));

    }
    public static void printChar(char c){
        System.out.print(c);
    }
    public static void printAlphabetPartsReverse(char startchar){
        if(startchar>'a' && startchar<'z') {
            for (char i = 'z'; i > startchar-1; i--) {
                printChar(i);
                System.out.print(" ");

            }
        }
    }

    public static int calcSum(int start, int end){
        int out = 0;
        if(start>=1&&end>=1&&start<=end){
            for(int i = start; i <= end; i++){
                out += i;
            }
            return out;
        }
        else return out;
    }

    public static boolean isAsciiValueInRange(char sign, char start, char end){
        if(sign >= start && sign <= end) return true;
        if(sign <= start && sign >= end) return true;
        return false;
    }

    public static String removeInString789(String text){
        if(text != null){
            text = text.replace("7","");
            text = text.replace("8","");
            text = text.replace("9","");
            return text;
        }
        else return "Fehler";
    }
}
