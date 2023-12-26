/*
    Aufgabe 1) for-Schleifen
*/
public class Aufgabe1 {

    public static void main(String[] args) {

        System.out.println(EinsA(17, 170)); // a)
        EinsB();
        EinsC();
        EinsD();
        EinsE();
    }

    public static int EinsA(int a, int b){ //Aufgabe 1a
        int sum = 0;
        for(int i = a; i <= b; i++){
            if (i % 17 == 0){
                sum += i;
            }
        }
        return sum;
    }

    public static void EinsB(){
        for(int i= 60; i<= 78; i++){
            if(i%6 == 0){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void EinsC(){
        for(int i = 118; i <= 585; i++){
            if(i%9 == 0 && i%13 == 0){
                System.out.print("+" + i);
            }
        }
        System.out.println("+");
    }

    public static void EinsD(){
        char c = 0;
        for(int i = 65; i >= 46; i--){
            c = (char) i;
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void EinsE(){
        String s = "Es ist kein echtes Edelmetall!";
        int counter = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.toLowerCase().charAt(i) == 'e'){
                counter++;
            }
        }
        System.out.println(s + " hat " + counter + " \"e's\"");
    }
}
