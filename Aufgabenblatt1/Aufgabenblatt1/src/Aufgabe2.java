/*
    Aufgabe 2) while-Schleifen
*/
public class Aufgabe2 {

    static String text = "Wir beginnen am Anfang mit den Grundlagen.";
    static String check = "Kein gesuchtes Zeichen im String!";

    public static void main(String[] args) {
        ZweiA();
        System.out.println();
        ZweiB(check);
        System.out.println();
        ZweiC();
        System.out.println();
        ZweiD(text);
        System.out.println();
        ZweiE(check);
        System.out.println();
    }

    public static void ZweiA(){
        int i = 1;
        while (i < text.length()){
            if(text.toLowerCase().charAt(i)!='a'){
                System.out.print(text.charAt(i));
            }
            i+=2;
        }
    }

    public static void ZweiB(String s){
        int i = 1;
        int counter = 0;
        while (i < s.length()){
            if(s.toLowerCase().charAt(i)=='s'){
                System.out.print(i + " ");
                counter++;
                break;
            }
            i++;
        }
        if(counter==0){
            System.out.print(-1);
        }
    }

    public static void ZweiC(){
        int i = 18;
        while(i < 237){
            if(i%17==0 && i%2==0){
                System.out.print(i + " ");
            }
            i++;
        }
    }

    public static void ZweiD(String s){
        int i = s.length();
        int counter = 0;
        while(i > 0){
            if(s.toLowerCase().charAt(i-1)=='e'){
                counter++;
            }
            System.out.print(s.charAt(i-1));
            if(counter == 3) break;
            i--;
        }

    }

    public static void ZweiE(String s){
        int i = 0;
        int counter = 0;
        while (i < s.length()){
            if(s.charAt(i) == '!' || s.charAt(i) == '.' || s.charAt(i) == ' '){
                counter++;
            }
            i++;
        }
        System.out.print(counter);
    }


}






