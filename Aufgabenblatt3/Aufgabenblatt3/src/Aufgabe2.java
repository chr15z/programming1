/*
    Aufgabe 2) Überladen von Methoden
*/
public class Aufgabe2 {

    private static void addSign(String text, char sign) {
        for (int i = 0; i < text.length()-1; i++) {
            System.out.print(text.charAt(i));
            for (int j = 0; j <= i; j++) {
                System.out.print(sign);

            }
        }
        if(text.length()>0) System.out.print(text.charAt(text.length()-1));
        System.out.println();
    }

    private static void addSign(int number, char sign) {
        String text = String.valueOf(number);
        addSign(text,sign);
    }

    private static void addSign(String text, String signs) {
        for (int i = 0; i < signs.length(); i++) {
            char c = signs.charAt(i);
            addSign(text, c);
        }
    }

    private static void addSign(String text) {
        if (text==null) System.out.print("");
        else addSign(text, '=');
    }

    public static void main(String[] args) {
        String text0 = "";
        String text1 = "IT";
        String text2 = "Hello!";
        String text3 = "+EP1+";
        String text4 = "INT";

        addSign(text0, '+');
        addSign(text1, '-');
        addSign(text2, '#');
        addSign(text3, '&');
        addSign(text4, '*');
        System.out.println();

        addSign(1, '$');
        addSign(42, '%');
        addSign(183, '.');
        addSign(4096, ':');
        addSign(65536, ']');
        System.out.println();

        addSign(text1, "/X/");
        addSign(text2, "(#?§");
        System.out.println();

        addSign(text0);
        addSign(text1);
        addSign(text2);
    }
}
