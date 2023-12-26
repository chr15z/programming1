/*
    Aufgabe 5) Schleifen und Zeichnen innerhalb des CodeDraw-Fensters
*/

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe5 {

    public static void main(String[] args) {

        aufg5(11);
    }
    public static void aufg5(int n){
        if(n > 19 || n < 5 || n%2==0) System.err.println("Ungültige eingabe");
        else{
            CodeDraw myDrawObj = new CodeDraw(300, 300);
            double radius = 1500000000 / n;
            radius = radius / 10000000;
            System.out.println(radius);

            myDrawObj.setLineWidth(2);
            myDrawObj.setColor(Palette.RED);
            for(int i = 0; i < n; i++){
                myDrawObj.drawCircle(radius, radius + (radius*2*i), radius);
            }
            for(int i = 0; i < n; i++){
                myDrawObj.drawCircle(radius+ (radius*2*i), 300-radius, radius);
            }

            for(int i = 0; i < n-4; i++){
                myDrawObj.drawCircle(radius*5,   radius*5 + (radius*2*i) , radius);
            }

            for(int i = 0; i < n-4; i++){
                myDrawObj.drawCircle(radius*5+ (radius*2*i), 300-radius*5, radius);
            }

            myDrawObj.setLineWidth(4);
            myDrawObj.setColor(Palette.BLUE);

            for(int i = 0; i < n-2; i++){
                myDrawObj.drawCircle(300-radius*3, radius*3 + (radius*2*i), radius);
            }
            for(int i = 0; i < n-2; i++){
                myDrawObj.drawCircle(radius*3+ (radius*2*i), radius*3, radius);
            }

            myDrawObj.show();
        }

    }
}
