/*
    Aufgabe 3) Verschachtelte Schleifen
*/
public class Aufgabe3 {

    public static void main(String[] args) {
        aufg3(9,0);

    }

    public static void aufg3(int height, int pattern){
        if(height < 1 || pattern < 0 || pattern > 2) System.err.println("Ungültige Eingabe");

        if(pattern == 0){
            for(int i = 0; i < height; i++){
                int space = 0;
                while (space < i){
                    System.out.print(" ");
                    space++;
                }
                System.out.println("*");
            }
        }

        if(pattern == 1){
            for(int i = 1; i < height + 1; i++){
                int space = height - i;
                int star = i;
                while (0 < space){
                    System.out.print(" ");
                    space--;
                }
                while (0 < star){
                    System.out.print("*");
                    star--;
                }
                System.out.println();
            }
        }

        if(pattern == 2){
            for (int i = 0; i < height; i++){
                int star = height;
                int space = i;
                while (0 < space){
                    System.out.print(" ");
                    space--;
                }
                while (0 < star){
                    System.out.print("*");
                    star--;
                }
                System.out.println();
            }
        }
    }
}
